package org.example.hexagonal.demoobserver.observer;

public interface Observer<T> {

    void update(T data);
}
