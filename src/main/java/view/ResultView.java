package view;

import domain.Ladder;
import domain.Names;

public class ResultView {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private final MessageResolver messageResolver;

    public ResultView(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    public void printLadder(Ladder ladder, Names names) {
        System.out.println(LINE_SEPARATOR + "실행결과" + LINE_SEPARATOR);
        System.out.println(messageResolver.resolveNamesMessage(names));
        System.out.println(messageResolver.resolveLadderMessage(ladder));
    }
}
