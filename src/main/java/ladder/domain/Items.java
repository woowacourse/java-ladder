package ladder.domain;

import java.util.List;

public class Items {
    private static final int MIN_NAME_LENGTH = 1;

    private List<String> items;

    public Items(List<String> items, int numberOfPeople) {
        checkItems(items, numberOfPeople);

        this.items = items;
    }

    private static void checkItems(List<String> items, int numberOfPeople) {
        checkBlank(items);
        checkNumberOfItems(items, numberOfPeople);

        for (String item : items) {
            checkItemLength(item);
        }
    }

    private static void checkBlank(List<String> input) {
        if (input.size() < 1) {
            System.err.println("빈칸이 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void checkNumberOfItems(List<String> items, int numberOfPeople) {
        if (items.size() != numberOfPeople) {
            System.err.println("아이템의 수가 사람의 수와 같지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void checkItemLength(String item) {
        if (item.trim().length() < MIN_NAME_LENGTH) {
            System.err.println("빈 아이템이 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    String getItemName(int index) {
        return items.get(index);
    }

    public List<String> getItems() {
        return items;
    }
}
