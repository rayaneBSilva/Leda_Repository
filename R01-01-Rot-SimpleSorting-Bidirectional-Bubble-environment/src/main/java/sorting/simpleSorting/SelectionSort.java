package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (validation(array, leftIndex, rightIndex)) {
			for (int i = leftIndex; i <= rightIndex; i++) {
				int smaller = i;
				for (int j = i + 1; j <= rightIndex; j++) {
					if (array[j].compareTo(array[smaller]) < 0) {
						smaller = j;
					}
				}
				Util.swap(array, i, smaller);
			}
		}
	}

	private boolean validation(T[] array, int leftIndex, int rightIndex) {
		boolean result = true;
		if (array == null)
			result = false;
		if (array.length == 0)
			result = false;
		if (leftIndex < 0 || rightIndex < 0)
			result = false;
		if (leftIndex > rightIndex)
			result = false;
		if (rightIndex >= array.length)
			result = false;
		return result;
	}
}
