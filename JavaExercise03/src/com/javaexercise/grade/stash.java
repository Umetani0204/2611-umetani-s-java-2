/*package com.javaexercise.numbers;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			int[] userNumbers = new int[10];

			for (int i = 0; i < 10; i++) {

				while (true) {

					System.out.print((i + 1) + "個目の数字を入力してください：");

					String input = scanner.nextLine();

					try {

						int number = Integer.parseInt(input);

						if (number >= 0 && number <= 9) {

							userNumbers[i] = number;
							break;

						} else {

							System.out.println("エラー：0～9の整数を入力してください");

						}

					} catch (NumberFormatException e) {

						System.out.println("エラー：数字を入力してください");

					}
				}
			}

			System.out.print("USER : ");

			for (int i = 0; i < 10; i++) {
				System.out.print(userNumbers[i] + " ");
			}
			System.out.println();

			int[] comNumbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

			Random random = new Random();

			for (int i = 9; i > 0; i--) {

				int j = random.nextInt(i + 1);

				int temp = comNumbers[i];
				comNumbers[i] = comNumbers[j];
				comNumbers[j] = temp;
			}

			System.out.print("COM : ");

			for (int i = 0; i < 10; i++) {
				System.out.print(comNumbers[i] + " ");
			}
			boolean straight = true;

			for (int i = 0; i < 10; i++) {
				if (userNumbers[i] != comNumbers[i]) {
					straight = false;
					break;
				}
			}

			int[] userCount = new int[10];
			int[] comCount = new int[10];

			for (int i = 0; i < 10; i++) {
				userCount[userNumbers[i]]++;
				comCount[comNumbers[i]]++;
			}

			boolean box = true;

			for (int i = 0; i < 10; i++) {
				if (userCount[i] != comCount[i]) {
					box = false;
					break;
				}
			}

			if (straight) {
				System.out.println("\n結果：ストレート");
			} else if (box) {
				System.out.println("\n結果：ボックス");
			} else {
				System.out.println("\n結果：ハズレ");
			}

			while (true) {
				System.out.println("もう一度プレイしますか？ (y/n)");

				String answer = scanner.nextLine();

				if (answer.equalsIgnoreCase("n")) {
					System.out.println("ゲームを終了します");
					scanner.close();
					return;

				} else if (answer.equalsIgnoreCase("y")) {
					System.out.println("もう一度プレイします");
					break;

				} else {
					System.out.println("y または n を入力してください");
				}
			}
		}
	}

}*/