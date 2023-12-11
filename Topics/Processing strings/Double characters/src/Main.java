import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();
        char[] result = new char[input.length*2];

        int idx = 0;
        for (int i = 0; i < input.length; i++){
            result[idx] = input[i];
            result[++idx] = input[i];

            idx++;
        }

        System.out.println(result);
    }
}
