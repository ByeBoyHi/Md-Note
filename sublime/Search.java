public class Search{
	// 二分查找
	public static int binaSearch(int flag, int[] num){
		int low = 0;
		int high = num.length();
		int mid = (low+high)/2;
		while(flag!=num[mid] && low<high){
			if(flag>num[mid]){
				low = mid+1;
				mid = (low+high)/2;
			}else{
				high = mid-1;
				mid = (low+high)/2;
			}
		}
		if(low<high){
			return mid;
		}else{
			return -1;
		}
	}
}