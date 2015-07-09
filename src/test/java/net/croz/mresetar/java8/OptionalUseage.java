/**
 * 
 */
package net.croz.mresetar.java8;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.function.Consumer;

import org.junit.Test;

/**
 * @author Miroslav
 *
 */
public class OptionalUseage {
	
	private Optional<String> getSystemProperty(String key) {
		String property = System.getProperty(key);
		return Optional.ofNullable(property);
	}
	
	@Test
	public void testOptional() {
		Optional<String> unknown = getSystemProperty("unknown");
		// empty is always the same instance
		assertThat(unknown).isSameAs(Optional.empty());
		// property not present
		assertThat(unknown.isPresent()).isFalse();
		Optional<String> osName = getSystemProperty("os.name");
		assertThat(osName.isPresent()).isTrue();
		
		// usage 1
		osName.ifPresent(System.out::println);
		// usage 2
		osName.ifPresent(it -> System.out.println("Host OS: " + it));
		
		// export action to variable (can be a method also)
		Consumer<? super String> doHostDependandAction = it -> {
			if (it.matches(".*Windows.*")) {
				System.out.println("It is windows");
			}
			else {
				System.out.println("It is not windows");
			}
		};
		osName.ifPresent(doHostDependandAction);
		
	}

	
}
