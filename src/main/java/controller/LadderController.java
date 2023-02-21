package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import domain.Game;
import domain.Ladder;
import domain.Level;
import domain.People;
import domain.Results;
import domain.Stool;
import view.InputView;
import view.OutputView;

public class LadderController {
	private static final Map<String, String> joinnedResult = new HashMap<>();
	private final InputView inputView;
	private final OutputView outputView;
	private People people;
	private Results results;
	private Ladder ladder;

	public LadderController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	private List<Boolean> getLevel(Level level) {
		return level.getStools().stream()
			.map(Stool::isStool)
			.collect(Collectors.toList());
	}

	public void init() {
		repeat(() -> people = People.from(inputView.readNames()));
		repeat(() -> results = Results.from(inputView.readSequences()));
		repeat(() -> ladder = Ladder.from(inputView.readHeight(), people.size()));
	}

	public void showLadder() {
		outputView.printResult(people.getNames(), getLadder(), results.getResults());
	}

	public void play() {
		for (int position = 0; position < people.size(); position++) {
			int newPosition = Game.start(position, ladder);
			joinnedResult.put(people.getNames().get(position), results.getResult(newPosition));
		}
	}

	public void askWanted() {
		String search = inputView.readWho();
		if (search.equals("all")) {
			outputView.printAll(joinnedResult);
		}
		if (joinnedResult.containsKey(search)) {
			outputView.printWanted(search, joinnedResult);
			askWanted();
		}
	}

	private List<List<Boolean>> getLadder() {
		return ladder.getLadder().stream()
			.map(this::getLevel)
			.collect(Collectors.toList());
	}

	private void repeat(Runnable repeatable) {
		try {
			repeatable.run();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			repeat(repeatable);
		}
	}
}
