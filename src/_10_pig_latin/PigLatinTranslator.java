package _10_pig_latin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PigLatinTranslator implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField field = new JTextField(10);
	JTextField field2 = new JTextField(10);
	JButton button = new JButton();

	/**
	 * Method to test whether a character is a letter or not.
	 * 
	 * @param c The character to test
	 * @return True if it's a letter
	 */
	private static boolean isLetter(char c) {
		if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
			return true;
		} else {
			return false;
		}
//Note: The same code that is in the if statement was just by itself with a return, but I put it in if statement, ask Daniel if the above is correct or not
	}

	/**
	 * Method to translate one word into pig latin.
	 * 
	 * @param word The word in english
	 * @return The pig latin version
	 */
	private static String pigWord(String word) {
		int split = firstVowel(word);
		return word.substring(split) + "-" + word.substring(0, split) + "ay";
	}

	/**
	 * Method to translate a sentence word by word.
	 * 
	 * @param s The sentence in English
	 * @return The pig latin version
	 */
	public String translate(String s) {
		String latin = "";
		int i = 0;
		while (i < s.length()) {
			// Take care of punctuation and spaces
			while (i < s.length() && !isLetter(s.charAt(i))) {
				latin = latin + s.charAt(i);
				i++;
			}
			// If there aren't any words left, stop.
			if (i >= s.length())
				break;
			// Otherwise we're at the beginning of a word.
			int begin = i;
			while (i < s.length() && isLetter(s.charAt(i))) {
				i++;
			}
			// Now we're at the end of a word, so translate it.
			int end = i;
			latin = latin + pigWord(s.substring(begin, end));
		}
		return latin;
	}

	/**
	 * Method to find the index of the first vowel in a word.
	 * 
	 * @param word The word to search
	 * @return The index of the first vowel
	 */
	private static int firstVowel(String word) {
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++)
			if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
					|| word.charAt(i) == 'u')
				return i;
		return 0;
	}

	void doingstuff() {
		frame.add(panel);
		button.addActionListener(this);
		panel.add(field);
		panel.add(button);
		panel.add(field2);
		frame.setVisible(true);
		frame.pack();
		button.setText("Translate");

	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String secondbox=translate(field.getText());
	field2.setText(secondbox);
}
}