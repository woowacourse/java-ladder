package controller;

import dto.LadderDto;
import dto.ResultDto;
import java.util.List;
import model.Index;
import model.ladder.Height;
import model.items.Items;
import model.ladder.Ladder;
import model.people.People;
import model.people.PersonCount;
import model.Result;
import model.ladder.line.RandomLinesGenerator;
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

        final LadderDto ladderDto = LadderDto.from(people, ladder, items);
        outputView.printLadderInfo(ladderDto);

        final Result result = findResult(people, ladder, items);
        final ResultDto resultDto = ResultDto.from(result);
        searchResult(resultDto);
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
        List<Index> resultIndexes = ladder.climbAll();
        return Result.of(people, resultIndexes, items);
    }

    private void searchResult(final ResultDto resultDto) {
        String personName = inputView.inputPersonName();
        while (!personName.equals(ALL)) {
            String itemName = resultDto.getItemNameByPersonName(personName);
            outputView.printResultByPerson(itemName);
            personName = inputView.inputPersonName();
        }

        outputView.printAllResult(resultDto.personAndItemName());
    }
}
