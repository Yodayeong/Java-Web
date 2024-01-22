**세션 트래킹**

* HTTP 프로토콜은 서버-클라이언트 통신 시 stateless 방식으로 통신을 하기 때문에, 각 웹 페이지나 서블릿끼리 상태나 정보를 공유하지 않는다.
* 또, 서블릿의 비즈니스 로직 처리 기능을 이용해 데이터베이스를 연동하면, 동시 사용자 수가 많아질수록 연동 속도가 영향을 받는다.
* 따라서 어떤 정보들은 클라이언트 PC나 서버의 메모리에 저장해두고 사용하면, 프로그램을 좀 더 빠르게 실행시키고 웹 페이지 사이의 상태나 정보를 공유할 수 있다.

<br>

1. hidden 태그를 이용해 웹 페이지 연동하기

   * HTML의 hidden 태그를 이용해 클라이언트의 데이터를 서버에 보냄

   * directory 구조

     ![hidden-directory](./image.assets/hidden-directory.PNG)

   * login.html

     ```java
     <!DOCTYPE html>
     <html>
     <head>
     <meta charset="UTF-8">
     <title>로그인창</title>
     </head>
     <body>
     	<form name="frmLogin" method="post" action="login" encType="UTF-8">
     		아이디 :<input type="text" name="user_id"><br>
     		비밀번호 :<input type="password" name="user_pw"><br>
     		<input type="submit" value="로그인">
     		<input type="reset" value="다시 입력">
     		<input type="hidden" name="user_address" value="서울시 성북구">
     		<input type="hidden" name="user_email" value="test@gmail.com">
     		<input type="hidden" name="user_hp" value="010-111-2222">
     	</form>
     </body>
     </html>
     ```

     * hidden 태그를 사용해 데이터 전달

   * LoginServlet.java

     ```java
     package sec01.ex01;
     
     import java.io.IOException;
     import java.io.PrintWriter;
     
     import javax.servlet.ServletConfig;
     import javax.servlet.ServletException;
     import javax.servlet.annotation.WebServlet;
     import javax.servlet.http.HttpServlet;
     import javax.servlet.http.HttpServletRequest;
     import javax.servlet.http.HttpServletResponse;
     
     @WebServlet("/login")
     public class LoginServlet extends HttpServlet {
     	public void init(ServletConfig config) throws ServletException {
     		System.out.println("init 메서드 호출");
     	}
     
     	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     		request.setCharacterEncoding("utf-8");
     		response.setContentType("text/html;charset=utf-8");
     		PrintWriter out = response.getWriter();
     		
     		String user_id = request.getParameter("user_id");
     		String user_pw = request.getParameter("user_pw");
     		String user_address = request.getParameter("user_address");
     		String user_email = request.getParameter("user_email");
     		String user_hp = request.getParameter("user_hp");
     		
     		String data = "안녕하세요!<br> 로그인하셨습니다.<br><br>";
     		data += "<html><body>";
     		data += "아이디 : " + user_id;
     		data += "<br>";
     		data += "비밀번호 : " + user_pw;
     		data += "<br>";
     		data += "주소 : " + user_address;
     		data += "<br>";
     		data += "이메일 : " + user_email;
     		data += "<br>";
     		data += "휴대전화 : " + user_hp;
     		data += "</body></html>";
     		out.print(data);
     	}
     
     	public void destroy() {
     		System.out.println("destroy 메서드 호출");
     	}
     
     }
     ```

     * getParameter()를 통해 hidden 태그로 전송된 데이터도 출력

   * 톰캣 서버 구동 후, http://localhost:8090/pro09/login.html 접속

     ![hidden-result](./image.assets/hidden-result.PNG)

     ![hidden-result2](./image.assets/hidden-result2.PNG)

<br>

