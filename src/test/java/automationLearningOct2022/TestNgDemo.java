package automationLearningOct2022;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNgDemo {
	
	@Test(priority =0, invocationCount = 5)
	public void methodBeforeSuite() {
		System.out.println("Code executed for @Before suite annotation :: 0");
	}
	
	@Test(priority =4)
	public void Testcase1() {
		System.out.println("Code executed for testcase  :: 4");
	}
	
	
	@Test(priority =1, enabled =false)
	public void methodBeforeClass() {
		System.out.println("Code executed for @Before Class annotation :: 1");
	}
	
	@Test(priority =3)
	public void methodBefore() {
		System.out.println("Code executed for @Beforemethod annotation ::3");
		//System.out.println("Broswer to be opened");

	}
	
	@Test (priority =2)
	public void methodAfter() {
		System.out.println("Broswer to be closed :: 2");
	}

}
