package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SeparatorTest {
	
	@Nested
	class 생성_테스트 {
		
		@ParameterizedTest
		@ValueSource(chars = {
				'-', '^', 'a', '@', ':'
		})
		void 정상적으로_생성한다(char value) {
			//given
			
			//expected
			Assertions.assertThatCode(() -> new Separator(value))
					.doesNotThrowAnyException();
		}
		
		@ParameterizedTest
		@ValueSource(chars = {
				'1', '2', '3'
		})
		void 숫자로_생성하면_예외가_발생한다(char value) {
			//given
			
			//expected
			Assertions.assertThatThrownBy(() -> new Separator(value))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("숫자는 구분자가 될 수 없습니다.");
		}
	}
	
}