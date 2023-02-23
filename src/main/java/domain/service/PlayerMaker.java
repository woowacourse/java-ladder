package domain.service;

import domain.model.Player;
import domain.model.Players;
import domain.vo.Name;
import domain.wrapper.Position;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerMaker {

    public Players make(List<Name> names) {
        Players players = new Players();
        players.addAll(mapToPlayerList(names));
        return players;
    }

    private static List<Player> mapToPlayerList(List<Name> names) {
        return names.stream()
                .map(name -> Player.of(name, Position.of(names.indexOf(name))))
                .collect(Collectors.toList());
    }
}
