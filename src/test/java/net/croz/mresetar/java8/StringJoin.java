package net.croz.mresetar.java8;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * @author Miroslav
 *
 */

public class StringJoin {

	@Test
	public void testJoin() {
		assertThat(String.join(" ", "Hello", "world!")).isEqualTo("Hello world!");
	}
	
}
