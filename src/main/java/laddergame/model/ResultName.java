package laddergame.model;

public class ResultName {
    private final String name;

    public ResultName(String name) {
        String noBlankName = name.replaceAll(" ", "");
        if (noBlankName.length() < 1 || noBlankName.length() > 5) {
            throw new IllegalArgumentException("실행결과 이름 에러");
        }
        this.name = noBlankName;
    }

    public String getName() {
        return name;
    }
}
