package controller;

import domain.Ladder;
import domain.People;
import view.InputView;
import view.OutputView;

public class LadderController {
	private final InputView inputView;
	private final OutputView outputView;

	private Ladder ladder;
	private People people;

	public LadderController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void init() {
		people = new People(inputView.readNames());
	}
}
