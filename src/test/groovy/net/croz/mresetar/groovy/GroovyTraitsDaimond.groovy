/**
 * 
 */
package net.croz.mresetar.groovy

import static org.assertj.core.api.StrictAssertions.assertThat;

import org.junit.Test;

import net.croz.mresetar.java8.DefaultInterfaceDaimond;

/**
 * @author Miroslav
 *
 */

trait FirstHello {
	String hello() {
		FirstHello.class.getCanonicalName()
	}
}

trait SecondHello {
	String hello() {
		SecondHello.class.getCanonicalName()
	}
}

class GroovyTraitsDaimond implements FirstHello, SecondHello {
	@Test
	void printHello() {
		assertThat(new GroovyTraitsDaimond().hello()).isEqualTo("net.croz.mresetar.groovy.SecondHello")
	}
}
