package Cat_cafe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MyCatCafe implements CatCafe{
    private double balance;
    ArrayList<Cat> cats;
    ArrayList<Customer> customers;
    public  MyCatCafe(double b){
        balance=b;
        cats=new ArrayList<>();
        customers=new ArrayList<>();
    }
    public void BuyinCat() throws InsufficientBalanceException {
        System.out.println("欢迎光临");
        while (true)
        {
            System.out.println("请输入你想要购买的猫类型，橘猫200元一只，黑猫350元一只");
            Scanner scanner=new Scanner(System.in);
            String type=scanner.next();
            if (type.equals("橘猫"))
            {
                if (balance>=200)
                {
                    System.out.println("请给你买的猫去一个名字吧，以及说明你想要购买的猫的猫龄,性别和体型是否丰腴");
                    System.out.println("例如:短短 1 公 true(或false)（务必按照这个格式）");
                    String name=scanner.next();
                    int age=scanner.nextInt();
                    if (age<=0) throw new CatAgeWrongException("猫猫年龄不能小于等于0");
                    String sex=scanner.next();
                    boolean isFat=scanner.nextBoolean();
                    OrangeCat oc=new OrangeCat(name,age,sex,isFat);
                    System.out.println("成功购入橘猫一只");
                    cats.add(oc);
                    balance -= 200;
                    break;
                }
                else
                {
                    throw new InsufficientBalanceException("店铺余额小于200,无法购入橘猫");
                }
            }
            else if (type.equals("黑猫"))
            {
                if (balance>=350)
                {
                    System.out.println("请给你买的猫去一个名字吧，以及说明你想要购买的猫的猫龄,性别");
                    System.out.println("例如:短短 1 公（务必按照这个格式）");
                    String name=scanner.next();
                    int age=scanner.nextInt();
                    if (age<=0) throw new CatAgeWrongException("猫猫年龄不能小于等于0");
                    String sex=scanner.next();
                    BlackCat bc=new BlackCat(name,age,sex);
                    cats.add(bc);
                    System.out.println("成功购入黑猫一只");
                    balance-=350;
                    break;
                }
                else
                {
                    throw new InsufficientBalanceException("店铺余额小于350,无法购入黑猫");
                }
            }
            else if (type.equals("886"))
            {
                break;
            }
            else
            {
                System.out.println("小店销售品种仅黑猫及橘猫");
                System.out.println("顾客若想继续购买猫,请说明购买品种,若不想,请输入886");
            }
        }

    }

    public void TreatCus(Customer i) throws CatNotFoundException{
        if (cats.size()==0)
        {
            throw new CatNotFoundException("店铺中无猫,无法rua猫了");
        }
        customers.add(i);
        int temp=i.getCnt();
        for (int j = 0; j < temp; j++) {
            balance+=15;
            Random num=new Random();
            int n=num.nextInt(cats.size());
            System.out.println(cats.get(n).toString());
            System.out.println("顾客请尽情rua它吧");
        }
    }
    public void CloseDown(){
        LocalDate localdate=LocalDate.now();
        int sum=0;
        for (int j=0;j<customers.size();j++)
        {
            if (localdate.equals(customers.get(j).getArriveTime()))
            {
                System.out.println(customers.get(j).getName());
                sum += customers.get(j).getCnt();
            }
        }
        System.out.printf("今天总收入%d",sum*15);
    }

    public ArrayList<Cat> getCats() {
        return cats;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public double getBalance() {
        return balance;
    }
}
