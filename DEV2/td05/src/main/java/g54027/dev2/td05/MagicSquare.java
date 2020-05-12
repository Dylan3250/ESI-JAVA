package g54027.dev2.td05;

public class MagicSquare {

    private int n;
    private int[][] t;

    public MagicSquare() {
        this.t = new int[][]{
            {4, 9, 2},
            {3, 5, 7},
            {8, 1, 6}};
        this.n = 3;
    }

    /**
     * Makes an magic square with n lines and n columns
     *
     * @param n the number of lines and columns
     * @throws IllegalArgumentException n smaller than 3 or n is even
     */
    public MagicSquare(int n) {
        if (n < 3 || n % 2 == 0) {
            throw new IllegalArgumentException("Erreur n : " + n);
        }
        this.n = n;
        t = new int[n][n];

        int k = 1;
        int line = n - 1;
        int col = n / 2;

        while (k != n * n) {
            int oldL = line;
            int oldC = col;

            t[line][col] = k;

            line = (line + 1) % n; // 0, 1, 2, 3, ..., n-1, 0, 1, 2, 3, 4
//            Le modulo ci-dessus remplace les 3 lignes suivantes
//            if (ligne + 1 > n) {
//                ligne = 0;
//            }
            col = (col + 1) % n;
            if (t[line][col] != 0) {
//                Visiblement on ne rentre jamais dedans
//                if (oldL == 0) {
//                    ligne = 0;
//                } else {
                line = oldL - 1;
//                }
                col = oldC;
            }

            t[line][col] = ++k;
        }
    }

    /**
     * Gives the array with the MagicSquare
     *
     * @return the t array
     */
    public int[][] getT() {
        return this.t;
    }

    /**
     * Gives the number of line and colomn (n)
     *
     * @return the number of line and colomn
     */
    public int getN() {
        return this.n;
    }

    /**
     * Computes the sum of the num line in array
     *
     * @param num the line where the sum is computing
     * @throws IllegalArgumentException inferior or superior than n
     * @return the sum of digits in the line
     */
    public int sumLine(int num) {
        if (num < 0 || num >= n) {
            throw new IllegalArgumentException("num < ou > que n : " + num);
        }

        int sum = 0;
        for (int tab : t[num]) {
            sum += tab;
        }
        return sum;
    }

    /**
     * Computes the sum of the num column in array
     *
     * @param num the column where the sum is computing
     * @throws IllegalArgumentException inferior or superior than n
     * @return the sum of digits in the column
     */
    public int sumColumn(int num) {
        if (num < 0 || num >= n) {
            throw new IllegalArgumentException("num < ou > que n : " + num);
        }

        int sum = 0;
        for (int[] lg : t) {
            sum += lg[num];
        }
        return sum;
    }

    /**
     * Computes the sum of diagonal in array
     *
     * @param num witch diagonal take (1 descending and 2 ascending)
     * @throws IllegalArgumentException not 1 or 2
     * @return the sum of digits in the diagonal choosed
     */
    public int sumDiag(int num) {
        if (num != 2 && num != 1) {
            throw new IllegalArgumentException("Num doit être 1 ou 2 : " + num);
        }

        int sum = 0;
        if (num == 1) {
            for (int i = 0; i < t.length; i++) {
                sum += t[i][i];
            }
        } else if (num == 2) {
            for (int i = t.length - 1; i >= 0; i--) {
                sum += t[i][i];
            }
        }
        return sum;
    }

    /**
     * Checks if the array is a MagicSquare
     *
     * @return true if it is magic square, false otherwise
     */
    public boolean isMagicSquare() {
        boolean isMagic = sumDiag(1) == sumDiag(2);

        int i = 0;
        while (i < n && isMagic) {
            int j = 0;
            while (j < n && isMagic) {
                isMagic = sumColumn(j) == sumLine(i) == isMagic;
                j++;
            }
            i++;
        }
        return isMagic;
    }

    /**
     * Makes a display custom for a MagicSquare array
     *
     * @throws IllegalArgumentException n superior or equal at 20
     */
    public void displayMagicSquare() {
        if (n >= 20) {
            throw new IllegalArgumentException("Doit être inférieur à 20 : " + n);
        }

        System.out.println("Square order : " + n + "\n");
        for (int[] lg : t) {
            for (int col : lg) {
                System.out.print(String.format("%4d ", col));
            }
            System.out.println("-> " + sumLine(0));
        }

        for (int i = 0; i < t[0].length; i++) {
            System.out.print(String.format("%s ", "----"));
        }
        System.out.println();

        for (int i = 0; i < t[0].length; i++) {
            System.out.print(String.format("%4d ", sumColumn(i)));
        }
        System.out.println();
    }
}
