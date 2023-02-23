package ladder.domain;

import ladder.util.NullChecker;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public enum GameResultViewScope {
    ALL("all"),
    ;

    private final String command;

    GameResultViewScope(String command) {
        this.command = command;
    }

    public static Optional<GameResultViewScope> from(String command) {
        NullChecker.checkNull(command, "잘못된 명령어입니다");

        return Arrays.stream(values())
                     .filter(gameResultViewScope -> Objects.equals(gameResultViewScope.command, command))
                     .findAny();
    }
}
