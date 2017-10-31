package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteOrder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Model.Calendar;

public class MainView {
	JFrame frame, framepop, frameevent;
	JPanel panel, panel2, panel22, panel3, panelpop, panelevent, panelbut, sma;
	JButton d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16, d17, d18, d19, d20, d21, d22, d23,
			d24, d25, d26, d27, d28, d29, d30, d31, d32, d33, d34, d35, d36, d37, d38, d39, d40, d41, d42;
	ArrayList<JButton> button;
	JScrollPane jsc;
	JTextArea ta, tae;
	JButton bm, next, back, sm, done, ce, smd;
	Calendar mycalemdar;
	String event;
	JComboBox<String> jcomm, jcomy, jth, jtm;
	JLabel en;
	int month;
	int year;
	String time;
	String day;

	public MainView(Calendar calendar) {

		DateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date myTime = new Date();
		month = (myTime.getMonth() + 1);
		year = Integer.parseInt(myTime.toString().split(" ")[myTime.toString().split(" ").length - 1]);
		time = myTime.toString().split(" ")[3].substring(0, 5);
		this.mycalemdar = calendar;
		button = new ArrayList<>();
		panelbut = new JPanel();
		jcomm = new JComboBox<>();
		jcomy = new JComboBox<>();
		panelbut.setLayout(new BorderLayout());
		panelbut.add(jcomm, BorderLayout.CENTER);
		panelbut.add(jcomy, BorderLayout.EAST);

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400, 400));
		frame.setSize(800, 600);
		panel = new JPanel();
		panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());

		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(6, 7));
		frame.add(panel);
		String y = "1994 1996 1997 2001 2000 2010 2011 2012 2013 2013 2014 2015 2016 2017 2018 2019 2020";
		for (String i : y.split(" ")) {
			jcomy.addItem(i);
		}

		for (String i : mycalemdar.getMonth()) {
			jcomm.addItem(i);

		}

		jcomm.setSelectedItem(mycalemdar.getMonth(month - 1));
		jcomy.setSelectedItem(year + "");
		jcomm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				month = mycalemdar.getMonth().indexOf(jcomm.getSelectedItem().toString()) + 1;
				year = Integer.parseInt(jcomy.getSelectedItem().toString());
				//

				showcalendar(mycalemdar.getMonth().indexOf(jcomm.getSelectedItem().toString()) + 1, year, time);

			}

		});
		jcomy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				year = Integer.parseInt(jcomy.getSelectedItem().toString());
				month = mycalemdar.getMonth().indexOf(jcomm.getSelectedItem().toString()) + 1;
				showcalendar(month, Integer.parseInt(jcomy.getSelectedItem().toString()), time);

			}
		});

		bm = new JButton(mycalemdar.getStamonth());

		next = new JButton(">>");
		back = new JButton("<<");
		final JTextField searchbar = new JTextField();
		searchbar.setPreferredSize(new Dimension(100, 20));
		searchbar.addActionListener(new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				e.getActionCommand();
				frameevent.setVisible(true);

				tae.setText(mycalemdar.searchBar(searchbar.getText()));	
			}
		});
		panel.setLayout(new BorderLayout());
		panel.add(panel2, BorderLayout.NORTH);
		panel2.add(searchbar, BorderLayout.EAST);
		// panel2.add(back, BorderLayout.WEST);
		panel2.add(panelbut, BorderLayout.CENTER);
		panel22 = new JPanel();
		panel22.setLayout(new GridLayout(1, 7));
		panel22.add(new JLabel("     Sunday"));
		panel22.add(new JLabel("     Monday"));
		panel22.add(new JLabel("     Tuesday"));
		panel22.add(new JLabel("     Wenesday"));
		panel22.add(new JLabel("     Thusday"));
		panel22.add(new JLabel("     Friday"));
		panel22.add(new JLabel("     Saturday"));
		panel2.add(panel22, BorderLayout.SOUTH);

		d1 = new JButton("");
		d2 = new JButton("");
		d3 = new JButton("");
		d4 = new JButton("");
		d5 = new JButton("");
		d6 = new JButton("");
		d7 = new JButton("");
		d8 = new JButton("");
		d9 = new JButton("");
		d10 = new JButton("");
		d11 = new JButton("");
		d12 = new JButton("");
		d13 = new JButton("");
		d14 = new JButton("");
		d15 = new JButton("");
		d16 = new JButton("");
		d17 = new JButton("");
		d18 = new JButton("");
		d19 = new JButton("");
		d20 = new JButton("");
		d21 = new JButton("");
		d22 = new JButton("");
		d23 = new JButton("");
		d24 = new JButton("");
		d25 = new JButton("");
		d26 = new JButton("");
		d27 = new JButton("");
		d28 = new JButton("");
		d29 = new JButton("");
		d30 = new JButton("");
		d31 = new JButton("");
		d32 = new JButton("");
		d33 = new JButton("");
		d34 = new JButton("");
		d35 = new JButton("");
		d36 = new JButton("");
		d37 = new JButton("");
		d38 = new JButton("");
		d39 = new JButton("");
		d40 = new JButton("");
		d41 = new JButton("");
		d42 = new JButton();

		button.add(d1);
		button.add(d2);
		button.add(d3);
		button.add(d4);
		button.add(d5);
		button.add(d6);
		button.add(d7);
		button.add(d8);
		button.add(d9);
		button.add(d10);
		button.add(d11);
		button.add(d12);
		button.add(d13);
		button.add(d14);
		button.add(d15);
		button.add(d16);
		button.add(d17);
		button.add(d18);
		button.add(d19);
		button.add(d20);
		button.add(d21);
		button.add(d22);
		button.add(d23);
		button.add(d24);
		button.add(d25);
		button.add(d26);
		button.add(d27);
		button.add(d28);
		button.add(d29);
		button.add(d30);
		button.add(d31);
		button.add(d32);
		button.add(d33);
		button.add(d34);
		button.add(d35);
		button.add(d36);
		button.add(d37);
		button.add(d38);
		button.add(d39);
		button.add(d40);
		button.add(d41);
		button.add(d42);
		ce = new JButton("Show your events!");

		for (JButton i : button) {
			panel3.add(i);
		}

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bm.setText(mycalemdar.back(mycalemdar.getStamonth()));
				// showmonth(mycalemdar.getStamonth());

			}
		});
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bm.setText(mycalemdar.next(mycalemdar.getStamonth()));
				// showmonth(mycalemdar.getStamonth());

			}
		});

		panel.add(panel3, BorderLayout.CENTER);
		// this.showmonth(mycalemdar.getStamonth());

		// ==============================
		this.showcalendar(month, year, time);

		panel.add(ce, BorderLayout.SOUTH);

		frame.setVisible(true);

		en = new JLabel("Enter your note :");
		framepop = new JFrame("Your Event");
		panelpop = new JPanel();
		jtm = new JComboBox<>();
		jth = new JComboBox<>();

		for (int i = 1; i <= 23; i++) {
			if (i < 10) {
				jth.addItem("0" + i);
			} else {
				jth.addItem(i + "");
			}
		}
		for (int i = 1; i <= 59; i++) {
			if (i < 10) {
				jtm.addItem("0" + i);
			} else {
				jtm.addItem(i + "");
			}
		}
		JPanel jj = new JPanel();
		jj.setLayout(new GridLayout(1, 2));
		jj.add(jth);
		jj.add(jtm);
		ta = new JTextArea("");
		sm = new JButton("submit");
		sma = new JPanel();
		sma.setLayout(new GridLayout(2, 1));
		sma.add(sm);
		smd = new JButton("Diary");
		sma.add(smd);

		panelpop.setLayout(new BorderLayout());
		panelpop.add(ta, BorderLayout.CENTER);
		panelpop.add(jj, BorderLayout.SOUTH);
		panelpop.add(en, BorderLayout.NORTH);
		panelpop.add(sma, BorderLayout.EAST);
		framepop.add(panelpop);
		// framepop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framepop.setPreferredSize(new Dimension(300, 300));
		framepop.setSize(300, 300);
		framepop.setVisible(false);

		jth.setSelectedItem(myTime.toString().split(" ")[3].substring(0, 5).split(":")[0]);
		jtm.setSelectedItem(myTime.toString().split(" ")[3].substring(0, 5).split(":")[1]);
		jth.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				event = event.substring(0, event.split(":")[0].length() - 2) + jth.getSelectedItem().toString() + ":"
						+ jtm.getSelectedItem().toString();

				if (!mycalemdar.searchDB(event).equals("")) {

					ta.setText(mycalemdar.searchDB(event).split(" :")[1]);
					mycalemdar.deleteDB(event);

				} else {
					ta.setText("");
				}

			}
		});

		jtm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				event = event.substring(0, event.split(":")[0].length() - 2) + jth.getSelectedItem().toString() + ":"
						+ jtm.getSelectedItem().toString();

				if (!mycalemdar.searchDB(event).equals("")) {

					ta.setText(mycalemdar.searchDB(event).split(" :")[1]);
					mycalemdar.deleteDB(event);

				} else {
					ta.setText("");
				}

			}
		});

		for (final JButton i : button) {
			i.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (!i.getText().equals("")) {
						Date date = new Date();
						System.out.println(date);
						day = i.getText();
						System.out.println(day);

						// System.out.println(event);
						// jth.setSelectedItem(date.toString().split("
						// ")[3].substring(0, 5).split(":")[0]);
						// jtm.setSelectedItem(date.toString().split("
						// ")[3].substring(0, 5).split(":")[1]);

						event = jcomm.getSelectedItem() + " " + i.getText() + " " + jcomy.getSelectedItem() + " "
								+ jth.getSelectedItem().toString() + ":" + jtm.getSelectedItem().toString();
						if (!mycalemdar.searchDB(event).equals("")) {
							ta.setText(mycalemdar.searchDB(event).split(" :")[1]);
							framepop.setVisible(true);
							mycalemdar.deleteDB(event);

						} else {
							ta.setText("");
							framepop.setVisible(true);
						}

					}

				}
			});
		}

		sm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				framepop.setVisible(false);
				if (!(ta.getText().equals(""))) {

					// event = event.substring(0,
					// event.split(":")[0].length()+3)+" "
					// +
					// jth.getSelectedItem().toString()+":"+jtm.getSelectedItem().toString();

					System.out.println(event + " :" + ta.getText());
					mycalemdar.addEventdb(event + " :" + ta.getText());

				}
			}
		});

		smd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				framepop.setVisible(false);
				if (!(ta.getText().equals(""))) {
					DateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
					Date date;

					try {
						date = dateTimeFormat.parse(day + "/" + month + "/" + year + " "
								+ jth.getSelectedItem().toString() + ":" + jtm.getSelectedItem().toString());
						if (!ta.getText().equals("")) {
							mycalemdar.addDiary(date.getDay(), (event + " :" + ta.getText()));
						}
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});

		frameevent = new JFrame("My event");
		tae = new JTextArea();
		jsc = new JScrollPane(tae);
		// frameevent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameevent.setPreferredSize(new Dimension(400, 600));
		frameevent.setSize(400, 600);
		panelevent = new JPanel();
		panelevent.setLayout(new BorderLayout());
		panelevent.add(jsc);
		done = new JButton("done");
		panelevent.add(done, BorderLayout.SOUTH);
		frameevent.add(panelevent);
		frameevent.setVisible(false);

		ce.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameevent.setVisible(true);

				tae.setText(mycalemdar.showshow((String) jcomm.getSelectedItem(),
						Integer.parseInt(jcomy.getSelectedItem().toString())));

			}
		});
		done.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameevent.setVisible(false);

			}
		});

	}

	public void showcalendar(int month, int year, String time) {
		int daystart = 1;
		DateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date myTime;

		try {

			myTime = dateTimeFormat.parse("01/" + month + "/" + year + " " + time);
			System.out.println(mycalemdar.getDaymonth(year).get(month - 1));
			for (int i = 0; i < button.size(); i++) {
				if (i >= myTime.getDay() && i < mycalemdar.getDaymonth(year).get(month - 1) + myTime.getDay()) {

					button.get(i).setText(daystart + "");
					daystart += 1;

				} else {
					button.get(i).setText("");
				}
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
