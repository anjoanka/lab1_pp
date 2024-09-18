import java.util.Scanner;

/**
 * Клас для числа Люка і перевірки, чи можна записати його як w^2 - 1.
 */
class LucasNumber {
    private int index;
    private int value;

    /**
     * Конструктор для створення числа Люка.
     * @param index номер числа
     * @param value значення числа
     */
    public LucasNumber(int index, int value){
        this.index = index;
        this.value = value;
    }

    /**
     * Повертає номер числа Люка.
     * @return номер числа
     */

    public int getIndex(){
        return index;
    }

    /**
     * Повертає значення числа Люка.
     * @return значення числа
     */
    public int getValue(){
        return value;
    }

    /**
     * Метод перевірки, чи можна представити число як w^2 - 1.
     * @return true, якщо число можна записати як w^2 - 1, false в іншому випадку
     */
    public boolean checkFormula(){
        int w = (int) Math.sqrt(value + 1);
        return w * w - 1 == value;
    }

}

/**
 * Головний клас для запуску програми.
 */
public class Main {

    /**
     * Метод для введення кількості чисел через командний рядок або з клавіатури.
     *
     * @param args аргументи командного рядка
     * @return кількість чисел N
     */
    public static int getInput(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість чисел Люка (N): ");
        int N = scanner.nextInt();
        scanner.close();
        return N;
    }
    /**
     * Метод для генерації перших N чисел Люка.
     * @param N кількість чисел Люка
     * @return масив об'єктів класу LucasNumber
     */
    public static LucasNumber[] generateLucasNumbers(int N) {
        LucasNumber[] lucasNumbers = new LucasNumber[N];
        int prev = 2;
        int curr = 1;

        lucasNumbers[0] = new LucasNumber(0, prev);
        lucasNumbers[1] = new LucasNumber(1, curr);

        for (int i = 2; i < N; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
            lucasNumbers[i] = new LucasNumber(i, curr);
        }

        return lucasNumbers;
    }

    /**
     * Метод для перевірки, чи можна записати числа як w^2 - 1 і вивести результат.
     * @param lucasNumbers масив об'єктів класу LucasNumber
     */

    public static void checkAndPrintResults(LucasNumber[] lucasNumbers){
        System.out.println("Числа Люка та перевірка на вигляд w^2 - 1:");
        for (LucasNumber lucas : lucasNumbers) {
            System.out.println("LucasNumber " + lucas.getIndex() + ": " + lucas.getValue());
            if (lucas.checkFormula()) {
                System.out.println("Число " + lucas.getValue() + " можна представити як w^2 - 1.");
            } else {
                System.out.println("Число " + lucas.getValue() + " НЕ можна представити як w^2 - 1.");
            }
        }
    }

    /**
     * Основний метод для запуску програми.
     * @param args аргументи командного рядка
     */

    public static void main (String[] args){
        int N = getInput(args);
        LucasNumber[] lucasNumbers = generateLucasNumbers(N);
        checkAndPrintResults(lucasNumbers);
    }
}

