package ku.sci.cs.calendar;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Calendar;

public class MyAppTest {

	@Test
	public void test() {
		Calendar cal = new  Calendar();
		assertEquals(cal.showEvent("January"),"You don't have events in this month");
		cal.addEvent("July 27 Birthday", 0);
		assertEquals(cal.showEvent("July"),"July 27 Birthday\n");
		cal.addEvent("July 31 Nut'Birthday", 0);
		assertEquals(cal.showEvent("July"),"July 27 Birthday\nJuly 31 Nut'Birthday\n");
		
		cal.addEvent("June 18 midterm exam", 0);
		assertEquals(cal.showEvent("June"), "June 18 midterm exam\n");
		
		assertEquals(cal.showEvent("August"),"You don't have events in this month");
		assertEquals(cal.showEvent("December"),"You don't have events in this month");
		
		
		
	}


}
