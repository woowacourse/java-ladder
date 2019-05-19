package laddergame.domain;

public class Request {
    private String request;

    public Request(Players players, String request) {
        validateRequest(players, request);
        this.request = request;
    }

    private static void validateRequest(Players players, String request) {
        if (request.equals("all")) { return; }

        boolean isNamePresent = false;
        for (int i = 0; i < players.getPlayers().size() && !isNamePresent; i++) {
            isNamePresent = players.getPlayers().get(i).isPresent(request);
        }

        if (!isNamePresent) { throw new IllegalArgumentException("일치하는 플레이어의 이름이 존재하지 않습니다."); }
    }
}
