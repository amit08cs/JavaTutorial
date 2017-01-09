package threads;



class A{
	static{
		System.out.println("1");
	}
	
	{
		System.out.println("2");
	}
}

class B extends A{
	static{
		System.out.println("3");
	}
	{
		System.out.println("4");
	}
}
public class StatickBlockCode {

	
	public static void main(String[] args) {
		B b=new B();
		B b1=new B();
		
		
	}
}
