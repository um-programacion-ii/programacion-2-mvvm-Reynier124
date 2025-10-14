package org.example.hexagonal.demoobserver.subject.implementation;

import lombok.extern.slf4j.Slf4j;
import org.example.hexagonal.demoobserver.model.WeatherData;
import org.example.hexagonal.demoobserver.observer.Observer;
import org.example.hexagonal.demoobserver.subject.Subject;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WeatherStation implements Subject<WeatherData> {

    private final List<Observer<WeatherData>> observers = new ArrayList<>();
    private WeatherData weatherData;

    @Override
    public void registerObserver(Observer<WeatherData> observer) {
        observers.add(observer);
        log.info("Nuevo observador registado. Total de registros: " + observers.size());
    }

    @Override
    public void removeObserver(Observer<WeatherData> observer) {
        observers.remove(observer);
        log.info("Observador removido. Total de registros: " + observers.size());
    }

    @Override
    public void notifyObservers() {
        log.info("Notificando a {} observadores sobre cambios climaticos.", observers.size());
        for (var observer : observers) {
            observer.update(weatherData);
        }
    }

    @Override
    public List<Observer<WeatherData>> getObservers() {
        return new ArrayList<>(observers);
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        log.info("Actualizando mediciones - Temp: {}, Hum: {}, Press: {}.", temperature, humidity, pressure);
        this.weatherData = new WeatherData(temperature, humidity, pressure);
        measurementsChanged();
    }

    public void setMeasurements(float temperature, float humidity) {
        log.info("Actualizando mediciones - Temp: {}, Hum: {}.", temperature, humidity);
        this.weatherData = new WeatherData(temperature, humidity);
        measurementsChanged();
    }

    private void measurementsChanged() {
        log.info("Notificando a los observadores sobre los cambios.");
        notifyObservers();
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }
}
