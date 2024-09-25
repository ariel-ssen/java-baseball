package study;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    private Set<Integer> numbers;


    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);  // 중복 값
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 테스트")
    void checkSetSize() {
        // when
        int size = numbers.size();

        // then
        System.out.println("Set의 크기: " + size);
        assertThat(size).isEqualTo(3); // 중복 값 1이 하나로 처리됨
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set에 1, 2, 3 값이 존재하는지 확인하는 테스트")
    void contains(int input) {
        // then
        System.out.println("Set에 값 " + input + "이(가) 포함되어 있는지 확인");
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Set에 포함된 값과 포함되지 않은 값에 대한 contains 메소드 테스트")
    void containsWithVariousValues(int input, boolean expected) {
        // when
        boolean result = numbers.contains(input);

        // then
        System.out.println("입력 값: " + input + " / 기대 결과: " + expected + " / 실제 결과: " + result);
        assertThat(result).isEqualTo(expected);
    }
}

