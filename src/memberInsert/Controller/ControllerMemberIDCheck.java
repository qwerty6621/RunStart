package memberInsert.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInsert.memberDAO;

public class ControllerMemberIDCheck extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		memberDAO dao = memberDAO.getInstance();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		PrintWriter out = resp.getWriter();
		
		if(dao.idchk(id)) {
			out.print("아이디가 존재합니다.");
		} else {
			out.print("아이디가 존재하지 않습니다.");
		}
		
		
	}

	
	
}
