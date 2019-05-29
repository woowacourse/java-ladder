package ladder;

import ladder.domain.*;

public class LadderGame {
	public LadderGameResult run(LadderGameInformation ladderGameInformation, Ladder ladder) {
		return new LadderGameResult(ladderGameInformation.matchPlayersAndRewards(ladder));
	}
}