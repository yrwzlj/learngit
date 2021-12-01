package Cat_cafe;

abstract class Cat {
    private String name;
    private int age;
    private double price;
    private String sex;
    public Cat(String n,int a,String s,double p){
        name=n;
        age=a;
        price=p;
        sex=s;
    }
    public abstract String toString();
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    public double getPrice() {
        return price;
    }

    public String getSex() {
        return sex;
    }
}


