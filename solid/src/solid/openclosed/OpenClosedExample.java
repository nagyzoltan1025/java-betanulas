package solid.openclosed;

interface IOperation{
	
	void performOperation();
}

class Addition implements IOperation {
	
    private double firstOperand;
    private double secondOperand;
    private double result = 0.0;
     
    public Addition(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }	
    
    @Override
    public void performOperation() {
    	result = firstOperand + secondOperand;
    	System.out.println(result);
    }
}

class Substraction implements IOperation{
    
	private double firstOperand;
    private double secondOperand;
    private double result = 0.0;
     
    public Substraction(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }	
	
    @Override
    public void performOperation() {
    	result = firstOperand - secondOperand;
    	System.out.println(result);
    }
}

interface ICalculator{
	void calculate(IOperation operation);
}

class Calculator implements ICalculator{
	
	@Override
	public void calculate(IOperation operation) {
		if (operation != null) {
			operation.performOperation();
		}
		
	}
}

public class OpenClosedExample {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.calculate(new Addition(2,2));
		calculator.calculate(new Substraction(2,2));
	}
}
