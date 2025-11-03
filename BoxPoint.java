import java.util.Scanner;

public class BoxPoint {
    //Метод принимает коробку и кладет в неё точку с тремя значениями
    public static void putPointInBox(Box<? super Point> box, Scanner scanner) {
        double x = Point.correctDouble(scanner, "Введите координату X: ");
        double y = Point.correctDouble(scanner, "Введите координату Y: ");
        double z = Point.correctDouble(scanner, "Введите координату Z: ");
        Points point = new Points(x, y, z);
        box.put(point);
        System.out.println("В коробку помещена точка с координатами: " + point);
    }
}
