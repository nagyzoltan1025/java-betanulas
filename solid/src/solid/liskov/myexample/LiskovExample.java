package solid.liskov.myexample;

class Rectangle {
	// t�glalapnak van sz�less�ge �s magass�ga
	private double width;
	private double height;
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}

}

class Square extends Rectangle{
	
	// A n�gyzet egy olyan t�glalap, amelynek minden oldala egyenl�
	// Biztos�tjuk, hogy ak�rmelyik settert is h�vja a kliens, a fenti szab�ly �rv�nyes�lj�n 
	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		super.setHeight(width);
	}
	
	@Override
	public void setHeight(double height) {
		super.setWidth(height);
		super.setHeight(height);
	}
}

public class LiskovExample {

	public static void calculateArea(Rectangle rec) {
		rec.setHeight(2);
		rec.setWidth(3);
		
		System.out.println("Area: "+ rec.getClass().getSimpleName() + " " + rec.getHeight()*rec.getWidth());
	}
	
	public static void main(String[] args) {
		calculateArea(new Rectangle());
		calculateArea(new Square());
	}
}
