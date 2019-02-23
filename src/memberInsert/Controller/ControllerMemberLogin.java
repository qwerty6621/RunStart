package memberInsert.Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import memberInsert.memberDAO;
import memberInsert.memberIn;

public class ControllerMemberLogin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		memberIn dao = memberDAO.getInstance();
		
		boolean aa = dao.memberLogin(id, pwd);
		
		if(aa) {
			System.out.println("로그인 성공");
			resp.sendRedirect("MemberOut/memberLoginOut.jsp?aaa=true");
			session.setAttribute("id", id);
			session.setAttribute("pwd", pwd);
			
		} else {
			System.out.println("로그인 실패");
			resp.sendRedirect("MemberOut/memberLoginOut.jsp?aaa=false");
		}
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	
}
