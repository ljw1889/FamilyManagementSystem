import java.util.ArrayList;
import java.util.Scanner;

import family.CousinFamily;
import family.Family;
import family.FamilyInput;
import family.FamilyKind;
import family.SecondFamily;
import family.ThirdFamily;

public class FamilyManager {
	Scanner input;

	FamilyManager(Scanner input){
		this.input = input;
	}
	ArrayList<FamilyInput> familys = new ArrayList<FamilyInput>(); //리스트로 여러명의 페밀리를 받을 공간을 만듦 

	public void addFamily() {
		int kind =0;
		FamilyInput familyInput;
		while (kind != 1 && kind != 2 && kind != 3 && kind != 4) {
		//em.out.println("1 for Family");
			System.out.println("1 for SecondsCousin");
			System.out.println("2 for ThirdCousin");
			System.out.println("3 for Cousin");
			System.out.print("Select number for Family Kind : ");
			kind = input.nextInt();
			if (kind==1) { 
				familyInput = new SecondFamily(FamilyKind.SecondCousin);
				familyInput.getUserInput(input);
				familys.add(familyInput);
			}
			else if (kind==2) {
				familyInput = new ThirdFamily(FamilyKind.ThirdCousin);
				familyInput.getUserInput(input);
				familys.add(familyInput);
			}
			else if (kind==3) {
				familyInput = new CousinFamily(FamilyKind.Cousin);
				familyInput.getUserInput(input);
				familys.add(familyInput);
			}
		/*	else if (kind==4) {
				familyInput = new Family();
				familyInput.getUserInput(input);
				familys.add(familyInput);
			}*/
			else {
				System.out.print("Select number for Family Kind : ");
			}
		}
	}

	public void deleteFamily() {
		System.out.print("Name : ");
		String name = input.next();
		int index = -1;

		for (int i =0; i <familys.size();i++) {
			if (familys.get(i).getName().equals(name)){
				index = i; 
				break; // for 문을 나감
			}
		}
		if (index>=0) {          // index가 0 보다 크면 학생을 찾은거다.
			familys.remove(index);
			System.out.println("the family" + name+ "is deleted");
		}
	}

	public void editFamily() {
		System.out.print("Name : ");
		String name = input.next();
		for (int i =0; i <familys.size();i++) {
			FamilyInput familyinput = familys.get(i);
			if (familyinput.getName().equals(name)){
				int num = -1;
				while (num != 5) {
					System.out.println("*** Family Management System Menu ***");
					System.out.println("1. Edit Name");
					System.out.println("2. Edit Relation");
					System.out.println("3. Edit Birth");
					System.out.println("4. Edit Adress");
					System.out.println("5. Exit ");
					System.out.print("Select one number between 1-5: ");
					num = input.nextInt();   

					switch(num) { 
					case 1:
						System.out.print("Name : ");
						familys.get(i).setName(input.next());
						break;
					case 2:
						System.out.print("Relation : ");
						familys.get(i).setRelation(input.next());
						break;
					case 3:
						System.out.print("Birth : ");
						familys.get(i).setBirth(input.nextInt());
						break;
					case 4:
						System.out.print("Adress : ");
						familys.get(i).setAdress(input.next());
						break;
					} 	//switch
				} //while
				break;
			}  //if
		} //for
	}  //editFamily()


	public void viewFamilys() {
		for (int i =0; i <familys.size();i++) {
			familys.get(i).printInfo();
		} 
	}
}
