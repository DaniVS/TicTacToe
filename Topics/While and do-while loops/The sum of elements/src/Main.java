import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int result = 0;
        int inputNumber;

        do {
            inputNumber = scanner.nextInt();
            result += inputNumber;
        } while (inputNumber != 0);

        System.out.println(result);
    }
}
