package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "2:3:5", "91:9:100"}, delimiter = ':')
    void 덧셈을_한다(int a, int b, int answer){
        Calculator calculator = new Calculator();

        Assertions.assertThat(calculator.add(a, b)).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:2:1", "5:3:2", "91:9:82"}, delimiter = ':')
    void 뺄샘을_한다(int a, int b, int answer){
        Calculator calculator = new Calculator();

        Assertions.assertThat(calculator.subtract(a, b)).isEqualTo(answer);
    }
}
