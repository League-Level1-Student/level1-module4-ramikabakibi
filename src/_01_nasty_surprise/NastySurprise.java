package _01_nasty_surprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySurprise implements ActionListener {

	
JFrame frame=new JFrame();
JPanel panel=new JPanel();
JButton button=new JButton();
JButton button1=new JButton();

	
void SettingStuff() {
	frame.add(panel);
	panel.add(button);
	panel.add(button1);
	button.setText("Treat");
	button1.setText("Trick");
	button.addActionListener(this);
	button1.addActionListener(this);
	frame.pack();
	frame.setVisible(true);
}

private void showPictureFromTheInternet(String imageUrl) {
    try {
        URL url = new URL(imageUrl);
        Icon icon = new ImageIcon(url);
        JLabel imageLabel = new JLabel(icon);
        JFrame frame = new JFrame();
        frame.add(imageLabel);
        frame.setVisible(true);
        frame.pack();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==button) {
		showPictureFromTheInternet("https://d17fnq9dkz9hgj.cloudfront.net/uploads/2018/03/Russian-Blue_01.jpg");
	}
	if(e.getSource()==button1) {
		showPictureFromTheInternet("https://i.pinimg.com/originals/cf/72/16/cf7216d7135400b060e617260d0e7a24.jpg");
	}
}
}

