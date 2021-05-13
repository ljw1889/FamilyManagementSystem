import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManager {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		FamilyManager familyManager = new FamilyManager(input);
		selectMenu(input, familyManager);					 // exception ����.

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
					break;
				case 2:
					familyManager.deleteFamily();
					break;
				case 3:
					familyManager.editFamily();
					break;
				case 4:
					familyManager.viewFamilys();
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
}