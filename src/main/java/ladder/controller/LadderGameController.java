package ladder.controller;

import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.PlayerName;
import ladder.domain.linegenerator.LinePatternGenerator;
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
        List<PlayerName> playerNames = inputPlayerNames();
        Height height = inputHeight();

        LinePatternGenerator lineGenerator = new LinePatternGenerator(new RandomBooleanSupplier());
        Ladder ladder = new Ladder(height, playerNames.size(), lineGenerator);

        PlayerNamesDto playerNamesDto = toDto(playerNames);
        LadderDto ladderDto = toDto(ladder);
        outputView.printResult(ladderDto, playerNamesDto);
    }

    private List<PlayerName> inputPlayerNames() {
        try {
            return inputView.inputPlayerNames().stream()
                    .map(PlayerName::new)
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

    private PlayerNamesDto toDto(List<PlayerName> playerNames) {
        List<String> resultPlayerNames = playerNames.stream()
                .map(PlayerName::getName)
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
