package edu.galileo.android.facebookrecipes.libs.base;

/**
 * Created by Alex on 18-06-2016.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
