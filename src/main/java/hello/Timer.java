//package hello;
//
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.scheduling.annotation.Scheduled;
//
//@SpringBootApplication
//public class Timer {
//	@Autowired
//	JmsTemplate sender;
//
//	@Scheduled(fixedDelay = 1000)
//	public void run() {
//		System.out.println("Timer dziala" + new Date());
//		sender.convertAndSend("kuba", "Ja też witam ;-)");
//	}
//
//}
