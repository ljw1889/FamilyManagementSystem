package family;

import java.util.Scanner;

public class ThirdFamily extends Family {
	public void getUserInput(Scanner input) {
		System.out.print("Name : ");
		String name = input.next();
		this.setName(name);

		System.out.print("Relation : ");
		String relation = input.next();
		this.setRelation(relation);

		char answer = 'q';
		while (true) {
			System.out.print("Do you Know Birth? (Y/N) : ");
			answer = input.next().charAt(0);
			if (answer == 'y' || answer == 'Y') {
				System.out.print("Birth : ");
				int birth = input.nextInt();
				this.setBirth(birth);
				break;
			}
			else if (answer == 'n' || answer == 'N') {
				this.setBirth(000000);
				break;
			}
			else {
			}
		}
		System.out.print("Adress : ");
		String adress = input.next();
		this.setAdress(adress);
	}
}
