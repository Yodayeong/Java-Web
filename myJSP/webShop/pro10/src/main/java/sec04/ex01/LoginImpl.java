package sec04.ex01;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class LoginImpl implements HttpSessionBindingListener{
	String user_id;
	String user_pw;
	static int total_user = 0;

	public LoginImpl() {
		
	}
	
	public LoginImpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		//setAttribute()를 통해 특정 name에 대해 새로운 리스너 구현체가 바인딩 될 때 호출됨
		System.out.println("사용자 접속");
		++total_user;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		//removeAttribute()를 통해 리스너 객체가 세션에서 제거될 때 호출됨
		System.out.println("접속자 해제");
		--total_user;
	}
	
}
