package common;

import java.util.ArrayList;

public interface CalendarInterface {
	public String searchBar(String m);
	public void addEventdb(String x);
	public String showshow(String m, int year);
	public void addDiary(int day, String x);
	public void deleteDB(String event);
	public String searchDB(String event);
	public ArrayList<String> getMonth();
	public String getMonth(int i);
	public String getStamonth();
	public ArrayList<Integer> getDaymonth(int year);
	
	
	
	
	

}
