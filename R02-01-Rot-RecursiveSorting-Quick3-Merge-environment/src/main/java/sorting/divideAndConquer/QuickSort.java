package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(validation(array, leftIndex, rightIndex)) {
			if(leftIndex < rightIndex) {
				int indexPivot = this.partition(array, leftIndex, rightIndex);
				this.sort(array, leftIndex, indexPivot - 1);
				this.sort(array, indexPivot + 1, rightIndex);
				
			}
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		int range = rightIndex - leftIndex + 1;
		int rand_pivot_index = (int)(Math.random() * range) + leftIndex;
		
		T pivot = array[leftIndex];
		int i = leftIndex;
		
		for(int j = leftIndex + 1; j <= rightIndex; j++) {
			if(array[j].compareTo(pivot) <= 0) {
				i++;
				Util.swap(array, j, i);
			}
		}
		Util.swap(array, leftIndex, i);
		
		return i;
	}

	private boolean validation(T[] array, int leftIndex, int rightIndex) {
		boolean result = true;
		if (array == null)
			result = false;
		if (array.length == 0)
			result = false;
		if (leftIndex < 0 || rightIndex < 0)
			result = false;
		if (rightIndex >= array.length)
			result = false;
		if (leftIndex > rightIndex)
			result = false;
		return result;
	}
}
