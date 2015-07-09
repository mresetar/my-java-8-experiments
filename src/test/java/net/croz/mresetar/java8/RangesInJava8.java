/**
 * 
 */
package net.croz.mresetar.java8;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * @author Miroslav
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RangesInJava8 {

	@Test
	public void range() {
		// prints 01234
		IntStream.range(0, 5).forEach(System.out::print);
	}
	
	@Test
	public void rangeInitializeObjects() {
		// type inference at work 
		// https://docs.oracle.com/javase/tutorial/java/generics/genTypeInference.html
		final List<LocalDate> dates = new ArrayList<>();
		
		IntStream.range(0, 4).forEach(i -> dates.add(LocalDate.now().plusWeeks(i)));
		assertThat(dates).hasSize(4);
		assertThat(dates).isSorted();
		assertThat(dates.get(dates.size()-1).isEqual(LocalDate.now().plusWeeks(4)));
		
		dates.forEach(System.out::println);
	}
}
