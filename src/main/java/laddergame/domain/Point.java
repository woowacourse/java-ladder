package laddergame.domain;

public class Point {
    private boolean link = false;

    public Point(boolean link) {
        this.link = link;
    }

    public boolean isTrue() {
        return this.link;
    }
    @Override
    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        if (link) {
//            stringBuilder.append("-----");
//            return stringBuilder.toString();
//        }
//        stringBuilder.append("     ");

        return link ? "-----" : "     ";
    }
}
