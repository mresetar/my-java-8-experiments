/**
 * 
 */
package net.croz.mresetar.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * @author Miroslav
 *
 */
public class ObserverPattern {
	private static final List<IntConsumer> actions = Collections.synchronizedList(new ArrayList<>());
	
	private static void notifyObservers(int value) {
		// run actions (in parallel)
		Stream<IntConsumer> peekStream = actions.parallelStream().peek(x -> System.out.println("Invoke action " + x));
		peekStream.forEach(action -> action.accept(value));
	}
	
	@Test
	public void observerPattern() {
		actions.add(x -> {if (x == 1) System.out.println("Action 1");});
		actions.add(x -> {if (x == 2) System.out.println("Action 2");});
		
		/*
		 * Prints:
		 * Invoke action net.croz.mresetar.java8.ObserverPattern$$Lambda$2/1607460018@15615099
		 * Invoke action net.croz.mresetar.java8.ObserverPattern$$Lambda$1/1174290147@15a4293
		 * Action 1
		 */
		notifyObservers(1);
		
		actions.remove(0);

		/*
		 * Prints:
		 * Invoke action net.croz.mresetar.java8.ObserverPattern$$Lambda$2/1607460018@15615099
		 */
		notifyObservers(1);
	}
	
}
