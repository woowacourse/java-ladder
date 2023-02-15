package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {

    //TODO: 전략패턴 하나의 인터페이스에 몰아서 하는 게 맞는지 확인하기
    //TODO: INPUT,OUTPUT, GENERATOR 객체로 컨트롤러에 생성자로 주입 혹은 STATIC으로 사용 둘중에 뭐가 맞는지 확인하기 ★★★★
    //TODO : 우르의 HANDLE ERROR기능 추가할지 고민해보기 ★★
    private static final int MINIMUM_HEIGHT = 1;
    private final RandomGenerator randomIntegerGenerator = new RandomDataGenerator();

    public void run() {
        Players players = createPlayers();
        Height heightOfLadder = decideHeightOfLadder();

        Ladder ladder = createLadder(players, heightOfLadder);

        ResultView.printLadder(players.getNames(), Name.NAME_MAXIMUM_LENGTH, ladder.getLines());
    }

    private Players createPlayers() {
        try {
            List<String> inputNames = InputView.inputPlayerNames();
            List<Player> players = createPlayersByName(inputNames);

            return new Players(players);
        } catch (IllegalArgumentException e) {
            ResultView.printError(e.getMessage());
            return createPlayers();
        }
    }

    private List<Player> createPlayersByName(List<String> inputNames) {
        return inputNames.stream()
                .map(inputName -> new Player(new Name(inputName)))
                .collect(Collectors.toList());
    }

    private Height decideHeightOfLadder() {
        try {
            int inputMaximumHeight = InputView.inputHeightOfLadder();
            int height = randomIntegerGenerator.generateNumber(MINIMUM_HEIGHT, inputMaximumHeight);

            return new Height(height);
        } catch (IllegalArgumentException e) {
            ResultView.printError(e.getMessage());
            return decideHeightOfLadder();
        }
    }

    private Ladder createLadder(Players players, Height height) {
        List<Line> lines = new ArrayList<>();
        for (int idx = 0; idx < height.getHeight(); idx++) {
            List<Bar> bars = LineMaker.generate(players.count(), randomIntegerGenerator);
            lines.add(new Line(bars));
        }
        return new Ladder(lines);
    }
}
