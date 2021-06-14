import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import gui.SpringUtilities;

public class FamilyAdder extends JPanel {
	
	WindowFrame frame;
	FamilyManager familyManager;
	
	public FamilyAdder(WindowFrame frame,FamilyManager familyManager) {
		this.familyManager = familyManager;
		this.frame = frame;		
		
		JPanel panel = new JPanel(new SpringLayout());
	//	panel.setLayout(new SpringLayout());  생성자로 레이아웃이 설정 가능하고, 따로 이렇게도 설정 가능함
		
		JLabel labelName = new JLabel("Name: ",JLabel.TRAILING);
		JTextField fieldName = new JTextField(10);
		labelName.setLabelFor(fieldName);
		panel.add(labelName);
		panel.add(fieldName);
		
		JLabel labelRelation = new JLabel("Relation: ",JLabel.TRAILING);
		JTextField fieldRelation = new JTextField(10);
		labelRelation.setLabelFor(fieldRelation);
		panel.add(labelRelation);
		panel.add(fieldRelation);
		
		JLabel labelBirth = new JLabel("Birth: ",JLabel.TRAILING);
		JTextField fieldBirth = new JTextField(10);
		labelBirth.setLabelFor(fieldBirth);
		panel.add(labelBirth);
		panel.add(fieldBirth);
		
		JLabel labelAdress = new JLabel("Adress: ",JLabel.TRAILING);
		JTextField fieldAdress = new JTextField(10);
		labelAdress.setLabelFor(fieldAdress);
		panel.add(labelAdress);
		panel.add(fieldAdress);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new FamilyAdderListener(fieldName,fieldRelation,fieldBirth,fieldAdress,familyManager));
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new FamilyAdderCancelListener(frame));
		
		panel.add(saveButton);
		panel.add(cancelButton);
		
		SpringUtilities.makeCompactGrid(panel, 5 , 2, 6, 6, 6, 6);
		
		this.add(panel);

		
	}

}
