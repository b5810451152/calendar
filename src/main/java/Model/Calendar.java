package Model;

import java.awt.Event;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Calendar {
	private ArrayList<String> month;
	private String stamonth = "January";
	private ArrayList<String> event;
	private ArrayList<Integer> daymonth;

	public Calendar() {
		event = new ArrayList<>();
		month = new ArrayList<>();
		daymonth = new ArrayList<>();

		month.add("January");
		month.add("Febuary");
		month.add("March");
		month.add("April");
		month.add("May");
		month.add("June");
		month.add("July");
		month.add("August");
		month.add("September");
		month.add("October");
		month.add("November");
		month.add("December");

		daymonth.add(31);
		daymonth.add(28);
		daymonth.add(31);
		daymonth.add(30);
		daymonth.add(31);
		daymonth.add(30);
		daymonth.add(31);
		daymonth.add(31);
		daymonth.add(30);
		daymonth.add(31);
		daymonth.add(30);
		daymonth.add(31);

	}

	public String next(String m) {
		if (month.indexOf(m) + 1 > 11) {
			stamonth = "January";

			return stamonth;
		}
		stamonth = month.get(month.indexOf(m) + 1);

		return stamonth;

	}

	public String back(String m) {
		if (month.indexOf(m) - 1 < 0) {
			stamonth = "December";
			return stamonth;
		}
		stamonth = month.get(month.indexOf(m) - 1);
		return stamonth;

	}


//	public String showEvent(String m) {
//		String str = "";
//		if (event.size() == 0) {
//			return "You don't have events in this month";
//		}else{
//			for(String i : event){
//				if(i.split(" ")[0].equals(m)){
//					str += i+"\n";
//				}
//			}
//			if(str.equals("")){
//				return "You don't have events in this month";
//			}
//			
//			return str;
//			
//			
//		}
//		
//	}
	
	public String showEventDB(String m){
		String r = "";
		try {
			// setup
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:celendar.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {

				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println(m);
				
				String query = "select * from events where month = '"+m+"' order by day";
				Statement statement = conn.createStatement();
//				statement.execute("insert into events\nvalues ('"+x.split(" ")[0]+"',"+Integer.parseInt(x.split(" ")[1])+",'"+x.split(":")[1]+"')");
				ResultSet resultset = statement.executeQuery(query);

				
				while (resultset.next()) {
					String month = resultset.getString(1);
					int day = resultset.getInt(2);
					String note = resultset.getString(3);
					r+=month+" "+day+" "+note+"\n";
					System.out.println(month+" "+day+" "+note);
					}
				resultset.close();
				statement.close();
			
				
		
			}
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(!r.equals("")){
			return r;
		}
		return "You don't have events in this month";
	}
	public void addEventdb(String x){
		
		
		try {
			// setup
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:celendar.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
			
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				String query = "select * from events";
				Statement statement = conn.createStatement();
				statement.execute("insert into events\nvalues ('"+x.split(" ")[0]+"',"+Integer.parseInt(x.split(" ")[1])+",'"+x.split(":")[1]+"')");
				ResultSet resultset = statement.executeQuery(query);
				resultset.close();
				statement.close();
				

			
				
		
			}
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void deleteDB(String event){
		try {
			// setup
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:celendar.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//				System.out.println("Delete from events where month = '"+event.split(" ")[0]+"' and day = "+event.split(" ")[1]);
				String query = "Delete from events where month = '"+event.split(" ")[0]+"' and day ="+event.split(" ")[1];
				Statement statement = conn.createStatement();
				statement.execute(query);

				
				statement.close();
			
				
		
			}
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
	public String searchDB(String event){
		String r = "";
		
	
		try {
			// setup
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:celendar.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {

				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();

				
				String query = "select * from events where month = '"+event.split(" ")[0]+"' and day ="+event.split(" ")[1];
				Statement statement = conn.createStatement();
				ResultSet resultset = statement.executeQuery(query);

				
				if (resultset.next()) {
					String month = resultset.getString(1);
					int day = resultset.getInt(2);
					String note = resultset.getString(3);
					r+=month+" "+day+" :"+note+"";
					
					}
				resultset.close();
				statement.close();
			
				
		
			}
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		if(!r.equals("")){
			return r;
		}
		return "";
		
	}

//	public void addEvent(String e, int i) {
//		if (event.size() == 0) {
//			event.add(e);
//			
//
//			return;
//		} else {
//			}
//			if (month.indexOf(e.split(" ")[0]) * 100
//					+ Integer.parseInt(e.split(" ")[1]) > month.indexOf(event.get(i).split(" ")[0]) * 100
//							+ Integer.parseInt(event.get(i).split(" ")[1])
//					&& i == event.size() - 1) {
//				event.add(e);
//				return;
//
//			} else if (month.indexOf(e.split(" ")[0]) * 100
//					+ Integer.parseInt(e.split(" ")[1]) > month.indexOf(event.get(i).split(" ")[0]) * 100
//							+ Integer.parseInt(event.get(i).split(" ")[1])) {
//				addEvent(e, i + 1);
//				return;
//			}
//			event.add(i, e);
//
//		}


	

	public ArrayList<String> getMonth() {
		return month;
	}

	public void setMonth(ArrayList<String> month) {
		this.month = month;
	}

	public String getStamonth() {
		return stamonth;
	}

	public void setStamonth(String stamonth) {
		this.stamonth = stamonth;
	}

	public ArrayList<String> getEvent() {
		return event;
	}

	public void setEvent(ArrayList<String> event) {
		this.event = event;
	}

	public ArrayList<Integer> getDaymonth() {
		return daymonth;
	}

	public void setDaymonth(ArrayList<Integer> daymonth) {
		this.daymonth = daymonth;
	}

}