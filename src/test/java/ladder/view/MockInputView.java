package ladder.view;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MockInputView implements Input {

    private final List<List<String>> inputPlayersNames;
    private final List<Integer> inputHeightOfLadder;

    private int orderOfInputPlayerNames;
    private int orderOfInputHeightOfLadder;

    public MockInputView(List<List<String>> inputPlayersNames, List<Integer> inputHeightOfLadder) {
        this.orderOfInputPlayerNames = 0;
        this.inputPlayersNames = new ArrayList<>(inputPlayersNames);
        this.orderOfInputHeightOfLadder = 0;
        this.inputHeightOfLadder = new ArrayList<>(inputHeightOfLadder);
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
}
