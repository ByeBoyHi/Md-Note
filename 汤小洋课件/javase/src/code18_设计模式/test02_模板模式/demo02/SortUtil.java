package code18_设计模式.test02_模板模式.demo02;

/*
 * 排序工具类
 */
public class SortUtil {
	
	//将部分逻辑以具体方法的形式实现
	public static <T> void sort(T[] arr,Comparator<T> t){
		// 先制定一个顶级逻辑框架
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-i-1;j++){
				// 将逻辑的细节留给具体的子类来实现
				int m = t.compareTo(arr[j],arr[j+1]);
				if(m>0){
					T temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
	}
}
