package view;

import domain.Connection;
import domain.Game;
import domain.GameResultDto;
import domain.Ladder;
import domain.Line;
import domain.Member;
import domain.Members;
import domain.Reward;
import domain.Rewards;
import java.util.HashMap;
import java.util.List;

public class OutputView {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String CONNECTED_CHARACTER = "-";
    private static final String DISCONNECTED_CHARACTER = " ";
    private static final String FRAME_OF_LADDER = "|";

    public void printLadder(Game game) {
        System.out.println("사다리 결과");
        System.out.println(resolveMembers(game.getMembers()));
        System.out.println(resolveLadder(game.getLadder()));
        System.out.println(resolveResults(game.getResults()));
    }

    private String resolveMembers(Members members) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : members.getNames()) {
            stringBuilder.append(String.format("%" + MAX_NAME_LENGTH + "s ", name));
        }
        return stringBuilder.toString();
    }

    private String resolveLadder(Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            stringBuilder.append(resolveLine(line));
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("\n"));
        return stringBuilder.toString();
    }

    private String resolveLine(Line line) {
        List<Connection> connections = line.getConnections();
        StringBuilder stringBuilder = new StringBuilder(repeatCharacter(DISCONNECTED_CHARACTER, MAX_NAME_LENGTH - 1));
        for (Connection connection : connections) {
            stringBuilder.append(FRAME_OF_LADDER);
            stringBuilder.append(resolveConnection(connection));
        }
        stringBuilder.append(FRAME_OF_LADDER);
        return stringBuilder.toString();
    }

    private String resolveConnection(Connection connection) {
        if (connection.equals(Connection.CONNECTED)) {
            return repeatCharacter(CONNECTED_CHARACTER, MAX_NAME_LENGTH);
        }
        return repeatCharacter(DISCONNECTED_CHARACTER, MAX_NAME_LENGTH);
    }

    private String repeatCharacter(String character, int times) {
        return character.repeat(times);
    }

    private String resolveResults(Rewards rewards) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : rewards.getValues()) {
            stringBuilder.append(String.format("%" + MAX_NAME_LENGTH + "s ", name));
        }
        return stringBuilder.toString();
    }

    public void printResult(GameResultDto gameResultDto) {
        HashMap<Member, Reward> results = gameResultDto.getGameResult();
        if (results.size() == 1) {
            System.out.println(resolveResult(gameResultDto));
            return;
        }
        System.out.println(resolveAllResults(gameResultDto));
    }

    private String resolveResult(GameResultDto gameResultDto) {
        HashMap<Member, Reward> results = gameResultDto.getGameResult();
        return results.values().stream()
                .map(Reward::getValue)
                .toList()
                .get(0);
    }

    private String resolveAllResults(GameResultDto gameResultDto) {
        StringBuilder stringBuilder = new StringBuilder();
        gameResultDto.getGameResult().forEach((member, result) -> {
            stringBuilder.append(member.getName());
            stringBuilder.append(" : ");
            stringBuilder.append(result.getValue());
            stringBuilder.append("\n");
        });
        return stringBuilder.toString();
    }
}
