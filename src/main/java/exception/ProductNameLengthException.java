package exception;

public class ProductNameLengthException extends IllegalArgumentException {
    private static final String PRODUCT_LENGTH_ERROR_MESSAGE = "[ERROR]  상품은 1~5글자만 가능합니다.";

    public ProductNameLengthException() {
        super(PRODUCT_LENGTH_ERROR_MESSAGE);
    }
}
