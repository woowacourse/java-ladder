package domain;

class FalseGenerator implements RandomGenerator {
    @Override
    public boolean next() {
        return false;
    }
}
