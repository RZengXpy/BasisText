package javase.day3;

import java.util.TreeSet;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/9 15:16
 */
public class CollectionSet {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        //添加
        treeSet.add(new Integer(22));
        treeSet.add(new Integer(45));
        treeSet.add(new Integer(82));
        treeSet.add(new Integer(95));

        //判断集合里是否包含某个元素
        boolean flag =treeSet.contains(new Integer(45));
        if(flag) System.out.println("存在");

        //删除
        flag =treeSet.contains(new Integer(82));
        if(flag) System.out.println("存在");
        treeSet.remove(new Integer(82));
        flag =treeSet.contains(new Integer(82));
        if(flag) System.out.println("存在");
        else  System.out.println("不存在");

    }
}
