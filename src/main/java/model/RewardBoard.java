package model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RewardBoard {
    private final Map<Person, Prize> board;

    public RewardBoard() {
        this.board = new LinkedHashMap<>();
    }

    public void addReward(Person person, Prize prize) {
        board.put(person, prize);
    }

    public Prize findPrizeByName(String name) {
        if(!board.containsKey(new Person(name))) {
            throw new IllegalArgumentException("해당 참가자를 찾을 수 없습니다.");
        }
        return board.get(new Person(name));
    }

    public List<Prize> findAllPrizes() {
        return board.values()
                .stream()
                .toList();
    }
}
