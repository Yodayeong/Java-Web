package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/show")
public class ShowMember extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = "", pwd = "";
		Boolean isLogin = false;
		HttpSession session = request.getSession(false); //세션이 있으면 반환하고, 없으면 null 반환
		
		if(session != null) {
			//세션이 있다면, 로그인 여부를 체크한다.
			isLogin = (Boolean) session.getAttribute("isLogin");
			if(isLogin == true) {
				//로그인 되어있다면, 세션에 저장된 id, pw를 보여준다.
				id = (String) session.getAttribute("login.id");
				pwd = (String) session.getAttribute("login.pwd");
				out.print("<html><body>");
				out.print("아이디 : " + id + "<br>");
				out.print("비밀번호 : " + pwd + "<br>");
				out.print("</body></html>");
			}
			else {
				//로그인 되어 있지 않다면, 로그인 폼으로 돌아간다.
				response.sendRedirect("login3.html");
			}
		}
		else {
			//세션이 없다면, 로그인 폼으로 돌아간다.
			response.sendRedirect("login3.html");
		}
		
	}

}
