package ladder.view;

import java.util.List;

public class MockInputView implements Input {

    private final List<List<String>> inputPlayersNames;
    private final List<Integer> inputHeightOfLadder;
    private final List<List<String>> inputRewards;
    private final List<List<String>> inputTargetPlayers;
    private final List<String> inputContinue;

    private int orderOfInputPlayerNames;
    private int orderOfInputHeightOfLadder;
    private int orderOfInputRewards;
    private int orderOfInputTargetPlayers;
    private int orderOfInputContinue;

    public MockInputView(List<List<String>> inputPlayersNames,
                         List<Integer> inputHeightOfLadder,
                         List<List<String>> inputRewards,
                         List<List<String>> inputTargetPlayers,
                         List<String> inputContinue) {
        this.inputPlayersNames = inputPlayersNames;
        this.inputHeightOfLadder = inputHeightOfLadder;
        this.inputRewards = inputRewards;
        this.inputTargetPlayers = inputTargetPlayers;
        this.inputContinue = inputContinue;
    }

    @Override
    public List<String> inputPlayerNames() {
        if (inputPlayersNames.size() == orderOfInputPlayerNames) {
            orderOfInputPlayerNames = 0;
        }
        return inputPlayersNames.get(orderOfInputPlayerNames++);
    }

    @Override
    public int inputHeightOfLadder() {
        if (inputHeightOfLadder.size() == orderOfInputHeightOfLadder) {
            orderOfInputHeightOfLadder = 0;
        }
        return inputHeightOfLadder.get(orderOfInputHeightOfLadder++);
    }

    @Override
    public List<String> inputRewards() {
        if (inputRewards.size() == orderOfInputRewards) {
            orderOfInputRewards = 0;
        }
        return inputRewards.get(orderOfInputRewards++);
    }

    @Override
    public List<String> inputTargetPlayerNames() {
        if (inputTargetPlayers.size() == orderOfInputTargetPlayers) {
            orderOfInputTargetPlayers = 0;
        }
        return inputTargetPlayers.get(orderOfInputTargetPlayers++);
    }

    @Override
    public String inputContinue() {
        if (inputContinue.size() == orderOfInputContinue) {
            orderOfInputContinue = 0;
        }
        return inputContinue.get(orderOfInputContinue++);
    }

}
