package Cat_cafe;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class text {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        MyCatCafe cf=new MyCatCafe(500);
        System.out.println("今天要买几只猫呢");
        int num=scanner.nextInt();
        for (int j = 0; j < num; j++) {
            try{
                cf.BuyinCat();
            } catch (InsufficientBalanceException | CatAgeWrongException e){
                System.out.println(e);
            }
            if (cf.getBalance()<200)
            {
                System.out.println("店主，余额不够了，明天再来吧");
                break;
            }
        }
        System.out.println("顾客,请在此填写你的信息,姓名及想rua猫次数");
        System.out.println("例如 张三 5");
        String name=scanner.next();
        int cnt=scanner.nextInt();
        LocalDate localdate=LocalDate.now();
        Customer i=new Customer(name,cnt,localdate);
        System.out.println(i.toString());
        try {
            cf.TreatCus(i);
        } catch (CatNotFoundException e) {
            System.out.println(e);
        }
        cf.CloseDown();
    }
}
