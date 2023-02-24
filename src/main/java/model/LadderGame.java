package model;

import dto.GameResultDto;
import dto.LineDto;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import strategy.PassGenerator;

public class LadderGame {

    private Names participantsNames;
    private LadderResults ladderResults;
    private Ladder ladder;
    private GameResults gameResults;

    public void initParticipantsNames(List<String> namesInfo) {
        this.participantsNames = Names.of(namesInfo);
    }

    public void initLadderResults(List<String> ladderResultsInfo) {
        validateParticipantsNames();
        this.ladderResults = LadderResults.of(ladderResultsInfo, participantsNames.getTotalParticipantSize());
    }

    public void initLadder(PassGenerator generator, int heightOfLadder) {
        validateParticipantsNames();

        Height height = new Height(heightOfLadder);

        this.ladder = Ladder.of(generator, height, participantsNames.getTotalParticipantSize());
    }

    public void play() {
        validateParticipantsNames();
        validateLadderResult();
        validateLadder();

        this.gameResults = GameResults.of(participantsNames, ladder, ladderResults);
    }

    public List<GameResultDto> findGameResult(String name) {
        validateGameResult();

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
        List<GameResult> gameResults = this.gameResults.getGameResults();

        return gameResults.stream()
                .map(GameResultDto::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateParticipantsNames() {
        if (Objects.isNull(participantsNames)) {
            throw new IllegalStateException("참가자가 등록되지 않았습니다.");
        }
    }

    private void validateLadder() {
        if (Objects.isNull(ladder)) {
            throw new IllegalStateException("사다리가 생성되지 않았습니다.");
        }
    }

    private void validateLadderResult() {
        if (Objects.isNull(ladderResults)) {
            throw new IllegalStateException("사다리 실행 결과가 등록되지 않았습니다.");
        }
    }

    private void validateGameResult() {
        if (Objects.isNull(gameResults)) {
            throw new IllegalStateException("사다리 게임을 진행하지 않았습니다.");
        }
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
