package family;

import java.util.Scanner;

import exceptions.PhoneFormatException;

public abstract class TCFamily extends Family {

	public TCFamily(FamilyKind kind){ 
		super(kind);
	}

	public abstract void getUserInput(Scanner input);

	public void setFamilyBirthwithYN(Scanner input) {
		char answer = 'q';
		while (true) {
			System.out.print("Do you Know Birth? (Y/N) : ");
			answer = input.next().charAt(0);
			if (answer == 'y' || answer == 'Y') {
				setBirth(input);
				break;
			}
			else if (answer == 'n' || answer == 'N') {
				this.setBirth(000000);
				break;																	
			}
			else {
			}
		}
	}
	public void setFamilyPhonewithYN(Scanner input) {
		char answer2 = 'q';
		
		while(true) {
			System.out.print("Do you Know Phone Number? (Y/N) : ");
			answer2 = input.next().charAt(0);
			try {  
				if (answer2 == 'y' || answer2 == 'Y') {
					setPhone(input);
					break;
				}
				else if (answer2 == 'n' || answer2 == 'N') {
					this.setPhone("");
					break;
				}
				else {
				}
			}catch (PhoneFormatException e) {
				System.out.println("Incorrect Phone Format -> Contain '-' ");
			}
		}
	}

	public void printInfo() {
		String fkind = getKindFamily();
		System.out.println("kind : "+ fkind + "name : "+this.name +"\n"+"relation : "+ this.relation+ "\n"+ "birth : "+this.birth+"\n"+"adress : "+ this.adress+"\n" + "phone : " + this.phone +"\n");                              
	}

}
