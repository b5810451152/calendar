package Control;

import java.time.Month;
import java.util.ArrayList;

import Model.Calendar;
import View.MainView;

public class Control {

	public void  StartAplication(){
		
		Calendar mycalendar = new Calendar();
		MainView view = new MainView(mycalendar);
		ArrayList<Integer> a = new  ArrayList<>();
		a.add(1);
		a.add(100);
		a.add(0,20);
		System.out.println(a);
		
		
		
	}

}
