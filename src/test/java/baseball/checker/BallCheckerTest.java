package baseball.checker;

import baseball.config.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallCheckerTest {

    private BallChecker ballChecker;
    private List<Integer> answer;

    @BeforeEach
    @DisplayName("테스트 전에 BallChecker와 정답 리스트를 초기화")
    public void setUp() {
        ballChecker = new BallChecker();
        answer = Arrays.asList(1, 2, 3); // 정답은 1, 2, 3
    }

    @Test
    @DisplayName("볼이 없는 경우: 예상한 숫자가 정답에 없는 경우")
    public void testNoBalls() {
        List<Integer> guess = Arrays.asList(4, 5, 6); // 정답에 없는 숫자
        int balls = ballChecker.countBalls(guess, answer);
        assertEquals(Constants.ZERO, balls, "볼이 없어야 합니다.");
    }

    @Test
    @DisplayName("하나의 볼이 있는 경우: 1이 정답에 포함되지만 위치가 다름")
    public void testOneBall() {
        List<Integer> guess = Arrays.asList(1, 5, 6); // 1이 있지만 위치가 다름
        int balls = ballChecker.countBalls(guess, answer);
        assertEquals(1, balls, "1개의 볼이어야 합니다.");
    }

    @Test
    @DisplayName("두 개의 볼이 있는 경우: 1과 3이 정답에 포함되지만 위치가 다름")
    public void testTwoBalls() {
        List<Integer> guess = Arrays.asList(1, 3, 6); // 1과 3은 있지만 위치가 다름
        int balls = ballChecker.countBalls(guess, answer);
        assertEquals(2, balls, "2개의 볼이어야 합니다.");
    }

    @Test
    @DisplayName("세 개의 볼이 있는 경우: 모든 숫자가 정답에 있지만 위치가 다름")
    public void testAllBalls() {
        List<Integer> guess = Arrays.asList(3, 1, 2); // 모두 위치가 다른 볼
        int balls = ballChecker.countBalls(guess, answer);
        assertEquals(3, balls, "3개의 볼이어야 합니다.");
    }
}



