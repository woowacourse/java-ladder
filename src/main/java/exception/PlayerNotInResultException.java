package exception;

import domain.LadderGameResult;

public class PlayerNotInResultException extends LadderGameException {

    public PlayerNotInResultException(String message) {
        super(message);
    }

}
