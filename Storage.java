public class Storage<T> {
    private final T item;
    private final T alternative;

    //Конструктор создаёт хранилище с указанным объектом или альтернативным значением
    public Storage(T item, T alternative) {
        this.item = item;
        this.alternative = alternative;
    }

    //Геттер для объекта коробки, и альтернативного значения если объект = null
    public T getItem() {
        if (item != null) {
            return item;
        } else {
            return alternative;
        }
    }

    public T extract() { //Метод извлекает объект из хранилища
        T el = this.getItem();
        System.out.println("Извлеченное значение: " + el);
        return el;
    }

    @Override
    public String toString() { //Метод для строкового представления хранилища
        T currentEl = getItem();
        return "Хранилище содержит: " + currentEl;
    }

    public static Object input(String el) { //Метод преобразовывает строку в нужный тип данных
        if (el.equalsIgnoreCase("null")) {
            return null;
        }
        try {
            return Integer.parseInt(el);
        } catch (NumberFormatException e1) {
        }
        try {
            return Double.parseDouble(el);
        } catch (NumberFormatException e2) {
        }
        if (el.equalsIgnoreCase("true") || el.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(el);
        }
        return el;
    }
}