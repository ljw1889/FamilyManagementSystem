package family;

import java.util.Scanner;

public class CousinFamily extends TCFamily {
	protected String phone;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public CousinFamily(FamilyKind kind){ 
		super(kind);
	}
	
	public void getUserInput(Scanner input) {
		setName(input);
		setRelation(input);
		setFamilyBirthwithYN(input);
		setAdress(input);
		setFamilyPhonewithYN(input);
	}
	public void printInfo() {
		String fkind = getKindFamily();
		System.out.println("kind : "+ fkind + "name : "+this.name +"\n"+"relation : "+ this.relation+ "\n"+ "birth : "+this.birth+"\n"+"adress : "+ this.adress+"\n" + "phone : " + this.phone +"\n");                              
	}	
}
