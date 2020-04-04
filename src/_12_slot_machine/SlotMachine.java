package _12_slot_machine;
//DONE!!!!
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JLabel orange=loadImage("orange1.png");
	JLabel cherry=loadImage("cherry.jpeg");
	JLabel lemon=loadImage("lemon.png");
	JButton button=new JButton();
	int random;
	int random1;
	int random2;
	
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
void randomImage(){
	
	Random rand=new Random();
	 random=rand.nextInt(3);
	 random1=rand.nextInt(3);
	 random2=rand.nextInt(3);
	if(random==0) {
		orange=loadImage("orange1.png");
	}
	if (random==1){
		orange=loadImage("cherry.jpeg");
	}
	if(random==2) {
		orange=loadImage("lemon.png");
	
	}
	if(random1==0) {
		cherry=loadImage("orange1.png");
	}
	if(random1==1) {
		cherry=loadImage("cherry.jpeg");
		
	}
	if(random1==2) {
		cherry=loadImage("lemon.png");
	}
	if(random2==0) {
		lemon=loadImage("orange1.png");
	}
	if(random2==1) {
		lemon=loadImage("cherry.jpeg");
	}
	if(random2==2) {
		lemon=loadImage("lemon.png");
	}
	
}


private JLabel loadImage(String fileName) {
	URL imageURL = getClass().getResource(fileName);
	Icon icon = new ImageIcon(imageURL);
	return new JLabel(icon);
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	if(random==random1&&random1==random2) {
		JOptionPane.showMessageDialog(null, "You win!");
	}
	panel.remove(lemon);
	panel.remove(cherry);
	panel.remove(orange);
	randomImage();
	panel.add(cherry);
	panel.add(lemon);
	panel.add(orange);
	frame.pack();
}
}