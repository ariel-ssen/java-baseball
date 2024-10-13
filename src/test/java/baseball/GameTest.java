package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    @DisplayName("정상적인 랜덤 숫자 생성 테스트")
    public void testGenerateRandomNumbers() {
        Game game = new Game();
        List<Integer> numbers = game.getAnswer();

        assertEquals(3, numbers.size(), "숫자 개수가 3개여야 합니다.");
        assertTrue(numbers.stream().allMatch(n -> n >= 1 && n <= 9),
                "모든 숫자는 1에서 9 사이여야 합니다.");
        assertEquals(3, numbers.stream().distinct().count(),
                "숫자는 중복되지 않아야 합니다.");
    }

    @Test
    @DisplayName("정답을 맞췄을 때 3 스트라이크 확인")
    public void testCheckGuessCorrect() {
        Game game = new Game(List.of(4, 2, 5));
        Result result = game.checkGuess(List.of(4, 2, 5));

        assertEquals(3, result.getStrike(), "3 스트라이크가 나와야 합니다.");
        assertEquals(0, result.getBall(), "볼이 없어야 합니다.");
        assertTrue(result.isCorrect(), "정답을 맞췄으므로 게임이 종료되어야 합니다.");
    }

    @Test
    @DisplayName("부분적으로 맞췄을 때 스트라이크와 볼 확인")
    public void testCheckGuessPartial() {
        Game game = new Game(List.of(4, 2, 5));
        Result result = game.checkGuess(List.of(4, 5, 2));

        assertEquals(1, result.getStrike(), "1 스트라이크여야 합니다.");
        assertEquals(2, result.getBall(), "2 볼이어야 합니다.");
    }

    @Test
    @DisplayName("아무 숫자도 맞추지 못했을 때 낫싱 확인")
    public void testCheckGuessNothing() {
        Game game = new Game(List.of(4, 2, 5));
        Result result = game.checkGuess(List.of(1, 6, 7));

        assertEquals(0, result.getStrike(), "스트라이크가 없어야 합니다.");
        assertEquals(0, result.getBall(), "볼이 없어야 합니다.");
    }

    @Test
    @DisplayName("중복된 숫자 입력 시 예외 발생 테스트")
    public void testDuplicateInputThrowsException() {
        Game game = new Game();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> game.checkGuess(List.of(1, 1, 2))
        );
        assertEquals("입력값은 서로 다른 3개의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("범위 외 숫자 입력 시 예외 발생 테스트")
    public void testOutOfRangeInputThrowsException() {
        Game game = new Game();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> game.checkGuess(List.of(0, 10, 2))
        );
        assertEquals("숫자는 1에서 9 사이여야 합니다.", exception.getMessage());
    }
}
