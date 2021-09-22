import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

import java.util.List;

public class Main {
    public static void main(String[] args){
        createObservablesWithJust();
        createObservablesWithIterable();
        createObservablesUsingCreate();
    }

    private static void createObservablesUsingCreate() {
        Observable<Integer> observable = Observable.create(emitter -> {
           emitter.onNext(1);
           emitter.onNext(2);
           emitter.onNext(3);
           emitter.onComplete();
        });
        observable.subscribe(
                integer -> System.out.println(integer),
                error -> System.out.println(error.getLocalizedMessage()),
                ()-> System.out.println("Completed!!"));
    }

    private static void createObservablesWithIterable() {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);
        Observable<Integer> observable = Observable.fromIterable(list);
        observable.subscribe(System.out::println);
    }

    public static void createObservablesWithJust() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5,6);

        //Subscribe->Consumer
        // We can reduce lines of code by using lambada and method reference
        observable.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Throwable {
                System.out.println(integer);
            }
        });

    }

}
