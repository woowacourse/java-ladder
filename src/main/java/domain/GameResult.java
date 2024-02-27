package domain;

import java.util.Map;

public record GameResult(Map<String, String> repository) {

    public void save(String userName, String prize) {
        repository.put(userName, prize);
    }

    public String findByUserName(String userName) {
        return repository.get(userName);
    }
}
