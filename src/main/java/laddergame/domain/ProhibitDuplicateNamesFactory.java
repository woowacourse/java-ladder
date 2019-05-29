package laddergame.domain;

import laddergame.domain.player.Player;

import java.util.HashSet;
import java.util.List;

public abstract class ProhibitDuplicateNamesFactory extends AbstractNamesFactory {

	protected void checkDuplication(List<Player> players) throws IllegalArgumentException {
		if (new HashSet<>(players).size() != players.size()) {
			throw new IllegalArgumentException("중복된 이름이 존재합니다");
		}
	}
}
