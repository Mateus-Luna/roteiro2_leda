package sorting.divideAndConquer.hybridMergesort;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		hybridMergeSort(array, leftIndex, rightIndex);
	}

	private void hybridMergeSort(T[] array, int leftIndex, int rightIndex) {
		if (array.length > 1 && leftIndex < rightIndex && array != null) {
			if((rightIndex - leftIndex) > SIZE_LIMIT) {
				int middleIndex = (leftIndex + rightIndex) / 2;
				hybridMergeSort(array, leftIndex, middleIndex);
				hybridMergeSort(array, middleIndex + 1, rightIndex);
				merge(array, leftIndex, middleIndex, rightIndex);
			}
			else {
				insertionSort(array, leftIndex, rightIndex);
			}
		}
		
	}

	private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {
		 MERGESORT_APPLICATIONS ++;
		 T[] aux = Arrays.copyOf(array, array.length);
		 int l = leftIndex;
		 int m = middleIndex + 1;
		 int i = leftIndex;
		 while(l <= middleIndex && m <= rightIndex) {
			 if(aux[l].compareTo(aux[m]) <= 0) {
				 array[i] = aux[l];
				 l++;
			 }
			 else {
				 array[i] = aux[m];
				 m++;
			 }
			 i++;
		 }
		while(l <= middleIndex) {
			array[i] = aux[l];
			l++;
			i++;
		}
		while(m <= rightIndex) {
			array[i] = aux[m];
			m++;
			i++;
		}
		
	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex + 1; i <=rightIndex; i++ ) {
			 T tmp = array[i];
			 int j = i - 1;
			 while(j >= leftIndex && array[j].compareTo(tmp) > 0) {
				 array[j + 1] = array[j];
				 j--;
			 }
			 array[j + 1]  = tmp;
		 }
		
		
	}
}
