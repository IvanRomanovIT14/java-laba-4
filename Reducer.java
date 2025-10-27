import java.util.List;

public class Reducer {
    public static <T> T reduce(List<T> list, Reduce<T> reducer, T initialValue) {
        if (list == null || list.isEmpty()) {
            return initialValue;
        }

        T result = initialValue;
        for (T item : list) {
            if (item != null) {
                result = reducer.reduce(result, item);
            }
        }
        return result;
    }
}