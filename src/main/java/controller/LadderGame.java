package controller;

import dto.LineDto;
import dto.ResultsDto;
import java.util.List;
import model.MatchedIndex;
import model.items.Item;
import model.ladder.Height;
import model.items.Items;
import model.ladder.Ladder;
import model.ladder.line.Line;
import model.people.People;
import model.ladder.line.RandomLinesGenerator;
import model.result.Results;
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
        final Items items = initItems(people.findPeopleSize());
        final Ladder ladder = initLadder(people.findPeopleSize());

        printLadder(people, ladder, items);

        final Results results = findResults(people, ladder, items);
        searchResult(results);
    }

    private People initPeople() {
        final List<String> peopleNames = inputView.inputPeopleNames();
        return People.from(peopleNames);
    }

    private Ladder initLadder(final int personCount) {
        final Height height = new Height(inputView.inputHeight());
        return Ladder.from(height, personCount, new RandomLinesGenerator());
    }

    private Items initItems(final int personCount) {
        List<String> itemNames = inputView.inputItemsNames();
        return Items.of(itemNames, personCount);
    }

    private void printLadder(final People people, final Ladder ladder, final Items items) {
        outputView.printLadderResultDescription();
        outputView.printPeopleNames(people.getNames());
        printLadderFormat(ladder);
        outputView.printItemNames(items.getNames());
    }

    private void printLadderFormat(final Ladder ladder) {
        List<Line> lines = ladder.getLines();
        List<LineDto> lineDtos = lines.stream()
                .map(LineDto::from)
                .toList();

        outputView.printLineDtos(lineDtos);
    }

    private Results findResults(final People people, final Ladder ladder, final Items items) {
        List<MatchedIndex> resultIndexes = ladder.climbAll();
        return Results.of(people, resultIndexes, items);
    }

    private void searchResult(final Results results) {
        String personName = inputView.inputPersonName();

        while (!inputView.isEnd()) {
            final Item item = results.findItemByPerson(personName);
            outputView.printResultByPerson(item.getName());
            personName = inputView.inputPersonName();
        }

        final ResultsDto resultsDto = ResultsDto.from(results);
        outputView.printAllResult(resultsDto);
    }
}
