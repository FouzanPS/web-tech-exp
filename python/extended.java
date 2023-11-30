import java.util.Scanner;

public class ExtendedEuclideanAlgorithm {

    public static int[] extendedEuclidean(int a, int m) {
        int[] result = new int[21]; // Increase the array size to accommodate steps
        int A = m, B = a, Q, R, T1 = 0, T2 = 1, T;
        int step = 0;
        while (true) {
            Q = A / B;
            R = A % B;
            result[step] = Q;
            result[step + 1] = A;
            result[step + 2] = B;
            result[step + 3] = R;
            result[step + 4] = T1;
            result[step + 5] = T2;
            T = T1 - Q * T2;
            result[step + 6] = T;
            if (R == 0) {
                break;
            }
            A = B;
            B = R;
            T1 = T2;
            T2 = T;
            step += 7;
        }
        return result;
    }

    public static void displayTable(int[] result, int a, int m) {
        int steps = result.length / 7;
        for (int i = 0; i < steps; i++) {
            int stepIndex = i * 7;
            System.out.println(
                    result[stepIndex] + "\t" +
                            result[stepIndex + 1] + "\t" +
                            result[stepIndex + 2] + "\t" +
                            result[stepIndex + 3] + "\t" +
                            result[stepIndex + 4] + "\t" +
                            result[stepIndex + 5] + "\t" +
                            result[stepIndex + 6]
            );
        }
        int multiplicativeInverse = (result[result.length - 2] % m + m) % m;
        System.out.println("----------------------------------------------------------");
        System.out.println("Multiplicative Inverse of " + a + " modulo " + m + " is " +
                multiplicativeInverse);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of 'a': ");
        int a = scanner.nextInt();
        System.out.print("Enter the value of 'm': ");
        int m = scanner.nextInt();
        int[] result = extendedEuclidean(a, m);
        System.out.println("Extended Euclidean Algorithm for finding Multiplicative Inverse");
        System.out.println("----------------------------------------------------------");
        System.out.println("Q\tA\tB\tR\tT1\tT2\tT");
        displayTable(result, a, m);
        scanner.close();
    }
}
