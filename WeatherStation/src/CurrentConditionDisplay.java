import interfaces.DisplayElement;
import interfaces.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;

    public CurrentConditionDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current condition: " + temperature +
                "F degrees and " + humidity + "% humidity " +
                "and Pressure is " + pressure + " atm");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity=humidity;
        this.pressure = pressure;
        display();
    }
}
