package calculator.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SeparatorsTest {
	
	@Nested
	class 문자열을_숫자로_분리한다 {
		
		@Test
		void 커스텀구분자가_없는_문자열을_분리한다() {
			//given
			StringCalculatorValue stringCalculatorValue = StringCalculatorValue.from("1:2:3");
			DefaultSeparatorFactory defaultSeparatorFactory = new DefaultSeparatorFactory();
			CustomSeparatorFactory customSeparatorFactory = CustomSeparatorFactory.from(stringCalculatorValue);
			Separators sut = Separators.from(List.of(defaultSeparatorFactory, customSeparatorFactory));
			
			//when
			List<BigDecimal> result = sut.separate(stringCalculatorValue);
			
			//then
			assertThat(result).containsExactlyInAnyOrder(
					BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)
			);
		}
		
		@Test
		void 여러개의_기본구분자가_사용된_문자열을_분리한다() {
			//given
			StringCalculatorValue stringCalculatorValue = StringCalculatorValue.from("1:2,3");
			DefaultSeparatorFactory defaultSeparatorFactory = new DefaultSeparatorFactory();
			CustomSeparatorFactory customSeparatorFactory = CustomSeparatorFactory.from(stringCalculatorValue);
			Separators sut = Separators.from(List.of(defaultSeparatorFactory, customSeparatorFactory));
			
			//when
			List<BigDecimal> result = sut.separate(stringCalculatorValue);
			
			//then
			assertThat(result).containsExactlyInAnyOrder(
					BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)
			);
		}
		
		@Test
		void 커스텀구분자가_있는_문자열을_분리한다() {
			//given
			StringCalculatorValue stringCalculatorValue = StringCalculatorValue.from("//;\\n1;2:3");
			DefaultSeparatorFactory defaultSeparatorFactory = new DefaultSeparatorFactory();
			CustomSeparatorFactory customSeparatorFactory = CustomSeparatorFactory.from(stringCalculatorValue);
			Separators sut = Separators.from(List.of(defaultSeparatorFactory, customSeparatorFactory));
			
			//when
			List<BigDecimal> result = sut.separate(stringCalculatorValue);
			
			//then
			assertThat(result).containsExactlyInAnyOrder(
					BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)
			);
		}
		
		@Test
		void 커스텀구분자가_여러개_있는_문자열을_분리한다() {
			//given
			StringCalculatorValue stringCalculatorValue = StringCalculatorValue.from("//;^\\n1;2^3:4");
			DefaultSeparatorFactory defaultSeparatorFactory = new DefaultSeparatorFactory();
			CustomSeparatorFactory customSeparatorFactory = CustomSeparatorFactory.from(stringCalculatorValue);
			Separators sut = Separators.from(List.of(defaultSeparatorFactory, customSeparatorFactory));
			
			//when
			List<BigDecimal> result = sut.separate(stringCalculatorValue);
			
			//then
			assertThat(result).containsExactlyInAnyOrder(
					BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3), BigDecimal.valueOf(4)
			);
		}
	}
	
}