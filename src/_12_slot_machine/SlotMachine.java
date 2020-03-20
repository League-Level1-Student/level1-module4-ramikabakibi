package _12_slot_machine;
//NOTE NOTE NOTE NOTE: I finished the random image class for one slot, but now i need to do the code for action listener for the button i think
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JLabel orange=loadImage("orange1.png");
	JLabel cherry=loadImage("cherry.jpeg");
	JLabel lemon=loadImage("lemon.png");
	JButton button=new JButton();
	
void doingStuff() {
	frame.add(panel);
	panel.add(button);
	button.setText("SPIN");
	button.addActionListener(this);
	panel.add(orange);
	panel.add(cherry);
	panel.add(lemon);
	//orange.setPreferredSize(new Dimension(200,200));
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.pack();
}
JLabel randomImage(){
	JLabel label1=new JLabel();
	Random rand=new Random();
	int random=rand.nextInt(3);
	if(random==1) {
		label1=loadImage("orange1.png");
	}
	if (random==2){
		label1=loadImage("cherry.jpeg");
	}
	if(random==3) {
		label1=loadImage("lemon.png");
	
	}
	return label1;
}
private JLabel loadImage(String fileName) {
	URL imageURL = getClass().getResource(fileName);
	Icon icon = new ImageIcon(imageURL);
	return new JLabel(icon);
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
}