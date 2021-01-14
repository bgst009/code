package pres.lanqiao.ds;

import java.util.Random;

/**
 * @author Nil
 */
public class InsertionSort {

	/**
	 * 插入排序
	 *
	 * @param arr 被排序的数组
	 */
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {

			//将arr[i] 插入到合适的位置
			for (int j = i; j - 1 >= 0; j--) {
				if (arr[j] < arr[j - 1]) {
					swap(arr, j, j - 1);
				} else {
					break;
				}
			}
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

		InsertionSort.sort(arr);

		for (int j : arr) {
			System.out.print(j + " ");
		}
	}
}
