package domain;

import view.InputView;

public final class LadderHeight {
    private static final String LADDER_HEIGHT_ERROR_MESSAGE = "[ERROR] 사다리의 높이는 숫자를 입력해야합니다";

    private final int ladderHeight;
    InputView inputView;

    public LadderHeight(String ladderHeight, InputView inputView){
        this.inputView = inputView;
        ladderHeight = validateLadderHeight(ladderHeight);
        this.ladderHeight = Integer.parseInt(ladderHeight);
    }

    private String validateLadderHeight(String ladderHeight) {
        try{
            validateLadderHeightIsNumber(ladderHeight);
        }catch(IllegalArgumentException exception){
            inputView.printErrorMessage(exception.getMessage());
            ladderHeight = validateLadderHeight(inputView.readLadderHeight());
        }
        return ladderHeight;
    }

    public static void validateLadderHeightIsNumber(String ladderHeight) {
        try {
            Integer.parseInt(ladderHeight);
        } catch (Exception exception) {
            throw new IllegalArgumentException(LADDER_HEIGHT_ERROR_MESSAGE);
        }
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
