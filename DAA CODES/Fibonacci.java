import java.util.Scanner;

class Fibonacci {
    
    public static int fib_recur(int n) {
        if (n <= 1) return n;
        return fib_recur(n - 1) + fib_recur(n - 2);
    }

    public static void fib_iter(int n) {
        if (n <= 0) return;
        int a = 0, b = 1;

        // print first term
        System.out.print(a);
        if (n == 1) {
            System.out.print(" ");
            return;
        }
        // print second term
        System.out.print(" " + b);

        // print remaining n-2 terms
        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }
        System.out.print(" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of values need to be generated (n):");
        int n = sc.nextInt();

        System.out.println("Fibonacci Series through Recursive approach:");
        for (int i = 0; i < n; i++) {
            System.out.print(fib_recur(i) + " ");
        }

        System.out.println();
        System.out.println("Fibonacci Series through Iterative approach:");
        fib_iter(n);
        System.out.println();
    }
}
