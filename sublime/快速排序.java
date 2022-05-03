public class 快速排序{

	public static void main(String[] args){
		int[] arr = {5,2,4,57,3,4,31,56,8,38};
		QuickSort(arr, 0, arr.length);
		System.out.println(arr);
	}

	public static void QuickSort(int[] arr, int low, int high){
		if (low<high) {
			// 1. 进行划分：以povit为分界线
			int povit = Partition(arr, low, high);
			// 2. 左子表递归排序
			QuickSort(arr, low, povit-1);  // 从low到povit-1
			// 3. 右子表递归排序
			QuickSort(arr, povit+1, high); // 从povit+1到high
		}
	}

	// 参数：数组，low，high
	// 返回值：返回基准的最终确认位置 int
	// 划分保证左边的比基准小，右边的比基准大，并且时刻保证low<high
	// 如果low=high，则退出，等于的位置就是确定的位置
	public static int Partition(int[] arr, int low, int high){
		// 确定第一个元素为基准，这时候第一个位置相当于空，则从不空的那一边开始排。
		// 你也可以选最后一个元素为基准，这个不影响
		int tag = arr[0];
		// 开始划分
		while(low<high){
			while(low<high && arr[high]>tag) high--; // 如果高位大于基准，就high不断左移
			arr[low] = arr[high]; // 找到个比基准小的元素或者low和high相等，就退出上面的循环，然后把高位赋值到低位（相当于把小值往左放）
			while(low<high && arr[low]<tag) low++; // 如果低位小于基准，就low不断右移
			arr[high] = arr[low]; // 找到个比基准大的元素或者low和high相等，就退出上面循环，然后把低位赋值到高位（相当于把大值往右放）
		}
		// 最终退出循环low==high
		// 把基准放进最终确定的位置
		// 并把基准下标返回出去，便于下次左右子表的划分
		arr[low] = tag;
		return low;
	}
}