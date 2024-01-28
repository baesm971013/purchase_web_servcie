package hello.core.singleton;

public class StatefulService {
    private int price; // 상태유지

    public void order(String name, int price){
        System.out.println(name + price);
        this.price = price;
    }
    public int getPrice(){
        return price;
    }
}
