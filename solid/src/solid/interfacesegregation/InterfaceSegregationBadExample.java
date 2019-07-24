package solid.interfacesegregation;

class Document{ }
class NotImplementedException extends RuntimeException {}

interface PrinterInterface {
	public void print(Document document);
	public Document scan(); 
}

class MyOldPrinter implements PrinterInterface{

	@Override
	public void print(Document document) {
		// nyomtatás implementáció
		
	}

	@Override
	public Document scan() {
		// a nyomtató nem tud scannelni, ezért ezt a funkciót nem tudjuk implementálni
		// mivel muszáj, így eldobunk egy exception-t:
		throw new NotImplementedException();
	}
	
}

/*
 * interface PrinterInterface { public void print(Document document); }
 * 
 * interface ScannerInterface { public Document scan(); }
 * 
 * class MyOldPrinter implements PrinterInterface {
 * 
 * @Override public void print(Document document) { // nyomtatás implementáció
 * 
 * } }
 */

public class InterfaceSegregationBadExample {

}
