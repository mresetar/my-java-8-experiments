package net.croz.mresetar.java8;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

interface FirstHello {
	default String hello() {
		return FirstHello.class.getCanonicalName();
	}
}

interface SecondHello {
	default String hello() {
		return SecondHello.class.getCanonicalName();
	}
}

public class DefaultInterfaceDaimond implements FirstHello, SecondHello {
	// needed, else compile error
	public String hello() {
		return FirstHello.super.hello();
	}

	@Test
	public void printHello() {
		assertThat(new DefaultInterfaceDaimond().hello()).isEqualTo("net.croz.mresetar.java8.FirstHello");
	}
}


