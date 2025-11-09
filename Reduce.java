@FunctionalInterface
public interface Reduce<T> {
    T reduce(T accumulator, T current); //Метод для объединения двух значений
}
