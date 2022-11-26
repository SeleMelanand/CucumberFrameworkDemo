package automationLearningOct2022;

import org.testng.annotations.Test;

public class SimpleForLoop {
	
	@Test
	public void forLoopDemo() {
		int count = 100; 
		for(int i=0;i<=5;i++) {
			System.out.println(count+i);
		}
	}

}
