import java.util.ArrayList;
import java.util.Scanner;

public class FamilyManager {
	Scanner input;

	FamilyManager(Scanner input){
		this.input = input;
	}
	ArrayList<Family> familys = new ArrayList<Family>(); //리스트로 여러명의 페밀리를 받을 공간을 만듦 
	
	public void addFamily() {
		Family family = new Family();
		System.out.print("Name : ");
		family.name = input.next();
		System.out.print("Relation : ");
		family.relation = input.next();
		System.out.print("Birth : ");
		family.birth = input.nextInt();
		System.out.print("Adress : ");
		family.adress = input.next();
		
		familys.add(family); // 리스트에 목록 추가
	}
	public void deleteFamily() {
		System.out.print("Name : ");
		String name = input.next();
		int index = -1;
		
		for (int i =0; i <familys.size();i++) {
			if (familys.get(i).name.equals(name)){
				index = i; 
				break; // for 문을 나감
			}
		}
		if (index>=0) {          // index가 0 보다 크면 학생을 찾은거다.
			familys.remove(index);
			System.out.println("the family" + name+ "is deleted");
		}
		System.out.println("the family is deleted");
		
	}
	
	public void editFamily() {
		System.out.print("Name : ");
		String name = input.next();
		for (int i =0; i <familys.size();i++) {
			Family family = familys.get(i);
			if (family.name.equals(name)){
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
						family.name = input.next();
						break;
					case 2:
						System.out.print("Relation : ");
						family.relation = input.next();
						break;
					case 3:
						System.out.print("Birth : ");
						family.birth = input.nextInt();
						break;
					case 4:
						System.out.print("Adress : ");
						family.adress = input.next();
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
