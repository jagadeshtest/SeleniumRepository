package testRunner;

import org.junit.runner.JUnitCore;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
JUnitCore.runClasses(Runner.class);
/*for(Failure failure:result.getFailures()){
	System.out.println(failure.toString());
}
System.out.println(result.wasSuccessful());*/
	}
}
