package sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener //HttpSessionBindingListener를 제외한 Listener를 구현한 모든 이벤트 핸들러는 해당 애너테이션을 통해 Listener로 등록
public class LoginImpl implements HttpSessionListener{
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
	public void sessionCreated(HttpSessionEvent se) {
		//세션 생성 시, 이벤트 처리
		System.out.println("세션 생성");
		++total_user;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//세션 소멸 시, 이벤트 처리
		System.out.println("세션 소멸");
		--total_user;
	}

}
