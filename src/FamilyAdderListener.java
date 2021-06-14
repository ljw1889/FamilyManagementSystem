

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JTextField;

import family.Family;
import family.FamilyInput;
import family.FamilyKind;
import family.SecondFamily;

public class FamilyAdderListener implements ActionListener {
	FamilyManager familyManager;
	
	JTextField fieldName;
	JTextField fieldRelation;
	JTextField fieldBirth;
	JTextField fieldAdress;
	
	public FamilyAdderListener( //생성자 (4개의 필드를 받음)
			JTextField fieldName, 
			JTextField fieldRelation, 
			JTextField fieldBirth,
			JTextField fieldAdress, FamilyManager familyManager) {
		this.fieldName = fieldName;
		this.fieldRelation = fieldRelation;
		this.fieldBirth = fieldBirth;
		this.fieldAdress = fieldAdress;
		this.familyManager = familyManager;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		FamilyInput family = new SecondFamily(FamilyKind.SecondCousin);
		family.setName(fieldName.getText());
		family.setRelation(fieldRelation.getText());
		family.setBirth(Integer.parseInt(fieldBirth.getText()));
		family.setAdress(fieldAdress.getText());
		familyManager.addFamily(family);
		
		putObject(familyManager,"Familymanager.ser");
		family.printInfo(); 
	}
	
	public static void putObject(FamilyManager familyManager,String filename) {//이제 가져온 오브젝트에서 write 할 수 있는거임.

		try {
			FileOutputStream file = new FileOutputStream(filename); //내가 적을 파일을 고름
			ObjectOutputStream out = new ObjectOutputStream(file);  //그 파일 오브젝트로 적음

			out.writeObject(familyManager); //매개변수를 오브젝트에 적음

			out.close();
			file.close();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  
}
