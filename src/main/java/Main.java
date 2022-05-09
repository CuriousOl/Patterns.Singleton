import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Logger logger = Logger.getInstance();

    /*
        Программа здоровается с пользователем, просит ввести два числа: размер списка N и верхнюю границу значений элементов в списке M.
        Программа создаёт список ArrayList из N элементов и заполняет их случайными числами от 0 до M.
        Программа просит пользователя ввести число f для фильтрации списка.
        Программа создаёт объект filter вашего класса Filter, передав в конструктор значение f
        Программа вызывает у filter метод List<Integer> filterOut(List<Integer> list), передавая созданный случайный список в качестве параметра и
        принимая в качестве ответа список, который идентичен исходному, если пропустить элементы меньше f
        Программа выводит итоговый список на экран и завершает свою работу
     */
    public static void main(String[] args) {
        logger.log("Здравствуйте!");

        int N = 0, M = 0;
        while (true) {
            logger.log("Введите, пожалуйста, 2 числа через пробел: размер списка N и верхнюю границу значений элемнтов в списке M:");
            String input = scanner.nextLine();
            String[] numbers = input.split(" ");
            try {
                N = Integer.parseInt(numbers[0]);
                M = Integer.parseInt(numbers[1]);
                break;
            } catch (NumberFormatException exc) {
                logger.log("Увы! Неверный ввод чисел. Попробуйте снова.");
            }
        }
        Random random = new Random();
        List<Integer> list = new ArrayList<>(N);
        for (int i = 0; i < N; ++i) {
            list.add(random.nextInt(M));
        }
        logger.log("Сформирован массив чисел:");
        list.stream().forEach(i -> System.out.print(i + " "));
        System.out.println();
        logger.log("Введите целое число в диапозоне от 0 до " + M + ":");
        int f = scanner.nextInt();
        Filter filter = new Filter(f);
        List<Integer> filteredList = filter.filterOut(list);
        logger.log("Список отфильтрован от чисел меньших " + f + ":");
        filteredList.stream().forEach(i -> System.out.print (i + " "));
        System.out.println();
        logger.log("Программа завершена.");
    }


}
