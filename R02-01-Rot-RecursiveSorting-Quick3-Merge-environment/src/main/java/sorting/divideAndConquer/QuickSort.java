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
		if (array.length > 1 && leftIndex < rightIndex && array != null) {
			int indexPivot = partition(array, leftIndex, rightIndex);
			int rightPivot = indexPivot - 1;
			int leftPivot = indexPivot + 1;
			sort(array, leftIndex, rightPivot);
			sort(array,leftPivot, rightIndex);
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		int range = rightIndex - leftIndex + 1;
        int rand_pivot_index = (int)(Math.random() * range) + leftIndex;
        Util.swap(array, leftIndex, rand_pivot_index);
        T pivot = array[leftIndex];
        int i = leftIndex;
        for (int j = leftIndex + 1; j <= rightIndex; j++) {
        	if (array[j].compareTo(pivot) <= 0) {
                i+=1;
                Util.swap(array, i, j);
            }
        }
        Util.swap(array, leftIndex, i);

		return i;
	}
	
}
