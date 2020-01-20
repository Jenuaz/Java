public class Main {
    public static void main(String agr[]){
        ONewsAgency maxim = new ONewsAgency();
        ONewsChannel receiver = new ONewsChannel();
        maxim.addObserver(receiver);
        maxim.setNews("New news!");
        System.out.println(receiver.getNews());
    }
}
