public class Sort{

	// 冒泡排序
	public static int PopoSort(int[] a){
		int count1,count2;
		int n = a.length;
		// 优化：因为如果某一圈冒泡比较下去后，发现都已经符合规则了，说明这时候已经排序完毕了，后面的循环就没有必要了，可以通过flag进行提前退出循环。
		boolean flag = true;
		for(int i=0;i<n && flag;i++){
			for(int j=n-1;j>i;j--){
				count1++;
				flag = false;
				if (a[j]<a[j-1]){
					count2++
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
					flag = true;
				}
			}
		}
		System.out.println("共比较了"+count1+"次,共移动了"+count2+"次。");
	}

	// 选择排序
	public static int SelectSort(int[] a){
		int n = a.length;
		for (int i=0;i<n-1;i++) {
			// 从第i个开始比较，比较到n-2个
			int min = i;
			for (int j=i+1;j<n;j++) {
				// 比较出最小的，放出去
				if (a[j]<a[min]) {
					min = j;
				}
			}
			if (min!=i) {
				int temp = a[min];
				a[min] = a[i];
				a[i] = temp;
			}
		}
	}

	// 直接插入排序
	public static void InsertSort(int[] a){
		int n = a.length;
		for (int i=1;i<n;i++) {
			int temp = a[i];
			for (j=i-1;a[j]>temp && j>=0;j--) { // 和取到的元素比较，并且往后移动，找到一个比这个元素小的或者找到最头部，就退出循环
				a[j+1] = a[j]; // 只要比Temp大，就往前覆盖
			}
			a[j+1] = temp;
		}
	}

	// 希尔排序
	public static void ShellSort(int[] a){
		int n = a.length;
		int temp;
		int gap = n; // gap间隔进行交换，并且依次后移减小
		do{
			gap = gap/3+1;
			for (int i=gap; i<n; i++) {
				temp = a[i];
				for (int j=i-1; a[j]>temp; j-=gap) {
					a[j+gap] = a[j];
				}
				a[j+gap] = temp;
			}
		}while(gap>1)
	}

