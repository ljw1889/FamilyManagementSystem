import java.util.Scanner;

public class FamilyManager {
	Scanner input;

	FamilyManager(Scanner input){
		this.input = input;
	}
	Family family; 
	
	public void addFamily() {
		family = new Family();
		System.out.print("Name : ");
		family.name = input.next();
		System.out.print("Relation : ");
		family.relation = input.next();
		System.out.print("Birth : ");
		family.birth = input.nextInt();
		System.out.print("Adress : ");
		family.adress = input.next();
	}
	public void deleteFamily() {
		System.out.print("Name : ");
		String name = input.next();
		
		if (family == null) {
			System.out.println("the family has not been registered");
			return;
		}
		if (family.name.equals(name)){
			System.out.println("the family is deleted");
			family = null;
		}
	}
	public void editFamily() {
		System.out.print("Name : ");
		String name = input.next();
		if (family.name.equals(name)){
			System.out.println("the family is deleted");
		}
	}
	public void viewFamily() {
		System.out.print("Name : ");
		String name = input.next();
		if (family.name.equals(name)){
			family.printInfo();
		}
	}

}
