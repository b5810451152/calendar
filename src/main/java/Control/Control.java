package Control;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;

import Model.Calendar;
import View.MainView;

public class Control {

	public void  StartAplication(){
		System.out.println("sadkjasld");
		Calendar mycalendar = new Calendar();

		
		
		MainView view = new MainView(mycalendar);
		ArrayList<Integer> a = new  ArrayList<>();
		a.add(1);
		a.add(100);
		a.add(0,20);
		System.out.println(a);
		
		
		
	}

}
