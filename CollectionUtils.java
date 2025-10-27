import java.util.List;

public class CollectionUtils {
    public static <T, P> P collect(List<T> list, Collector<P, T> collector, Accumulator<P, T> accumulator) {
        if (list == null) {
            return collector.createCollection();
        }

        P result = collector.createCollection();
        for (T item : list) {
            if (item != null) {
                accumulator.accumulate(result, item);
            }
        }
        return result;
    }
}