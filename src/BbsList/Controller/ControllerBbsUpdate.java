package BbsList.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
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

public class ControllerBbsUpdate  extends HttpServlet{

	ServletConfig mConfig;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		mConfig = config;
	}
	
	public boolean FileUpdateList(String seq, String id, String qnatype, String title, String content, String abc[]) {

		BbsDAO dao = BbsDAO.getInstance();
		String aa = dao.getFileSelect(seq);
		String abcde[] = aa.split("@");
		String all = "";
		int a = 0;
		boolean ab = false;
		
		if(abcde.length == 1) {
			if(abc[0] != "") {
				abcde[0] = abc[0];
				 
			} 
			a = 1;
		} else if(abcde.length == 2) {
			if(abc[0] != "") {
				abcde[0] = abc[0];
			} 
			if(abc[1] != "") {
				abcde[1] = abc[1];
				
			} 
			a = 1;
		} else if(abcde.length == 3) {
			if(abc[0] != "") {
				abcde[0] = abc[0];
			} 
			if(abc[1] != "") {
				abcde[1] = abc[1];
			} 
			if(abc[2] != "") {
				abcde[2] = abc[2];
				
			} 
			a = 1;
		} else if(abcde.length == 4) {
			if(abc[0] != "") {
				abcde[0] = abc[0];
			} 
			if(abc[1] != "") {
				abcde[1] = abc[1];
			} 
			if(abc[2] != "") {
				abcde[2] = abc[2];
			} 
			if(abc[3] != "") {
				abcde[3] = abc[3];
			
			} 
			a = 1;
		} else if(abcde.length == 5) {
			if(abc[0] != "") {
				abcde[0] = abc[0];
			} 
			if(abc[1] != "") {
				abcde[1] = abc[1];
			} 
			if(abc[2] != "") {
				abcde[2] = abc[2];
			} 
			if(abc[3] != "") {
				abcde[3] = abc[3];
			} 
			if(abc[4] != "") {
				abcde[4] = abc[4];
				
			} 
			a = 1;
		}
		
		if(a == 1) {
			if(abcde.length == 1) {
				all = abcde[0] + "@";
				ab = dao.BbsUpdate(seq, id, qnatype, title, content, all);
				System.out.println("[FileUpdateList] 0");
			} else if(abcde.length == 2) {
				all = abcde[0] + "@" + abcde[1] + "@";
				ab = dao.BbsUpdate(seq, id, qnatype, title, content, all);
				System.out.println("[FileUpdateList] 1");
			} else if(abcde.length == 3) {
				all = abcde[0] + "@" + abcde[1] + "@" + abcde[2]+ "@";
				ab = dao.BbsUpdate(seq, id, qnatype, title, content, all);
				System.out.println("[FileUpdateList] 2");
			} else if(abcde.length == 4) {
				all = abcde[0] + "@" + abcde[1] + "@" + abcde[2]+ "@" + abcde[3] + "@";
				ab = dao.BbsUpdate(seq, id, qnatype, title, content, all);
				System.out.println("[FileUpdateList] 3");
			} else if(abcde.length == 5) {
				all = abcde[0] + "@" + abcde[1] + "@" + abcde[2]+ "@" + abcde[3] + "@" + abcde[4] + "@";
				ab = dao.BbsUpdate(seq, id, qnatype, title, content, all);
				System.out.println("[FileUpdateList] 4");
			} 
		}

		return ab;
		
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
		String fileName = "";
		if(fileItem.getName().equals("")) {
			fileName = "";
		} else {
			fileName = all + fileItem.getName() ;
		
		
		
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
		
		}
		//=============================================
		return fileName;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		

		BbsDAO dao = BbsDAO.getInstance();
		String fupload =  mConfig.getServletContext().getRealPath("/upload");
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
		String seq = "";
		String abc[] = new String[5];

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

						if(item.getFieldName().equals("seq")) {
							seq = item.getString("utf-8");
						} else if (item.getFieldName().equals("id")) { 
							id = item.getString("utf-8");
						} else if (item.getFieldName().equals("qnatype")) {
							qnatype = item.getString("utf-8");
						} else if (item.getFieldName().equals("title")) {
							title = item.getString("utf-8");
						} else if (item.getFieldName().equals("content")) {
							content = item.getString("utf-8"); 
						} 

					}
					// file
					else {
						if(item.getFieldName().equals("fileload1")) {
							if(item.getFieldName().equals("")) {
								abc[0] = "";
							} else {
								filename = processUploadFile(item, fupload);
								abc[0] = filename;
							}
						} else if(item.getFieldName().equals("fileload2")) {
								filename = processUploadFile(item, fupload);
								abc[1] = filename;
						} else if(item.getFieldName().equals("fileload3")) {
								filename = processUploadFile(item, fupload);
								abc[2] = filename;
						} else if(item.getFieldName().equals("fileload4")) {
								filename = processUploadFile(item, fupload);
								abc[3] = filename;
						} else if(item.getFieldName().equals("fileload5")) {
								filename = processUploadFile(item, fupload);
								abc[4] = filename;
						} else {
							abc[0] = "";
						}
			
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} 

		} else {
			System.out.println("멀티파트아님");
		}
		Boolean isS = FileUpdateList(seq, id, qnatype, title, content, abc);
		if (isS) {
		  resp.sendRedirect("bbs.jsp");
		} else {
		  resp.sendRedirect("bbsSelect.jsp");
		}
			 

	}

}
