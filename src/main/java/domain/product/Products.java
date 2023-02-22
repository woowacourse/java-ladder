package domain.product;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private final List<Product> products;

    public Products(List<Product> products) {
        this.products = products;
    }

    public static Products generate(List<String> inputProducts) {
        List<Product> products = new ArrayList<>();
        for (String product : inputProducts) {
            products.add(new Product(product));
        }
        return new Products(products);
    }
}
