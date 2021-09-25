import io.reactivex.rxjava3.core.Observable;

public class Main {
    public static void main(String[] args){
//        createObservableUsingRange();
        createObservableUsingDefer();
    }

    private static void createObservableUsingRange() {
        // Observable using Range
        Observable<Integer> observable = Observable.range(1,10);
        observable.subscribe(System.out::println);
        // Formula to calculate range of numbers : [n, n+m-1] --> range(1, 1+10-1) -->[1,2,3,...,10]
    }

    public static int start=1, count=3;
    private static void createObservableUsingDefer() {
        // Defer Care for state change
        Observable<Integer> observable = Observable.defer(() -> Observable.range(start, count));
        observable.subscribe(integer -> {
            System.out.println("Observable-1 "+integer);
        });
        count = 5;
        observable.subscribe(integer -> {
            System.out.println("Observable-2 "+integer);
        });
    }
}