2. URL Rewriting을 이용한 세션 트래킹

   * GET 방식으로 URL 뒤에 정보를 붙여서 다른 페이지로 전송

   * directory 구조

     ![url-directory](./image.assets/url-directory.PNG)

   * LoginServlet.java

     ```java
     package sec01.ex02;
     
     import java.io.IOException;
     import java.io.PrintWriter;
     import java.net.URLEncoder;
     
     import javax.servlet.ServletConfig;
     import javax.servlet.ServletException;
     import javax.servlet.annotation.WebServlet;
     import javax.servlet.http.HttpServlet;
     import javax.servlet.http.HttpServletRequest;
     import javax.servlet.http.HttpServletResponse;
     
     @WebServlet("/login")
     public class LoginServlet extends HttpServlet {
     	public void init(ServletConfig config) throws ServletException {
     		System.out.println("init 메서드 호출");
     	}
     
     	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     		request.setCharacterEncoding("utf-8");
     		response.setContentType("text/html;charset=utf-8");
     		PrintWriter out = response.getWriter();
     		
     		String user_id = request.getParameter("user_id");
     		String user_pw = request.getParameter("user_pw");
     		String user_address = request.getParameter("user_address");
     		String user_email = request.getParameter("user_email");
     		String user_hp = request.getParameter("user_hp");
     		
     		String data = "안녕하세요!<br> 로그인하셨습니다.<br><br>";
     		data += "<html><body>";
     		data += "아이디 : " + user_id;
     		data += "<br>";
     		data += "비밀번호 : " + user_pw;
     		data += "<br>";
     		data += "주소 : " + user_address;
     		data += "<br>";
     		data += "이메일 : " + user_email;
     		data += "<br>";
     		data += "휴대전화 : " + user_hp;
     		data += "<br>";
     		
     		user_address = URLEncoder.encode(user_address, "utf-8"); //GET 방식으로 한글을 전송하기 위해 인코딩
     		data += "<a href='/pro09/second?user_id="+user_id+"&user_pw="+user_pw+"&user_address="+user_address+"'>두 번째 서블릿으로 보내기</a>";
     		data += "</body></html>";
     		out.print(data);
     	}
     
     	public void destroy() {
     		System.out.println("destroy 메서드 호출");
     	}
     
     }
     ```

     * SecondServlet으로 URL을 통해 유저 아이디, 비밀번호, 주소를 전달

   * SecondServlet.java

     ```java
     package sec01.ex02;
     
     import java.io.IOException;
     import java.io.PrintWriter;
     
     import javax.servlet.ServletConfig;
     import javax.servlet.ServletException;
     import javax.servlet.annotation.WebServlet;
     import javax.servlet.http.HttpServlet;
     import javax.servlet.http.HttpServletRequest;
     import javax.servlet.http.HttpServletResponse;
     
     @WebServlet("/second")
     public class SecondServlet extends HttpServlet {
     	public void init(ServletConfig config) throws ServletException {
     		System.out.println("init 메서드 호출");
     	}
     
     	public void destroy() {
     		System.out.println("destroy 메서드 호출");
     	}
     
     	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     		request.setCharacterEncoding("utf-8");
     		response.setContentType("text/html;charset=utf-8");
     		PrintWriter out = response.getWriter();
     		
     		String user_id = request.getParameter("user_id");
     		String user_pw = request.getParameter("user_pw");
     		String user_address = request.getParameter("user_address");
     		
     		out.println("<html><body>");
     		if(user_id != null && user_id.length() != 0) {
     			out.println("이미 로그인 상태입니다!<br><br>");
     			out.println("첫 번째 서블릿에서 넘겨준 아이디 : " + user_id + "<br>");
     			out.println("첫 번째 서블릿에서 넘겨준 비밀번호 : " + user_pw + "<br>");
     			out.println("첫 번째 서블릿에서 넘겨준 주소 : " + user_address + "<br>");
     			out.println("</body></html>");
     		}
     		else {
     			out.println("로그인 하지 않았습니다.<br><br>");
     			out.println("다시 로그인하세요!!<br>");
     			out.println("<a href='/pro09/login.html'>로그인창으로 이동하기</a>");
     		}
     	}
     
     }
     ```

     * 넘겨받은 user_id 유무로, 다르게 출력

   * 톰캣 서버 구동 후, http://localhost:8090/pro09/login.html 접속

     * user_id가 있는 경우

       ![url-result](./image.assets/url-result.PNG)

       ![url-result-1](./image.assets/url-result-1.PNG)

       ![url-result-2](./image.assets/url-result-2.PNG)

     * user_id가 없는 경우

       ![url-result1](./image.assets/url-result1.PNG)

       ![url-result1-1](./image.assets/url-result1-1.PNG)

       ![url-result1-2](./image.assets/url-result1-2.PNG)