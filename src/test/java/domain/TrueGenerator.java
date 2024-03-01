package domain;

class TrueGenerator implements RandomGenerator {
    @Override
    public boolean next() {
        return true;
    }
}
