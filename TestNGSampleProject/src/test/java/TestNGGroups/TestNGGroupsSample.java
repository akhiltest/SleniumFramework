package TestNGGroups;

import org.testng.annotations.Test;

public class TestNGGroupsSample {
  @Test(groups={"sanity"})
  public void test1() {
	  System.out.println("This is Test 1");
  }
  @Test(groups={"sanity","smoke"})
  public void test2() {
	  System.out.println("This is Test 2");
  }
  @Test(groups={"regression","sanity"})
  public void test3() {
	  System.out.println("This is Test 3");
  }
  @Test
  public void test4() {
	  System.out.println("This is Test 4");
  }
}
