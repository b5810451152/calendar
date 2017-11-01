package client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;

import common.CalendarInterface;

public class Control {

	public void  StartAplication(CalendarInterface calendar){
	
		CalendarInterface mycalendar = calendar;
		
		
		MainView view = new MainView(mycalendar);
//		ArrayList<Integer> a = new  ArrayList<>();
//		a.add(1);
//		a.add(100);
//		a.add(0,20);
//		System.out.println(a);
		
		
		
	}

}
