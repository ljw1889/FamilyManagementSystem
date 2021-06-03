import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import family.CousinFamily;
import family.Family;
import family.FamilyInput;
import family.FamilyKind;
import family.SecondFamily;
import family.ThirdFamily;

public class FamilyManager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2412553903878265045L;
	transient Scanner input; 	//�����ڷ� �ٷ� ����.
	FamilyManager(){		//������
	}
	FamilyManager(Scanner input){		//������
		this.input = input;
	}
	ArrayList<FamilyInput> familys = new ArrayList<FamilyInput>(); //����Ʈ�� �������� ��и��� ���� ������ ���� 
	
	public void addFamily() {
		int kind =-1;
		FamilyInput familyInput;
		while (kind != 1 && kind != 2 && kind != 3 ) {
			try {
			System.out.println("1 for SecondsCousin");
			System.out.println("2 for ThirdCousin");
			System.out.println("3 for Cousin");
			System.out.print("Select number for Family Kind : ");
			
//			System.out.println(input);   
			
			kind = input.nextInt();
			if (kind==1) { 
				familyInput = new SecondFamily(FamilyKind.SecondCousin);
				familyInput.getUserInput(input);
				familys.add(familyInput);
			}
			else if (kind==2) {
				familyInput = new ThirdFamily(FamilyKind.ThirdCousin);
				familyInput.getUserInput(input);
				familys.add(familyInput);
			}
			else if (kind==3) {
				familyInput = new CousinFamily(FamilyKind.Cousin);
				familyInput.getUserInput(input);
				familys.add(familyInput);
			}
			else {
				System.out.print("Select number for Family Kind : ");
			}}
			catch(InputMismatchException e) {
				System.out.println("Please put an integer between 1 to 3 !");
				if(input.hasNext()) {
					input.next();
				}
				kind = -1;
			}
		}
	}
	
	public void deleteFamily() {
		System.out.print("Name : ");
		String name = input.next();
		int index = findIndex(name);	//�����丵
		removefromFamily(index,name);	//�����丵
	}	
	public int findIndex(String name) {	//�����丵 �Լ�
		int index = -1;

		for (int i =0; i <familys.size();i++) {
			if (familys.get(i).getName().equals(name)){
				index = i; 
				break; // for ���� ����
			}
		}
		return index;
	}
	public void removefromFamily(int index,String name) { 	//�����丵 �Լ�
		if (index>=0) {          // index�� 0 ���� ũ�� �л��� ã���Ŵ�.
			familys.remove(index);
			System.out.println("the family" + name+ "is deleted");
		}
	}

	public void editFamily() {
		System.out.print("Name : ");
		String name = input.next();
		for (int i =0; i <familys.size();i++) {
			FamilyInput family = familys.get(i);
			if (family.getName().equals(name)){
				int num = -1;
				while (num != 5) {
					showEditMenu();
					num = input.nextInt();   

					switch(num) { 
					case 1:
						family.setName(input);
						break;
					case 2:
						family.setRelation(input);
						break;
					case 3:
						family.setBirth(input);
						break;
					case 4:
						family.setAdress(input);
						break;  
					default:
						continue;
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

	public int size() {
		return familys.size(); 
	}
	
	public FamilyInput get(int index) {
		return (Family) familys.get(index);
	}
	
	public void showEditMenu() {
		System.out.println("*** Family Management System Menu ***");
		System.out.println("1. Edit Name");
		System.out.println("2. Edit Relation");
		System.out.println("3. Edit Birth");
		System.out.println("4. Edit Adress");
		System.out.println("5. Exit ");
		System.out.print("Select one number between 1-5: ");
	}
	public void setInput(Scanner input) {
		this.input = input;
	}
}

