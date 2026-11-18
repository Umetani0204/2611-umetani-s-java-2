package com.javaexercise.grade;

import java.util.Scanner;

public class Main {

    private static final String[] SUBJECTS = {"国語", "英語", "数学", "社会", "理科"};
    private static final int SUBJECT_COUNT = SUBJECTS.length;

    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 100;

    private static final int FAIL_SCORE = 20;

    private static final int GRADE_A_TOTAL = 450;
    private static final int GRADE_B_TOTAL = 400;
    private static final int GRADE_C_TOTAL = 300;
    private static final int GRADE_D_TOTAL = 200;

    private static final String GRADE_A = "A";
    private static final String GRADE_B = "B";
    private static final String GRADE_C = "C";
    private static final String GRADE_D = "D";
    private static final String GRADE_F = "F";

    private static final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                int total = 0;
                boolean hasFailure = false;

                for (int i = 0; i < SUBJECT_COUNT; i++) {
                    int score = inputScore(scanner, SUBJECTS[i]);
                    total += score;
                    if (score < FAIL_SCORE) {
                        hasFailure = true;
                    }
                }

                System.out.println(SUBJECT_COUNT + "教科の合計点：" + total + "点");
                System.out.println("成績：" + judgeGrade(total, hasFailure));

                System.out.println("もう一度判定しますか？（終了する場合は" + EXIT_COMMAND + "と入力）");
                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase(EXIT_COMMAND)) {
                    System.out.println("アプリを終了します。");
                    break;
                }
            }
        }
    }

    private static int inputScore(Scanner scanner, String subject) {
        while (true) {
            System.out.print(subject + "の点数を入力してください：");
            String input = scanner.nextLine();

            try {
                int score = Integer.parseInt(input);

                if (score >= MIN_SCORE && score <= MAX_SCORE) {
                    return score;
                }
                System.out.println("エラー：" + MIN_SCORE + "～" + MAX_SCORE + "の整数を入力してください");

            } catch (NumberFormatException e) {
                System.out.println("エラー：数字を入力してください");
            }
        }
    }

    private static String judgeGrade(int total, boolean hasFailure) {
        if (hasFailure) {
            return GRADE_F;
        }
        if (total >= GRADE_A_TOTAL) {
            return GRADE_A;
        }
        if (total >= GRADE_B_TOTAL) {
            return GRADE_B;
        }
        if (total >= GRADE_C_TOTAL) {
            return GRADE_C;
        }
        if (total >= GRADE_D_TOTAL) {
            return GRADE_D;
        }
        return GRADE_F;
    }
}