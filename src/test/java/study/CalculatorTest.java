package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void makeCalculator() {
        calculator = new Calculator();
    }

    public static void inputHandling(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
    }

    @Test
    void complexExecute() {
        inputHandling("2 + 3 - 0 * 4 / 2");
        assertThat(calculator.execute()).isEqualTo(10);
    }

    @Test
    void add() {
        inputHandling("2 + 3 + 4 + 5");
        assertThat(calculator.execute()).isEqualTo(14);
    }

    @Test
    void subtract() {
        inputHandling("10 - 2 - 3 - 6");
        assertThat(calculator.execute()).isEqualTo(-1);
    }

    @Test
    void multiply() {
        inputHandling("2 * 3 * 4 * 5");
        assertThat(calculator.execute()).isEqualTo(120);
    }

    @Test
    void divide() {
        inputHandling("10 / 2 / 5");
        assertThat(calculator.execute()).isEqualTo(1);
    }

    @Test
    void exceptionTest() {
        inputHandling("1 C 3 * 4 / 2");
        assertThatThrownBy(() -> calculator.execute()).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("연산자");
    }


}
