package org.example.hexagonal.demoobserver.display;

import lombok.extern.slf4j.Slf4j;
import org.example.hexagonal.demoobserver.model.WeatherData;
import org.example.hexagonal.demoobserver.observer.Observer;
@Slf4j
public class HumidityDisplay implements Observer<WeatherData> {

    private float currentHumidity;
    public HumidityDisplay(){
        currentHumidity = 0.0f;
        log.info("Display de humedad creado");
    }

    @Override
    public void update(WeatherData weatherData) {
       if (weatherData != null){
           this.currentHumidity = weatherData.getHumidity();
           display();
       }else {
           log.warn("Datos nulos");
       }
    }

    private void display() {
        log.info("Humidity: " + currentHumidity);
    }

    public float getCurrentHumidity() {
        return currentHumidity;
    }
}
