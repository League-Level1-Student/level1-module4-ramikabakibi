package _08_calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	JLabel label1 = new JLabel();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JTextField field = new JTextField(10);
	JTextField field2 = new JTextField(10);
	int number;
	int number2;

	void doingstuff() {
		frame.add(panel);
		panel.add(field);
		panel.add(label1);
		panel.add(field2);
		panel.add(label);
		panel.add(button);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		frame.setTitle("The Best of the Best of the Best Calculator");
		frame.setVisible(true);
		button.setText("add");
		button1.setText("sub");
		button2.setText("mul");
		button3.setText("div");
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		frame.pack();
	}

	void add(int number, int number2) {
		int additionanswer = number + number2;
		label1.setText(additionanswer + "");
	}

	void subtract(int number3, int number4) {
		int subtractionanswer = number3 - number4;
		label1.setText(subtractionanswer + "");
	}

	void divide(double number5, int number6) {
		double divide = number5 / number6;
		label1.setText(divide + "");
	}

	void multiply(int number7, int number8) {
		int multiply = number7 * number8;
		label1.setText(multiply + "");
	}
	void makeInt(String x, String y) {
		Integer.parseInt(x);
		Integer.parseInt(y);
	}
	//BIG BOY NOTE: ALMOST DONE, I NEED TO COMPLETE WHAT YOU SEE IN THE ACTION PERFORMED BELOW FOR ALL THE OPERATIONS, ASK DANIEL ABOUT THE MAKE INT METHOD ABOVE TO USE LESS CODE

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button) {
			int s=Integer.parseInt(field.getText());
			int x=Integer.parseInt(field2.getText());
			add(s, x);
		}
		if(e.getSource()==button1) {
			int subtract1=Integer.parseInt(field.getText());
			int subtract2=Integer.parseInt(field2.getText());
			subtract(subtract1, subtract2);
		}
		if(e.getSource()==button2) {
			int multiply1=Integer.parseInt(field.getText());
			int multiply2=Integer.parseInt(field2.getText());
			multiply(multiply1, multiply2);
		}
		if (e.getSource()==button3) {
			int divide1=Integer.parseInt(field.getText());
			int divide2=Integer.parseInt(field2.getText());
			divide(divide1, divide2);
		}
	}
}
