package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class GetCookieValue extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] allCookies = request.getCookies(); //getCookies() 메서드를 호출해 브라우저로부터 쿠키를 전달받음
		for(int i = 0; i < allCookies.length; i++) {
			if (allCookies[i].getName().equals("cookieTest")) {
				//cookieTest 이름을 통해 값을 가져옴
				out.println(URLDecoder.decode(allCookies[i].getValue(), "utf-8"));
			}
		}
	}

}
