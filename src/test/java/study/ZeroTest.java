package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

public class ZeroTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }


    @Test
    void splitByComma() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void splitByComma2() {
        String[] result1 = "1,2".split(",");
        String[] result2 = "1".split(",");

        // print 출력
        System.out.println("splitByComma() 결과 1: ");
        for (String s : result1) {
            System.out.println(s);
        }

        System.out.println("splitByComma() 결과 2: ");
        for (String s : result2) {
            System.out.println(s);
        }

        // assertThat 검증
        assertThat(result1).containsExactly("1", "2");
        assertThat(result2).containsExactly("1");
    }


    @Test
    @DisplayName("특정 위치의 문자를 가져오는 테스트")
    void charAtTest() {
        // given
        String abc = "abc";

        // when
        char result = abc.charAt(1);

        // print to console
        System.out.println("charAt(1)의 결과: " + result);

        // then
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("위치를 벗어난 charAt 호출 시 StringIndexOutOfBoundsException 발생 테스트")
    void charAtOutOfBoundTestWithPrint() {
        // given
        String abc = "abc";

        // print to console
        System.out.println("charAt(5)을 호출합니다.");

        // then
        assertThatThrownBy(() -> {
            // when
            abc.charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }
}

