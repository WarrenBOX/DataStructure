package com.tunbobo.Hashtable;

public class hashDemo {
    public static void main(String[] args) {
        Person person = new Person();
        int p1 = person.hashCode();

        Person person1 = new Person();
        int p2 = person1.hashCode();

        System.out.println(p1);//1324119927
        System.out.println(p2);//990368553

        System.out.println(p1 == p2);

        System.out.println(person); //com.tunbobo.Hashtable.Person@4eec7777            getClass().getName() + "@" + Integer.toHexString(hashCode())
        System.out.println(person1); //com.tunbobo.Hashtable.Person@3b07d329

        /**
         * String类的hash值
         * *重写了obj类的hashcode方法
         * **/

        String s1 = new String("abc");
        String s2 = "abc";

        System.out.println(s1.hashCode()); //96354
        System.out.println(s2.hashCode()); //96354

        System.out.println("重地".hashCode()); //1179395
        System.out.println("通话".hashCode()); //1179395
    }
}
