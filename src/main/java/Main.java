import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.List;



public class Main {
    public static void main(String[] args){
       // Cold Observable create three ways:- just, create, fromIterable
        // Hot Observable : from cold observable using connectable observable
        createHotObservable();
    }

    private static void createHotObservable() {
       // Observable<Integer> observable = Observable.just(1,2,3,4,5);
        ConnectableObservable<Integer> observable = Observable.just(1,2,3,4,5).publish(); //Hot Observable
        observable.subscribe(item -> System.out.println("Observable-1: "+ item));
        observable.subscribe(item -> System.out.println("Observable-2: "+ item));
        observable.connect();
    }
}
