import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import log.EventLogger;

public class MenuManager {
	static EventLogger logger = new EventLogger("log.txt");	//�α׸� �����ϴ� �ΰŸ� ������. , static ���� �ѹ� �����Ѱſ��� ��� �� �� �ְ�
	public static void main(String[] args) {
 
		Scanner input = new Scanner(System.in);
		FamilyManager familyManager = getObject("Familymanager.ser");
		if(familyManager == null ) {
			familyManager = new FamilyManager(input);
		}

		selectMenu(input, familyManager);					 // exception ����.

		putObject(familyManager,"Familymanager.ser");

	}

	public static void selectMenu(Scanner input,FamilyManager familyManager) {
		int num = -1;
		while (num != 5) {
			try {
				ShowMenu();
				num = input.nextInt();   //num �� �޾Ƶ��̴� �κ�. (1-6���� ���� ���ڸ� �޴��Ŀ� ���� �޶����� ���� �Ұ���)
				switch(num) {   // if ���� �ᵵ �� ����, swich �� �� �������� ���Ƽ� ���  +case�� break �� �ɾ���� ���̳���, �ƴѰ��: ������̽��� ����)
				case 1:
					familyManager.addFamily();
					logger.log("add a family");
					break;
				case 2:
					familyManager.deleteFamily();
					logger.log("delete a family");
					break;
				case 3:
					familyManager.editFamily();
					logger.log("edit a family");
					break;
				case 4:
					familyManager.viewFamilys();
					logger.log("view a list of family");
					break;
				default:
					continue;
				} 	
			}catch(InputMismatchException e) {
				System.out.println("Please put an integer between 1 to 5 !");
				if(input.hasNext()) {
					input.next();
				}
				num = -1;
			}
		}
	}
	public static void ShowMenu() {
		System.out.println("*** Family Management System Menu ***");
		System.out.println("1. Add Family");
		System.out.println("2. Delete Family");
		System.out.println("3. Edit Family");
		System.out.println("4. View Familys");
		System.out.println("5. Exit ");
		System.out.print("Select one number between 1-5: ");
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

	public static void putObject(FamilyManager familyManager,String filename) {//���� ������ ������Ʈ���� write �� �� �ִ°���.

		try {
			FileOutputStream file = new FileOutputStream(filename); //���� ���� ������ ��
			ObjectOutputStream out = new ObjectOutputStream(file);  //�� ���� ������Ʈ�� ����

			out.writeObject(familyManager); //�Ű������� ������Ʈ�� ����

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
	//get put : ����� ����, �� get�� ��ǻ�Ϳ��� �������°� , put�� ���� ��ǻ�ͷ� �о� �ִ°�
}