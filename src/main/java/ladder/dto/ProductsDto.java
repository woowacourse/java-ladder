package ladder.dto;

import java.util.List;
import ladder.domain.product.Products;

public record ProductsDto(List<String> names) {

    public static ProductsDto from(Products products) {
        return new ProductsDto(products.getNames());
    }
}
