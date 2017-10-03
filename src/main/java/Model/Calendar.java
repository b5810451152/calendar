package Model;

import java.awt.Event;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;

public class Calendar {
	private ArrayList<String> month;
	private String stamonth = "January";

	private ArrayList<Integer> daymonth;
	private ArrayList<Integer> daymonthl;

	public Calendar() {

		// event = new ArrayList<>();
		month = new ArrayList<>();
		daymonth = new ArrayList<>();

		daymonthl = new ArrayList<>();

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

		daymonthl.add(31);
		daymonthl.add(29);
		daymonthl.add(31);
		daymonthl.add(30);
		daymonthl.add(31);
		daymonthl.add(30);
		daymonthl.add(31);
		daymonthl.add(31);
		daymonthl.add(30);
		daymonthl.add(31);
		daymonthl.add(30);
		daymonthl.add(31);

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

	public String showshow(String m, int year) {
		String r = "";
		try {
			// setup
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:celendar.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {

				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println(m);

				String query = "select * from events where month = '" + m + "' and year = " + year + " order by day";
				Statement statement = conn.createStatement();
				ResultSet resultset = statement.executeQuery(query);

				while (resultset.next()) {
					String month = resultset.getString(1);
					int day = resultset.getInt(2);
					int y = resultset.getInt(3);
					String note = ": " + resultset.getString(5);
					String time = resultset.getString(4);
					String str = "";

					if (!str.equals("")) {
						note = str;
					}
					// r += month + " " + day + " "+y+" " +time+" "+ note +
					// "\n===========================\n";
					String mm = (month + " " + day + " " + y + "  " + time);
					r += mm + "\n";

					for (String i : note.split("\n")) {
						r += String.format("%40s", "") + "   " + i + "\n";
					}
					r += "=======================================\n";

					// System.out.println(mm+" **********");
					// r += ;

				}
				resultset.close();
				statement.close();

			}
			conn.close();

		} catch (

		ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (!r.equals("")) {
			System.out.println(r + " return");
			return r;
		}
		return "You don't have events in this month";

	}

	public String showEventDB(String m, int year) {
		String r = "";
		try {
			// setup
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:celendar.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {

				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println(m);

				String query = "select * from events where month = '" + m + "' and year = " + year + " order by day";
				Statement statement = conn.createStatement();
				ResultSet resultset = statement.executeQuery(query);

				while (resultset.next()) {
					String month = resultset.getString(1);
					int day = resultset.getInt(2);
					int y = resultset.getInt(3);
					String note = ": " + resultset.getString(5);
					String time = resultset.getString(4);
					String str = "";

					if (note.split("\n").length > 1) {
						str += " " + note.split("\n")[0] + "\n";
						for (int j = 1; j < note.split("\n").length; j++) {
							for (int i = 0; i < 18; i++) {

								str += " ";
							}
							if (j == note.split("\n").length - 1) {
								str += ": " + note.split("\n")[j];
							} else {
								str += ": " + note.split("\n")[j] + "\n";
							}

						}

					}
					if (!str.equals("")) {
						note = str;
					}
					r += month + " " + day + " " + y + "  " + time + " " + note + "\n===========================\n";

				}
				resultset.close();
				statement.close();

			}
			conn.close();

		} catch (

		ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (!r.equals("")) {
			return r;
		}
		return "You don't have events in this month";
	}

	public void addEventdb(String x) {

		try {
			// setup
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:celendar.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {

				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				// String query = "select * from events";
				Statement statement = conn.createStatement();
				statement.execute("insert into events\nvalues ('" + x.split(" ")[0] + "',"
						+ Integer.parseInt(x.split(" ")[1]) + "," + Integer.parseInt(x.split(" ")[2]) + ",'"
						+ x.split(" ")[3] + "','" + x.split(":")[2] + "')");
				// ResultSet resultset = statement.executeQuery(query);
				// resultset.close();
				statement.close();

			}
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addDiary(int day, String x) {
		try {
			// setup
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:celendar.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {

				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				DateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				
				Date date;
				
				int m = 1 ;

				Statement statement = conn.createStatement();
	
				for (int i : getDaymonth(Integer.parseInt(x.split(" ")[2]))) {
					
					for (int j = 1; j <= i; j++) {

						try {
							date = dateTimeFormat.parse(j + "/" + m + "/" + Integer.parseInt(x.split(" ")[2]) + " "
									+ x.split(" ")[3]);
							if(date.getDay()==day){
								statement.execute("insert into events\nvalues ('"+getMonth(m-1)+"',"+j+","+x.split(" ")[2]+",'"+x.split(" ")[3]+"','"+x.split(" :")[1]+"')");
							}
							
							
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					m+=1;

				}

				statement.close();

			}
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(x+"     EVENT");
		System.out.println(getDaymonth(Integer.parseInt(x.split(" ")[2])));

	}

	public void deleteDB(String event) {
		try {
			// setup
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:celendar.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				// System.out.println("Delete from events where month =
				// '"+event.split(" ")[0]+"' and day = "+event.split(" ")[1]);
				String query = "Delete from events where month = '" + event.split(" ")[0] + "' and day ="
						+ event.split(" ")[1] + " and year = " + event.split(" ")[2];
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

	public String searchDB(String event) {
		String r = "";
		System.out.println(event + " oooooooo");

		try {
			// setup
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:celendar.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {

				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				// System.out.println("select * from events where month = '" +
				// event.split(" ")[0] + "' and day = "
				// + event.split(" ")[1] + " and year = " + event.split("
				// ")[2]);

				String query = "select * from events where month = '" + event.split(" ")[0] + "' and day ="
						+ event.split(" ")[1] + " and year =" + event.split(" ")[2] + " and time = '"
						+ event.split(" ")[3] + "'";
				Statement statement = conn.createStatement();
				ResultSet resultset = statement.executeQuery(query);

				if (resultset.next()) {
					String month = resultset.getString(1);
					int day = resultset.getInt(2);
					int year = resultset.getInt(3);
					String time = resultset.getString(4);
					String note = resultset.getString(5);
					r += month + " " + day + " " + year + " " + time + " :" + note;

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

		if (!r.equals("")) {
			return r;
		}
		return "";

	}

	public ArrayList<String> getMonth() {
		return month;
	}

	public String getMonth(int i) {
		return month.get(i);

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

	public ArrayList<Integer> getDaymonth(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {

			return daymonthl;
		}

		return daymonth;
	}

	public void setDaymonth(ArrayList<Integer> daymonth) {
		this.daymonth = daymonth;
	}

}