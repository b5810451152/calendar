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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Model.Calendar;

public class MainView {
	JFrame frame, framepop, frameevent;
	JPanel panel, panel2, panel22, panel3, panelpop, panelevent;
	JButton d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16, d17, d18, d19, d20, d21, d22, d23,
			d24, d25, d26, d27, d28, d29, d30, d31, d32, d33, d34, d35, d36, d37, d38, d39, d40, d41, d42;
	ArrayList<JButton> button;
	JScrollPane jsc;
	JTextArea ta, tae;
	JButton bm, next, back, sm, done, ce;
	Calendar mycalemdar;
	String event;
	JComboBox<String> jcom;
	JLabel en;

	public MainView(Calendar calendar) {

		this.mycalemdar = calendar;
		button = new ArrayList<>();

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
		jcom = new JComboBox<>();

		for (String i : mycalemdar.getMonth()) {
			jcom.addItem(i);

		}
		jcom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(jcom.getToolTipText());

			}
		});

		bm = new JButton(mycalemdar.getStamonth());
		next = new JButton(">>");
		back = new JButton("<<");

		panel.setLayout(new BorderLayout());
		panel.add(panel2, BorderLayout.NORTH);
		panel2.add(next, BorderLayout.EAST);
		panel2.add(back, BorderLayout.WEST);
		panel2.add(bm, BorderLayout.CENTER);

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
				showmonth(mycalemdar.getStamonth());

			}
		});
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bm.setText(mycalemdar.next(mycalemdar.getStamonth()));
				showmonth(mycalemdar.getStamonth());

			}
		});

		panel.add(panel3, BorderLayout.CENTER);
		this.showmonth(mycalemdar.getStamonth());

		panel.add(ce, BorderLayout.SOUTH);

		for (final JButton i : button) {
			i.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (!i.getText().equals("")) {
						event = bm.getText() + " " + i.getText();
						if (!mycalemdar.searchDB(event).equals("")) {
							ta.setText(mycalemdar.searchDB(event).split(":")[1]);
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

		frame.setVisible(true);
		en = new JLabel("Enter your note :");
		framepop = new JFrame("Your Event");
		panelpop = new JPanel();
		ta = new JTextArea("");
		sm = new JButton("submit");
		panelpop.setLayout(new BorderLayout());
		panelpop.add(ta, BorderLayout.CENTER);
		panelpop.add(sm, BorderLayout.SOUTH);
		panelpop.add(en, BorderLayout.NORTH);
		framepop.add(panelpop);
		// framepop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framepop.setPreferredSize(new Dimension(300, 300));
		framepop.setSize(300, 300);
		framepop.setVisible(false);

		sm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				framepop.setVisible(false);
				if (!(ta.getText().equals(""))) {

					// mycalemdar.addEvent(event + " : " + ta.getText(), 0);
					// System.out.println(event+" "+ta.getText());
					// System.out.println(ta.getText());
					mycalemdar.addEventdb(event + " :" + ta.getText());
				}
			}
		});

		frameevent = new JFrame("My event");
		tae = new JTextArea();
		jsc = new JScrollPane(tae);
		// frameevent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameevent.setPreferredSize(new Dimension(300, 600));
		frameevent.setSize(300, 600);
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

				tae.setText(mycalemdar.showEventDB(mycalemdar.getStamonth()));

			}
		});
		done.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameevent.setVisible(false);

			}
		});

	}

	public void showmonth(String stam) {
		Integer indexstart = 0;
		Integer day = mycalemdar.getDaymonth().get(mycalemdar.getMonth().indexOf(stam));
		if (stam == "January") {
			for (int i = 0; i < button.size(); i++) {
				if (i < 31) {
					button.get(i).setText((i + 1) + "");
				} else {
					button.get(i).setText("");
				}
			}
		} else {
			for (int i = 0; i < mycalemdar.getMonth().indexOf(stam); i++) {
				indexstart += mycalemdar.getDaymonth().get(i) % 7;

			}
			Integer date = 1;
			indexstart = indexstart % 7;
			for (int i = 0; i < button.size(); i++) {
				if (i >= indexstart && i <= day + indexstart - 1) {
					button.get(i).setText((date) + "");
					date += 1;
				} else {
					button.get(i).setText("");
				}
			}

		}

	}

}
