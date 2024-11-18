package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    
    @Test
    void 기본_구분자만을_사용하여_더한다() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    
    @Test
    void 여러가지_기본_구분자만을_사용하여_더한다() {
        assertSimpleTest(() -> {
            run("1:2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    
    @Test
    void 커스텀_구분자만을_사용하여_더한다() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    
    @Test
    void 여러가지_커스텀_구분자_사용하여_더한다() {
        assertSimpleTest(() -> {
            run("//;^\\n1;2^3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    
    @Test
    void 기본_구분자와_커스텀_구분자를_혼합해서_사용하여_더한다() {
        assertSimpleTest(() -> {
            run("//;^\\n1;2^3:4,5");
            assertThat(output()).contains("결과 : 15");
        });
    }
    
    @Test
    void 아무_값도_넣지_않으면_0이_반환된다() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }
    
    @Test
    void 커스텀_구분자가_비어있다면_기본_구분자만으로_더한다() {
        assertSimpleTest(() -> {
            run("//\\n1:2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    
    @Test
    void 공백이_포함되도_정상적으로_더한다() {
        assertSimpleTest(() -> {
            run("/ /^ \\ n  1 : 2 ,3^       4");
            assertThat(output()).contains("결과 : 10");
        });
    }
    
    @Test
    void 매우_긴_문자열도_정상적으로_더한다() {
        assertSimpleTest(() -> {
            run("12345678987654321:12345678987654321");
            assertThat(output()).contains("결과 : 24691357975308642");
        });
    }
    
    @ParameterizedTest
    @ValueSource(strings = {
            "^\\n1:2:3",
            "/^\\n1:2:3",
            "//^n1:2:3",
            "//^\\1:2:3",
    })
    void 커스텀_구분자_부분이_완성되지_않으면_예외가_발생한다(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자 부분은 숫자로 시작되어야 합니다.")
        );
    }
    
    @ParameterizedTest
    @ValueSource(strings = {
            "//^\\n:2^3",
            ":2,3",
    })
    void 숫자부분이_숫자로_시작하지_않으면_예외가_발생한다(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자 부분은 숫자로 시작되어야 합니다.")
        );
    }
    
    @ParameterizedTest
    @ValueSource(strings = {
            "//^\\n1:2^",
            "1:2,",
    })
    void 숫자부분이_숫자로_끝나지_않으면_예외가_발생한다(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자 부분은 숫자로 끝나야 합니다.")
        );
    }
    
    @Test
    void 구분자가_반복되면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1::2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("구분자는 연속될 수 없습니다.")
        );
    }
    
    @Test
    void 존재하지_않는_구분자가_존재하면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("지정되지 않은 구분자가 존재합니다.")
        );
    }
    
    @Test
    void 음수가_포함되면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자 부분은 숫자로 시작되어야 합니다.")
        );
    }
    
    @Test
    void 음수가_중간에_포함되면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,-2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("구분자는 연속될 수 없습니다.")
        );
    }
    
    @Test
    void 마이너스가_구분자로_사용되면_그대로_계산된다() {
        assertSimpleTest(() -> {
            run("//-\\n1-2-3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
