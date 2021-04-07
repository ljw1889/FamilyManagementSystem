import java.util.Scanner;

public class Family {

	String name;
	String relation;
	int birth;
	String adress;

	public Family(){ 
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

	public void printInfo() {
		System.out.println("name : "+this.name +"\n"+"relation : "+ this.relation+ "\n"+ "birth : "+this.birth+"\n"+"adress : "+ this.adress);                              
	}
}