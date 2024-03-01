package util;

import java.util.function.Supplier;

public class RetryHelper {

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
        retryCount = -1;
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
