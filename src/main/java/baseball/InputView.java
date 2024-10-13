package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> getUserInput() {
        while (true) {
            try {
                System.out.print("숫자를 입력해 주세요 (1에서 9 사이의 숫자 3개): ");
                String input = scanner.nextLine().trim();

                // 입력에서 숫자만 추출
                List<Integer> numbers = extractNumbers(input);

                if (numbers.size() != 3) {
                    throw new IllegalArgumentException("숫자 3개를 정확히 입력해야 합니다.");
                }
                if (numbers.stream().distinct().count() != 3) {
                    throw new IllegalArgumentException("각 숫자는 중복되지 않아야 합니다.");
                }

                return numbers;
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다: " + e.getMessage());
            }
        }
    }

    // 입력에서 숫자만 추출하는 메서드
    private static List<Integer> extractNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {  // 숫자 문자만 처리
                int num = Character.getNumericValue(c);
                validateNumber(num);
                numbers.add(num);
            }
        }
        return numbers;
    }

    private static void validateNumber(int num) {
        if (num < 1 || num > 9) {
            throw new IllegalArgumentException("숫자는 1에서 9 사이여야 합니다.");
        }
    }
}
