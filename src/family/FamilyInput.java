package family;

import java.util.Scanner;

public interface FamilyInput {
	
	public String getName();
	
	public void setName(String name);
	
	public void setRelation(String relation);
	
	public void setBirth(int birth);
	
	public void setAdress(String adress);
	
	public void printInfo();
	
	public void getUserInput(Scanner input);
	
}
