package edu.galileo.android.androidchat.lib;

/**
 * Created by Alex on 10-06-2016.
 */
public interface EventBus {

    void register (Object subscriber);
    void unregistrer(Object subscriber);
    void post(Object event);
}
