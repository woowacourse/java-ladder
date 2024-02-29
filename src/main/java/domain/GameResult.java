package domain;

import java.util.Map;

public record GameResult(Map<String, String> userPrizeRepository) {

    public void save(String userName, String prize) {
        userPrizeRepository.put(userName, prize);
    }

    public String findByUserName(String userName) {
        return userPrizeRepository.get(userName);
    }
}
