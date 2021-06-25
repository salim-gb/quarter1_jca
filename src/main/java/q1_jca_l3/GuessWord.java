package q1_jca_l3;

import java.util.Random;
import java.util.Scanner;

/**
 * Guess a word.
 */
public class GuessWord {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        String[][] words = {
                {"яблоко", "Цвет этого фрукта красный или зеленый"},
                {"банан", "Цвет этого фрукта желтый"},
                {"лимон", "Цвет этого фрукта желтый"},
                {"клубника", "Цвет этого фрукта красный"},
                {"манго", "Цвет этого фрукта зеленый, желтый, красный"},
                {"папайя", "Цвет этого фрукта оранжевый или зеленый"},
                {"гуава", "Цвет этого фрукта зеленый"},
                {"киви", "Цвет этого фрукта коричневый"},
                {"апельсин", "Цвет этого фрукта оранжевый"},
                {"арбуз", "Цвет этого фрукта зеленый"},
                {"виноград", "Цвет этого фрукта красный, зеленый"},
                {"персик", "Цвет этого фрукта оранжевый"},
                {"дыня", "Цвет этого фрукта желтый"},
                {"Абрикос", "Цвет этого фрукта желтый"},
                {"гранат", "Цвет этого фрукта красный"},
                {"маракуйя", "Цвет этого фрукта фиолетовый"}
        };

        guessWord(words);
    }

    static void guessWord(String[][] words) {
        do {
            int randomArrayIndex = random.nextInt(words.length);
            String wordAI = words[randomArrayIndex][0];
            System.out.printf("AI : %s\n", wordAI); // for testing
            System.out.print("Угадай фрукт >>> ");
            boolean isPromptUsed = false;
            while (true) {
                String answer = scanner.next();
                StringBuilder s = new StringBuilder();
                boolean isMatch = false;
                if (answer.equals(wordAI)) {
                    System.out.println("Вы угадали!");
                    break;
                } else {
                    /* get min word length to not get an exception */
                    int iterationNumber = Math.min(wordAI.length(), answer.length());
                    for (int i = 0; i < iterationNumber; i++) {
                        if (wordAI.charAt(i) == answer.charAt(i)) {
                            s.append(wordAI.charAt(i));
                            isMatch = true;
                        } else {
                            s.append("#");
                        }
                    }
                    for (int i = 0; i < 15 - s.length(); i++) {
                        s.append("##");
                    }
                    if (isMatch) System.out.printf("Вы угадали какие то буквы: %s\n", s);
                    else System.out.println("Неправильный ответ!");
                    if (!isPromptUsed) {
                        System.out.println("Хотите использовать подсказку? да или нет");
                        if (scanner.next().toLowerCase().equals("да")) {
                            System.out.println(words[randomArrayIndex][1]);
                        }
                        isPromptUsed = true;
                    }

                    System.out.print("Попробуй еще раз >>> ");
                }
            }
            System.out.println("Хотите еще раз поиграть? да или нет");
        } while (scanner.next().equalsIgnoreCase("да"));
    }
}
