package dto;

import domain.Height;

public record HeightRequest(int height) {
    public Height toHeight() {
        return new Height(height);
    }
}
