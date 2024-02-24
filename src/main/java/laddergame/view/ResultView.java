package laddergame.view;

import laddergame.domain.ladder.Connection;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.RowLine;
import laddergame.domain.people.Name;
import laddergame.domain.people.People;
import laddergame.view.enums.NameFormat;

import java.util.List;
import java.util.StringJoiner;

import static laddergame.domain.ladder.Connection.CONNECTED;

public class ResultView {
    private static final String LINE_SEPERATOR = System.lineSeparator();

    private ResultView() {
    }

    public static void printLadder(People people, Ladder ladder) {
        System.out.println(LINE_SEPERATOR+"실행 결과"+LINE_SEPERATOR);
        System.out.println(MessageResolver.resolvePeopleMessage(people));
        System.out.println(MessageResolver.resolveLadderMessage(ladder));
    }

}
