package _05_typing_tutor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
JFrame frame=new JFrame();
JPanel panel=new JPanel();
char currentLetter;
JLabel label=new JLabel();
void type() {
	frame.setTitle("Type or die");
	frame.setVisible(true);
	frame.add(label);
	currentLetter = generateRandomLetter();
	label.setText(currentLetter+"");
	frame.add(panel);
	panel.add(label);
	label.setFont(label.getFont().deriveFont(28.0f));
	label.setHorizontalAlignment(JLabel.CENTER);
	frame.addKeyListener(this);
}
char generateRandomLetter() {
    Random r = new Random();
    return (char) (r.nextInt(26) + 'a');
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("You typed: "+ e.getKeyChar());
	if(currentLetter==e.getKeyChar()){
		System.out.println("Correct!");
		panel.setBackground(Color.green);
	}
	else {
		System.out.println("Incorrect");
		panel.setBackground(Color.red);
	}
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	currentLetter=generateRandomLetter();
	label.setText(currentLetter+"");
}



}
