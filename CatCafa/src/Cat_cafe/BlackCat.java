package Cat_cafe;

public class BlackCat extends Cat{
    public BlackCat(String n,int a,String s){
        super(n,a,s,300);
    }
    public String toString(){
        return getName()+" "+getAge()+" "+getSex()+" "+"为你提供服务";
    }
}