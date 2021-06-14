
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
	public static FamilyManager getObject(String filename) { 	//사용자 입장에서 오브젝트를 가져와서 이제 거기 내용을 쓸 수가 있는것임.
		FamilyManager familyManager=null;	//패밀리 매니저 를 하나 만들고
		try {
			FileInputStream file = new FileInputStream(filename);	//파일로 입력되게 만들고(즉, 포스트잇 하나 만드는거) 
			ObjectInputStream in = new ObjectInputStream(file);  //그 파일에 오브젝트형 안에서 입력되게(즉,(포스트잇 말고 공책에 작성) 오브젝트 안에 기록을 한다는것임)
			//input output : 파일 입장, 즉 나는 반대로 생각하면 됨 output은 내가 입력해서 파일에 적히는것
			familyManager = (FamilyManager)in.readObject(); //read: 사용자 입장, 읽은 오브젝트를 형변환 시켜서 줌, 이제 이걸 리턴해서 여기 적는 내용으로 오브젝트에 로그 기록이 가능한 것임. 

			
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
