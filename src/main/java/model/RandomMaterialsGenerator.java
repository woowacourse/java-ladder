package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMaterialsGenerator implements MaterialsGenerator {
    @Override
    public List<Boolean> pickMaterials(int count) {
        List<Boolean> materials = new ArrayList<>();
        while (materials.size() < count) {
            materials.add(generateMaterial(materials));
        }
        return materials;
    }

    private boolean generateMaterial(List<Boolean> materials) {
        if (isPossibleToMake(materials)) {
            return new Random().nextBoolean();
        }
        return false;
    }

    private boolean isPossibleToMake(List<Boolean> materials) {
        if (materials.isEmpty()) {
            return true;
        }
        return !materials.get(materials.size() - 1);
    }
}
