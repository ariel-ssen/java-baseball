package baseball.checker;

import baseball.config.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrikeCheckerTest {

    private StrikeChecker strikeChecker;
    private List<Integer> answer;

    @BeforeEach
    @DisplayName("테스트 전에 StrikeChecker와 정답 리스트를 초기화")
    public void setUp() {
        strikeChecker = new StrikeChecker();
        answer = Arrays.asList(1, 2, 3); // 정답은 1, 2, 3
    }

    @Test
    @DisplayName("스트라이크가 없는 경우: 예상한 숫자가 정답과 일치하지 않는 경우")
    public void testNoStrikes() {
        List<Integer> guess = Arrays.asList(4, 5, 6); // 정답과 다른 숫자
        int strikes = strikeChecker.countStrikes(guess, answer);
        assertEquals(Constants.ZERO, strikes, "스트라이크가 없어야 합니다.");
    }

    @Test
    @DisplayName("한 개의 스트라이크가 있는 경우: 하나의 숫자와 위치가 일치하는 경우")
    public void testOneStrike() {
        List<Integer> guess = Arrays.asList(1, 5, 6); // 첫 번째 숫자 1만 일치
        int strikes = strikeChecker.countStrikes(guess, answer);
        assertEquals(1, strikes, "1개의 스트라이크가 있어야 합니다.");
    }

    @Test
    @DisplayName("두 개의 스트라이크가 있는 경우: 두 개의 숫자와 위치가 일치하는 경우")
    public void testTwoStrikes() {
        List<Integer> guess = Arrays.asList(1, 2, 6); // 첫 번째와 두 번째 숫자가 일치
        int strikes = strikeChecker.countStrikes(guess, answer);
        assertEquals(2, strikes, "2개의 스트라이크가 있어야 합니다.");
    }

    @Test
    @DisplayName("세 개의 스트라이크가 있는 경우: 모든 숫자와 위치가 일치하는 경우")
    public void testThreeStrikes() {
        List<Integer> guess = Arrays.asList(1, 2, 3); // 모두 일치
        int strikes = strikeChecker.countStrikes(guess, answer);
        assertEquals(3, strikes, "3개의 스트라이크가 있어야 합니다.");
    }
}
