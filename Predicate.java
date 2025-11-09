@FunctionalInterface
public interface Predicate<T> {
    boolean test(T value); // Возвращает true если элемент удовлетворяет условию, false - если нет
}
