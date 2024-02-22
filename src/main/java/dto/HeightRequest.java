package dto;

import domain.Height;

public class HeightRequest {
    private final int height;

    public HeightRequest(int height) {
        this.height = height;
    }

    public Height toHeight() {
        return new Height(height);
    }
}
