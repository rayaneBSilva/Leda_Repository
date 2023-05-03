package problems;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		StartEndPositionImpl start = new StartEndPositionImpl();
		Integer[] array = new Integer[] {5, 7, 7, 8, 8, 10};
		System.out.println(Arrays.toString(start.startEndPosition(array, 8)));
		
	}
}
