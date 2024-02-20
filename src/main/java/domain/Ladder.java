package domain;

public class Ladder {

    private int height;

    public Ladder(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height){
        if(height<=0){
            throw new IllegalArgumentException("[Error] 사다리 높이는 1이상 이어야 합니다.");
        }
    }
}
