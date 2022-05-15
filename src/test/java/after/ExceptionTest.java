package after;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {

    Calculator calculator = new Calculator();

    public static void inputHandling(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
    }

    @Test
    void inputBlank(){
        inputHandling("");
        assertThatThrownBy(() -> calculator.execute())
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("공백은 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("계산 형식이 잘못된 입력")
    void wrongInput(){
        inputHandling("1 * 0 /");
        assertThatThrownBy(() -> calculator.execute())
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessage("입력이 잘못되었습니다.");
    }

    @Test
    void wrongOperator(){
        inputHandling("1 C 2");
        assertThatThrownBy(() -> calculator.execute())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 연산자입니다.");
    }

    @Test
    void wrongNumber() {
        inputHandling("ㅁ * 2");
        assertThatThrownBy(() -> calculator.execute())
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("숫자 자리에 다른 문자를 입력했거나 띄워쓰기가 잘못되었습니다.");
    }
}
