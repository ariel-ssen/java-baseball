package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private List<Integer> answer;

    public Game() {
        this.answer = generateRandomNumbers();
    }

    public Game(List<Integer> answer) {
        this.answer = answer;
    }

    public void start() {
        boolean isCorrect = false;
        while (!isCorrect) {
            List<Integer> guess = InputView.getUserInput();
            Result result = checkGuess(guess);
            ResultView.printResult(result);
            isCorrect = result.isCorrect();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        while (numbers.size() < 3) {
            int num = random.nextInt(9) + 1;
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return numbers;
    }

    public Result checkGuess(List<Integer> guess) {
        if (guess.size() != 3 || guess.stream().distinct().count() != 3) {
            throw new IllegalArgumentException("입력값은 서로 다른 3개의 숫자여야 합니다.");
        }
        if (!guess.stream().allMatch(n -> n >= 1 && n <= 9)) {
            throw new IllegalArgumentException("숫자는 1에서 9 사이여야 합니다.");
        }

        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (guess.get(i).equals(answer.get(i))) {
                strike++;
            } else if (answer.contains(guess.get(i))) {
                ball++;
            }
        }
        return new Result(strike, ball);
    }

    public List<Integer> getAnswer() {
        return new ArrayList<>(answer);
    }
}
