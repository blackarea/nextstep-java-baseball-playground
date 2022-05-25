package before;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberBaseballExceptionTest {

    NumberBaseball nb = new NumberBaseball();

    public static void inputHandling(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
    }

    @DisplayName("숫자가 아닌 다른 값 입력")
    @Test
    void wrongInput(){
        inputHandling(" 12");
        assertThatThrownBy(() -> nb.scanNumber()).isInstanceOf(NoSuchElementException.class)
                .hasMessage("No line found");
    }
}
