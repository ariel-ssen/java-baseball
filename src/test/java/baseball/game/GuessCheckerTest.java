package baseball.game;

import baseball.model.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GuessCheckerTest {

    private GuessChecker guessChecker;

    @BeforeEach
    public void setUp() {
        // 정답 리스트는 [1, 2, 3]로 설정
        List<Integer> answer = List.of(1, 2, 3);
        guessChecker = new GuessChecker(answer);
    }

    @Test
    @DisplayName("3 스트라이크: 정답과 동일한 숫자와 위치일 경우")
    public void testAllStrikes() {
        List<Integer> guess = List.of(1, 2, 3);  // 정답과 일치
        Result result = guessChecker.check(guess);

        assertEquals(3, result.getStrike(), "3개의 스트라이크여야 합니다.");
        assertEquals(0, result.getBall(), "볼이 없어야 합니다.");
    }

    @Test
    @DisplayName("2 스트라이크 1 볼: 두 숫자는 일치하고, 한 숫자는 위치만 틀린 경우")
    public void testTwoStrikesOneBall() {
        List<Integer> guess = List.of(1, 2, 5);  // 1, 2는 스트라이크, 3은 없음
        Result result = guessChecker.check(guess);

        assertEquals(2, result.getStrike(), "2개의 스트라이크여야 합니다.");
        assertEquals(0, result.getBall(), "볼이 없어야 합니다.");
    }

    @Test
    @DisplayName("1 스트라이크 2 볼: 하나의 숫자는 위치가 맞고, 두 개의 숫자는 위치만 틀린 경우")
    public void testOneStrikeTwoBalls() {
        List<Integer> guess = List.of(1, 3, 2);  // 1은 스트라이크, 2와 3은 볼
        Result result = guessChecker.check(guess);

        assertEquals(1, result.getStrike(), "1개의 스트라이크여야 합니다.");
        assertEquals(2, result.getBall(), "2개의 볼이어야 합니다.");
    }

    @Test
    @DisplayName("낫싱: 모든 숫자가 틀린 경우")
    public void testNothing() {
        List<Integer> guess = List.of(4, 5, 6);  // 정답과 전혀 다른 숫자들
        Result result = guessChecker.check(guess);

        assertEquals(0, result.getStrike(), "스트라이크가 없어야 합니다.");
        assertEquals(0, result.getBall(), "볼이 없어야 합니다.");
    }
}
