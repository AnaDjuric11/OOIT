package geometry;

import javax.swing.JFrame;

public class TestFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Drawing());
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
