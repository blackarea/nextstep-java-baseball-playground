package before;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberBaseballTest {

    NumberBaseball nb = new NumberBaseball();

    @Test
    void makeRandomNumber() {
        for (int i = 0; i < 20; i++) {
            int[] randomNumber = nb.makeRandomNumberArray();
            assertThat(randomNumber[0] == randomNumber[1]).isFalse();
            assertThat(randomNumber[0] == randomNumber[2]).isFalse();
            assertThat(randomNumber[1] == randomNumber[2]).isFalse();
        }
    }
}