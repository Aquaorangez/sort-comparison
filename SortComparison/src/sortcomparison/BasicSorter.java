package sortcomparison;

import static java.lang.Math.*;
import static org.apache.commons.lang3.StringUtils.*;

import java.util.*;

public class BasicSorter implements Sorter {

	@Override
	public void insertionSort(ArrayList<String> data, int firstIndex, int numberToSort) {
		int start = firstIndex;
		if (firstIndex == 0)
			start = 1;
		int prev = start - 1;

		for (int i = start; i < firstIndex + numberToSort; i++) {
			prev = i - 1;
			String temp = data.get(i);
			int comp = temp.compareTo(data.get(prev));
			int ph = i;

			while (comp < 0 && prev >= 0) {
				data.set(i, data.get(prev));
				data.set(prev, temp);

				if (prev == 0)
					break;

				i--;
				prev = prev - 1;
				comp = temp.compareTo(data.get(prev));
			}
			i = ph;

		}
	}


	@Override
	public void quickSort(ArrayList<String> data, int firstIndex, int numberToSort) {

		if (numberToSort > 1) {
			if (numberToSort < 16) {
				insertionSort(data, firstIndex, numberToSort);
			} else {

				int n = partition(data, firstIndex, numberToSort);
				int left = n - firstIndex;
				int right = numberToSort - left - 1;

				quickSort(data, firstIndex, left);
				quickSort(data, n + 1, right);
			}
		}

	}


	@Override
	public int partition(ArrayList<String> data, int firstIndex, int numberToPartition) {
		// Random rand = new Random();
		// ArrayList<String> median = new ArrayList<String>();
		//
		// for (int i = 0; i < 3; i++) {
		// int n = rand.nextInt(numberToPartition) + firstIndex;
		// median.add(data.get(n));
		// }
		//
		// insertionSort(median, 0, 3);
		//
		// String tempFirst = data.get(firstIndex);
		// data.set(firstIndex, median.get(1));
		// data.set(data.lastIndexOf(median.get(1)), tempFirst);

		String pivot = data.get(firstIndex);
		int tooBigNdx = firstIndex + 1;
		int tooSmallNdx = firstIndex + numberToPartition - 1;

		while (tooBigNdx < tooSmallNdx) {
			int bigToPivot = data.get(tooBigNdx).compareTo(pivot);
			int smallToPivot = data.get(tooSmallNdx).compareTo(pivot);

			while (tooBigNdx < tooSmallNdx && bigToPivot <= 0) {
				tooBigNdx++;
				bigToPivot = data.get(tooBigNdx).compareTo(pivot);
			}

			while (tooSmallNdx > firstIndex && smallToPivot > 0) {
				tooSmallNdx--;
				smallToPivot = data.get(tooSmallNdx).compareTo(pivot);
			}

			if (tooBigNdx < tooSmallNdx) {
				String tempBig = data.get(tooBigNdx);
				data.set(tooBigNdx, data.get(tooSmallNdx));
				data.set(tooSmallNdx, tempBig);
			}
		}

		if (pivot.compareTo(data.get(tooSmallNdx)) >= 0) {
			String tempSmall = data.get(tooSmallNdx);
			data.set(tooSmallNdx, pivot);
			data.set(firstIndex, tempSmall);

			return tooSmallNdx;
		}

		else
			return firstIndex;

	}


	@Override
	public void mergeSort(ArrayList<String> data, int firstIndex, int numberToSort) {
		if (numberToSort > 1) {
			// if (numberToSort < 16) {
			// insertionSort(data, firstIndex, numberToSort);
			// return;
			// }

			int n = numberToSort;
			int left = n / 2;
			int right = numberToSort - left;

			mergeSort(data, firstIndex, left);
			mergeSort(data, firstIndex + left, right);

			int mid = (firstIndex + numberToSort) / 2;

			// if (data.get(mid).compareTo(data.get(mid + 1)) < 0) {
			// for (int i = 0; i <)
			//
			// return;
			// }

			merge(data, firstIndex, left, right);

		}

	}


	@Override
	public void merge(ArrayList<String> data, int firstIndex, int leftSegmentSize, int rightSegmentSize) {
		int i = firstIndex, j = firstIndex + leftSegmentSize;
		ArrayList<String> temp = new ArrayList<String>();

		while (i < leftSegmentSize + firstIndex && j < rightSegmentSize + firstIndex + leftSegmentSize) {

			if (data.get(i).compareTo(data.get(j)) < 0) {
				temp.add(data.get(i));
				i++;
			} else {
				temp.add(data.get(j));
				j++;
			}
		}

		while (i < leftSegmentSize + firstIndex) {
			temp.add(data.get(i));
			i++;
		}

		while (j < rightSegmentSize + firstIndex + leftSegmentSize) {
			temp.add(data.get(j));
			j++;
		}

		for (int k = 0; k < temp.size(); k++)
			data.set(k + firstIndex, temp.get(k));

		temp.clear();

	}


	@Override
	public void heapSort(ArrayList<String> data) {
		// TODO Auto-generated method stub

	}


	@Override
	public void heapify(ArrayList<String> data) {
		// TODO Auto-generated method stub

	}

}
