package sorting.divideAndConquer.quicksort3;

import java.util.Arrays;

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
		quicksortMedianOfThree(array, leftIndex, rightIndex);
	}

	private void quicksortMedianOfThree(T[] array, int leftIndex, int rightIndex) {
		if (array.length > 1 && leftIndex < rightIndex && array != null) {
			int q = partition(array, leftIndex, rightIndex);
			quicksortMedianOfThree(array, leftIndex, q - 1);
			quicksortMedianOfThree(array, q + 1, rightIndex);
			}
		
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {

		int middle = (leftIndex + rightIndex) / 2;
		T a = array[leftIndex];
		T b = array[middle];
		T c = array[rightIndex];
		int medianIndex;
		if (a.compareTo(b) < 0 ){
			if(b.compareTo(c) < 0) {
				medianIndex = middle;
			}
			else {
				if(a.compareTo(c) < 0) {
					medianIndex = rightIndex;
				}
				else {
					medianIndex = leftIndex;
				}
			}
		}
			else{
				if(b.compareTo(c) > 0) {
					medianIndex = middle;
				}
				else {
					if(a.compareTo(c) > 0) {
						medianIndex = rightIndex;
					}
					else {
						medianIndex = leftIndex;
					}
				}
			}
			Util.swap(array, medianIndex, rightIndex);
			T pivot = array[rightIndex];
			int i = leftIndex - 1;
			for (int j = leftIndex; j <= rightIndex - 1; j++) {
				if(array[j].compareTo(pivot) <= 0) {
					i += 1;
					Util.swap(array, i, j);
				}
			}
		Util.swap(array, i+1, rightIndex);	
		return i+1;
	}
	
	
}
