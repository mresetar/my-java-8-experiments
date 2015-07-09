/**
 * 
 */
package net.croz.mresetar.java8;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * @author Miroslav
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StreamsSortingCollecting {
	final private String[] cityNames = new String[]{"Zagreb", "Split", "Rijeka"};

	@Test
	public void collectAll() {
		String allCityNames = Stream.of(cityNames).collect(Collectors.joining(", "));
		System.out.println(allCityNames);
	}

	@Test
	public void sortArrayAndForEach() {
		// long form
		Comparator<? super String> strLenComparator = (first, second) -> Integer.compare(first.length(), second.length());
		String[] sortedByLength = 
				Stream.of(cityNames)
				.sorted(strLenComparator)
				.toArray(String[]::new);
		
		assertThat(Arrays.asList(sortedByLength)).isSortedAccordingTo(strLenComparator);
		Stream.of(sortedByLength).forEach(System.out::println);
		
		String[] cityNamesCopy = Arrays.copyOf(cityNames, cityNames.length);
		// short form, does in place
		Arrays.sort(cityNamesCopy, strLenComparator);

		assertThat(cityNamesCopy).isSortedAccordingTo(strLenComparator);
		assertThat(cityNamesCopy).containsSequence(sortedByLength);
	}
	
}
