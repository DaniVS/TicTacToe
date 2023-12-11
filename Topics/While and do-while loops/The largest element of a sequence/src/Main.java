import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean stop = false;
        int currentNumber = -1;
        int max = currentNumber;

        while (!stop){
            currentNumber = scanner.nextInt();

            if (currentNumber != 0){
                if (currentNumber > max){
                    max = currentNumber;
                }
            } else {
                stop = true;
                System.out.println(max);
            }
        }
    }
}
