import java.util.List;

public class Reducer {
    //Объединяет все элементы списка в один результат
    public static <T> T reduce(List<T> list, Reduce<T> reducer, T start) {
        if (list == null || list.isEmpty()) {
            return start; //Возвращаем начальное значение 
        }
        T result = start;
        for (T item : list) {
            if (item != null) {
                result = reducer.reduce(result, item);
            }
        }
        return result;
    }
}
