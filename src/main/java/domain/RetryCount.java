package domain;

public class RetryCount {

    private int count;

    public RetryCount(int count) {
        this.count = count;
    }

    public boolean isLimit() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    public void decrease() {
        count--;
    }
}
