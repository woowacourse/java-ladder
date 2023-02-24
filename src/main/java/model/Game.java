package model;

import util.GameStrategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<Name, Goal> prizeResult = new HashMap<>();

    public Game(Names names, LadderGoal goal, Ladder ladder, GameStrategy gameStrategy) {
        prizeResult = convertPrize(gameStrategy.playGame(ladder),
                names, goal);
    }

    private Map<Name, Goal> convertPrize(Map<Integer,Integer> prize, Names names, LadderGoal goal){
        prize.forEach((key,value) -> {
            prizeResult.put(names.getNames().get(key),
                    goal.getLadderGoal().get(value));
        });
        return prizeResult;
    }

    public String getPrizeIndividualWinner(Winner name) {
        return prizeResult.get(new Name(name.getWinner())).getGoal();
    }

    public Map<Name, Goal> getPrizeWinners() {
        return Collections.unmodifiableMap(prizeResult);
    }
}
