package server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppServer {

	public static void main(String[] args) {
		ApplicationContext calen  = new ClassPathXmlApplicationContext("Server.xml");
//		Calendar claendar = (Calendar) calen.getBean("calendar");
		System.out.println("start server");

	}

}
