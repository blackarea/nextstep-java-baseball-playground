package before;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class NumberBaseballTest {

    NumberBaseball nb = new NumberBaseball();

    public static void inputHandling(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
    }

    @Test
    void makeRandomNumber() {
        for (int i = 0; i < 20; i++) {
            int[] randomNumber = nb.makeRandomNumberArray();
            assertThat(randomNumber[0] == randomNumber[1]).isFalse();
            assertThat(randomNumber[0] == randomNumber[2]).isFalse();
            assertThat(randomNumber[1] == randomNumber[2]).isFalse();
        }
    }

    @Test
    void scanNumber(){
        inputHandling("123");
        assertThat(nb.scanNumber()).isEqualTo(123);
    }

    @Test
    void intToArray(){
        int[] arr = nb.intToArray(123);
        assertThat(arr).containsExactly(1, 2, 3);
    }
}