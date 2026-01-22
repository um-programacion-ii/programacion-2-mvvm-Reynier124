package org.example.hexagonal.demoobserver.subject;

import org.example.hexagonal.demoobserver.observer.Observer;

import java.util.List;

public interface Subject<T> {
    void registerObserver(Observer<T> observer);
    void removeObserver(Observer<T> observer);
    void notifyObservers();
    List<Observer<T>> getObservers();
}
