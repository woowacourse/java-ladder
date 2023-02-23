package domain.product;

public class Product {
    private final String product;

    private static final int PLAYER_NAME_MAX_SIZE = 5;
    private static final int PLAYER_NAME_MIN_SIZE = 1;
    private static final String PLAYER_NAME_LENGTH_ERROR_MESSAGE = "[ERROR]  상품은 1~5글자만 가능합니다.";
    private static final String BLANK_MESSAGE = "[ERROR] 입력값이 비어있습니다.";
    private static final String NULL_MESSAGE = "[ERROR] 아무것도 입력하지 않았습니다.";

    public Product(String product) {
        checkProduct(product);
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

    private void checkProduct(String product) {
        checkNull(product);
        checkBlank(product);
        checkPlayerNameLength(product);
    }

    private void checkPlayerNameLength(String playerName) {
        if (playerName.length() > PLAYER_NAME_MAX_SIZE || playerName.length() < PLAYER_NAME_MIN_SIZE) {
            throw new IllegalArgumentException(PLAYER_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void checkBlank(String player) {
        if (player.isBlank()) {
            throw new IllegalArgumentException(BLANK_MESSAGE);
        }
    }

    private static void checkNull(String player) {
        if (player == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }
}
