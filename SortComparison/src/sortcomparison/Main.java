package sortcomparison;

import static sbcc.Core.*;

import java.util.*;

import static java.lang.System.*;
import static org.apache.commons.lang3.StringUtils.*;

public class Main {

	public static void main(String[] args) {

		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();
		arr.add("b");
		arr.add("d");
		arr.add("e");
		arr.add("h");
		arr.add("a");
		arr.add("c");
		arr.add("f");
		arr.add("g");
		arr.add("b");
		arr.add("d");
		arr.add("e");
		arr.add("h");
		arr.add("a");
		arr.add("c");
		arr.add("f");
		arr.add("g");
		// ArrayList<String> words = new ArrayList<String>();
		// for (String s : new String[] { "M", "B", "Z", "A", "F", "D", "C", "P", "Q",
		// "E", "V", "X" })
		// words.add(s);

		BasicSorter demo = new BasicSorter();
		demo.quickSort(arr, 0, 16);

		// demo.quickSort(arr, 0, 8);

		// System.out.println(demo.partition(arr, 0, 8));

		// Random rand = new Random();
		// ArrayList<String> median = new ArrayList<String>();
		// int n = rand.nextInt(8);
		// for (int i = 0; i < 3; i++) {
		// n = n + rand.nextInt(8);
		// // median.add(arr.get(n));
		// }
		//
		// n = n / 3;
		// System.out.println(n);
		// demo.insertionSort(median, 0, 3);

		// System.out.println(median.get(1));

		for (String word : arr) {
			System.out.println(word);
		}

	}

}
