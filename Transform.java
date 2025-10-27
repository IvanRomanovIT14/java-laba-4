import java.util.ArrayList;
import java.util.List;

public class Transform {
    public static <T, R> List<R> transform(List<T> list, Function<T, R> function) {
        if (list == null) {
            return new ArrayList<>();
        }

        List<R> result = new ArrayList<>();
        for (T item : list) {
            if (item != null) {
                result.add(function.apply(item));
            }
        }
        return result;
    }
}