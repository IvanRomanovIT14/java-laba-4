import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберите номер задания 1-7: ");
        Valid valid = new Valid();
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Box<Integer> integerBox = new Box<>();
                    integerBox.put(3);
                    Integer something = integerBox.extract();
                    System.out.println("Достали: " + something);
                    System.out.println("Коробка после доставания: " + integerBox);
                    System.out.println("Введите число для хранения в коробке: ");
                    Box<Integer> integerBox1 = new Box<>();
                    String Box1 = scanner.nextLine();
                    if (valid.isNumber(Box1)) {
                        int n1 = Integer.parseInt(Box1);
                        integerBox1.put(n1);
                        System.out.println("Коробка пуста: " + integerBox1.full());
                        int a = integerBox1.extract();
                        System.out.println("Достали: " + a);
                    } else {
                        System.out.println("Вводить можно только число!");
                    }
                    break;
                case 2:
                    Storage<Integer> storage1 = new Storage<>(null, 0);
                    System.out.println(storage1);
                    storage1.extract();
                    Storage<Integer> storage2 = new Storage<>(99, -1);
                    System.out.println(storage2);
                    storage2.extract();
                    Storage<String> storage3 = new Storage<>(null, "default");
                    System.out.println(storage3);
                    storage3.extract();
                    Storage<String> storage4 = new Storage<>("hello", "hello world");
                    System.out.println(storage4);
                    storage4.extract();
                    System.out.println("Введите объект (или 'null' для null): ");
                    String el21 = scanner.nextLine();
                    Object input1 = Storage.input(el21);
                    System.out.println("Введите альтернативный объект: ");
                    String el22 = scanner.nextLine();
                    Object input2 = Storage.input(el22);
                    Storage<Object> storage5 = new Storage<>(input1, input2);
                    System.out.println(storage5);
                    storage5.extract();
                    break;
                case 3:
                    Box<Object> box = new Box<>();
                    BoxPoint.putPointInBox(box, scanner);
                    break;
                case 4:
                    System.out.println("1. Строки - длины строк:");
                    List<String> strings1 = List.of("qwerty", "asdfg", "zx");
                    List<Integer> lengths = Transform.transform(strings1, value -> value.length());
                    System.out.println("   Исходные: " + strings1);
                    System.out.println("   Результат: " + lengths);
                    System.out.println("2. Числа - абсолютные значения:");
                    List<Integer> numbers1 = List.of(1, -3, 7);
                    List<Integer> absolutes = Transform.transform(numbers1, value ->
                            Math.abs(value));
                    System.out.println("   Исходные: " + numbers1);
                    System.out.println("   Результат: " + absolutes);
                    System.out.println("3. Массивы - максимальные значения:");
                    List<int[]> arrays1 = List.of(new int[]{1, 2, 3}, new int[]{-1, -5, 0},
                            new int[]{10, 20, 5});
                    List<Integer> maxValues = Transform.transform(arrays1, array -> {
                        if (array.length == 0) {
                            return null;
                        }
                        int max = array[0];
                        for (int num : array) {
                            if (num > max) {
                                max = num;
                            }
                        }
                        return max;
                    });
                    System.out.println("   Исходные массивы: " + Arrays.deepToString(arrays1.
                            toArray()));
                    System.out.println("   Максимальные значения: " + maxValues);
                    System.out.println("Выберите тип преобразования:");
                    System.out.println("1 - Строки в их длины");
                    System.out.println("2 - Числа в абсолютные значения");
                    System.out.println("3 - Массивы в максимальные значения");
                    System.out.print("Ваш выбор: ");
                    String transformChoice = scanner.nextLine();
                    switch (transformChoice) {
                        case "1":
                            System.out.print("Сколько строк вы хотите ввести? ");
                            String countStr = scanner.nextLine();
                            while (!valid.isValidPositiveInteger(countStr)) {
                                System.out.println("Ошибка: введите положительное целое число!");
                                System.out.print("Сколько строк вы хотите ввести? ");
                                countStr = scanner.nextLine();
                            }
                            int count = Integer.parseInt(countStr);
                            List<String> inputStrings = new ArrayList<>();
                            for (int i = 0; i < count; i++) {
                                System.out.print("Введите строку " + (i + 1) + ": ");
                                inputStrings.add(scanner.nextLine());
                            }
                            List<Integer> resultLengths = Transform.transform(inputStrings,
                                    value -> value.length());
                            System.out.println("Исходные строки: " + inputStrings);
                            System.out.println("Длины строк: " + resultLengths);
                            break;
                        case "2":
                            System.out.print("Сколько чисел вы хотите ввести? ");
                            String countStr2 = scanner.nextLine();
                            while (!valid.isValidPositiveInteger(countStr2)) {
                                System.out.println("Ошибка: введите положительное целое число!");
                                System.out.print("Сколько чисел вы хотите ввести? ");
                                countStr2 = scanner.nextLine();
                            }
                            int count1 = Integer.parseInt(countStr2);
                            List<Integer> inputNumbers = new ArrayList<>();
                            for (int i = 0; i < count1; i++) {
                                System.out.print("Введите число " + (i + 1) + ": ");
                                String numStr = scanner.nextLine();
                                while (!valid.isValidInteger(numStr)) {
                                    System.out.println("Ошибка: введите целое число!");
                                    System.out.print("Введите число " + (i + 1) + ": ");
                                    numStr = scanner.nextLine();
                                }
                                inputNumbers.add(Integer.parseInt(numStr));
                            }
                            List<Integer> resultAbsolutes = Transform.transform(inputNumbers,
                                    value -> Math.abs(value));
                            System.out.println("Исходные числа: " + inputNumbers);
                            System.out.println("Абсолютные значения: " + resultAbsolutes);
                            break;
                        case "3":
                            System.out.print("Сколько массивов вы хотите ввести? ");
                            String countStr3 = scanner.nextLine();
                            while (!valid.isValidPositiveInteger(countStr3)) {
                                System.out.println("Ошибка: введите положительное целое число!");
                                System.out.print("Сколько массивов вы хотите ввести? ");
                                countStr3 = scanner.nextLine();
                            }
                            int count2 = Integer.parseInt(countStr3);
                            List<int[]> inputArrays = new ArrayList<>();
                            for (int i = 0; i < count2; i++) {
                                System.out.print("Сколько чисел в массиве " + (i + 1) + "? ");
                                String sizeStr = scanner.nextLine();
                                while (!valid.isValidPositiveInteger(sizeStr)) {
                                    System.out.println("Ошибка: введите положительное" +
                                            " целое число!");
                                    System.out.print("Сколько чисел в массиве " + (i + 1) + "? ");
                                    sizeStr = scanner.nextLine();
                                }
                                int size = Integer.parseInt(sizeStr);
                                int[] array = new int[size];
                                for (int j = 0; j < size; j++) {
                                    System.out.print("Введите число " + (j + 1) + " массива "
                                            + (i + 1) + ": ");
                                    String numStr = scanner.nextLine();
                                    while (!valid.isValidInteger(numStr)) {
                                        System.out.println("Ошибка: введите целое число!");
                                        System.out.print("Введите число " + (j + 1) + " массива "
                                                + (i + 1) + ": ");
                                        numStr = scanner.nextLine();
                                    }
                                    array[j] = Integer.parseInt(numStr);
                                }
                                inputArrays.add(array);
                            }
                            List<Integer> resultMax = Transform.transform(inputArrays, array -> {
                                if (array.length == 0) {
                                    return null;
                                }
                                int max = array[0];
                                for (int num : array) {
                                    if (num > max) {
                                        max = num;
                                    }
                                }
                                return max;
                            });
                            System.out.println("Исходные массивы: " +
                                    Arrays.deepToString(inputArrays.toArray()));
                            System.out.println("Максимальные значения: " + resultMax);
                            break;
                        default:
                            System.out.println("Неверный выбор!");
                    }
                    break;
                case 5:
                    System.out.println("1. Фильтрация строк (длина >= 3):");
                    List<String> strings2 = List.of("qwerty", "asdfg", "zx");
                    List<String> filteredStrings = Filter.filter(strings2,
                            value -> value.length() >= 3);
                    System.out.println("   Исходные: " + strings2);
                    System.out.println("   Результат: " + filteredStrings);
                    System.out.println("2. Фильтрация положительных чисел:");
                    List<Integer> numbers2 = List.of(1, -3, 7);
                    List<Integer> positiveNumbers = Filter.filter(numbers2, value -> value > 0);
                    System.out.println("   Исходные: " + numbers2);
                    System.out.println("   Результат: " + positiveNumbers);
                    System.out.println("3. Фильтрация массивов без положительных элементов:");
                    List<int[]> arrays2 = List.of(new int[]{1, 2, 3}, new int[]{-1, -5, 0},
                            new int[]{-10, -20, -5});
                    List<int[]> arraysWithoutPositives = Filter.filter(arrays2, array -> {
                        for (int num : array) {
                            if (num > 0) {
                                return false;
                            }
                        }
                        return true;
                    });
                    System.out.println("   Исходные массивы: " + Arrays.deepToString(arrays2.
                            toArray()));
                    System.out.println("   Массивы без положительных элементов: " + Arrays.
                            deepToString(arraysWithoutPositives.toArray()));
                    System.out.println("Выберите тип фильтрации:");
                    System.out.println("1 - Фильтрация строк по длине");
                    System.out.println("2 - Фильтрация положительных чисел");
                    System.out.println("3 - Фильтрация массивов без положительных элементов");
                    System.out.print("Ваш выбор: ");
                    String filterChoice = scanner.nextLine();
                    switch (filterChoice) {
                        case "1":
                            System.out.print("Сколько строк вы хотите ввести? ");
                            String countStr = scanner.nextLine();
                            while (!valid.isValidPositiveInteger(countStr)) {
                                System.out.println("Ошибка: введите положительное целое число!");
                                System.out.print("Сколько строк вы хотите ввести? ");
                                countStr = scanner.nextLine();
                            }
                            int count = Integer.parseInt(countStr);
                            List<String> inputStrings = new ArrayList<>();
                            for (int i = 0; i < count; i++) {
                                System.out.print("Введите строку " + (i + 1) + ": ");
                                inputStrings.add(scanner.nextLine());
                            }
                            System.out.print("Введите минимальную длину для фильтрации: ");
                            String minLengthStr = scanner.nextLine();
                            while (!valid.isValidPositiveInteger(minLengthStr)) {
                                System.out.println("Ошибка: введите положительное целое число!");
                                System.out.print("Введите минимальную длину для фильтрации: ");
                                minLengthStr = scanner.nextLine();
                            }
                            int minLength = Integer.parseInt(minLengthStr);
                            List<String> filtered = Filter.filter(inputStrings,
                                    value -> value.length() >= minLength);
                            System.out.println("Исходные строки: " + inputStrings);
                            System.out.println("Отфильтрованные строки: " + filtered);
                            break;
                        case "2":
                            System.out.print("Сколько чисел вы хотите ввести? ");
                            String countStr2 = scanner.nextLine();
                            while (!valid.isValidPositiveInteger(countStr2)) {
                                System.out.println("Ошибка: введите положительное целое число!");
                                System.out.print("Сколько чисел вы хотите ввести? ");
                                countStr2 = scanner.nextLine();
                            }
                            int count1 = Integer.parseInt(countStr2);
                            List<Integer> inputNumbers = new ArrayList<>();
                            for (int i = 0; i < count1; i++) {
                                System.out.print("Введите число " + (i + 1) + ": ");
                                String numStr = scanner.nextLine();
                                while (!valid.isValidInteger(numStr)) {
                                    System.out.println("Ошибка: введите целое число!");
                                    System.out.print("Введите число " + (i + 1) + ": ");
                                    numStr = scanner.nextLine();
                                }
                                inputNumbers.add(Integer.parseInt(numStr));
                            }
                            List<Integer> positives = Filter.filter(inputNumbers,
                                    value -> value > 0);
                            System.out.println("Исходные числа: " + inputNumbers);
                            System.out.println("Положительные числа: " + positives);
                            break;
                        case "3":
                            System.out.print("Сколько массивов вы хотите ввести? ");
                            String countStr3 = scanner.nextLine();
                            while (!valid.isValidPositiveInteger(countStr3)) {
                                System.out.println("Ошибка: введите положительное целое число!");
                                System.out.print("Сколько массивов вы хотите ввести? ");
                                countStr3 = scanner.nextLine();
                            }
                            int count2 = Integer.parseInt(countStr3);
                            List<int[]> inputArrays = new ArrayList<>();
                            for (int i = 0; i < count2; i++) {
                                System.out.print("Сколько чисел в массиве " + (i + 1) + "? ");
                                String sizeStr = scanner.nextLine();
                                while (!valid.isValidPositiveInteger(sizeStr)) {
                                    System.out.println("Ошибка: введите положительное целое " +
                                            "число!");
                                    System.out.print("Сколько чисел в массиве " + (i + 1) + "? ");
                                    sizeStr = scanner.nextLine();
                                }
                                int size = Integer.parseInt(sizeStr);
                                int[] array = new int[size];
                                for (int j = 0; j < size; j++) {
                                    System.out.print("Введите число " + (j + 1) + " массива "
                                            + (i + 1) + ": ");
                                    String numStr = scanner.nextLine();
                                    while (!valid.isValidInteger(numStr)) {
                                        System.out.println("Ошибка: введите целое число!");
                                        System.out.print("Введите число " + (j + 1) + " массива " +
                                                "" + (i + 1) + ": ");
                                        numStr = scanner.nextLine();
                                    }
                                    array[j] = Integer.parseInt(numStr);
                                }
                                inputArrays.add(array);
                            }
                            List<int[]> filteredArrays = Filter.filter(inputArrays, array -> {
                                for (int num : array) {
                                    if (num > 0) {
                                        return false;
                                    }
                                }
                                return true;
                            });
                            System.out.println("Исходные массивы: " + Arrays.deepToString
                                    (inputArrays.toArray()));
                            System.out.println("Массивы без положительных элементов: " +
                                    Arrays.deepToString(filteredArrays.toArray()));
                            break;
                        default:
                            System.out.println("Неверный выбор!");
                    }
                    break;
                case 6:
                    System.out.println("1. Объединение строк:");
                    List<String> strings3 = List.of("qwerty", "asdfg", "zx");
                    String concatenated = Reducer.reduce(strings3, (acc, cur) -> acc + cur, "");
                    System.out.println("   Исходные: " + strings3);
                    System.out.println("   Результат: " + concatenated);
                    System.out.println("2. Сумма чисел:");
                    List<Integer> numbers3 = List.of(1, -3, 7);
                    Integer sum = Reducer.reduce(numbers3, (acc, cur) -> acc + cur, 0);
                    System.out.println("   Исходные: " + numbers3);
                    System.out.println("   Результат: " + sum);
                    System.out.println("3. Общее количество элементов во всех списках:");
                    List<List<Integer>> listOfLists = List.of(
                            List.of(1, 2, 3),
                            List.of(4, 5),
                            List.of(6, 7, 8, 9)
                    );
                    List<Integer> sizes = Transform.transform(listOfLists, list -> {
                        int count = 0;
                        for (Integer item : list) {
                            count++;
                        }
                        return count;
                    });
                    Integer totalElements = Reducer.reduce(sizes, (acc, cur) -> acc + cur, 0);
                    System.out.println("   Исходные списки: " + listOfLists);
                    System.out.println("   Общее количество элементов: " + totalElements);
                    System.out.println("4. Тест с пустым списком:");
                    List<String> emptyList = List.of();
                    String emptyResult = Reducer.reduce(emptyList, (acc, cur) -> acc + cur,
                            ":)");
                    System.out.println("   Пустой список: " + emptyList);
                    System.out.println("   Результат: " + emptyResult);
                    System.out.println("Выберите операцию:");
                    System.out.println("1 - Конкатенация строк");
                    System.out.println("2 - Сумма чисел");
                    System.out.println("3 - Общее количество элементов в списках");
                    System.out.print("Ваш выбор: ");
                    String reduceChoice = scanner.nextLine();
                    switch (reduceChoice) {
                        case "1":
                            System.out.print("Сколько строк вы хотите ввести? ");
                            String countStr = scanner.nextLine();
                            while (!valid.isValidPositiveInteger(countStr)) {
                                System.out.println("Ошибка: введите положительное целое число!");
                                System.out.print("Сколько строк вы хотите ввести? ");
                                countStr = scanner.nextLine();
                            }
                            int count = Integer.parseInt(countStr);
                            List<String> inputStrings = new ArrayList<>();
                            for (int i = 0; i < count; i++) {
                                System.out.print("Введите строку " + (i + 1) + ": ");
                                inputStrings.add(scanner.nextLine());
                            }
                            String result = Reducer.reduce(inputStrings, (acc, cur)
                                    -> acc + cur, "");
                            System.out.println("Исходные строки: " + inputStrings);
                            System.out.println("Результат конкатенации: " + result);
                            break;
                        case "2":
                            System.out.print("Сколько чисел вы хотите ввести? ");
                            String countStr2 = scanner.nextLine();
                            while (!valid.isValidPositiveInteger(countStr2)) {
                                System.out.println("Ошибка: введите положительное целое число!");
                                System.out.print("Сколько чисел вы хотите ввести? ");
                                countStr2 = scanner.nextLine();
                            }
                            int count1 = Integer.parseInt(countStr2);
                            List<Integer> inputNumbers = new ArrayList<>();
                            for (int i = 0; i < count1; i++) {
                                System.out.print("Введите число " + (i + 1) + ": ");
                                String numStr = scanner.nextLine();
                                while (!valid.isValidInteger(numStr)) {
                                    System.out.println("Ошибка: введите целое число!");
                                    System.out.print("Введите число " + (i + 1) + ": ");
                                    numStr = scanner.nextLine();
                                }
                                inputNumbers.add(Integer.parseInt(numStr));
                            }
                            Integer resultSum = Reducer.reduce(inputNumbers, (acc, cur)
                                    -> acc + cur, 0);
                            System.out.println("Исходные числа: " + inputNumbers);
                            System.out.println("Сумма чисел: " + resultSum);
                            break;
                        case "3":
                            System.out.print("Сколько списков вы хотите ввести? ");
                            String countStr3 = scanner.nextLine();
                            while (!valid.isValidPositiveInteger(countStr3)) {
                                System.out.println("Ошибка: введите положительное целое число!");
                                System.out.print("Сколько списков вы хотите ввести? ");
                                countStr3 = scanner.nextLine();
                            }
                            int count2 = Integer.parseInt(countStr3);
                            List<List<Integer>> inputLists = new ArrayList<>();
                            for (int i = 0; i < count2; i++) {
                                System.out.print("Сколько чисел в списке " + (i + 1) + "? ");
                                String sizeStr = scanner.nextLine();
                                while (!valid.isValidPositiveInteger(sizeStr)) {
                                    System.out.println("Ошибка: введите положительное целое" +
                                            " число!");
                                    System.out.print("Сколько чисел в списке " + (i + 1) + "? ");
                                    sizeStr = scanner.nextLine();
                                }
                                int size = Integer.parseInt(sizeStr);
                                List<Integer> list = new ArrayList<>();
                                for (int j = 0; j < size; j++) {
                                    System.out.print("Введите число " + (j + 1) + " списка " +
                                            (i + 1) + ": ");
                                    String numStr = scanner.nextLine();
                                    while (!valid.isValidInteger(numStr)) {
                                        System.out.println("Ошибка: введите целое число!");
                                        System.out.print("Введите число " + (j + 1) + " списка " +
                                                (i + 1) + ": ");
                                        numStr = scanner.nextLine();
                                    }
                                    list.add(Integer.parseInt(numStr));
                                }
                                inputLists.add(list);
                            }
                            List<Integer> inputSizes = Transform.transform(inputLists, list -> {
                                int countElements = 0;
                                for (Integer item : list) {
                                    countElements++;
                                }
                                return countElements;
                            });
                            Integer total = Reducer.reduce(inputSizes, (acc, cur) -> acc + cur, 0);
                            System.out.println("Исходные списки: " + inputLists);
                            System.out.println("Общее количество элементов: " + total);
                            break;
                        default:
                            System.out.println("Неверный выбор!");
                    }
                    break;
                case 7:
                    System.out.println("1. Разбиение чисел на положительные и отрицательные:");
                    List<Integer> numbers4 = List.of(1, -3, 7, -2, 0, 5);
                    Collector<List<List<Integer>>, Integer> numberCollector = () -> {
                        List<List<Integer>> res = new ArrayList<>();
                        res.add(new ArrayList<>());
                        res.add(new ArrayList<>());
                        res.add(new ArrayList<>());
                        return res;
                    };
                    Accumulator<List<List<Integer>>, Integer> numberAccumulator = (lists, value)
                            -> {
                        if (value > 0) {
                            lists.get(0).add(value);
                        } else if (value < 0) {
                            lists.get(1).add(value);
                        } else {
                            lists.get(2).add(value);
                        }
                    };
                    List<List<Integer>> numberGroups = CollectionUtils.collect(numbers4,
                            numberCollector, numberAccumulator);
                    System.out.println("   Исходные числа: " + numbers4);
                    System.out.println("   Положительные: " + numberGroups.get(0));
                    System.out.println("   Отрицательные: " + numberGroups.get(1));
                    System.out.println("   Нули: " + numberGroups.get(2));
                    System.out.println("2. Группировка строк по длине:");
                    List<String> strings4 = List.of("qwerty", "asdfg", "zx", "qw");
                    Collector<List<List<String>>, String> lengthCollector = () -> {
                        List<Integer> uniqueLengths = new ArrayList<>();
                        for (String str : strings4) {
                            int len = str.length();
                            if (!uniqueLengths.contains(len)) {
                                uniqueLengths.add(len);
                            }
                        }
                        Collections.sort(uniqueLengths);
                        List<List<String>> res = new ArrayList<>();
                        for (int i = 0; i < uniqueLengths.size(); i++) {
                            res.add(new ArrayList<>());
                        }
                        return res;
                    };
                    Accumulator<List<List<String>>, String> lengthAccumulator = (lists,
                                                                                 value) -> {
                        int len = value.length();
                        int idx = -1;
                        for (int i = 0; i < lists.size(); i++) {
                            if (!lists.get(i).isEmpty() && lists.get(i).get(0).length() == len) {
                                idx = i;
                                break;
                            }
                        }
                        if (idx == -1) {
                            for (int i = 0; i < lists.size(); i++) {
                                if (lists.get(i).isEmpty()) {
                                    lists.get(i).add(value);
                                    break;
                                }
                            }
                        } else {
                            lists.get(idx).add(value);
                        }
                    };
                    List<List<String>> lengthGroups = CollectionUtils.collect(strings4,
                            lengthCollector, lengthAccumulator);
                    System.out.println("   Исходные строки: " + strings4);
                    System.out.println("   Группировка по длине:");
                    for (int i = 0; i < lengthGroups.size(); i++) {
                        if (!lengthGroups.get(i).isEmpty()) {
                            int length = lengthGroups.get(i).get(0).length();
                            System.out.println("     Длина " + length + ": " + lengthGroups.
                                    get(i));
                        }
                    }
                    System.out.println("3. Уникальные строки:");
                    List<String> strings5 = List.of("qwerty", "asdfg", "qwerty", "qw");
                    Collector<List<String>, String> uniqueCollector = ArrayList::new;
                    Accumulator<List<String>, String> uniqueAccumulator = (list, value) -> {
                        if (!list.contains(value)) {
                            list.add(value);
                        }
                    };
                    List<String> uniqueStrings = CollectionUtils.collect(strings5,
                            uniqueCollector, uniqueAccumulator);
                    System.out.println("   Исходные строки: " + strings5);
                    System.out.println("   Уникальные строки: " + uniqueStrings);
                    System.out.println("Выберите тип группировки:");
                    System.out.println("1 - Разбиение чисел на положительные/отрицательные/нули");
                    System.out.println("2 - Группировка строк по длине");
                    System.out.println("3 - Получение уникальных строк");
                    System.out.print("Ваш выбор: ");
                    String collectChoice = scanner.nextLine();
                    switch (collectChoice) {
                        case "1":
                            System.out.print("Сколько чисел вы хотите ввести? ");
                            String countStr = scanner.nextLine();
                            while (!valid.isValidPositiveInteger(countStr)) {
                                System.out.println("Ошибка: введите положительное целое число!");
                                System.out.print("Сколько чисел вы хотите ввести? ");
                                countStr = scanner.nextLine();
                            }
                            int cnt = Integer.parseInt(countStr);
                            List<Integer> inputNumbers = new ArrayList<>();
                            for (int i = 0; i < cnt; i++) {
                                System.out.print("Введите число " + (i + 1) + ": ");
                                String numStr = scanner.nextLine();
                                while (!valid.isValidInteger(numStr)) {
                                    System.out.println("Ошибка: введите целое число!");
                                    System.out.print("Введите число " + (i + 1) + ": ");
                                    numStr = scanner.nextLine();
                                }
                                inputNumbers.add(Integer.parseInt(numStr));
                            }
                            Collector<List<List<Integer>>, Integer> col1 = () -> {
                                List<List<Integer>> res = new ArrayList<>();
                                res.add(new ArrayList<>());
                                res.add(new ArrayList<>());
                                res.add(new ArrayList<>());
                                return res;
                            };
                            Accumulator<List<List<Integer>>, Integer> acc1 = (lists, value) -> {
                                if (value > 0) {
                                    lists.get(0).add(value);
                                } else if (value < 0) {
                                    lists.get(1).add(value);
                                } else {
                                    lists.get(2).add(value);
                                }
                            };
                            List<List<Integer>> res1 = CollectionUtils.collect(inputNumbers, col1,
                                    acc1);
                            System.out.println("Исходные числа: " + inputNumbers);
                            System.out.println("Положительные числа: " + res1.get(0));
                            System.out.println("Отрицательные числа: " + res1.get(1));
                            System.out.println("Нули: " + res1.get(2));
                            break;
                        case "2":
                            System.out.print("Сколько строк вы хотите ввести? ");
                            String countStr2 = scanner.nextLine();
                            while (!valid.isValidPositiveInteger(countStr2)) {
                                System.out.println("Ошибка: введите положительное целое число!");
                                System.out.print("Сколько строк вы хотите ввести? ");
                                countStr2 = scanner.nextLine();
                            }
                            int cnt2 = Integer.parseInt(countStr2);
                            List<String> inputStrings = new ArrayList<>();
                            for (int i = 0; i < cnt2; i++) {
                                System.out.print("Введите строку " + (i + 1) + ": ");
                                inputStrings.add(scanner.nextLine());
                            }
                            List<Integer> length = new ArrayList<>();
                            for (String str : inputStrings) {
                                int len = str.length();
                                if (!length.contains(len)) {
                                    length.add(len);
                                }
                            }
                            Collections.sort(length);
                            final List<Integer> lenList = length;
                            Collector<List<List<String>>, String> col2 = () -> {
                                List<List<String>> res = new ArrayList<>();
                                for (int i = 0; i < lenList.size(); i++) {
                                    res.add(new ArrayList<>());
                                }
                                return res;
                            };
                            Accumulator<List<List<String>>, String> acc2 = (lists, value) -> {
                                int l = value.length();
                                int idx = lenList.indexOf(l);
                                if (idx != -1) {
                                    lists.get(idx).add(value);
                                }
                            };
                            List<List<String>> res2 = CollectionUtils.collect(inputStrings, col2,
                                    acc2);
                            System.out.println("Исходные строки: " + inputStrings);
                            System.out.println("Группировка по длине:");
                            for (int i = 0; i < res2.size(); i++) {
                                System.out.println("  Длина " + lenList.get(i) + ": " +
                                        res2.get(i));
                            }
                            break;
                        case "3":
                            System.out.print("Сколько строк вы хотите ввести? ");
                            String countStr3 = scanner.nextLine();
                            while (!valid.isValidPositiveInteger(countStr3)) {
                                System.out.println("Ошибка: введите положительное целое число!");
                                System.out.print("Сколько строк вы хотите ввести? ");
                                countStr3 = scanner.nextLine();
                            }
                            int cnt3 = Integer.parseInt(countStr3);
                            List<String> strList = new ArrayList<>();
                            for (int i = 0; i < cnt3; i++) {
                                System.out.print("Введите строку " + (i + 1) + ": ");
                                strList.add(scanner.nextLine());
                            }
                            Collector<List<String>, String> col3 = ArrayList::new;
                            Accumulator<List<String>, String> acc3 = (list, value) -> {
                                if (!list.contains(value)) {
                                    list.add(value);
                                }
                            };
                            List<String> uniqueRes = CollectionUtils.collect(strList, col3, acc3);
                            System.out.println("Исходные строки: " + strList);
                            System.out.println("Уникальные строки: " + uniqueRes);
                            break;
                        default:
                            System.out.println("Неверный выбор!");
                    }
                    break;
                default:
                    System.out.println("Вводить можно только число 1-7!");
            }
        } else {
            System.out.println("Вводить можно только число 1-7!");
        }
    }
}
