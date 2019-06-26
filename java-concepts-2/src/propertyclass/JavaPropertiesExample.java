package propertyclass;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Forrás:
 * https://www.baeldung.com/java-properties
 * @author NZ-LENOVO
 *
 */
public class JavaPropertiesExample {

	static String path = System.getProperty("user.dir") + "\\src\\propertyclass";
	
	/**
	 * Létre van hozva a property class-ban két darab property fájl:
	 * 	app.properties
	 * 	catalog 
	 * A catalog egy kiterjesztés nélküli fájl, annyit hivatott szemléltetni, 
	 * hogy a Properties osztály képes bármilyen fáljkiterjesztést kezelni.
	 * 
	 * A loadMyProperties metódus annyit csinál, hogy ezt a két propety fájlt beolvassa,
	 * majd egy kulcs alapján kinyomja a hozzá tartozó értéket.
	 * 
	 */
	public static void loadMyProperties() {

		Properties appProps = new Properties();
		Properties catalogProps = new Properties();
		
		try (FileInputStream appPropStream = new FileInputStream(path + "\\app.properties"); 
				FileInputStream catalogPropStream = new FileInputStream(path + "\\catalog");
				FileWriter newAppPropsFile = new FileWriter(path + "\\new-app.properties")){
			
			// fájl tartalmának beolvasása a propetry objektumba:
			appProps.load(appPropStream);
			catalogProps.load(catalogPropStream);
			
			// beolvasot property értékek kiiratása
			String appVersion = appProps.getProperty("version");
			System.out.println("version: " + appVersion);
			System.out.println("name: " + appProps.getProperty("name"));
			System.out.println("date: " + appProps.getProperty("date"));
			System.out.println("time: " + appProps.getProperty("time"));
			System.out.println("breakfast: " + appProps.getProperty("breakfast lunch supper"));
			System.out.println("c1: " + catalogProps.getProperty("c1"));
			System.out.println("NOT_EXISTS: " + catalogProps.getProperty("NOT_EXISTS"));
			System.out.println("NOT_EXISTS: " + catalogProps.getProperty("NOT_EXISTS", "Default Value"));
			
			// Property-k módosítása. Itt csak az objektum értéke módosul, a property fájlban lévő érték nem
			appProps.setProperty("version", String.valueOf(Double.valueOf(appProps.getProperty("version")) + 0.1));
			System.out.println("new version: " + appProps.getProperty("version"));
			appProps.setProperty("new-prop", "This is a new property");
			appProps.setProperty("new-prop2", "This is another new property");
			
			// property eltávolítása
			appProps.remove("new-prop2");
			System.out.println("new-prop2 after removal: " + appProps.getProperty("new-prop2"));
			
			// a store már eltárolja fájlba a property-t.
			appProps.store(newAppPropsFile, "store to property file");
			
			// Kiírjuk az összes kulcsot majd az összes értéket.
			JavaPropertiesExample.printAllPropertyKey(appProps);
			JavaPropertiesExample.printAllPropertyValue(appProps);
			// összes kulcs-érték kilistázása
			appProps.list(System.out);

			
			// mégegyszer ugyanabból a streamből megnyitva ugyanazt a property-t, csak null értéket ad vissza
			Properties appProps2 = new Properties();
			appProps2.load(appPropStream);
			appProps2.list(System.out);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printAllPropertyValue(Properties myProperties) {
		Enumeration<Object> valueEnumeration = myProperties.elements();
		while (valueEnumeration.hasMoreElements()) {
			System.out.println(valueEnumeration.nextElement());
		}
	}
	
	public static void printAllPropertyKey(Properties myProperties) {
		Enumeration<Object> keyEnumeration = myProperties.keys();
		while (keyEnumeration.hasMoreElements()) {
			System.out.println(keyEnumeration.nextElement());
		}
	}
}
