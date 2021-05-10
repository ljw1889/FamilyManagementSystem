package family;
import java.util.Scanner;

public abstract class Family {

	protected FamilyKind kind = FamilyKind.SecondCousin; // Default ������ ����.

	protected String name;
	protected String relation;
	protected int birth;
	protected String adress;

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

	public abstract void printInfo();
//	public void printInfo() {
//		String fkind = "none";
//		switch(this.kind) {
//		case SecondCousin :
//			fkind = "SecondCousin";
//			break;
//		case ThirdCousin :
//			fkind = "ThirdCousin";
//			break;
//		case Cousin :
//			fkind = "Cousin";
//			break;
//		default:
//		}
//		System.out.println("kind : "+ fkind + "name : "+this.name +"\n"+"relation : "+ this.relation+ "\n"+ "birth : "+this.birth+"\n"+"adress : "+ this.adress+"\n");                              
//	}

//	public void getUserInput(Scanner input) {
//		System.out.print("Name : ");
//		String name = input.next();
//		this.setName(name);
//
//		System.out.print("Relation : ");
//		String relation = input.next();
//		this.setRelation(relation);
//
//		System.out.print("Birth : ");
//		int birth = input.nextInt();
//		this.setBirth(birth);
//
//		System.out.print("Adress : ");
//		String adress = input.next();
//		this.setAdress(adress);
//	}
}