public class Fibonacci {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr , 99));
    }

    public static int maxSize = 20;

    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    // 斐波那契查找（其实就是每次查找的点，都接近把数组划分成0.618比率，左边元素个数/总元素个数 约等于 0.618）
    // 大致就是想要每次查找按照（查找点左侧元素/总元素个数）接近0.618的比率获取查找元素下标。
    // 因为斐波那契查找，相邻两项前后的比值接近0.618，然后就根据斐波那契数列的规律利用到查找算法中。
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        // 表示斐波那契分割数值的下标
        int k = 0;
        int mid = 0;
        int f[] = fib();
        // 获取斐波那契分割数值下标，根据查找数组的长度，决定需要多少个斐波那契数值
        while(high > f[k] - 1) {
            k++;
        }
        // 因为f[k]值可能大于a的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向a[]
        // 不足的部分会使用0填充
        int[] temp = Arrays.copyOf(a, f[k]);
        // 实际上需求使用a数组最后的数填充temp
        // 例如：temp = {1,8,10,89,1000,1234,0,0,0} => {1,8,10,89,1000,1234,1234,1234}
        for(int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }
        // 使用while来循环处理，找到我们的数key
        while(low <= high) {
            mid = low + f[k - 1] - 1;
            // 我们应该继续向数组左边查找
            if(key < temp[mid]) {
                high = mid - 1;
                // 为什么是k--
                // 全部元素 = 前面元素 + 后边元素 f[k] = f[k - 1] + f[k - 2]
                // 因为前面有f[k - 1]个元素，所以可以继续拆分f[k - 1] = f[k - 2] + f[k - 3]
                // 即在f[k - 1]左部继续查找k--，即下次循环mid = f[k - 1 - 1] - 1
                k--;
            } else if(key > temp[mid]) {
                // 全部元素 = 前面元素 + 后边元素 f[k] = f[k - 1] + f[k - 2]
                // 右边查找
                low = mid + 1;
                k -= 2;
            } else {
                return Math.min(mid, high);
            }
        }
        return -1;
    }
}