package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class calculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2","", "  "})
    //@ValueSource(strings = {"2 + 3 * 4 / 2", "3 * 10 - 5 / 5"})
    void inputSplitTest(String input) {
        Calculator calc = new Calculator();
        calc.calulator(input);
    }
}
