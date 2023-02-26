package techcourse.jcf.mission;

public class SimpleElement {

    private String value;
    private SimpleElement next;

    public SimpleElement(String value) {
        this.value = value;
        this.next = null;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SimpleElement getNext() {
        return next;
    }

    public void setNext(SimpleElement next) {
        this.next = next;
    }
}
