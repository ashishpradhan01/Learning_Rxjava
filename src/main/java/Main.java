import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromCallable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.List;
import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args){
//        throwException();
//        throwExceptionUsingCallable();
//        createObservableUsingEmpty();
        createObservableUsingNever();
    }

    private static void throwException() {
        //Create one Error Instance
        Observable observable = Observable.error(
                new Throwable("An Exception!!")
        );
        observable.subscribe(
                System.out::println,
                error -> System.out.println("Error Subscribe-1: " + error.hashCode())
        );
        observable.subscribe(
                System.out::println,
                error -> System.out.println("Error Subscribe-2: " + error.hashCode())
        );
    }

    private static void throwExceptionUsingCallable() {
        //Create different instance of error for different observer
        Observable observable = Observable.error(() -> new Throwable("Error"));

        observable.subscribe(
                System.out::println,
                error -> System.out.println("Error Subscribe-1: " + error.hashCode())
        );
        observable.subscribe(
                System.out::println,
                error -> System.out.println("Error Subscribe-2: " + error.hashCode())
        );
    }
    private static void createObservableUsingEmpty() {
        Observable observable = Observable.empty();
        observable.subscribe(
                System.out::println,
                System.out::println,
                ()->System.out.println("Completed")
        );
    }

    private static void createObservableUsingNever() {
        Observable observable = Observable.never();
        observable.subscribe(
                System.out::println,
                System.out::println,
                ()->System.out.println("Completed")
        );
    }
}

