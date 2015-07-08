/**
 * 
 */
package net.croz.mresetar.java8;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @author Miroslav
 *
 */
public class IterateExperiment {

	public static void main(String[] args) {
		iterateExample();
	}

	private static void iterateExample() {
		BinaryOperator<Integer> sumNumbers = (Integer first, Integer second) -> {
			return first + second;
		};
		Optional<Integer> sum = Stream
			.iterate(100, x ->  x - 1)
			.limit(10)
			.sorted(Integer::compare)
			.peek(it -> System.out.print(" " + it))
			.reduce(sumNumbers);
			//.count();
		sum.ifPresent(it -> System.out.println(String.format("\nTotal sum is %d", it)));
	}
}
