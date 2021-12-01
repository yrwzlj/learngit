package que3;

public class nprocess {
    //利用wait 和 notify
    public void ExOut(int [] arr1,int [] arr2){
        final Object obj=new Object();
        var a1=new Thread(() -> {
            synchronized (obj) {
                for (int i:arr1)
                {
                    System.out.printf(i+" ");
                    try{
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        });
        a1.start();
        var a2=new Thread(() -> {
            synchronized (obj) {
                for (int i:arr2)
                {
                    System.out.printf(i+" ");
                    try{
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        });
        a2.start();
    }
}
