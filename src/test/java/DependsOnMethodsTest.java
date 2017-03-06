import org.testng.annotations.*;

public class DependsOnMethodsTest {
	private volatile boolean method1done = false;

	@Test
	public void method1() throws InterruptedException {
		System.out.println("Start method1");
		Thread.sleep(1000);
		method1done = true;
		System.out.println("Finish method1");
	}

	@Test
	public void method2() {
		System.out.println("Start method2");
		System.out.println("Finish method2");
	}

	@Test(dependsOnMethods = "method1")
	public void method3() {
		System.out.println("Start method3");
		assert method1done : "method1 has finished";
		System.out.println("Finish method3");
	}
}
