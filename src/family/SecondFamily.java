package family;

import java.util.Scanner;

public class SecondFamily extends Family {  //형제,자매

	public SecondFamily(FamilyKind kind){ 
		this.kind = kind;        
	}
	
	public void getUserInput(Scanner input) {
		setName(input);
		setRelation(input);
		setBirth(input);
		setAdress(input);
		setPhone(input);
	}
	
	public void printInfo() {
		String fkind = getKindFamily();
		System.out.println("kind : "+ fkind + "name : "+this.name +"\n"+"relation : "+ this.relation+ "\n"+ "birth : "+this.birth+"\n"+"adress : "+ this.adress+"\n" + "phone : " + this.phone +"\n");                              
	}
}
