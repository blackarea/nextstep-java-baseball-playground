package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split(){
        String[] split = "1,2".split(",");
        assertThat(split).containsExactly("1", "2");
        String[] split1 = "1".split(",");
        assertThat(split1).contains("1");
    }

    @Test
    void substring(){
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 charAt 테스트")
    void charAtTest(){
        char c = "abc".charAt(0);
        assertThat(c).isEqualTo('a');
        assertThatThrownBy(()->"abc".charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    
}
