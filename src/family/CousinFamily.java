package family;

import java.util.Scanner;

public class CousinFamily extends Family implements FamilyInput {
	protected int phone;
	
	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public CousinFamily(FamilyKind kind){ 
		this.kind = kind;           //super(kind) 이거 대체.
	}
	
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
		
		char answer2 = 'q';
		while(true) {
			System.out.print("Do you Know Phone Number? (Y/N) : ");
			answer2 = input.next().charAt(0);
			if (answer2 == 'y' || answer2 == 'Y') {
				System.out.print("Phone : ");
				int phone = input.nextInt();
				this.setPhone(phone);
				break;
			}
			else if (answer2 == 'n' || answer2 == 'N') {
				this.setPhone(00000000);
				break;
			}
			else {
			}
		}
	}
	public void printInfo() {
		String fkind = "none";
		switch(this.kind) {
		case SecondCousin :
			fkind = "SecondCousin";
			break;
		case ThirdCousin :
			fkind = "ThirdCousin";
			break;
		case Cousin :
			fkind = "Cousin";
			break;
		default:
		}
		System.out.println("kind : "+ fkind + "name : "+this.name +"\n"+"relation : "+ this.relation+ "\n"+ "birth : "+this.birth+"\n"+"adress : "+ this.adress+"\n" + "phone : " + this.phone +"\n");                              
	}
}
