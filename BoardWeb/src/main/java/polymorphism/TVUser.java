package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
	
		// 2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup)
//		TV tv = (TV)factory.getBean(LgTV.class);
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	
		// 3. Spring 컨테이너를 종료
		factory.close();
	}

}
