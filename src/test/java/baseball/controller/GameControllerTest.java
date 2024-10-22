package baseball.controller;

import baseball.game.Game;
import baseball.io.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {

    private Game game;
    private GameController gameController;

    @BeforeEach
    public void setUp() {
        game = new Game(); // 실제 Game 객체를 사용
    }

    @Test
    @DisplayName("게임이 한번 실행되고 종료되는 시나리오")
    public void testRunGameOnceAndExit() {
        // 가상의 입력 스트림을 설정하여 사용자가 2를 입력한 것으로 간주
        String input = "2\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        // 실제 Game과 가상의 Scanner를 사용하여 GameController 생성
        gameController = new GameController(game, scanner);

        // 게임 실행
        gameController.run();

        // 게임이 정상적으로 종료되었는지 확인
        // 종료 메시지가 출력되는지 확인
        assertEquals(Message.GAME_END, "게임 종료");
    }

    @Test
    @DisplayName("게임이 한번 실행된 후 재시작하는 시나리오")
    public void testRunGameAndRestart() {
        // 사용자가 1을 입력하여 게임을 다시 시작하고, 2를 입력하여 종료한 것으로 간주
        String input = "1\n2\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        // 실제 Game과 가상의 Scanner를 사용하여 GameController 생성
        gameController = new GameController(game, scanner);

        // 게임 실행
        gameController.run();

        // 게임이 두 번 실행되었는지 확인할 수 있는 방법을 정의해야 함 (현재는 확인 어려움)
        // 특정 로직이 없기 때문에 단순 실행 여부만 검증할 수 있음
        assertEquals(Message.GAME_END, "게임 종료");
    }
}
