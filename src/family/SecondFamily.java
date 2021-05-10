package family;

import java.util.Scanner;

public class SecondFamily extends Family implements FamilyInput {  //형제,자매
	protected int phone;
	
	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public SecondFamily(FamilyKind kind){ 
		this.kind = kind;           //super(kind) 이거 대체.
	}
	
	public void getUserInput(Scanner input) {
		System.out.print("Name : ");
		String name = input.next();
		this.setName(name);

		System.out.print("Relation : ");
		String relation = input.next();
		this.setRelation(relation);

		System.out.print("Birth : ");
		int birth = input.nextInt();
		this.setBirth(birth);

		System.out.print("Adress : ");
		String adress = input.next();
		this.setAdress(adress);
		
		System.out.print("Phone : ");
		int phone = input.nextInt();
		this.setPhone(phone);
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
