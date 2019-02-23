package BbsList.Controller;

import java.io.File;

import java.io.IOException;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import BbsList.BbsDAO;


public class ControllerBbsInsert extends HttpServlet {

	ServletConfig mConfig;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		mConfig = config;
	}

	public String processUploadFile(FileItem fileItem, String dir){ // org.apache.commons.fileupload.fileitem
	    // String dir  업로드할 경로
		
		Calendar cal = Calendar.getInstance();
		String year =cal.get(Calendar.YEAR) + "";
		String month = cal.get(Calendar.MONTH) + 1 + "";
		String day = cal.get(Calendar.DATE) + "";
		String hour = cal.get(Calendar.HOUR_OF_DAY) + "";
		String minute = cal.get(Calendar.MINUTE) + "";
		String second = cal.get(Calendar.SECOND) + "";
		
		String all = year+month+day+hour+minute+second;
		
		System.out.println(all);
		String fileName = all + fileItem.getName() ;
		System.out.println(fileName);
		long sizeInBytes = fileItem.getSize();
		
		
		// ============================================= 파일명을 가져온다.
		// 파일 정상일때
		if(sizeInBytes > 0){
			int idx = fileName.lastIndexOf("\\");  // d: \\tmp\\abc.txt    에서  마지막 \\ 해서 파일명만 가져오기
			if(idx == -1){ // 파일이 없을때
				idx = fileName.lastIndexOf("/");   // 위 \\ 가 없는경우 / 로 찾아본다.
			}
			fileName = fileName.substring(idx + 1);   // 파일이름 abc.txt 의  abc 부터 txt 까지 찾는다.
		//============================================= 	
			
		//============================================= 파일을 업로드한다,	
			try{
				File uploadFile = new File(dir, fileName);
				fileItem.write(uploadFile);  // 실제 업로드되는 부분	
			} catch(Exception e){}
			
		}
		//=============================================
		return fileName;
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");


		BbsDAO dao = BbsDAO.getInstance();
		// tomcat 배포(톰캣 안에)

		//String fupload = "";
		String fupload =  mConfig.getServletContext().getRealPath("/upload");
		//fupload = mConfig.getServletContext().getRealPath("/upload");
		// 지정 폴더에 저장
		// String fupload = "c:\\tmp";

		System.out.println("파일업로드 : " + fupload);
		System.out.println(fupload);
		String yourTempDirectory = fupload;
		System.out.println(yourTempDirectory);
		int yourMaxRequestSize = 100 * 1024 * 1024; // 1M
		int yourMaxMemorySize = 100 * 1024;

		// form field의 데이터(String)--> 제목, 아이디, 내용
		String id = "";
		String title = "";
		String qnatype = "";
		String content = "";
		String image ="";

		// file data
		String filename = "";

		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		System.out.println(req);
		System.out.println(isMultipart);
		if (isMultipart) {
			try {

				// FileItem을 생성하는 함수
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(yourMaxMemorySize);
				factory.setRepository(new File(yourTempDirectory));
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setFileSizeMax(yourMaxRequestSize);
				// list저장
				List<FileItem> items;
				items = upload.parseRequest(req);
				Iterator<FileItem> it = items.iterator();
				// 리스트로 다 받고 구분은 여기서 해준다 id, title, content, file
				
				MultipartRequest multi = null;
				
				
				
				while (it.hasNext()) {
					FileItem item = it.next();
			
					
					// id, title, content
					if (item.isFormField()) {

						if (item.getFieldName().equals("id")) { // get파라메타랑 동일하다.
							id = item.getString("utf-8");
						} else if (item.getFieldName().equals("title")) {
							title = item.getString("utf-8");
						} else if (item.getFieldName().equals("content")) {
							content = item.getString("utf-8");
						} else if (item.getFieldName().equals("qnatype")) {
							qnatype = item.getString("utf-8"); 
						} 

					}
					// file
					else {
						if (item.getFieldName().equals("fileload")) {
							filename =  processUploadFile(item, fupload);
							
							System.out.println("fupload:" + fupload + "\\" + item.getName());

							image += filename + "@";
						}

					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		} else {
			// isMultipart type 아님
			System.out.println("멀티파트아님");
		}
		


		System.out.println("11");
		boolean isS = dao.BbsInsert(id, qnatype, title, content, image);

		
		if (isS) {
			  resp.sendRedirect("bbs.jsp");
		} else {
			  resp.sendRedirect("bbsSelect.jsp");
		}
		 
	}

}
