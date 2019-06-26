package initialization.block;

public interface InitParentInterface {
	
	int i = 2;

	// Error: interface-nél nem lehet initializert létrehozni:
	/*
	static {
		System.out.println("Static interface");
	}*/
	
	/*
	{
		System.out.println("Instance interface");
	}*/
	
	// Interface-eknek nem lehet konstruktora:
	/*InitParentInterface() {
		
	}*/
	
}
