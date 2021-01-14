package pres.lanqiao.ds;

/**
 * @author Nil
 */
public class HalfSearch {
	public static int halfS(int[] array, int key) {
		int min, max, mid;//分别为最小值,最大值,和中间值
		min = 0;
		max = array.length - 1;
		mid = (max + min) / 2;//这应该就是二分的核心了,
		//当key = arr[mid]说明已经找到了这个数据,所以while循环的条件是!=
		while (array[mid] != key) {
			if (key > array[mid]) {
				min = mid + 1;
			} else if (key < array[mid]) {
				max = mid - 1;
			}
			if (max < min) {
				return -1;
			}
			mid = (max + min) / 2;
		}
		//返回值为对应key值得下标
		return mid;
	}
}
