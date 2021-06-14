import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FamilyAdderCancelListener implements ActionListener {

	WindowFrame frame;
	
	public FamilyAdderCancelListener(WindowFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		JButton button = (JButton)e.getSource();
//		FamilyAdder adder = frame.getFamilyadder();
//		frame.setupPanel(adder); 
		frame.getContentPane().removeAll();
		frame.getContentPane().add(frame.getMenuselection());
		frame.revalidate();
		frame.repaint();
	}

}
