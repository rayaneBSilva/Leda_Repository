package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(validation(array,leftIndex, rightIndex)) {
			int smaller = leftIndex;
			for (int j = leftIndex + 1; j < rightIndex + 1; j++) {
				if (array[j].compareTo(array[smaller]) < 0) {
					smaller = j;
				}
			}
			Util.swap(array, smaller, leftIndex);

			if (leftIndex < rightIndex) {
				sort(array, leftIndex + 1, rightIndex);
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
