import java.util.Scanner;

public class MenuManager {

	public static void main(String[] args) {
		int num = 0;
		Scanner input = new Scanner(System.in);
		
		while (num != 6) {
		
		System.out.println("*** Family Management System Menu ***");
		System.out.println("1. Add Family");
		System.out.println("2. Delete Family");
		System.out.println("3. Edit Family");
		System.out.println("4. View Family");
		System.out.println("5. Show a Menu");
		System.out.println("6. Exit ");
		System.out.print("Select one number between 1-6: ");
		num = input.nextInt();   //num �� �޾Ƶ��̴� �κ�. (1-6���� ���� ���ڸ� �޴��Ŀ� ���� �޶����� ������ �Ұ���)
		switch(num) {   // if ���� �ᵵ �� ����, swich �� �� �������� ���Ƽ� ���  +case�� break �� �ɾ���� ���̳���, �ƴѰ��: ������̽��� ����)
		case 1:
			System.out.print("Name : ");
			String name = input.next();
			System.out.print("Relation : ");
			String relation = input.next();
			System.out.print("Birth : ");
			int birth = input.nextInt();
			System.out.print("Adress : ");
			String adress = input.next();
			break;
		case 2:
		case 3:
		case 4:
			System.out.print("Name : ");
			String name2 = input.next();  
		}
		}
	}
}