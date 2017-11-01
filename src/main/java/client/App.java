package client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import common.CalendarInterface;

public class App 
{
    public static void main( String[] args ){
//    	Control control = new Control();
    	ApplicationContext con = new ClassPathXmlApplicationContext("Client.xml");
    	Control control = (Control) con.getBean("controller");
    	control.StartAplication((CalendarInterface) con.getBean("calendar"));
    	
    	
    	
        
    }
}