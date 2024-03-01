package util;

import java.util.function.Supplier;

class RetryHelper {

    private final int maxRetryCount;
    private int retryCount = -1;

    public RetryHelper(int maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
    }

    public <E> E retry(Supplier<E> supplier) {
        E result = null;
        while (result == null && retryCount < maxRetryCount) {
            result = useSupplier(supplier);
        }
        return result;
    }

    private <E> E useSupplier(Supplier<E> supplier) {
        retryCount++;
        try {
            return supplier.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
