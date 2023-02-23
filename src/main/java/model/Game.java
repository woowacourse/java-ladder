package model;

import util.GameStrategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<Name, Result> prizeResult = new HashMap<>();

    public Game(Names names, LadderGoal goal, Ladder ladder, GameStrategy gameStrategy) {
        prizeResult = convertPrize(gameStrategy.playGame(ladder),
                names, goal);
    }

    private Map<Name, Result> convertPrize(Map<Integer,Integer> prize,Names names, LadderGoal goal){
        prize.forEach((key,value) -> {
            prizeResult.put(names.getNames().get(key),
                    goal.getLadderGoal().get(value));
        });
        return prizeResult;
    }

    public String getPrizeIndividualPlayer(Player name) {
        return prizeResult.get(new Name(name.getPlayer())).getResult();
    }

    public Map<Name,Result> getPrizePlayers() {
        return Collections.unmodifiableMap(prizeResult);
    }
}
