package sample.member;

class Parent {
	int i = 10;
	public void exec(){
		System.out.println(i);
	}
}

class Child extends Parent {
	int i = 5;
	int j = 10;
	public void exec(){
		System.out.println(i);
	}
}

public class TestPC {
	
	public static void main(String[] args){
		Parent p = new Child();
		System.out.println(p.i);
	}

}
