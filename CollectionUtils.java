import java.util.List;

public class CollectionUtils {
    public static <T, P> P collect(List<T> list, Collector<P, T> collector, Accumulator<P, T>
            accumulator) { //Создаёт коллекцию и добавляет в неё все элементы из списка
        if (list == null) {
            return collector.createCollection(); //Возвращаем пустую коллекцию
        }
        P result = collector.createCollection();
        for (T item : list) {
            if (item != null) {
                //Добавляем элемент в коллекцию с помощью аккумулятора
                accumulator.accumulate(result, item);
            }
        }
        return result;
    }
}
