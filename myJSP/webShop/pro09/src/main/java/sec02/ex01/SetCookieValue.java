package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date d = new Date();
		Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP프로그래밍입니다.", "utf-8")); //cookieTest이름으로 JSP프로그래밍입니다.라는 정보 저장
		c.setMaxAge(-1); //쿠키 유효시간을 24시간으로 설정
		
		response.addCookie(c); //addCookie() 메서드를 이용해 생성된 쿠키를 브라우저로 전송
		out.println("현재시간 : " + d);
		out.println("<br>현재시간을 쿠키에 저장합니다.");
	}

}
