package domain;

public class Bridge {

    public Bridge(int height) {
        validate(height);
    }

    private void validate(int height) {
        if(height <= 0){
            throw new IllegalArgumentException("");
            //TODO : 예외 메시지 추가해주기
        }
    }
}
