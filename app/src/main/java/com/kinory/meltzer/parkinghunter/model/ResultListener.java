package com.kinory.meltzer.parkinghunter.model;

/**
 * Created by Gilad Kinory on 23/09/2017.
 * e-mail: giladkinory2000@gmail.com
 *
 *
 * An interface of a listener used by methods that work asynchronously to return their results.
 * @param <T> The type of the results.
 */
public interface ResultListener<T> {
    void onGetResult(T result);
}
