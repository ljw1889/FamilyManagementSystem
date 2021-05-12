package family;

import java.util.Scanner;

public class ThirdFamily extends TCFamily {
	
	public ThirdFamily(FamilyKind kind){ 
		super(kind);
		//this.kind = kind;           //super(kind) 와 차이점이 무엇이지?
	}
	public void getUserInput(Scanner input) {
		setName(input);
		setRelation(input);
		setFamilyBirthwithYN(input);
		setAdress(input);
	}
	
	public void printInfo() {
		String fkind = getKindFamily();
		System.out.println("kind : "+ fkind + "name : "+this.name +"\n"+"relation : "+ this.relation+ "\n"+ "birth : "+this.birth+"\n"+"adress : "+ this.adress+"\n");                              
	}
}
