package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")	// <bean id="tv" class="polymorphysm.LgTV"/> 과 같음
public class LgTV implements TV {
	
	@Autowired
//	@Qualifier("apple")
//	@Resourse(name="apple") // @Autowired + @Qualifier - java가 제공하는 기능
	private Speaker speaker;
	
	@Override
	public void powerOn() {
		System.out.println("LgTV -- 전원 켠다.");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV -- 전원 끈다.");
		
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
		
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
		
	}
}
