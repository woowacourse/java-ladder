package dto;

import domain.Height;

public record HeightRequest(int height) {

    public Height toHeigth() {
        return new Height(height);
    }
}
