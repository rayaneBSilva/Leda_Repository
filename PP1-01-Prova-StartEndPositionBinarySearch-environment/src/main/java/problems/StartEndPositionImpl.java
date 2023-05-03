package problems;

/**
 * Dado um array A ordenado de inteiros de tamanho N e um valor x, possivelmente com mais de uma ocorrencia,
 * usar busca binária para encontrar as posicoes da primeira e ultima ocorrencias de x em  A.

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].

 * Restricoes: 
 * - Seu algoritmo NÃO pode usar memória extra (a nao ser variaveis simples locais e nao de colecao/estrutura) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * - Retornar um array com dois elementos [primeiraPosicao,ultimaPosicao], onde primeiraPosicao
 *   tem o valor do indice da primeira ocorrencia de x em A, e ultimaPosicao tem o valor do indice 
 *   da ultima ocorrencia de x em A
 * - Note que se x nao esta em A entao o retorno deve ser [-1,-1]
 *
 */
public class StartEndPositionImpl implements StartEndPosition{


	@Override
	public int[] startEndPosition(Integer[] array, Integer x){
		int[] result = new int[2];
		if(!(array == null && array.length == 0 && x == null)) {
			int position_one = this.binarySearch(array, x, 0, array.length - 1);
 		    int position_two = this.binarySearch(array, x,position_one + 1,array.length - 1, position_one);
			result[0] = position_one;
			result[1] = position_two;
			
		}
		return result;
		
	}

	private int binarySearch(Integer[] array, Integer x, int leftIndex, int rightIndex) {
			if(leftIndex < rightIndex) {
			
			int middle = (leftIndex + rightIndex) / 2;
			
			if(array[middle - 1] == x) {
				return middle - 1;
			} 
			
			if(x == array[middle]) {
				return middle;
			} 
			
			if(x < array[middle]) {
				return this.binarySearch(array, x, leftIndex, middle - 1);
			} else {
				return this.binarySearch(array,x, middle + 1, rightIndex);
			}
		}
		return - 1;
		
	}

	private int binarySearch(Integer[] array, Integer x, int leftIndex, int rightIndex, int position) {
		
		if(leftIndex < rightIndex) {
			
			int middle = (leftIndex + rightIndex) / 2;
			
			if(array[middle - 1] == x) {
				if(position == middle - 1)
					return middle;
			} 
			
			if(x == array[middle]) {
				return middle;
			} 
			
			if(x < array[middle]) {
				return this.binarySearch(array, x, leftIndex, middle - 1);
			} else {
				return this.binarySearch(array,x, middle + 1, rightIndex);
			}
		}
		return - 1;
		
		
	}

	

}
