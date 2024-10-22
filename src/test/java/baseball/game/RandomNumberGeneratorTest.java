package baseball.game;

import baseball.config.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RandomNumberGeneratorTest {

    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    public void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    @DisplayName("랜덤 숫자가 3개 생성되며, 숫자는 중복되지 않고 1에서 9 사이여야 한다")
    public void testGenerateRandomNumbers() {
        List<Integer> numbers = randomNumberGenerator.generate();

        // 숫자가 3개여야 함
        assertEquals(Constants.NUMBER_COUNT, numbers.size(), "숫자 개수가 3개여야 합니다.");

        // 숫자는 1에서 9 사이여야 함
        assertTrue(numbers.stream().allMatch(n -> n >= Constants.MIN_NUMBER && n <= Constants.MAX_NUMBER),
                "모든 숫자는 1에서 9 사이여야 합니다.");

        // 중복된 숫자가 없어야 함
        assertEquals(numbers.stream().distinct().count(), numbers.size(), "숫자가 중복되지 않아야 합니다.");
    }

    @Test
    @DisplayName("랜덤 숫자가 여러 번 생성될 때, 각 시도마다 다른 숫자가 생성되어야 한다")
    public void testGenerateDifferentNumbers() {
        List<Integer> firstAttempt = randomNumberGenerator.generate();
        List<Integer> secondAttempt = randomNumberGenerator.generate();

        // 두 번 생성한 결과가 동일하지 않아야 함
        assertNotEquals(firstAttempt, secondAttempt, "두 번의 시도에서 생성된 숫자가 달라야 합니다.");
    }
}
