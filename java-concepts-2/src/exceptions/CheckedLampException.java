package exceptions;

abstract class CheckedLampException extends Exception {
	
	CheckedLampException() {
		System.out.println("CheckedLampException created");
	}
	
	abstract void message();
}

abstract class UncheckedLampException extends RuntimeException {
	
	UncheckedLampException(){
		System.out.println("UncheckedLampException created.");
	}
	
	abstract void warning();
}

class NoLightbulbInTheLampException extends CheckedLampException {
	
	NoLightbulbInTheLampException() {
		System.out.println("NoLightBulbException created.");
	}
	
	@Override
	void message() {
		System.out.println("There is no lightbulb in the lamp");
	}
}

class NoPowerException extends CheckedLampException {
	
	NoPowerException(){
		System.out.println("NoPowerException created.");
	}
	
	@Override
	void message() {
		System.out.println("There is no power.");
	}
}

class UnexpectedLampMalfunction extends UncheckedLampException {
	
	UnexpectedLampMalfunction() {
		System.out.println("UnexpectedLampMalfunction created.");
	}
	
	void warning() {
		System.out.println("The Lamp exlpoded");
	}
}

