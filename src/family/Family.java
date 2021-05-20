package family;
import java.io.Serializable;
import java.util.Scanner;

import exceptions.PhoneFormatException;

public abstract class Family implements FamilyInput,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5552807900255596794L;

	protected FamilyKind kind = FamilyKind.SecondCousin; // Default °ªÀ¸·Î »ïÃÌ.

	protected String name;
	protected String relation;
	protected int birth;
	protected String adress;
	protected String phone;


	public Family(){ 
	}

	public Family(FamilyKind kind){ 
		this.kind = kind;
	}

	public Family(String name,String relation){ 
		this.name = name;
		this.relation = relation;
	}

	public Family(String name,String relation,int birth){ 
		this.name = name;
		this.relation = relation;
		this.birth = birth;
	}

	public Family(String name,String relation,int birth,String adress){ 
		this.name = name;
		this.relation = relation;
		this.birth = birth;
		this.adress = adress;
	}
	public Family(FamilyKind kind, String name,String relation,int birth,String adress){ 
		this.kind = kind;
		this.name = name;
		this.relation = relation;
		this.birth = birth;
		this.adress = adress;
	}

	public FamilyKind getKind() {
		return kind;
	}

	public void setKind(FamilyKind kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhone() {			//second, cousin
		return phone;
	}

	public void setPhone(String phone) throws PhoneFormatException {		//second, cousin	
		if(!phone.contains("-") && !phone.equals("")) {
			throw new PhoneFormatException();
		}
		this.phone = phone;
	}

	public abstract void printInfo();	

	public void setName(Scanner input) {
		System.out.print("Name : ");
		this.setName(input.next()); 
	}
	public void setRelation(Scanner input) {
		System.out.print("Relation : ");
		this.setRelation(input.next());
	}
	public void setBirth(Scanner input) {
		System.out.print("Birth : ");
		this.setBirth(input.nextInt());
	}
	public void setAdress(Scanner input) {
		System.out.print("Adress : ");
		this.setAdress(input.next());
	}
	public void setPhone(Scanner input) {	//second, cousin
		String phone = "";
		while(!phone.contains("-")) {
			System.out.print("Phone : ");
			phone = input.next();
			try {
				this.setPhone(phone);
			} catch (PhoneFormatException e) {
				System.out.println("Incorrect Phone Format -> Contain '-' ");
				//	e.printStackTrace();
			}
		}
	}

	public String getKindFamily() {
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
		return fkind;
	}
}