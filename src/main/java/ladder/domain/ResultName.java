//package ladder.domain;
//
//public class ResultName {
//    private static final String NAME_CONTAIN_SPACE_ERROR = "공백 포함 오류";
//    private static final String NAME_LENGTH_ERROR = "길이 5 초과 오류";
//    private static final String EMPTY_NAME_ERROR = "공백 입력 불가 오류";
//    private static final String WHITE_SPACE = " ";
//    private static final int NAME_UPPER_BOUND = 5;
//    private static final int NAME_LOWER_BOUND = 0;
//
//    private String name;
//
//    public ResultName(String name) {
//        checkEmptyName(name);
//        checkNameLength(name);
//        checkNameContainSpace(name);
//        this.name = name;
//    }
//
//    private void checkEmptyName(String name) {
//        if (name.length() == NAME_LOWER_BOUND) {
//            throw new IllegalArgumentException(EMPTY_NAME_ERROR);
//        }
//    }
//
//    private void checkNameLength(String name) {
//        if (name.length() > NAME_UPPER_BOUND) {
//            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
//        }
//    }
//
//    private void checkNameContainSpace(String name) {
//        if(name.contains(WHITE_SPACE)){
//            throw new IllegalArgumentException(NAME_CONTAIN_SPACE_ERROR);
//        }
//    }
//
//    @Override
//    public String toString() {
//        return this.name;
//    }
//}
