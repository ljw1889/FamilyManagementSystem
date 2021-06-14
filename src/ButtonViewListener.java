
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;

public class ButtonViewListener implements ActionListener {

	WindowFrame frame;
	
	public ButtonViewListener(WindowFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FamilyViewer familyViewer = frame.getFamilyviewer();
		FamilyManager familyManager = getObject("Familymanager.ser"); 
		familyViewer.setFamilyManager(familyManager);
		
//		JButton button = (JButton)e.getSource();
//		FamilyViewer viewer = frame.getFamilyviewer();
//		frame.setupPanel(viewer); 
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(familyViewer);
		frame.revalidate();
		frame.repaint();
	}
	public static FamilyManager getObject(String filename) { 	//����� ���忡�� ������Ʈ�� �����ͼ� ���� �ű� ������ �� ���� �ִ°���.
		FamilyManager familyManager=null;	//�йи� �Ŵ��� �� �ϳ� �����
		try {
			FileInputStream file = new FileInputStream(filename);	//���Ϸ� �Էµǰ� �����(��, ����Ʈ�� �ϳ� ����°�) 
			ObjectInputStream in = new ObjectInputStream(file);  //�� ���Ͽ� ������Ʈ�� �ȿ��� �Էµǰ�(��,(����Ʈ�� ���� ��å�� �ۼ�) ������Ʈ �ȿ� ����� �Ѵٴ°���)
			//input output : ���� ����, �� ���� �ݴ�� �����ϸ� �� output�� ���� �Է��ؼ� ���Ͽ� �����°�
			familyManager = (FamilyManager)in.readObject(); //read: ����� ����, ���� ������Ʈ�� ����ȯ ���Ѽ� ��, ���� �̰� �����ؼ� ���� ���� �������� ������Ʈ�� �α� ����� ������ ����. 

			
			in.close();
			file.close();


		} catch (FileNotFoundException e) {
			return familyManager;
			//	e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return familyManager;
	}  
}
