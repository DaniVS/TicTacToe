import java.time.Year;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year = scanner.nextInt();

        if ((year % 400 == 0) ||
                (year % 4 == 0 && year % 100 != 0)
        ) {
            System.out.println("Leap");
        } else
            System.out.println("Regular");
    }
}
