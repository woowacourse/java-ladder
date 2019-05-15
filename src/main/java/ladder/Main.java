package ladder;

import ladder.model.Ladder;
import ladder.model.LadderHeight;
import ladder.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        List<Player> players = new ArrayList<>();
        players.add(new Player("red"));
        players.add(new Player("blue"));
        players.add(new Player("green"));
        players.add(new Player("a"));
        players.add(new Player("c"));
        players.add(new Player("b"));
        players.add(new Player("d"));


        LadderHeight ladderHeight = new LadderHeight(10);

        System.out.println(new Ladder(players, ladderHeight));

    }
}
