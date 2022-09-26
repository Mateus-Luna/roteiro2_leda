package sorting.divideAndConquer;


import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array.length > 1 && leftIndex < rightIndex && array != null) {
			int middleIndex = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middleIndex);
			sort(array, middleIndex + 1, rightIndex);
			
			merge(array, leftIndex, middleIndex, rightIndex);
			}
	
		}

	private T[] merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {
		T[] aux = (T[]) new Comparable[array.length];
		for (int i = leftIndex; i<= rightIndex; i++) {
			aux[i] = array[i];
		}
		int m = middleIndex + 1;
		int i = leftIndex;
		int l = leftIndex;
		while(i <= middleIndex && m <= rightIndex) {
			if (aux[i].compareTo(aux[m]) < 0) {
				array[l] = aux[i];
				i++;
			}
			else {
				array[l] = aux[m];
				m++;
			}
			l++;
		}
		while (i <= middleIndex) {
			array[l] = aux[i];
			i++;
			l++;
		}
		while (m <= rightIndex) {
			array[l] = aux[m];
			m++;
			l++;
		}
		return aux;
		
	}


	}