	// 堆排序
	public static void HeapSort(int[] a, int n){
		for (int i=n/2;i>0;i--) {
			HeapAdjust(k,i,n); // 将n个数据建立成大顶堆
		}

		for (int i=n;i>1;i--) {
			swap(k,1,i); // 互换位置
			HeapAdjust(k,1,i-1); // 将剩下的i-1个元素，建立大顶堆
		}
	}
	// 交换元素
	public static void swap(int[] a, int i, int j){
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	// 建立大顶堆
	// 第一步：3，4，1
	// 第二步：3，1，4
	// 第三步：4，1，4
	// 第四步：4，1，3
	public static void HeapAdjust(int[] a, int s, int n){
		int temp = a[s]; // 存储最初传入的双亲节点值
		for (int i=2*s; i<=n; i*=2) { // 2*s 取 s 的孩子
			if (i<n && a[i]<a[i+1]) { // i<n确定不是最后一个节点，如果右孩子大于左孩子
				i++; // i++，实现指向右孩子
			}
			if (temp>=a[i]) { // 如果双亲大于等于自己的孩子，则直接退出循环，因为符合大顶堆要求
				break;
			}
			a[s] = a[i]; // 把大值存入指定的双亲节点
			s = i; // 因为双亲的节点比较小，所以让双亲的判断点后移，移动到第i个
		}
		a[s] = temp; // temp原来存的双亲值给了新的双亲节点
	}
	// 建立小顶堆
	// 第一步：3，1，4
	// 第二步：3，4，1
	// 第三步：1，4，1
	// 第四步：1，4，3
	public static void HeapAdjust2(int[] a, int s, int n){
		int temp = a[s];   // 存储最初传入的双亲节点值
		for (int i=2*s; i<=n; i++) {
			if (a[i]<a[i+1]) {
				i++;
			}
			if (temp<a[i]) {
				break;
			}
			a[s] = a[i];
			s = i;
		}
		a[s] = temp;
	}

	// 归并排序
	// 递归
	public static int MergeSort(int[] a){
		int n = a.length;
		if (n>1) {
			int[n] list1 = a; 
			int list1_size = n/2;// 从开头的位置
			int[n] list2 = a; 
			int list2_size = n - list1_size; // 从n/2到尾部
			MergeSort(list1,list1_size);
			MergeSort(list2,list2_size);

			merging(list1,list1_size,list2,list2_size);
		}
	}
	// 归并：把最后的结果存放到list1里面
	public static void merging(int[] list1, int list1_size, int[] list2, int list2_size){
		int[] temp = new int[list1_size+list2_size];
		int i=0;
		int j=0;
		int k=0;
		while(i<list1_size && j<list2_size){
			if (list1[i]<list2[j]) { // 把小值存放进temp中
				temp[k++] = list1[i++];
			}else {
				temp[k++] = list2[j++];
			}
		}

		while(i<list1_size){
			temp[k++] = list1[i++];
		}
		while(j<list2_size){
			temp[k++] = list2[i++];
		}

		for (int m=0; m<temp.length; m++) {
			list1[m] = temp[m];
		}
	}
	// 迭代
	public static void MergeSort2(int[] a){
		/*
			left_min,left_max:分别是左边一份的最左端和最右端
			right_min,right_max:分别是右边一份的最左端和最右端
		*/
		int left_min,left_max,right_min,right_max,next;
		int[] temp = new int[a.length];
		for (int i=1; i<n ; i*=2) { // 步长
			for (left_min=0; left_min<n-i; left_min=right_max) { // left_min=right_max是进行下一轮的比较
				left_max = left_min+i; // i是步长
				right_min = left_max;
				right_max = left_max+i;

				if (right_max>n) { // right_max可能大于n溢出
					right_max = n; // 则此时只能等于队尾
				}

				next = 0;
				while(left_min<left_max && right_min<right_max){
					if (a[left_min]<a[right_min]) {
						temp[next++] = a[left_min++];
					}else{
						temp[next++] = a[right_min++];
					}
				}

				while (left_min<left_max) {
					a[--right_min] = a[--left_min];
				}
				while(next>0){
					a[--right_min] = temp[--next];
				}
			}
		}
	}

// ==============================================================================
	// 快速排序
	// 调用函数
	public static int QuickSort(int[] a){
		QSort(a,0,a.length-1); // 三个参数：数组，初始位置，末尾位置
	}
	// 排序函数
	public static void QSort(int[] a, int low, int high){
		int point;
		if (low<high) {
			point = Partion(a, low, high);
			QSort(a, low ,point-1); // 左边递归
			QSort(a.point+1,high); // 右边递归
		}
	}
	// 基准点函数：左右对称交换法则，左边放小的，右边放大的。
	public static int Partion(int[] a, int low, int high){
		int point = a[low]; // 取第一位为基准点
		while(low<high){
			while(low<high && a[high]>=point){ // 与第一位进行比较，大的话，high--
				high--;
			}
			a = swap1(a,low,high); // 把小的和大的互换位置，把小的放在基准点

			while(low<high && a[low]<=point){ // 与第一位进行比较，大的话，high--
				low++;
			}
			a = swap1(a,low,high); // 把小的和大的互换位置，把大的放在基准点
			// 也就是左边小，右边大
		}
		return low;
	}
	public static int[] swap1(int[] a, int low ,int high){
		int[] k = a;
		int temp;
		temp = k[low];
		k[low] = k[high];
		k[high] = temp;
		return k;
	}
	// 快速排序优化:优化选取基准点
	public static int Partion(int[] a, int low, int high){
		int point;
		int mid = low+(high-low)/2;

		if (a[low]>a[high]) {
			a = swap1(a,low,high);
		}

		if (a[mid]>a[high]) {
			a = swap1(a,mid,high);
		}

		if (a[mid]>a[low]) {
			a = swap1(a,mid,low);
		}

		point = a[low]; // 取中间值为基准点，这样后面的排序就会基于中间值进行排，会防止极端情况出现导致的极低效率

		while(low<high){
			while(low<high && a[high]>=point){ // 与第一位进行比较，大的话，high--
				high--;
			}
			a = swap1(a,low,high); // 把小的和大的互换位置，把小的放在基准点

			while(low<high && a[low]<=point){ // 与第一位进行比较，大的话，high--
				low++;
			}
			a = swap1(a,low,high); // 把小的和大的互换位置，把大的放在基准点
			// 也就是左边小，右边大
		}
		return low;
	}
	// 快速排序优化：优化不必要的交换-->把交换变成赋值
	public static int Partion(int[] a, int low, int high){
		int point;
		int mid = low+(high-low)/2;

		if (a[low]>a[high]) {
			a = swap1(a,low,high);
		}

		if (a[mid]>a[high]) {
			a = swap1(a,mid,high);
		}

		if (a[mid]>a[low]) {
			a = swap1(a,mid,low);
		}
		point = a[low]; // 取中间值为基准点，这样后面的排序就会基于中间值进行排，会防止极端情况出现导致的极低效率
		
		while(low<high){
			while(low<high && a[high]>=point){ // 与第一位进行比较，大的话，high--
				high--;
			}
			// 把小的和大的互换位置，把小的放在基准点
			a[low] = a[high];

			while(low<high && a[low]<=point){ // 与第一位进行比较，大的话，high--
				low++;
			}
			// 把小的和大的互换位置，把大的放在基准点
			a[high] = a[low];
			// 也就是左边小，右边大
		}
		a[low] = point; // 把最初传进来的point值放进最后确定的low的位置，也就是排好序后的值。

		return low;
	}

	int num = 7;
	// 排序选择
	public static int[] QSort2(int[] a, int low, int high){
		int point;
		if ((high-low)>num) { // 数据过多的时候用快速排序
			point = Partion(a, low, high);
			a = QSort2(a, low ,point-1); // 左边递归
			a = QSort2(a.point+1,high); // 右边递归
		}else{  // 数据少的时候用直接插入排序
			a = InsertSort2(a,low,high);
		}
		return a;
	}
	public static int[] ISort(int[] a){
		int temp = a;
		int n = temp.length;
		for (int i=1;i<n;i++) {
			int temp2 = temp[i];
			for (j=i-1;temp[j]>temp2 && j>=0;j--) { // 和取到的元素比较，并且往后移动，找到一个比这个元素小的或者找到最头部，就退出循环
				temp[j+1] = temp[j]; // 只要比Temp大，就往前覆盖
			}
			temp[j+1] = temp2;
		}
		return temp;
	}
	public static int[] InsertSort2(int[] a, int low, int high){
		int[] temp = new int[high-low+1];
		for (int i=low; i<high; i++) {
			temp[i-low] = a[i];
		}
		return ISort(temp);
	}

	// 尾递归
	public static int[] QSort3(int[] a, int low, int high){
		int point;
		if (low < high) { // 数据过多的时候用快速排序
			point = Partion(a, low, high);
			if (point-low < high-low) {
				a = QSort3(a, low ,point-1); // 左边递归
				low = point+1;
			}else{
				a = QSort3(a,point+1,high);
				high = point-1;
			}
			
		}else{  // 数据少的时候用直接插入排序
			a = InsertSort2(a,low,high);
		}
		return a;
	}
// ==============================================================================

	
	public static void main(String[] args) {
		int[] a={3,4,2,1,5,3,6};
		MergeSort(a);
	}
}