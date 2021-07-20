/**
 * @author yujiale
 * @Classname Person
 * @Description TODO
 * @Date 2021/7/20 下午8:53
 * @Created by yujiale
 */
public class Person implements Comparable<Person> {
    private int age;



    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compateTo(Person p) {
        // if (this.age >p.age){
        //     return 1;
        // } else if (this.age<p.age){
        //     return -1;
        // }else {
        //     return 0;
        // }
        return age - p.age;
    }
}
