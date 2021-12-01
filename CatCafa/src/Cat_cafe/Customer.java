package Cat_cafe;

import java.time.LocalDate;

public class Customer {
    @Override
    public String toString() {
        return name+"在"+ArriveTime+"入店想要rua猫"+cnt+"次";
    }
    private String name;
    private int cnt;
    private LocalDate ArriveTime;
    public Customer(String n,int c,LocalDate a){
        name=n;
        cnt=c;
        ArriveTime=a;
    }
    public int getCnt() {
        return cnt;
    }

    public String getName() {
        return name;
    }

    public LocalDate getArriveTime() {
        return ArriveTime;
    }
}
