package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Products {

    private final List<Product> products;

    public Products(final List<Product> products) {
        this.products = products;
    }

    public int size() {
        return products.size();
    }

    public Product get(int position) {
        return products.get(position);
    }

    public List<Product> toUnmodifiableProducts() {
        return Collections.unmodifiableList(products);
    }
}
