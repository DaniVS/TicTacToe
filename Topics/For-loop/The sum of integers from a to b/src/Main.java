import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowerLimit = scanner.nextInt();
        int upperLimit = scanner.nextInt();
        int total = 0;

        for (int i = lowerLimit; i <= upperLimit; i++){
            total += i;
        }

        System.out.println(total);
    }
}
