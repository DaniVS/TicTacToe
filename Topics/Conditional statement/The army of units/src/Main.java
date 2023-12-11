import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int unit = scanner.nextInt();

        if (unit < 1){
            System.out.println("no army");
        } else if (unit >= 1 && unit < 20) {
            System.out.println("pack");
        } else if (unit >= 20 && unit < 250) {
            System.out.println("throng");
        } else if (unit >= 250 && unit < 1000) {
            System.out.println("zounds");
        } else {
            System.out.println("legion");
        }
    }
}
