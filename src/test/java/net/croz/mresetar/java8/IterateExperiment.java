/**
 * 
 */
package net.croz.mresetar.java8;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * @author Miroslav
 *
 */
public class IterateExperiment {

	@Test
	public void iterateExample() {
		BinaryOperator<Integer> sumNumbers = (Integer first, Integer second) -> {
			return first + second;
		};
		// it can be better written with range 
		Optional<Integer> sum = Stream
			.iterate(100, x ->  x - 1)
			.limit(10)
			.sorted(Integer::compare)
			.peek(it -> System.out.print(" " + it))
			.reduce(sumNumbers);
			//.count();
		sum.ifPresent(it -> System.out.println(String.format("\nTotal sum is %d", it)));
		
		assertThat(sum.get()).isEqualTo(955);
	}
}
