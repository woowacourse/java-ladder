package model;

import dto.GameResultDto;
import dto.LineDto;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import strategy.PassGenerator;

public class LadderGame {

    private final Names participantsNames;
    private final LadderResults ladderResults;
    private final Ladder ladder;
    private final GameResults gameResults;

    private LadderGame(Names participantsNames, LadderResults ladderResults, Ladder ladder,
            GameResults gameResults) {
        this.participantsNames = participantsNames;
        this.ladderResults = ladderResults;
        this.ladder = ladder;
        this.gameResults = gameResults;
    }

    private static LadderGame of(List<String> namesInfo, List<String> ladderResultsInfo, PassGenerator generator,
            Height height) {
        int totalParticipantSize = namesInfo.size();
        Names participantsNames = Names.of(namesInfo);
        LadderResults ladderResults = LadderResults.of(ladderResultsInfo, totalParticipantSize);
        Ladder ladder = Ladder.of(generator, height, totalParticipantSize);
        GameResults gameResults = GameResults.of(participantsNames, ladder, ladderResults);

        return new LadderGame(participantsNames, ladderResults, ladder, gameResults);
    }

    private static class Builder {
        private static final int MINIMUM_PARTICIPANT_SIZE = 2;
        private static final int MINIMUM_LADDER_RESULT_SIZE = 2;

        private List<String> namesInfo;
        private List<String> ladderResultsInfo;
        private PassGenerator generator;
        private Height height;

        public static Builder builder() {
            return new Builder();
        }

        public Builder namesInfo(List<String> namesInfo) {
            this.namesInfo = namesInfo;

            return this;
        }

        public Builder ladderResultsInfo(List<String> ladderResultsInfo) {
            this.ladderResultsInfo = ladderResultsInfo;

            return this;
        }

        public Builder generator(PassGenerator generator) {
            this.generator = generator;

            return this;
        }

        public Builder heightOfLadder(int heightOfLadder) {
            this.height = new Height(heightOfLadder);

            return this;
        }

        public LadderGame build() {
            validateNamesInfo();
            validateLadderResultsInfo();
            validateGenerate();

            return LadderGame.of(namesInfo, ladderResultsInfo, generator, height);
        }

        private void validateNamesInfo() {
            if (Objects.isNull(namesInfo)) {
                throw new IllegalStateException();
            }
            if (namesInfo.size() < MINIMUM_PARTICIPANT_SIZE) {
                throw new IllegalArgumentException();
            }
        }

        private void validateLadderResultsInfo() {
            if (Objects.isNull(namesInfo)) {
                throw new IllegalStateException();
            }
            if (namesInfo.size() < MINIMUM_LADDER_RESULT_SIZE) {
                throw new IllegalArgumentException();
            }
        }

        private void validateGenerate() {
            if (Objects.isNull(generator)) {
                throw new IllegalStateException();
            }
        }
    }

    public List<GameResultDto> findGameResult(String name) {
        if (LadderGameCommand.ALL_RESULT_PRINT_AND_EXIT_COMMAND.isPlayable(name)) {
            return findGameResultByName(name);
        }
        return findGameResultAll();
    }

    private List<GameResultDto> findGameResultByName(String name) {
        GameResult gameResult = gameResults.findGameResultByName(name);
        GameResultDto gameResultDto = new GameResultDto(gameResult);

        return List.of(gameResultDto);
    }

    private List<GameResultDto> findGameResultAll() {
        List<GameResult> totalGameResults = gameResults.getGameResults();

        return totalGameResults.stream()
                .map(GameResultDto::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getParticipantsNames() {
        List<Name> names = participantsNames.getNames();

        return names.stream()
                .map(Name::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<LineDto> getLadder() {
        List<Line> lines = ladder.getLines();

        return lines.stream()
                .map(line -> new LineDto(mapToPathLog(line)))
                .collect(Collectors.toUnmodifiableList());
    }

    private List<Boolean> mapToPathLog(Line line) {
        List<Path> paths = line.getPaths();

        return paths.stream()
                .map(Path::isPassable)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getLadderResults() {
        return ladderResults.getResults();
    }
}
