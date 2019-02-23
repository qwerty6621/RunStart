package memberInsert.Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInsert.memberDAO;
import memberInsert.memberDTO;
import memberInsert.memberIn;

public class ControllerMemberInsert extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age"));
		String address = req.getParameter("address");
		String etc = req.getParameter("etc");
		
		int point = 0;
		int auth = 0;
		
		
		memberDTO dto = new memberDTO(id, pwd, name, email, phone, gender, age, address, etc, point, auth);
		memberIn dao = memberDAO.getInstance();
		
		boolean aa = dao.memberInsert(dto);
		
		if(aa) {
			System.out.println("회원가입 성공");
			resp.sendRedirect("MemberOut/memberInsertOut.jsp?aaa=true");
			
		} else {
			System.out.println("회원가입 실패");
			resp.sendRedirect("MemberOut/memberInsertOut.jsp?aaa=false");
		}
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	
}
