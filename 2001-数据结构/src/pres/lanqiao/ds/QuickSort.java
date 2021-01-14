package pres.lanqiao.ds;

import java.util.Random;

/**
 * @author Nil
 */
public class QuickSort {
	public static void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	private static void sort(int[] arr, int l, int r) {
		if (l >= r) {
			return;
		}
		int p = partition(arr, l, r);
		sort(arr, l, p - 1);
		sort(arr, p + 1, r);
	}

	/**
	 * arr[l+1...j]<v,arr[j+1...i]>v
	 *
	 * @param arr partition 数组
	 * @param l   左边界
	 * @param r   右边界
	 *
	 * @return
	 */
	private static int partition(int[] arr, int l, int r) {
		int j = l;

		for (int i = l + 1; i <= r; i++) {
			if (arr[i] <= arr[l]) {
				j++;
				swap(arr, j, i);
			}
		}

		swap(arr, j, l);

		return j;
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

	public static boolean isSorted(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr = new int[20];

		System.out.println("排序前：");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(50);
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n排序后：");

		QuickSort.sort(arr);

		if (isSorted(arr)) {
			for (int j : arr) {
				System.out.print(j + " ");
			}
		}
	}
}
