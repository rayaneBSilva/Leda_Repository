package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;


/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(validation(array,leftIndex, rightIndex)){
			boolean swapped = true;
			while(swapped){
				swapped = false;
				for(int i = leftIndex ; i < rightIndex ; i++){
					if(array[i].compareTo(array[i+1]) > 0){
						Util.swap(array,i, i+ 1);
						swapped = true;
					}

				}
			}
		}
	}
	private boolean validation(T[] array, int leftIndex, int rightIndex){
		boolean result = true;
		if(array == null) 
			result = false;
		
		if(array.length == 0) 
			result = false;
		
		if(leftIndex > rightIndex) 
			result = false;
		
		if(leftIndex < 0 || rightIndex < 0) 
			result = false;
		
		if(rightIndex >= array.length) 
			result = false;
		
		return result;
	}

}
