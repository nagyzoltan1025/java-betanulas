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
		// nyomtat�s implement�ci�
		
	}

	@Override
	public Document scan() {
		// a nyomtat� nem tud scannelni, ez�rt ezt a funkci�t nem tudjuk implement�lni
		// mivel musz�j, �gy eldobunk egy exception-t:
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
 * @Override public void print(Document document) { // nyomtat�s implement�ci�
 * 
 * } }
 */

public class InterfaceSegregationBadExample {

}
