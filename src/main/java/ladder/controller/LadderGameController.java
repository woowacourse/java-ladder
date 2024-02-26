package ladder.controller;

import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.player.Player;
import ladder.domain.linegenerator.StickListGenerator;
import ladder.domain.linegenerator.SticksPatternGenerator;
import ladder.domain.linegenerator.RandomBooleanSupplier;
import ladder.dto.LadderDto;
import ladder.dto.LineDto;
import ladder.dto.PlayerNamesDto;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        List<Player> players = inputPlayerNames();
        Height height = inputHeight();

        StickListGenerator stickListGenerator = new SticksPatternGenerator(new RandomBooleanSupplier());
        Ladder ladder = Ladder.of(height, players.size(), stickListGenerator);

        PlayerNamesDto playerNamesDto = toDto(players);
        LadderDto ladderDto = toDto(ladder);
        outputView.printResult(ladderDto, playerNamesDto);
    }

    private List<Player> inputPlayerNames() {
        try {
            return inputView.inputPlayerNames().stream()
                    .map(Player::new)
                    .toList();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return inputPlayerNames();
        }
    }

    private Height inputHeight() {
        try {
            return new Height(inputView.inputHeight());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return inputHeight();
        }
    }

    private PlayerNamesDto toDto(List<Player> players) {
        List<String> resultPlayerNames = players.stream()
                .map(Player::getName)
                .toList();
        return new PlayerNamesDto(resultPlayerNames);
    }

    private LadderDto toDto(Ladder ladder) {
        List<LineDto> lineDtos = IntStream.range(0, ladder.getHeight())
                .mapToObj(height -> toLineDto(ladder, height))
                .toList();
        return new LadderDto(lineDtos);
    }

    private LineDto toLineDto(Ladder ladder, int height) {
        List<Boolean> sticks = IntStream.range(0, ladder.getWidth())
                .mapToObj(width -> ladder.isExist(height, width))
                .toList();
        return new LineDto(sticks);
    }
}
