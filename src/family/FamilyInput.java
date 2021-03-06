package family;

import java.util.Scanner;

import exceptions.PhoneFormatException;

public interface FamilyInput {
	
	public String getName();
	
	public void setName(String name);
	
	public String getRelation();
	
	public void setRelation(String relation);
	
	public int getBirth();
	
	public void setBirth(int birth);
	
	public String getAdress();
	
	public void setAdress(String adress);
	
	public void setPhone(String phone) throws PhoneFormatException;
	
	public void printInfo();
	
	public void getUserInput(Scanner input);
	
	public void setName(Scanner input);
	public void setRelation(Scanner input);
	public void setBirth(Scanner input);
	public void setAdress(Scanner input);
	public void setPhone(Scanner input);
}
