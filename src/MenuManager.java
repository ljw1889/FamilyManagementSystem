import java.util.Scanner;

public class MenuManager {

	public static void main(String[] args) {
		int num = -1;
		Scanner input = new Scanner(System.in);
		FamilyManager familyManager = new FamilyManager(input);

		while (num != 5) {

			System.out.println("*** Family Management System Menu ***");
			System.out.println("1. Add Family");
			System.out.println("2. Delete Family");
			System.out.println("3. Edit Family");
			System.out.println("4. View Familys");
			System.out.println("5. Exit ");
			System.out.print("Select one number between 1-5: ");
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
			} 	
		}
	}
}