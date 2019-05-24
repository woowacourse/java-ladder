package ladder.view;

import ladder.model.LadderGame;
import ladder.model.Member;
import ladder.model.Result;
import ladder.model.Row;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String SINGLE_BLANK = " ";
    private static final String NEW_LINE = "\n";
    private static final int MAX_NAME_LENGTH = 5;
    private static final String GAME_RESULT = "실행 결과";

    public static void printLadder(LadderGame ladderGame) {
        StringBuilder stringBuilder = new StringBuilder();

        setPrintName(ladderGame, stringBuilder);
        setPrintLadder(ladderGame, stringBuilder);
        setPrintResults(ladderGame, stringBuilder);

        System.out.println(stringBuilder.toString());
    }

    private static void setPrintName(LadderGame ladderGame, StringBuilder stringBuilder) {
        for (String name: ladderGame.getMembersName()) {
            stringBuilder.append(makePrettyName(name)).append(SINGLE_BLANK);
        }
    }

    // todo: LadderGame에서 ladder 정보를 전달하도록 구현
    private static void setPrintLadder(LadderGame ladderGame, StringBuilder stringBuilder) {
        stringBuilder.append(NEW_LINE);
        for (Row row : ladderGame.getLadderStructure()){
            stringBuilder.append(row.toString()).append(NEW_LINE);
        }
    }

    private static void setPrintResults(LadderGame ladderGame, StringBuilder stringBuilder) {
        for (String result : ladderGame.getResults()) {
            stringBuilder.append(makePrettyName(result)).append(SINGLE_BLANK);
        }
    }

    private static String makePrettyName(String name){
        StringBuilder stringBuilder = new StringBuilder();
        int blankLength = MAX_NAME_LENGTH - name.length();
        stringBuilder.append(name);

        for (int i = 1; i <= blankLength; i++){
            addBlank(stringBuilder, i);
        }

        return stringBuilder.toString();
    }

    private static void addBlank(StringBuilder stringBuilder, int index) {
        if (index % 2 == 0){
            stringBuilder.append(SINGLE_BLANK);
        }
        if (index % 2 == 1){
            stringBuilder.insert(0, SINGLE_BLANK);
        }
    }

    public static void printMemberResult(Result result) {
        System.out.println(GAME_RESULT);
        System.out.println(result.getResult());
    }

    public static void allPrintResult(Map<String, Result> results, List<String> membersName) {
        System.out.println(GAME_RESULT);
        membersName.forEach(name -> System.out.println(name + " : " + results.get(name).getResult()));
    }
}
