package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {

    private Names players;
    private Rows rows;
    private Names rewards;
    private Map<Name, Name> resultMap;

    public LadderGame(Names players, Rows rows, Names rewards) {
        this.players = players;
        this.rows = rows;
        this.rewards = rewards;
        resultMap = new HashMap<>();
    }

    public void makeResultMap() {
        for (int i = 0; i < players.getCount(); i++) {
            resultMap.put(players.getElement(i), rewards.getElement(rows.followLadder(i)));
        }
    }
    public Name getReward(Name name){
        return resultMap.get(name);
    }
}
