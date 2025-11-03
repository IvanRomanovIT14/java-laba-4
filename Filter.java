import java.util.ArrayList;
import java.util.List;

public class Filter {
    //Фильтрует элементы списка, возвращает список с элементами удовлетворяющими условию
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        if (list == null) {
            return new ArrayList<>();
        }
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (item != null && predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
