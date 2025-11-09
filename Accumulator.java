@FunctionalInterface
public interface Accumulator<P, T> {
    void accumulate(P collection, T value); //Метод для добавления элемента в коллекцию
}
