package domain.result;

import java.util.List;

public class Search {
    public static final String SEARCH_NAME_ERROR_MESSAGE = "[ERROR] 등록되지 않은 유저입니다.";
    private static final String ALL_KEYWORD = "all";

    private final String searchName;

    public Search(String searchName, List<String> userNames) {
        validateSearchName(searchName, userNames);
        this.searchName = searchName;
    }

    private void validateSearchName(String searchName, List<String> userNames) {
        if (!searchName.equals(ALL_KEYWORD) && !userNames.contains(searchName)) {
            throw new IllegalArgumentException(SEARCH_NAME_ERROR_MESSAGE);
        }
    }

    public boolean isAllKeyword() {
        return searchName.equals(ALL_KEYWORD);
    }

    public String getSearchName() {
        return searchName;
    }
}
