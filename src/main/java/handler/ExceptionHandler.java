package handler;

import java.util.function.Supplier;

public class ExceptionHandler {

    public <T> T handle(Supplier<T> callback){
        try{
            return callback.get();
        }catch (Exception e){
            System.out.printf("%n[ERROR] %s%n", e.getMessage());
            return handle(callback);
        }
    }
}
