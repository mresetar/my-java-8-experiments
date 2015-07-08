/**
 * 
 */
package net.croz.mresetar.groovy

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
	static void main(String[] args) {
		// prints net.croz.mresetar.groovy.SecondHello
		println new GroovyTraitsDaimond().hello()
	}
}
