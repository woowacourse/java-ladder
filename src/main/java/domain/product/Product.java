package domain.product;

import exception.EmptyException;
import exception.NullException;
import exception.ProductNameLengthException;

public class Product {
    private final String product;

    private static final int PRODUCT_NAME_MAX_SIZE = 5;
    private static final int PRODUCT_NAME_MIN_SIZE = 1;

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
        checkProductNameLength(product);
    }

    private void checkProductNameLength(String playerName) {
        if (playerName.length() > PRODUCT_NAME_MAX_SIZE || playerName.length() < PRODUCT_NAME_MIN_SIZE) {
            throw new ProductNameLengthException();
        }
    }

    private static void checkBlank(String player) {
        if (player.isBlank()) {
            throw new EmptyException();
        }
    }

    private static void checkNull(String player) {
        if (player == null) {
            throw new NullException();
        }
    }
}
