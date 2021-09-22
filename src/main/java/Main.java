public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(Main::runIt);
        thread.start();
    }
    public static void runIt() {
        System.out.println("Thread name: "+Thread.currentThread().getName());
    }
}
