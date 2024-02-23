package game;

import java.util.List;
import java.util.function.Supplier;

import domain.HorizontalLineStatus;
import domain.Ladder;
import domain.LadderHeight;
import domain.Name;
import generator.LadderFloorGenerator;
import view.InputView;
import view.OutputView;

public class LadderGame {

	private final InputView inputView;
	private final OutputView outputView;
	private final LadderFloorGenerator floorGenerator;

	public LadderGame(InputView inputView, OutputView outputView, LadderFloorGenerator floorGenerator) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.floorGenerator = floorGenerator;
	}

	public void play() {
		List<Name> names = retryOnException(this::getNames);
		LadderHeight height = retryOnException(this::getHeight);

		Ladder ladder = Ladder.of(names.size(), height.value());
		ladder.drawLines(floorGenerator);
		List<HorizontalLineStatus> statuses = ladder.createStatuses();

		printLadderResult(names, statuses);
	}

	private List<Name> getNames() {
		outputView.printReadNames();
		List<String> names = inputView.readNames();

		return names.stream()
			.map(Name::new)
			.toList();
	}

	private LadderHeight getHeight() {
		outputView.printReadLadderHeight();
		int height = inputView.readLadderHeight();

		return new LadderHeight(height);
	}

	private void printLadderResult(List<Name> names, List<HorizontalLineStatus> statuses) {
		outputView.printResultMessage();
		outputView.printNames(convertNames(names));
		outputView.printLadder(statuses);
	}

	private List<String> convertNames(List<Name> names) {
		return names.stream()
			.map(Name::value)
			.toList();
	}

	private <T> T retryOnException(Supplier<T> function) {
		try {
			return function.get();
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e.getMessage());
			return retryOnException(function);
		}
	}
}
