import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonAddListener implements ActionListener {

	WindowFrame frame;
	
	public ButtonAddListener(WindowFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		JButton button = (JButton)e.getSource();
//		FamilyAdder adder = frame.getFamilyadder();
//		frame.setupPanel(adder); 
		frame.getContentPane().removeAll();
		frame.getContentPane().add(frame.getFamilyadder());
		frame.revalidate();
		frame.repaint();
	}

}
