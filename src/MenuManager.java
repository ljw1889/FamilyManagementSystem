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
	static EventLogger logger = new EventLogger("log.txt");	//로그를 관리하는 로거를 생성함. , static 으로 한번 실행한거에서 계속 쓸 수 있게
	public static void main(String[] args) {
 
		Scanner input = new Scanner(System.in);
		FamilyManager familyManager = getObject("Familymanager.ser");
		if(familyManager == null ) {
			familyManager = new FamilyManager(input);
		}

		selectMenu(input, familyManager);					 // exception 포함.

		putObject(familyManager,"Familymanager.ser");

	}

	public static void selectMenu(Scanner input,FamilyManager familyManager) {
		int num = -1;
		while (num != 5) {
			try {
				ShowMenu();
				num = input.nextInt();   //num 을 받아들이는 부분. (1-6부터 무슨 숫자를 받느냐에 따라 달라지게 세팅 할것임)
				switch(num) {   // if 문을 써도 되 지만, swich 가 더 가독성이 좋아서 사용  +case에 break 를 걸어줘야 끝이난다, 아닌경우: 모든케이스를 진행)
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
	//get put : 사용자 입장, 즉 get은 컴퓨터에서 가져오는거 , put은 내가 컴퓨터로 밀어 넣는것
}