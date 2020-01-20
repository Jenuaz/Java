public class Main {
    public static void main(String argv[])
    {
        NewsAgency observable = new NewsAgency();
        NewsChannel observer = new NewsChannel();

        observable.addObserver(observer);
        observable.setNews("This is news!");
        System.out.println(observer.getNews());
        return;
    }
}
