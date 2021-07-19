package javase.day1;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/7 18:48
 */
public class BoomSort {
    public static void main(String[] args) {
        int[] a = {5, 9, 8, 7, 1, 155, 10, 8};

        int m, k, s;
        int flag=1;
        k = a.length;
        //冒泡排序
//        while(k>0&& flag==1) {
//            flag = 0;
//            for (int i = 0; i < a.length - 1; i++) {
//                if (a[i] > a[i + 1]) {
//                    flag=1;
//                    m = a[i];
//                    a[i] = a[i + 1];
//                    a[i + 1] = m;
//                }
//            }
//            k--;
//        }
        //选择排序
        for(int i=0 ; i<a.length-1 ; i++){
            s=i;
            for(int j=i+1; j<a.length ; j++){
                if(a[s]>a[j]){
                    s=j;
                }
            }
            if(s!=i){
                m=a[i];
                a[i]=a[s];
                a[s]=m;
            }
        }
        for (int aa : a) {
            System.out.print(aa + "\t");
        }
        System.out.println();
        //二分查找
        int low = 1 , high = a.length;
        int mid=0,ser=9;
        while(low<=high){
            mid=(low+high)/2;
            if(ser == a[mid])
                break;
            else if(ser<a[mid]) high=mid-1;
            else low=mid+1;
        }
        System.out.println("找到了，位置为："+(mid+1));
    }
}
