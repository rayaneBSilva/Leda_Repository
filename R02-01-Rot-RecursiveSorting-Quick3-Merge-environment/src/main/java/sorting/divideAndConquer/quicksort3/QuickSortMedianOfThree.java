package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(validation(array,leftIndex,rightIndex)){
			if(leftIndex < rightIndex){
				int index_pivot = partition(array, leftIndex, rightIndex);
				this.sort(array, leftIndex, index_pivot - 1);
				this.sort(array, index_pivot + 1, rightIndex);
			}

		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex){
		int pivotIndex = pivotMedianOfThreeIndex(array, leftIndex, rightIndex);
		int i = leftIndex;
		Util.swap(array, pivotIndex, leftIndex);

		for (int j = i + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(array[leftIndex]) <= 0) {
				i++;
				Util.swap(array, j, i);
			}
		}

		Util.swap(array, i, leftIndex);

		return i;
	}

	private int pivotMedianOfThreeIndex(T[] array, int leftIndex,int rightIndex) {
		int middle = (leftIndex + rightIndex)/ 2;
		if(array[leftIndex].compareTo(array[rightIndex]) > 0)
			Util.swap(array, rightIndex, leftIndex);
		if(array[leftIndex].compareTo(array[middle]) > 0)
			Util.swap(array, middle, leftIndex);
		if(array[middle].compareTo(array[rightIndex]) > 0) 
			Util.swap(array, rightIndex, middle);

		return middle;

	}

	private boolean validation(T[] array, int leftIndex, int rightIndex){

		boolean result = true;

		if(array == null)
			result = false;
		if(array.length == 0)
			result = false;
		if(leftIndex < 0 || rightIndex < 0)
			result = false;
		if(rightIndex >= array.length)
			result = false;
		if(leftIndex > rightIndex)
			result = false;
		return result;

	}
}
