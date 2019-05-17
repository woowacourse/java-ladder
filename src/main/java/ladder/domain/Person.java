package ladder.domain;

import java.util.List;

public class Person {
    private static final int NAME_MAX_LENGTH = 6;
    private final List<String> names;

    public Person(List<String> names) {
        this.names = names;
    }

    String getName(int index) {
        return names.get(index);
    }

    public int getCountOfPerson() {
        return names.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(makeBlank(name));
            sb.append(name);
        }
        return sb.toString();
    }

    private String makeBlank(String name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NAME_MAX_LENGTH - name.length(); i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public boolean findName(String requestedName) {
        return names.contains(requestedName);
    }
}