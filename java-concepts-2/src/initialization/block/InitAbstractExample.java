package initialization.block;

public class InitAbstractExample {

	
	static {
		System.out.println("Static abstract");
	}
	
	{
		System.out.println("Instance abstract");
	}
	
	InitAbstractExample() {
		System.out.println("Abstract Constructor");
	}
}
