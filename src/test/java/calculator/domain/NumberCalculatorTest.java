package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class NumberCalculatorTest {
	
	@Nested
	class 값_더하기_테스트 {
		
		@Test
		void 정상적으로_여러_값을_더한다() {
		    //given
			List<Integer> numbers = List.of(1, 2, 3);
			NumberCalculator sut = new NumberCalculator();
			
			//when
			long result = sut.caculate(numbers);
			
			//then
			Assertions.assertThat(result).isEqualTo(6L);
		}
		
		@Test
		void 값이_하나도_없으면_0을_반환한다() {
			//given
			List<Integer> numbers = List.of();
			NumberCalculator sut = new NumberCalculator();
			
			//when
			long result = sut.caculate(numbers);
			
			//then
			Assertions.assertThat(result).isEqualTo(0L);
		}
	}
}