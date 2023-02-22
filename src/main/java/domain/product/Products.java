package domain.product;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private final List<Product> products;

    private static int MAX_PRODUCTS_SIZE = 5;
    private static int MIN_PRODUCTS_SIZE = 1;
    public Products(List<Product> products) {
        checkProducts(products);
        this.products = products;
    }

    public static Products generate(List<String> inputProducts) {
        List<Product> products = new ArrayList<>();
        for (String product : inputProducts) {
            products.add(new Product(product));
        }
        return new Products(products);
    }

    private void checkProducts(List<Product> products) {
        checkProductCount(products);
    }

    private void checkProductCount(List<Product> products) {
        if (products.size() > MAX_PRODUCTS_SIZE || products.size() < MIN_PRODUCTS_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
