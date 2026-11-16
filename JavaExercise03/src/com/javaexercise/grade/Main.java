package com.javaexercise.grade;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            int[] scores = new int[5];

            String[] subjects = {"国語", "英語", "数学", "社会", "理科"};

            for (int i = 0; i < 5; i++) {

                while (true) {

                    System.out.print(subjects[i] + "の点数を入力してください：");

                    String input = scanner.nextLine();

                    try {

                        int number = Integer.parseInt(input);

                        if (number >= 0 && number <= 100) {

                            scores[i] = number;
                            break;

                        } else {

                            System.out.println("エラー：0～100の整数を入力してください");

                        }

                    } catch (NumberFormatException e) {

                        System.out.println("エラー：数字を入力してください");

                    }
                }

            }

            int total = 0;

            for (int i = 0; i < 5; i++) {

                total += scores[i];

            }

            System.out.println("5教科の合計点：" + total + "点");

            boolean hasFailure = false;

            for (int i = 0; i < 5; i++) {

                if (scores[i] < 20) {

                    hasFailure = true;

                }

            }

            String grade;

            if (hasFailure) {

                grade = "F";

            } else if (total >= 450) {

                grade = "A";

            } else if (total >= 400) {

                grade = "B";

            } else if (total >= 300) {

                grade = "C";

            } else if (total >= 200) {

                grade = "D";

            } else {

                grade = "F";

            }

            System.out.println("成績：" + grade);

            System.out.println("もう一度判定しますか？（終了する場合はexitと入力）");

            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("exit")) {
                System.out.println("アプリを終了します。");
                break;
            }

        }

        scanner.close();

    }

}