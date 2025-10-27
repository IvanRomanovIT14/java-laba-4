public class Box<T> {
    private T item;

    public Box() {
        this.item = null;
    }

    public void put(T item) { //Метод помещает объект в коробку
        if (this.item != null) {
            throw new IllegalStateException("Коробка не пустая!");
        }
        this.item = item;
    }

    public T extract() {
        T el = this.item;
        this.item = null;
        return el;
    }

    public boolean full() {
        return this.item == null;
    }

    @Override
    public String toString() { //Метод для строкового представления коробки
        if (item != null) {
            return "В коробке лежит: " + item;
        } else {
            return "Коробка пустая!";
        }
    }
}
