package org.example.hexagonal.demoobserver.display;

import lombok.extern.slf4j.Slf4j;
import org.example.hexagonal.demoobserver.model.WeatherData;
import org.example.hexagonal.demoobserver.observer.Observer;

@Slf4j
public class TemperatureDisplay implements Observer<WeatherData> {

    private float currentTemperature;

    public TemperatureDisplay() {
        log.info("Display de temperatura creado");
        this.currentTemperature = 0.0f;
    }

    @Override
    public void update(WeatherData weatherData) {
        if (weatherData != null) {
            this.currentTemperature = weatherData.getTemperature();
            display();
        }else {
            log.warn("Datos nulos");
        }
    }

    private void display(){
        log.info("Temperatura: " + this.currentTemperature);
    }

    public float getCurrentTemperature() {
        return currentTemperature;
    }

}
