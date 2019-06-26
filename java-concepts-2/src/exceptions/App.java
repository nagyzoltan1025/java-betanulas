package exceptions;

public class App {

	public static void main(String[] args)  {
		
		String[] roomConditions = {"xNOT_HAS_POWER", "xNOT_HAS_LIGHT_BULB"};
		ExceptionExample exceptionExampleTesting = new ExceptionExample(roomConditions);
		
		// exceptionExampleTesting.simpeTryCatch();
		// exceptionExampleTesting.unionTryCatch();
		// exceptionExampleTesting.multiTryCatch();
		// exceptionExampleTesting.tryCatchFinally();
		// exceptionExampleTesting.tryFinallyWithoutCatch();
		// exceptionExampleTesting.tryCatchFinallyAlone();
		// exceptionExampleTesting.innerTryCatch();
		
		boolean tryException = true;
		boolean catchException = true;
		boolean finallyException = true;
		exceptionExampleTesting.throwExcepiton(tryException, catchException, finallyException);
	}

}
