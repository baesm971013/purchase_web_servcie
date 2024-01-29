package hello.core.singleton;

public class StatefulService {
    //
    // private int price; // 상태유지

    public int  order(String name, int price){
        System.out.println(name + price);
        return price;

    }
//    public int getPrice(){
//        //
//    }
}
