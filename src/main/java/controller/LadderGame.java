package controller;

import dto.LadderInfo;
import dto.Result;
import java.util.List;
import model.Items;
import model.Ladder;
import model.People;
import model.line.RandomLinesGenerator;
import view.InputView;
import view.OutputView;

public class LadderGame {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGame(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        final People people = initPeople();
        final Items items = initItems(people.getPersonCount());
        final Ladder ladder = initLadder(people.getPersonCount());

        final LadderInfo ladderInfo = LadderInfo.from(people, ladder, items);
        outputView.printLadderInfo(ladderInfo);

        final Result result = Result.from(people, ladder, items);
        findResult(result);
    }

    private People initPeople() {
        final List<String> peopleNames = inputView.inputPeopleNames();
        return People.from(peopleNames);
    }

    private Ladder initLadder(final int personCount) {
        final int height = inputView.inputHeight();
        return Ladder.from(height, personCount, new RandomLinesGenerator());
    }

    private Items initItems(final int personCount) {
        List<String> itemNames = inputView.inputItemsNames();
        return Items.of(itemNames, personCount);
    }


    private void findResult(final Result result) {
        String personName = inputView.inputPersonName();
        while (!personName.equals("all")) {
            // 결과 출력
            personName = inputView.inputPersonName();
        }
    }
}
