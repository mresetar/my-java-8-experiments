package net.croz.mresetar.java8;


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
	
	public static void main(String[] args) {
		// prints net.croz.mresetar.java8.FirstHello
		System.out.println(new DefaultInterfaceDaimond().hello());
	}
}


