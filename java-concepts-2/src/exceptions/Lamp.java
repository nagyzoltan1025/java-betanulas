package exceptions;

public class Lamp {

	private boolean isOn;	
	
	Lamp(boolean state){
		this.isOn = state;
	}
	
	Lamp(){
		this.isOn = false;
	}
	
	public void changeState(){
		this.isOn = !this.isOn;
	}
	
	public boolean getIsOn() {
		return isOn;
	}
	
}
