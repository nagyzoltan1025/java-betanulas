package exceptions;
/*  sima try catch
    try, több catch
        különböző exception-ök
        ugyanazok az exception-ök
        gyermek-szülő exception, szülő elöl
        gyermek-szülő expcetion, gyermek elöl
    try több catch finally
    try finally
    try több finally
    csak finally
    al try catch beágyazás:
        try-ban még egy try-catch ág
        catch-ban még egy try catch ág
        finally-ban még egy try-catch ág
    throw
        try-catch-en kívül
        try-ban
        catch-ban
        finally-ban
    Írni saját exception osztályt gyerekkel
 */

public class ExceptionExample {
	
	private Room myRoom;
	
	/*
	 * Exception-ök roomConditions string tömb értékei alapján dobódnak
	 * Én csak ezt akarom szabályozni.
	 * Az, hogy a Lamp objektum true vagy false értékkel inicializálódik, az a példa szempontjából érdektelen
	 * (Alamértelmezetten false-ként fog)
	 */
	ExceptionExample(String[] roomConditions) { 
		this.myRoom = new Room(new Lamp(), roomConditions);
	}
	
	
	/**
	 * Ebben a metódusban egy simpla try catch blokk van.
	 * A switchLight metódus 2 exceptiont dobhat, mindkettő a CheckedLampException gyermeke
	 * Példában látható, hogy egy CheckedLampException-el le lehet kezelni mindkét exceptiont.
	 * 
	 */
	public void simpleTryCatch() {

		try {
			this.myRoom.switchLight();
			// throw new NullPointerException();
		} catch(CheckedLampException e) {
			System.out.println("Kivételkezelés");
			e.message();
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Simpla try catch, de a catch blokk 2 exception-t is lekezel.
	 */
	public void  unionTryCatch() {
		
		try {
			this.myRoom.switchLight();
		} catch(NoLightbulbInTheLampException | NoPowerException p) {
			p.message();
			p.printStackTrace();
		}
	}
	
	
	/**
	 * A switchLight által dobott exception 2 exception-t kezel le különbözőképpen
	 * Bónuszként lekezeli a 2 exception ősét (CheckedLampException) is, de erre a vezérlés nem fog lefutni,
	 * mivel a switchLight csak a NoLightbulbInTheLampException és NoPowerException dobhatja.
	 */
	public void multiTryCatch() {
		
		try {
			this.myRoom.switchLight();
		} catch (NoLightbulbInTheLampException e) {
			System.out.println("x");
			e.printStackTrace();
		} catch (NoPowerException e) {
			System.out.println("y");
			e.printStackTrace();
		} catch (CheckedLampException e) {
			// ide soha nem fogok eljutni, mivel: 
			// - a switchLight csak a fenti két exceptiont dobhatja a metódus fejléce szerint (NoLightbulbInTheLampException, NoPowerException)
			// - a CheckedLampException ősosztálya a fenti két osztálynak
			System.out.println("z");
			e.printStackTrace();
		}

	}
	
	
	/**
	 * Try-Catch-Finally ág lefutásánál vizsgálom a vezérlést.
	 * Happy ág: Nincs exception
	 * Unhappy ág: Van exception
	 */
	public void tryCatchFinally() {

		try {
			System.out.println("try ág eleje"); // happy és unhappy ágon lefut
			this.myRoom.switchLight(); 
			System.out.println("try ág vége"); // csak happy ágon fut le 
		} catch (NoLightbulbInTheLampException | NoPowerException e) {
			System.out.println("Catch ág eleje"); // csak unhappy ágon fut le
			e.printStackTrace();
			System.out.println("Catch ág vége"); // csak unhappy ágon fut le
		} finally {
			System.out.println("Finally ág"); // happy és unhappy ágon is lefut
		}
		
	}
	
	/**
	 * A példában az látszik, hogy:
	 * A try catch nélkül is használható
	 * A finally ág nem utolsónak fut le. 
	 * Két finally blokk nem megengedett
	 */
	public void tryFinallyWithoutCatch() {
		
		try {
			System.out.println("try ág"); // 1 
		} finally {
			System.out.println("finally ág"); // 2
		} /*finally {
			
		}*/
		
		System.out.println("Finally ág utáni ág"); // 3
	}
	
	
	/**
	 * A példában az látszik, hogy sem a try, sem a catch sem a finally blokk nem állhat magában.
	 */
	public void tryCatchFinallyAlone() {
		
		System.out.println("első");
		
		// try blokk magában
		/*
		try {
			System.out.println("Try magában");
		};*/ 
		
		// catch blokk magában
		/*
		catch (NullPointerException e) {
			
		}*/
		
		
		// finally blokk magában
		/* 
		finally {
			System.out.println("finally");
		}*/

	}
	
	
	/**
	 * Egymásba ágyazott try-catch-finally blokkok működésére példa
	 * Egyrészt látszik, hogy lehetséges
	 * Lefutás sorrendjében nincs meglepetés
	 * Bemegyünk a külső blokkba, lefut a belső blokk megyünk a következő külső blokkban
	 * Az, hogy a catch blokk lefut, az dönti el, hogy volt-e exception
	 * 
	 */
	public void innerTryCatch() {
		
		try {
			this.myRoom.switchLight();
			try {
				System.out.println("try/try"); // happy ág, ha switchLight előtt lenne akkor unhappy ágon is lefut
				// throw new NullPointerException();
			} finally {
				System.out.println("try/finally"); // happy ág, ha switchLight előtt lenne akkor unhappy ágon is lefut
			}
		} catch (CheckedLampException e) {
			try {
				System.out.println("catch/try"); // unhappy ág
				throw new NullPointerException();
			} finally {
				System.out.println("catch/finally"); // unhappy ág
			} 
		} finally {
			try {
				System.out.println("finally/try"); // happy & unhappy ág
				// throw new NullPointerException();
			} finally {
				System.out.println("finally/finally"); // happy & unhappy ág
				
			} 
		}
	}
	
	/**
	 * Egymásba ágyazott try-catch-ek lefutási sorrendjének vizsgálata történik meg ebben a metódusban.
	 * Metódus paraméterei kapcsolókként működnek:
	 * 	tryException:  Ha true, a legkülső try ágban eldobunk egy exception-t.
	 * 	catchException: Ha true, a catch ágban dobunk egy egy exception-t.
	 * 	finallyException: Ha true a legkülső finally ágban eldobunk egy exception 
	 * 
	 * Leírás:
	 * try-catch-finally blokkokban eldobtam egy nullpointer exceptiont, ha a megfelelő boolean paraméter igaz
	 * Try-ban eldobva elmentünk a catch-be. ott megint el lett dobva egy nullpointer
	 * A 2. nullpointer már nem lett catch-elve, az eljutott a main-ing. 
	 * Szöveg: "Exception in thread "main" java.lang.NullPointerException"
	 * finally-ben dobok egy nullpointert. A compiler ezt jelzi, hogy nem jó ötlet
	 * 
	 * Ha a finally és a catch ágban is dobok nullpointert, akkor csak 1 db nullpointer staktrace jelenik csak meg
	 * 
	 * 
	 */
	
	public void throwExcepiton(boolean tryException, boolean catchException, boolean finallyException) {
		
		try {
			System.out.println("try eleje");
			if (tryException) {
				System.out.println("try NullPointer");
				throw new NullPointerException();
			}
			System.out.println("try vége");
		} catch (NullPointerException e) {
			System.out.println("Catch eleje");
			e.printStackTrace();
			if (catchException) {
				System.out.println("Catch NullPointer");
				throw new NullPointerException();
			}
			System.out.println("Catch vége");
			
		} finally {
			System.out.println("finally eleje");
			if (finallyException) {
				System.out.println("finally NullPointer");
				try {
					throw new NullPointerException(); // működik, de a warning van
				} catch (NullPointerException e) {
					System.out.println("finally catched nullpointer");
					e.printStackTrace();
				}
			}
			System.out.println("finally vége");
		}
	}
 
}
