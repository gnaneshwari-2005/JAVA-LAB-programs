package BM23AI069;


import java.util.Scanner;

public class STUDENTSCORES {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[5];
        int sum = 0;
        int highest = Integer.MIN_VALUE;

        System.out.println("Enter exam scores for 5 students:");

        for (int i = 0; i < scores.length; i++) {
            System.out.print("Student " + (i + 1) + " score: ");
            scores[i] = scanner.nextInt();
            sum += scores[i];
            if (scores[i] > highest) {
                highest = scores[i];
            }
        }

        System.out.println("\n--- Exam Statistics ---");
        System.out.println("Total score: " + sum);
        System.out.println("Highest score: " + highest);
    }
}
