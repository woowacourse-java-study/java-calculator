package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class NumberCalculatorTest {
	
	@Nested
	class 생성_테스트 {
		
		@Test
		void 정상적으로_생성한다() {
			//given
			List<String> numbers = List.of(
					"1", "2", "3"
			);
			
			//expected
			Assertions.assertThatCode(() -> NumberCalculator.from(numbers))
					.doesNotThrowAnyException();
		}
		
		@Test
		void 음수가_포함되어_있으면_예외가_발생한다() {
			//given
			List<String> numbers = List.of(
					"-1", "2", "3"
			);
			
			//expected
			Assertions.assertThatThrownBy(() -> NumberCalculator.from(numbers))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("음수는 포함될 수 없습니다.");
		}
	}
	
	@Nested
	class 값_더하기_테스트 {
		
		@Test
		void 정상적으로_여러_값을_더한다() {
			//given
			List<String> numbers = List.of(
					"1", "2", "3"
			);
			NumberCalculator sut = NumberCalculator.from(numbers);
			
			//when
			String result = sut.caculate();
			
			//then
			Assertions.assertThat(result).isEqualTo("6");
		}
		
		@Test
		void 값이_하나도_없으면_0을_반환한다() {
			//given
			List<String> numbers = List.of();
			NumberCalculator sut = NumberCalculator.from(numbers);
			
			//when
			String result = sut.caculate();
			
			//then
			Assertions.assertThat(result).isEqualTo("0");
		}
	}
}