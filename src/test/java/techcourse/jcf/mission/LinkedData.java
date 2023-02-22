package techcourse.jcf.mission;

public class LinkedData {
    private String value;
    private LinkedData next;

    public LinkedData(String value) {
        this.value = value;
    }

    public void setNext(LinkedData next) {
        this.next = next;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public LinkedData next() {
        return next;
    }
}
