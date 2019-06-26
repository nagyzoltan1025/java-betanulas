package initialization.block;

public class InitParentExample extends InitAbstractExample{

	static {
		System.out.println("Static Parent 1");
	}
	
	static {
		System.out.println("Static Parent 2");
	}
	
	{
		System.out.println("Instance Parent 1");
	}
	
	{
		System.out.println("Instance Parent 2");
	}
	
	InitParentExample() {
		System.out.println("Constructor Parent");
	}
}
