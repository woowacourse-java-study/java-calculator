package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class CustomSeparatorFactoryTest {
	
	@Nested
	class 생성_테스트 {
		
		@ParameterizedTest
		@MethodSource("getNoCustomSeparatorInput")
		void 커스텀_구분자가_없는_문자열로_생성한다(String input) {
		    //given
		    
		    //when
			CustomSeparatorFactory result = CustomSeparatorFactory.from(input);
			
			//then
			List<Separator> separators = result.create();
			Assertions.assertThat(separators).extracting(
					"value"
			).isEmpty(
			);
		}
		
		@ParameterizedTest
		@MethodSource("getCustomSeparatorInputAndResults")
		void 커스텀_구분자가_있는_문자열로_생성한다(String input, List<Character> results) {
			//given
			
			//when
			CustomSeparatorFactory result = CustomSeparatorFactory.from(input);
			
			//then
			List<Separator> separators = result.create();
			Assertions.assertThat(separators).extracting(
					"value"
			).isEqualTo(
					results
			);
		}
		
		private static Stream<Arguments> getNoCustomSeparatorInput() {
			return Stream.of(
					Arguments.arguments("//\\n1"),
					Arguments.arguments("1:2:3")
			);
		}
		
		private static Stream<Arguments> getCustomSeparatorInputAndResults() {
			return Stream.of(
					Arguments.arguments("//;\\n1", List.of(';')),
					Arguments.arguments("//;:^\\n1", List.of(';', ':', '^'))
			);
		}
	
	}
	
}
