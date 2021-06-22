import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FPUtils {
    public static <T,R>Function<T,R> S2F(Supplier<R> supplier){
        return a-> supplier.get();
    }

    public static <T,R>Consumer<T> C2F(Function<T,R> function){
        return a->function.apply(a);
    }
    public static <R> Runnable S2R(Supplier<R> supplier){
        return ()->supplier.get();
    }

}
