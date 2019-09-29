package behavioral.observer;


/*
    被观察者维护一个列表，记录观察者信息
    观察者注册时被添加到该列表，
    数据变动时，被观察者遍历列表，通知观察者
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

        WeatherData2 weatherData2 = new WeatherData2();
        CurrentConditionsDisplay2 display2 = new CurrentConditionsDisplay2(weatherData2);
        weatherData2.setMeasurements(80, 65, 30.4f);
        weatherData2.setMeasurements(82, 70, 29.2f);
        weatherData2.setMeasurements(78, 90, 29.2f);
    }
}
