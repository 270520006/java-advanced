package reflection;

public class PersonVO {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonVO{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", num=" + num +
                '}';
    }

    public PersonVO(String name, int gender, int age, int num) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.num = num;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String name="zsp";
    private int  gender;
    protected int age;
    int num=0;

    public PersonVO() {
    }




}
