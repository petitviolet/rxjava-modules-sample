package net.petitviolet.rxjava_modules.math;

import android.util.Log;

import rx.Observable;
import rx.observables.MathObservable;

public class RxMath {
    private static final String TAG = RxMath.class.getSimpleName();
    public static void testMath() {
        Observable<Integer> src = Observable.just(1, 2, 3, 4, 5);
        MathObservable
                .averageInteger(src)
                .subscribe(RxMath::log);

        MathObservable
                .min(src)
                .subscribe(RxMath::log);

        MathObservable
                .max(src)
                .subscribe(RxMath::log);

        MathObservable
                .sumInteger(src)
                .subscribe(RxMath::log);


        Observable<User> users = Observable.just(
                new User("alice", "alice@aaa.com"),
                new User("bob", "bob-long-email@bbb.com"),
                new User("charley", "charley@ccc.com")
        );
        MathObservable
                .from(users)
                .averageInteger(u -> u.name.length())
                .subscribe(RxMath::log);

    }

    static class User {
        private final String name;
        private final String email;

        User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return "User(" + name + ", " + email + ")";
        }
    }

    private static void log(Object msg) {
        Log.d(TAG, "" + msg);
    }
}