package file.processing;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class FileHandlingExamples {

	/**
	 * A File osztály 3 metódussal rendelkezik, melyel pathokat lehet kezelni:
	 * 	Path: Ezt kapta paraméterül a File objektum konstruktora.
	 * 	Absolute Path: A fájl könyvtárának teljes elérési útja. Lényegében a Path mögé odatesszük az utat a gyökérkönyvtárig
	 * 	Canonical Path: Feloldja az absolute path-t, emelett eltünteti az elérésből a spec karaktereket, pl.: ".", ".." stb
	 * 		Mivel a getCanonicalPath a file systemmel dolgozik, emiatt IOException dob, amit try-catch-el el kell kapni.
	 * 		Ha a canonical path olyan karaktert tartalmaz, amit a fájlrendszer az elérési útvonalaiban nem enged meg, akkor
	 * 		a getCanonicalPath IOException-t dob.
	 * 	
	 * 	Forrás:
	 * 		https://www.baeldung.com/java-path
	 * 
	 */
	public static void printPathsInfoExample() {
		File myPath = new File("\\myFolder\\..\\myFile.txt");
		System.out.println("getAbsolutePath: " + myPath.getAbsolutePath()); //C:\myFolder\..\myFile.txt
		System.out.println("getParent: " + myPath.getParent()); // \myFolder\..
		System.out.println("getParentFile: " + myPath.getParentFile()); // \myFolder\.. // fájl objektumot ad vissza
		System.out.println("getPath: " + myPath.getPath()); // \myFolder\..\myFile.txt
		try {
			System.out.println("getCanonicalPath: " + myPath.getCanonicalPath()); // C:\myFile.txt
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * A metódus az aktuális projekt könyvtárban létrehoz egy új könyvtárat.
	 * A projekt elérését System.getProperty("user.dir") adja.
	 * Az új könyvtár a File object mkdir metódushívásával jön létre.
	 * Az mkdir metódus egy boolean-t ad vissza, mely értéke annak függvénye,
	 * hogy a létrejött-e. Ezt az értéket kiíratom. 
	 * 
	 * Majd a metódus a létrehozott könyvtárban létrehoz egy új fájlt a createNewFile metódus segítségével.
	 */
	public static void createFolderAndFileTest() {
		// Könyvtár létrehozása projektben
		File myPath = new File(System.getProperty("user.dir") + "\\src\\file\\Folder1");
		System.out.println(myPath.mkdir());
		File myFile = new File(System.getProperty("user.dir") + "\\src\\file\\Folder1\\myFile.txt");
		try {
			System.out.println(myFile.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * File class konstruktorok hívása:
	 */
	public static void fileConstructorTest() {
		File myPath = new File(System.getProperty("user.dir") + "\\src\\Folder2", "\\Subfolder");
		System.out.println(myPath.getAbsolutePath());
		
		File myFile = new File(myPath, "\\myFile.txt");
		System.out.println(myFile.getAbsolutePath());
		
		try {
			File myURI = new File(new URI("file:///C:/_git/fun-with-java/java-concepts-2/src/Folder1/myFile.txt"));
			System.out.println(myURI.getPath());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Kiírja a processing könyvtárban található fájlokat és könyvtárakat.
	 */
	public static void  listingDirectories() {
		File file = null;
		String[] paths;
		
		file = new File(System.getProperty("user.dir") + "\\src\\file\\processing");
		paths = file.list();
		
		for(String path:paths) {
			System.out.println(path);
		}
	}
	
}