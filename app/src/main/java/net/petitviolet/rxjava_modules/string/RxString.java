package net.petitviolet.rxjava_modules.string;

import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import rx.Observable;
import rx.observables.StringObservable;

public class RxString {
    private static final String TAG = RxString.class.getSimpleName();

    public static void testString() {

        Observable<String> toSplit = Observable.just("a,b,c");
        StringObservable
                .split(toSplit, ",")
                .subscribe(RxString::log);

        Observable<String> toByLine = Observable.just("x\ny\nz\n");
        StringObservable
                .byLine(toByLine)
                .subscribe(RxString::log);
        // == StringObservable.split(toByLine, "\n")

        Observable<String> toJoin = Observable.just("x", "y", "z");
        StringObservable
                .join(toJoin, ":")
                .subscribe(RxString::log);

        Observable<String> toConcat = Observable.just("A", "B", "C");
        StringObservable
                .stringConcat(toConcat)
                .subscribe(RxString::log);
        // == StringObservable.join(toConcat, "")

//        java.lang.NoClassDefFoundError: rx.internal.operators.OnSubscribeInputStream
//        String toFrom = "string";
//        InputStream toFromIS = new ByteArrayInputStream(toFrom.getBytes());
//        StringObservable.from(toFromIS, 2)
//                .subscribe(RxString::log);

    }

    private static void log(Object msg) {
        Log.d(TAG, "" + msg);
    }
}