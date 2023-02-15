package controller;

import domain.Ladder;
import domain.People;
import view.InputView;
import view.OutputView;

public class LadderController {
	private final InputView inputView;
	private final OutputView outputView;

	private People people;
	private Ladder ladder;

	public LadderController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void init() {
		repeat(() -> people = People.from(inputView.readNames()));
		repeat(() -> ladder = Ladder.from(inputView.readHeight(), people.size()));
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
