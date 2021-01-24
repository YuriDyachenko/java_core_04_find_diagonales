package kurs;

public class Main {

    static final int SIZE = 10;
    static final int DOTS_TO_WIN = 5;

    public static void main(String[] args) {

        int[][] map = new int[SIZE][SIZE];

        int maxShift = SIZE - DOTS_TO_WIN;

        for (int dy = -maxShift; dy <= maxShift; dy++) {
            //главная диагональ
            for (int y = 0; y < SIZE; y++) {
                int x = y - dy;
                if (x < 0 || x >= SIZE) continue;
                map[y][x]++;
            }
            //побочная диагональ
            for (int y = 0; y < SIZE; y++) {
                int x = SIZE - 1 - y - dy;
                if (x < 0 || x >= SIZE) continue;
                map[y][x]++;
            }
        }
        
        printMap(map);
    }

    private static void printMap(int[][] map) {
        for (int y = 0; y < SIZE; y++) {
            System.out.println();
            for (int x = 0; x < SIZE; x++)
                System.out.print(leftPadChar("" + map[y][x], 4, ' '));
        }
        System.out.println();
    }

    private static String leftPadChar(String s, int n, char c) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n - s.length(); i++)
            stringBuilder.append(c);
        return stringBuilder.toString() + s;
    }
}
