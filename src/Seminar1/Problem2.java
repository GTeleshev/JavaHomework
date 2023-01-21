package Seminar1;

public class Problem2 {
    //Вывести все простые числа от 1 до 1000
    static int[] Primes = new int[10000];

    public static void main(String[] args) {
        int n = 1000;
        System.out.println("Число: " + n);
        Eratos(n);
        System.out.println("Простые числа: ");
        for (int i = 1; i <= n; i++) {
            if (i == 2)
                System.out.print(i + " ");
            else if (i % 2 == 1 && Primes[i / 2] == 0)
                System.out.print(i + " ");
        }
    }

    static void Eratos(int n) {
        Primes[0] = 1;
        for (int i = 3; i * i <= n; i += 2) {
            if (Primes[i / 2] == 0) {
                for (int j = 3 * i; j <= n; j += 2 * i)
                    Primes[j / 2] = 1;
            }
        }
    }
}
