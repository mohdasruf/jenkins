package Tests;

import java.util.Scanner;

public class LongestOrderedSubSequence {

	private static Scanner numScanner;
	private static Scanner s;

	public static int maximumLength(int[] arr) {
		if (arr.length <= 1)
			return arr.length;
		int maxLength = 1;
		int curLength = 1;
		for (int i = 1; i < arr.length; i++) {
			if ((arr.length - i + curLength) <= maxLength)
				return maxLength;
			if (arr[i] > arr[i - 1])
				curLength++;
			else {
				if (maxLength < curLength)
					maxLength = curLength;
				curLength = 1;
			}
		}
		if (maxLength < curLength)
			return curLength;
		return maxLength;
	}

	public static void main(String[] args) {
		s = new Scanner(System.in);

		System.out.println("Enter the length of the array :");
		int count = s.nextInt();
		s.nextLine();

		int[] numbers = new int[count];
		System.out.println("Enter the numbers next to each other .e.g. 1 2 3 4 5 :");
		numScanner = new Scanner(s.nextLine());
		for (int i = 0; i < count; i++) {
			if (numScanner.hasNextInt()) {
				numbers[i] = numScanner.nextInt();
			} else {
				System.out.println("You didn't provide enough numbers");
				break;
			}
		}

		System.out.println("maximum length:" + maximumLength(numbers));

	}

}
