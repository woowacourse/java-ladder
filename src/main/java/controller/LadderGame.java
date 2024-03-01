package controller;

import dto.LadderInfo;
import dto.ResultInfo;
import java.util.List;
import model.Height;
import model.Items;
import model.Ladder;
import model.People;
import model.PersonCount;
import model.Result;
import model.line.RandomLinesGenerator;
import view.InputView;
import view.OutputView;

public class LadderGame {
    private static final String ALL = "all";
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

        final Result result = findResult(people, ladder, items);
        final ResultInfo resultInfo = ResultInfo.from(result);
        searchResult(resultInfo);
    }

    private People initPeople() {
        final List<String> peopleNames = inputView.inputPeopleNames();
        return People.from(peopleNames);
    }

    private Ladder initLadder(final PersonCount personCount) {
        final Height height = new Height(inputView.inputHeight());
        return Ladder.from(height, personCount, new RandomLinesGenerator());
    }

    private Items initItems(final PersonCount personCount) {
        List<String> itemNames = inputView.inputItemsNames();
        return Items.of(itemNames, personCount);
    }

    private Result findResult(final People people, final Ladder ladder, final Items items) {
        List<Integer> resultIndexes = ladder.climbAll();
        return Result.of(people, resultIndexes, items);
    }

    private void searchResult(final ResultInfo resultInfo) {
        String personName = inputView.inputPersonName();
        while (!personName.equals(ALL)) {
            String itemName = resultInfo.getItemNameByPersonName(personName);
            outputView.printResultByPerson(itemName);
            personName = inputView.inputPersonName();
        }

        outputView.printAllResult(resultInfo.personAndItemName());
    }
}
