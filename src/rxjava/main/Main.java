package rxjava.main;


import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
//        main.observable1();
//        main.observableFrom();
//        main.observableJust();

//        main.publishSubject1();
//        main.publishSubject2();
//        main.replaySubject();
        main.asyncSubject();

    }


    private void observable1() {
        Observable<Integer> observableString =
                Observable.create(new Observable.OnSubscribe<Integer>() {
                    @Override
                    public void call(Subscriber<? super Integer> observer) {
                        for (int i = 0; i < 5; i++) {
                            observer.onNext(i);
                        }
                        observer.onCompleted();
                    }
                });


        Subscription subscriptionPrint =
                observableString.subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("Observable completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("Oh no! Something wrong happened!");
                    }

                    @Override
                    public void onNext(Integer item) {
                        System.out.println("Item is " + item);
                    }
                });
    }

    private void observableFrom() {
        List<Integer> items = new ArrayList<Integer>();
        items.add(1);
        items.add(10);
        items.add(100);
        items.add(200);
        Observable<Integer> observableString = Observable.from(items);
        Subscription subscriptionPrint =
                observableString.subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("Observable completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("Oh no! Something wrong happened!");
                    }

                    @Override
                    public void onNext(Integer item) {
                        System.out.println("Item is " + item);
                    }
                });
    }

    private void observableJust() {
        Observable<String> observableString = Observable.just(helloWorld());
        Subscription subscriptionPrint =
                observableString.subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("Observable completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("Oh no! Something wrong happened!");
                    }

                    @Override
                    public void onNext(String message) {
                        System.out.println(message);
                    }
                });
    }

    private String helloWorld() {
        return "Hello World";
    }


    private void publishSubject1() {
        PublishSubject<String> stringPublishSubject = PublishSubject.create();
        Subscription subscriptionPrint = stringPublishSubject.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Observable completed");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Oh no! Something wrong happened!");
            }

            @Override
            public void onNext(String message) {
                System.out.println(message);
            }
        });
        stringPublishSubject.onNext("Hello World");
    }

    private void publishSubject2() {
        final PublishSubject<Boolean> subject = PublishSubject.create();
        subject.subscribe(new Observer<Boolean>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(Boolean completed) {
                System.out.println("Observable completed!");
            }
        });

        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 5; i++) {
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        }).doOnCompleted(new Action0() {
            @Override
            public void call() {
                subject.onNext(true);
            }
        }).subscribe();
    }

    private void behaviorSubject() {
        BehaviorSubject<Integer> behaviorSubject =BehaviorSubject.create(1);

        behaviorSubject.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Observable completed");
            }
            @Override
            public void onError(Throwable e) {
                System.out.println("Oh no! Something wrong happened!");
            }
            @Override
            public void onNext(Integer message) {
                System.out.println(message);
            }
        });
    }

    private void replaySubject() {
        ReplaySubject<Integer> replaySubject = ReplaySubject.create();

        replaySubject.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Observable completed");
            }
            @Override
            public void onError(Throwable e) {
                System.out.println("Oh no! Something wrong happened!");
            }
            @Override
            public void onNext(Integer message) {
                System.out.println(message);
            }
        });
    }

    private void asyncSubject() {
        AsyncSubject<Integer> asyncSubject = AsyncSubject.create();

        asyncSubject.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Observable completed");
            }
            @Override
            public void onError(Throwable e) {
                System.out.println("Oh no! Something wrong happened!");
            }
            @Override
            public void onNext(Integer message) {
                System.out.println(message);
            }
        });
    }




}