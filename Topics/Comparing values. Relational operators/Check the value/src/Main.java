import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.nextInt() < 10){
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }
}
