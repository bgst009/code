package pres.lanqiao.ds;

import java.util.Random;

/**
 * @author Nil
 */
public class SelectionSort {
	/**
	 * 选择排序
	 * <p>
	 * arr[0...i)有序，arr[i...n)无序
	 *
	 * @param arr 被排序的数组
	 */
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			//arr[i..n)中的最小值索引
			int minIndex = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}

	/**
	 * 交换数组中两个元素
	 *
	 * @param arr 被交换元素的数组
	 * @param i   元素下标
	 * @param j   元素下标
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
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
