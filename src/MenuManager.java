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
			num = input.nextInt();   //num 을 받아들이는 부분. (1-6부터 무슨 숫자를 받느냐에 따라 달라지게 세팅 할것임)
			switch(num) {   // if 문을 써도 되 지만, swich 가 더 가독성이 좋아서 사용  +case에 break 를 걸어줘야 끝이난다, 아닌경우: 모든케이스를 진행)
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