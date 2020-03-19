package _11_whack_a_mole;


import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton secretbutton;
	int mole = 0;
	int missed=0;
	Date date;
	void doingstuff() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(500, 500);
		
	}

	void drawButtons(int numbButtons) {

		int r = new Random().nextInt(numbButtons);
		for (int i = 0; i < numbButtons; i++) {
			JButton button = new JButton();
			button.addActionListener(this);

			if (i == r) {
				button.setText("mole");
				secretbutton = button;
			}
			panel.add(button);
		}
		

	}
void start(){
	date=new Date();
	doingstuff();
	drawButtons(100);
}
	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

	private void endGame(Date timeAtStart, int molesWhacked) {
		Date timeAtEnd = new Date();
		System.out.println(molesWhacked);
		System.out.println((timeAtEnd.getTime() - timeAtStart.getTime()));
		JOptionPane.showMessageDialog(null, "Your whack rate is "
				+ ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked) + " moles per second.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == secretbutton) {
			playSound("yes.wav");
			frame.getContentPane().removeAll();
			panel=new JPanel();
			doingstuff();
			drawButtons(100);
			frame.repaint();
			frame.revalidate();
			mole++;
			if(mole==10) {
				endGame(date, mole);
			}
		} else {
			
			missed++;
			speak("You've missed "+missed+" times");
		}
		if(missed==5) {
			JOptionPane.showMessageDialog(null, "I'm sorry dude but you LOSSSSTTTTTTT!!!!");
			endGame(date, mole);
		}
	}
}