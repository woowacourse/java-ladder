package domain;

import java.util.Map;

public class GameResult {

    Map<String, String> repository;

    public GameResult(Map<String, String> repository) {
        this.repository = repository;
    }

    public void save(String userName, String prize) {
        repository.put(userName, prize);
    }
}
