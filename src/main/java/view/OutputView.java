package view;

import domain.Participant;
import domain.Participants;
import domain.Result;
import domain.Results;
import domain.util.Display;

import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

	private final static String ERROR_PREFIX = "[ERROR] ";
	private final static String RESULT_MSG = "실행 결과";


	public static void printLadder(Display names, Display ladder, Results results) {
		System.out.println(names.format());
		System.out.println(ladder.format());
		printResults(results);
		System.out.println();
	}

	public static void printError(String errorMsg) {
		System.out.println(ERROR_PREFIX + errorMsg);
	}

	public static void printParticipantResult(Result result) {
		System.out.println(RESULT_MSG);
		System.out.println(result.getValue());
		System.out.println();
	}

	public static void printAllResult(Participants participants, Map<Participant, Result> results) {
		int participantsNum = participants.getParticipantsNum();
		for (int i = 0; i < participantsNum; i++) {
			Participant participant = participants.get(i);
			printNameWithResult(participant, results.get(participant));
		}
	}

	private static void printResults(Results results) {
		String lineResults = results.getResults().stream()
				.map(Result::getValue)
				.map(s -> String.format("%6s", s))
				.collect(Collectors.joining(""));
		System.out.println(lineResults);
	}

	private static void printNameWithResult(Participant participant, Result result) {
		System.out.printf("%s : %s", participant.format(), result.getValue());
		System.out.println();
	}
}
