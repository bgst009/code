package pres.lanqiao.test;

import pres.lanqiao.ds.SelectionSort;

import java.util.Random;

/**
 * @author Nil
 */
public class SearchTest {
	public static void main(String[] args) {
		int[] arr = new int[10];

		System.out.println("排序前：");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(20);
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n排序后：");

		SelectionSort.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
