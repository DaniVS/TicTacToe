import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int totalParts = scanner.nextInt();
        int perfect = 0;
        int rejects = 0;
        int fixable = 0;

        for (int idx = 0; idx < totalParts; idx++){
            int qualityCheck = scanner.nextInt();

            if (qualityCheck == 0) {
                perfect++;
            } else if (qualityCheck == -1) {
                rejects++;
            } else if (qualityCheck == 1) {
                fixable++;
            }
        }

        System.out.println(perfect + " " + fixable + " " + rejects);

    }
}
