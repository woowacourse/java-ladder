package ladder.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import ladder.model.Line;

public class LadderGame {
    public LadderGame() {
    }

    public List<Integer> climbDownOneLine(List<Integer> initialPosition, Line line) {
        List<Boolean> isConnected = line.getConnected();
        List<Integer> connectedIndices = IntStream.range(0, isConnected.size())
                .filter(isConnected::get)
                .boxed()
                .toList();

        // 0, 2, 5 면 01 23 56 을 스왑

        for (int connectedIndex : connectedIndices) {
            Collections.swap(initialPosition, connectedIndex, connectedIndex+1);
        }

        return initialPosition;
    }
}
