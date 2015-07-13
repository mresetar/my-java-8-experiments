/**
 * 
 */
package net.croz.mresetar.java8;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * @author Miroslav
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LambdasAndEvents {
	private static Screen s;

	@Test
	public void testClickAction1() {
		s = new Screen(34, 120);
		// var device is "effectively final"
		String device = "touch";
		// example of closure 
		s.registerClickHandler((x, y) -> System.out.println(String.format("Clicked at x(%d), y(%d) using device %s.", x, y, device)));
	}
	
	@Test
	public void testClickAction2() {
		// in this method call there is on longer of device variable, still it prints touch
		s.click();
	}	
	
	private void runAction(Runnable action) {
		System.out.println("Running action: " + action.getClass().getCanonicalName());
		action.run();
	}
	
	@Test
	public void testRunAction() {
		Runnable myLambda = () -> System.out.println("My lambda");
		runAction(myLambda);
	}
	
	class Screen {
		private int x, y;
		private ClickAction action;
		
		Screen(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public void registerClickHandler(ClickAction action) {
			this.action = action;
		}
		
		public void click() {
			action.clickedAt(x, y);
		}
	}
	
	// annotated with interface can have just one method
	@FunctionalInterface
	interface ClickAction {
		void clickedAt(int x, int y);
	}
	
	
	
}
