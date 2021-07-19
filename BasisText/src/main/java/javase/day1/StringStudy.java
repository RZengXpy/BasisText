package javase.day1;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/7 16:44
 */
public class StringStudy {
    public static void main(String[] args) {
        String str = "HelloWorld";
        System.out.println(str);
        //replace方法返回一个string对象,直接调用，不改变string的值
        System.out.println(str.replace("l","L"));

        StringBuffer stringBuffer = new StringBuffer("helloworld");
        System.out.println(stringBuffer);
        stringBuffer.replace(0,1,"aaaa");
        System.out.println(stringBuffer);

        String string = "abc,de,fg,hijk";
        String [] ss = string.split(",");
        for(String s : ss)
            System.out.print(s+"\t");
    }
}
