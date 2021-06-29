package q1_jca_l4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    public static char[][] map;
    public static final int SIZE = 5;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final int CHIPS = 4;
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        startGame();
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void startGame() {
        do {
            humanTurn();
            printMap();
            if (isThereWinner(DOT_X)) break;
            if (isDraW()) break;
            AITurn();
            printMap();
            if (isThereWinner(DOT_O)) break;
            if (isDraW()) break;
        } while (true);
    }

    public static void humanTurn() {
        int i, j;
        do {
            /* для быстроты тестирования*/
            String s = "";
            while (s.length() != 2) {
                System.out.print("Введите координаты в формате XY >>> ");
                s = scanner.next();
            }
            i = s.charAt(0) - '1';
            j = s.charAt(1) - '1';
        } while (!isCellValid(i, j));
        map[i][j] = DOT_X;
    }

    public static void AITurn() {
        if (!canAIWin()) {
            if (!canHumanWin()) {
                int i, j;
                do {
                    i = random.nextInt(SIZE);
                    j = random.nextInt(SIZE);
                } while (!isCellValid(i, j));
                map[i][j] = DOT_O;
            }
        }
    }

    public static boolean canHumanWin() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (isThereWinner(DOT_X)) {
                        map[i][j] = DOT_O;
                        return true;
                    } else {
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        return false;
    }

    public static boolean canAIWin() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (isThereWinner(DOT_O)) {
                        return true;
                    } else {
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isThereWinner(char symbol) {
        // Проверка строк и столбцов
        for (int i = 0; i < SIZE; i++) {
            boolean rowMatch = true;
            boolean colMatch = true;
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symbol) {
                    count1++;
                    if (count1 == CHIPS) break;
                } else {
                    count1 = 0;
                    if (SIZE - j < CHIPS) rowMatch = false;
                }
                if (map[j][i] == symbol) {
                    count2++;
                    if (count2 == CHIPS) break;
                } else {
                    count2 = 0;
                    if (SIZE - j < CHIPS) colMatch = false;
                }
            }
            if ((rowMatch || colMatch) && (count1 == CHIPS || count2 == CHIPS)) {
                winnerAnnouncement(symbol);
                return true;
            }
        }
        // Проверка побочного диагонала
        for (int i = 1; i <= SIZE + (SIZE - 3); i++) {
            boolean matchDiag = true;
            int count3 = 0;
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    if (j + k == i) {
                        if (map[j][k] == symbol) {
                            count3++;
                            if (count3 == CHIPS) break;
                        } else {
                            count3 = 0;
                        }
                    }
                }
            }
            if (count3 < CHIPS) matchDiag = false;
            if (matchDiag) {
                winnerAnnouncement(symbol);
                return true;
            }
        }
        // Проверка обычного диагонала
        int count4 = 1;
        for (int j = 0; j < SIZE; j++) {
            for (int k = 0; k < SIZE; k++) {
                if (isCellValid(j+1, k+1) && map[j][k] == symbol && map[j + 1][k + 1] == symbol) {
                    count4++;
                    if (count4 == CHIPS - 1) break;
                }
            }
            if (count4 == CHIPS) {
                winnerAnnouncement(symbol);
                return true;
            }
        }
        //Если нет не какой совпадении возвращаем false
        return false;
    }

    public static boolean isDraW() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        System.out.println("Ничия!");
        return true;
    }

    private static boolean isCellValid(int i, int j) {
        return (i >= 0 && i < SIZE) && (j >= 0 && j < SIZE) && (map[i][j] == DOT_EMPTY);
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void winnerAnnouncement(char symbol) {
        System.out.println(symbol == DOT_X ? "Вы победили!" : "Комп победил!");
    }
}