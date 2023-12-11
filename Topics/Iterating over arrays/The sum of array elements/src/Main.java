import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[] numbers = new int[size];

        for (int i=0; i<size; i++){
            numbers[i] = scanner.nextInt();
        }

        System.out.println(sumAll(numbers));
    }

    private static int sumAll(int[] numbers) {
        int res = 0;

        for (int i=0; i<numbers.length; i++){
            res += numbers[i];
        }

        return res;
    }
}
