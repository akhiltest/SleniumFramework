package testNG;

import org.testng.annotations.Test;

public class DependsOnMethod {
	
  @Test
  public void search() {
	  System.out.println("Flight Search");
  }
  @Test()
  public void book() {
	  System.out.println("Flight Book");
  }
  /*
    @Test(dependsOnMethods={"search"})
  public void book() {
	  System.out.println("Flight Book");
  }
   */
}
