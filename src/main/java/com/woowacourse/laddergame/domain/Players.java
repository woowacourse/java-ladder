package com.woowacourse.laddergame.domain;

import com.woowacourse.laddergame.util.NaturalNumber;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<Player> players;

    public Players() {
        players = new ArrayList<>();
    }

    public void add(Player player) {
        if (checkDuplicateName(player)) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다");
        }
        players.add(player);
    }

    private boolean checkDuplicateName(Player player) {
        return players.contains(player);
    }

    public int getPlayerNo(String name) {
        return players.indexOf(new Player(name)) + 1;
    }

    public Player get(NaturalNumber playerNo) {
        return players.get(playerNo.convertIndex());
    }

    public int size() {
        return players.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Player player : players) {
            sb.append(player.toString());
        }
        return sb.toString();
    }
}
