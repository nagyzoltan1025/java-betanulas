package initialization.block;

public class InitChildExample extends InitParentExample{
	
	static int myStaticI = 1;
	// Egyszerű kifejezés változó értékének inicializálására: 
	int i = -1;
	// bonyolult kifejezés változó értékének inicializálására
	int j = (int) (Math.abs(i)*Math.PI);

	// Inicializációs blokkok & konstruktor
	{
		System.out.println("Instance child 1");
		i = 11;
	}
	
	static {
		// Error: i nem statikus, itt nem tudom megváltoztatni az értékét.
		// i = 2;
		myStaticI = 2;
		System.out.println("Static child 2");

	}
	
	{
		myStaticI = 1000;
		System.out.println("Instance child 2");
	}
	
	InitChildExample() {
		System.out.println("Constructor child");
	}
	
	static {
		System.out.println("Static child 1");
	}
	
}
