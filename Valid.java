public class Valid {
    public boolean isNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    //Метод для проверки целых чисел
    public boolean isValidInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        if (str.startsWith("-")) { //Разрешаем знак минуса в начале
            // Проверяем, что после минуса идут только цифры
            String withoutMinus = str.substring(1);
            if (withoutMinus.isEmpty()) return false;
            for (int i = 0; i < withoutMinus.length(); i++) {
                char c = withoutMinus.charAt(i);
                if (c < '0' || c > '9') {
                    return false;
                }
            }
            return true;
        } else { //Проверяем, что все символы - цифры
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c < '0' || c > '9') {
                    return false;
                }
            }
            return true;
        }
    }

    //Метод для проверки положительных целых чисел
    public boolean isValidPositiveInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        //Проверяем, что все символы - цифры и число положительное
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }

        //Проверяем, что число не равно 0
        return !str.equals("0");
    }
}