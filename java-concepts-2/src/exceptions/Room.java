package exceptions;

import java.util.Arrays;

/*
 * Szobában van egy lámpa, a szoba rendelkezik bizonyos kondíciókkal, pl.: van a szobában áram
 * Happy ág: 
 * A szobában a lámpát fel lehet kapcsolni, ha:
 * - Van a szobában áram
 * - Van szobában lévő lámpában van izzó
 * 
 * Unhappy ág:
 * A szobában a szoba kondíciók alapján nincs áram ->  NoPowerException-t dobunk.
 * A szobában lévő lámpában a szoba kondíciók alapján nincs izzó ->  NoPowerException-t dobunk.
 * 
 */

public class Room {

	private Lamp myLamp;
	private String[] roomConditions;
	
	Room(Lamp lamp, String[] roomConditions) {
		this.myLamp = lamp;
		this.roomConditions = roomConditions;
	}
	
	/*
	 * Ha a room condition-ök engedik, akkor megváltozik a lámpa státusza
	 */
	public void switchLight() throws NoLightbulbInTheLampException, NoPowerException {
		if (isArrayContainsElement(this.roomConditions, "NOT_HAS_LIGHT_BULB")) {
			throw new NoLightbulbInTheLampException();
		} else if (isArrayContainsElement(this.roomConditions, "NOT_HAS_POWER")) {
			throw new NoPowerException();
		} else {
			this.myLamp.changeState();
			System.out.println("The lamp is on: " + this.myLamp.getIsOn());
		}
		
	}
	
	/*
	 * Megvizsgálja, hogy a string tömb tartalmazza-e az adott elemet.
	 */
	private boolean isArrayContainsElement(String[] stringArray, String element) {

		return Arrays.stream(stringArray).anyMatch(element::equals);
	}

	
	
}
