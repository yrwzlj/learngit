package Cat_cafe;

public class OrangeCat extends Cat{
    boolean isFat;
    public OrangeCat(String n,int a,String s,boolean f){
        super(n,a,s,200);
        isFat=f;
    }
    public String toString(){
        if (isFat)
            return getName()+" "+getAge()+" "+getSex()+" "+"丰腴"+" "+"为你提供服务";
        else return getName()+" "+getAge()+" "+getSex()+" "+"瘦弱"+" "+"为你提供服务";
    }
}