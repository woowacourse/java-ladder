package model;

import java.util.List;

@FunctionalInterface
public interface MaterialsGenerator {
    List<Boolean> pickMaterials(int count);
}
