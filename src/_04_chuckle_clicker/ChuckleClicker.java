package _04_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class ChuckleClicker implements ActionListener {
	JButton button=new JButton();
	JButton button2=new JButton();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
ChuckleClicker clicker=new ChuckleClicker();
clicker.makeButtons();
	}
void	makeButtons(){
		JFrame frame=new JFrame();
		frame.setVisible(true);
		JPanel panel=new JPanel();
		
		frame.add(panel);
		panel.add(button);
		panel.add(button2);
		button.setText("joke");
		button2.setText("punchline");
		button.addActionListener(this);
		button2.addActionListener(this);
	}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==button) {
		JOptionPane.showMessageDialog(null, "Why did the bike fall over?");
	}
	if(e.getSource()==button2){
		JOptionPane.showMessageDialog(null, "It was two tired");
	}
}

}
