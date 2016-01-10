package net.petitviolet.rxjava_modules.debug;

import android.util.Log;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;

import rx.Observable;
import rx.plugins.DebugHook;
import rx.plugins.RxJavaPlugins;
import rx.plugins.SimpleContext;
import rx.plugins.SimpleDebugNotificationListener;
import static rx.plugins.SimpleDebugNotificationListener.NotificationsByObservable;

public class RxDebug {
    private static final String TAG = RxDebug.class.getSimpleName();
    public static void debug(List<Integer> list) {
        SimpleDebugNotificationListener listener = new SimpleDebugNotificationListener();
//        DebugHook<SimpleContext<?>> hook = new DebugHook<>(listener);
//
//        RxJavaPlugins.getInstance().registerObservableExecutionHook(hook);

        Observable.from(list)
                .flatMap(i -> Observable.from(Arrays.asList(i, i * 100)))
                .subscribe(integer -> {
                    Log.d(TAG, "integer -> " + integer);
                });

        SortedSet<NotificationsByObservable<?>> snapshot =
                listener.getNotificationsByObservable();

        Log.d(TAG, listener.toString(snapshot));

    }
}