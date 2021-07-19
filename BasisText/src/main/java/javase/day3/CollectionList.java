package javase.day3;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/9 10:49
 */
public class CollectionList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.clear();
        for(int i=0; i<10 ; i++){
            arrayList.add(new Integer(i*i+i));
        }

        while(true){
            PrintArry(arrayList);
            System.out.println("1、增加；2、查询；3、修改；4、删除；0、退出");
            Scanner sc = new Scanner(System.in);
            switch (sc.next()){
                case "1":
                    break;
                case "2":Serach(arrayList);
                    break;
                case "3":break;
                case "4":break;
                case "0":return;
                default:
                    System.out.println("错误输入，请重试！");
                    break;
            }
        }


//        //增加
//        //add末尾增加元素
//        arrayList.add(new Integer(1));
//        arrayList.add(new Integer(2));
//        arrayList.add(new Integer(45));
//        //指定位置添加元素
//        arrayList.add(1,new Integer(3));
//        PrintArry(arrayList);
//
//        //查找
//        //根据索引查找元素，得到元素
//        Integer element = arrayList.get(2);
//        System.out.println(element);
//        //根据元素查找索引，得到索引
//        int index = arrayList.indexOf(new Integer(45));
//        System.out.println(index);
//        PrintArry(arrayList);
//
//        //修改
//        //根据索引修改元素
//        arrayList.set(index,new Integer(54));
//        PrintArry(arrayList);
//
//        //删除
//        //根据索引删除元素
//        arrayList.remove(3);
//        //根据元素值删除元素
//        arrayList.remove(new Integer(54));
//        PrintArry(arrayList);


    }
    public static void Serach(ArrayList<Integer> arrayList){
        Scanner sc = new Scanner(System.in);
        Integer x = Integer.valueOf(sc.next());
        switch (x){
            case 1:
                System.out.println("输入索引查找元素，请输入索引：");
                Scanner sca = new Scanner(System.in);
                Integer xx = Integer.valueOf(sca.next());
                //根据索引查找元素，得到元素
                Integer element = arrayList.get(xx);
                System.out.println(element);
                break;
            case 2:
                System.out.println("输入元素查找位置，请输入元素值：");
                Scanner sca1 = new Scanner(System.in);
                Integer xxx = Integer.valueOf(sca1.next());
                //根据元素查找索引，得到索引
                int index = arrayList.indexOf(xxx);
                System.out.println(index);
                break;
            case 0: return;
            default: System.out.println("错误输入，请重试！");
                break;
        }
    }
    //打印全部
    public static void PrintArry (ArrayList<Integer> arry){


        for(int a : arry){
            System.out.print(a+"\t");
        }
    }
}
