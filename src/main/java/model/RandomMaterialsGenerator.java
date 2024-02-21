package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMaterialsGenerator implements MaterialsGenerator {
    @Override
    public List<Boolean> pickMaterials(int count) {
        List<Boolean> materials = new ArrayList<>();
        while (materials.size() < count) {
            boolean material = false;
            if (isPossibleToMake(materials)) {
                material = new Random().nextBoolean();
            }
            materials.add(material);
        }
        return materials;
    }

    private boolean isPossibleToMake(List<Boolean> materials) {
        if (materials.isEmpty()) {
            return true;
        }
        return !materials.get(materials.size() - 1);
    }
}
