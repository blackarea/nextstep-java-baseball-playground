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
    void scanNumber() {
        inputHandling("123");
        assertThat(nb.scanNumber()).isEqualTo(123);
    }

    @Test
    void intToArray() {
        int[] arr = nb.intToArray(123);
        assertThat(arr).containsExactly(1, 2, 3);
    }

    @Test
    void judgeStrike() {
        int[] randomArr = {1, 2, 3};
        int[] inputArr = {1, 2, 3};
        assertThat(nb.judgeStrike(randomArr, inputArr)).isEqualTo(3);
        inputArr[0] = 5;
        assertThat(nb.judgeStrike(randomArr, inputArr)).isEqualTo(2);
    }

    @Test
    void judgeBall() {
        int[] randomArr = {1, 2, 3};
        int[] inputArr = {3, 1, 2};
        assertThat(nb.judgeBall(randomArr, inputArr)).isEqualTo(3);
        int[] inputArr2 = {1, 2, 3};
        assertThat(nb.judgeBall(randomArr, inputArr2)).isEqualTo(0);
    }

    @Test
    void judgeResult() {
        int[] randomArr = {1, 2, 3};

        assertThat(nb.judgeResult(randomArr, new int[]{1, 2, 3})).isEqualTo("3S");
        assertThat(nb.judgeResult(randomArr, new int[]{3, 1, 2})).isEqualTo("3B");
        assertThat(nb.judgeResult(randomArr, new int[]{5, 4, 6})).isEqualTo("4B");
        assertThat(nb.judgeResult(randomArr, new int[]{1, 3, 6})).isEqualTo("1B 1S");
    }

}