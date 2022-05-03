package code18_设计模式.test02_模板模式.demo01;

/*
 * 排序工具类，抽象类
 */
public abstract class SortUtil<T> {
	
	//将部分逻辑以具体方法的形式实现
	public void sort(T[] arr){
		// 先制定一个顶级逻辑框架
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-i-1;j++){
				// 将逻辑的细节留给具体的子类来实现
				int m = compareTo(arr[j],arr[j+1]);
				if(m>0){
					T temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
	}
	
	// 声明一些抽象方法来迫使子类实现剩余的逻辑
	public abstract int compareTo(T o1,T o2);
	
}
