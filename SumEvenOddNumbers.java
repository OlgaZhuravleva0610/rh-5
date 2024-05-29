
import java.util.Arrays;
import java.util.List;

class SumEvenOddNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7,8, 9,10, 11, 12,13,14, 15);

        int sumEven = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        int sumOdd = numbers.stream()
                .filter(num -> num % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("сумма четных чисел: " + sumEven);
        System.out.println("сумма нечетных чисел: " + sumOdd);
    }
}