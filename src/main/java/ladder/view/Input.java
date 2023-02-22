package ladder.view;

import java.util.List;

public interface Input {

    List<String> inputPlayerNames();

    int inputHeightOfLadder();

    List<String> inputRewards();

    List<String> inputTargetPlayerNames();

    String inputContinue();
}
