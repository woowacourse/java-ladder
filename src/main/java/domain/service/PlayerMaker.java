package domain.service;

import domain.model.Players;
import domain.vo.Names;

public class PlayerMaker {

    public static Players make(final Names names) {
        return new Players(names.mapToPlayers());
    }
}
