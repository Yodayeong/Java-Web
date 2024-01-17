**서블릿의 비즈니스 처리 과정**

1. 클라이언트로부터 요청을 받는다.
2. 데이터베이스 연동과 같은 비즈니스 로직을 처리한다.
3. 처리 결과를 클라이언트에게 돌려준다.

<br>

**서블릿의 데이터베이스 연동하기**

1. SQL Developer에서 회원 정보 테이블 생성 및 추가

   ![servlet-db](./image.assets/servlet-db.PNG)

   ![servlet-db-result](./image.assets/servlet-db-result.PNG)

2. 오라클 데이터베이스와 연동하는 데 필요한 드라이버인 ojdbc6.jar를 복사 붙여넣기

   ![servlet-db-directory](./image.assets/servlet-db-directory.PNG)

3. MemberVO.java

   ![servlet-memberVo](./image.assets/servlet-memberVo.PNG)

4. MemberDAO.java

   ![servlet-memberDao](./image.assets/servlet-memberDao.PNG)

5. MemberServlet.java

   ![servlet-memberServlet](./image.assets/servlet-memberServlet.PNG)

6. 톰캣 서버 구동 후, http://localhost:8090/pro07/member로 접속

   ![servlet-db-font](./image.assets/servlet-db-font.PNG)

7. 콘솔창 확인

   ![servlet-db-console](./image.assets/servlet-db-console.PNG)

<br>

**느낀점**

* MemberVO는 전송 객체?와 같은 느낌을 받았다. 임의의 형태의 객체에 담아서 데이터를 보내고 싶을 때 해당 객체를 만드는 것 같다.
* MemberDAO는 데이터베이스에 접근하고 SQL문을 실행할 때 사용하는 것 같다.
* MemberServlet은 Controller 역할을 하는 것 같다.
