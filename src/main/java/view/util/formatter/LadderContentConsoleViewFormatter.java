package view.util.formatter;

public class LadderContentConsoleViewFormatter {

    private static final int CONTENT_BOX_SIZE_MAX = 5;
    private static final String BLANK = " ";

    /**
     * CONTENT_BOX_SIZE_MAX 만큼의 크기를 기준으로 가운데 정렬하여 반환
     * ex) "ab" -> " ab  ", "abc" -> " abc "
     * @param content 사다리 구성요소 중 참가자 이름 혹은 결과 내용
     * @return format
     */
    public static String formatContent(String content) {
        String formatContent = content;

        int index = CONTENT_BOX_SIZE_MAX;
        while (content.length() != index) {
            formatContent = appendSpace(formatContent, index);
            index--;
        }

        return formatContent;
    }

    private static String appendSpace(String formatContent, int index) {
        if (isFirstAppendable(index)) {
            return BLANK + formatContent;
        }

        return formatContent + BLANK;
    }

    private static boolean isFirstAppendable(int index) {
        return index % 2 == 0;
    }
}
