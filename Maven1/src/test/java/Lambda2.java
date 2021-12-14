/*
 * Copyright (c) 2018, 2021, github.com/Gudark All rights reserved.
 *
 */

import java.util.Comparator;
import java.util.function.*;

/**
 * <p>Project: Maven1 - Lambda2
 * <p>Powered by Gudark On 2021/12/23 16:45
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public class Lambda2 {
    public static void main(String... args) {
        /*******************方法引用*********************/
        //类：：静态方法名
        Comparator<Integer> cc = (x, y) -> Integer.compare(x, y);
        System.out.println(cc.compare(3, 2));
        Comparator<Integer> bb = Integer::compare;
        System.out.println(bb.compare(3, 2));

        Comparator<Integer> dd = (x, y) -> x.compareTo(y);
        System.out.println(dd.compare(3, 2));
        Comparator<Integer> ee = Integer::compareTo;
        System.out.println(ee.compare(3, 2));
        //类：：实例方法名
        //BiPredicate<T,U> 代表一个 两个参数的boolean值 方法
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        System.out.println(bp.test("a", "b"));
        BiPredicate<String, String> bp1 = String::equals;
        System.out.println(bp1.test("a", "b"));
        //Consumer消费型 接受一个对象处理，无返回值
        Consumer<String> con1 = x -> System.out.println(x);
        con1.accept("abc");
        Consumer<String> con2 = System.out::println;
        con2.accept("abc");

        Emp emp = new Emp("上海", "xiaoming", 10);
        //Supplier供给型 提供一个对象
        Supplier<String> supper1 = () -> emp.getAddress();
        System.out.println(supper1.get());
        Supplier<String> supper2 = emp::getAddress;
        System.out.println(supper2.get());
        /*******************构造器引用*********************/
        //无参构造函数，创建实例
        Supplier<Emp> supper3 = () -> new Emp();
        Supplier<Emp> supper4 = Emp::new;
        Emp emp1 = supper4.get();
        emp1.setAddress("上海");
        //一个参数
        //Function函数型 转换一个对象为不同类型的对象
        Function<String, Emp> fun = address -> new Emp(address);
        Function<String, Emp> fun1 = Emp::new;
        System.out.println(fun1.apply("beijing"));
        //两个参数
        //BiFunction 代表一个 接受两个输入参数的方法，并且返回一个结果
        BiFunction<String, Integer, Emp> bFun = (name, age) -> new Emp(name, age);
        BiFunction<String, Integer, Emp> bFun1 = Emp::new;
        System.out.println(bFun1.apply("xiaohong", 18));
    }

    static class Emp {
        private String address;
        private String name;
        private Integer age;

        public Emp() {

        }

        public Emp(String address) {
            this.address = address;
        }

        public Emp(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Emp(String address, String name, Integer age) {
            super();
            this.address = address;
            this.name = name;
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String toString() {
            return "Emp [address=" + address + ",name=" + name + ",age=" + age + "]";
        }
    }
}
