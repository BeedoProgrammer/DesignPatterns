package Observer;

import java.util.*;

public interface Observer {
    public void update(String weather);
}

interface WeatherStation{
    public void subscribe(Observer observer);
    public void unsubscribe(Observer observer);
    public void Notify();
}

class WeatherService implements WeatherStation{
    private ArrayList<Observer> observers;
    private String weather;

    public WeatherService() {
        weather = "";
        observers = new ArrayList<>();
    }

    public void setWeather(String weather) {
        this.weather = weather;
        Notify();
    }
    
    @Override
    public void subscribe(Observer observer){
        observers.add(observer);
    }
    
    @Override
    public void unsubscribe(Observer observer){
        observers.remove(observer);
    }
    
    @Override
    public void Notify(){
        for(int i = 0; i < observers.size(); i++)
            observers.get(i).update(weather);
    }
    
}

class MobileSubscriber implements Observer{
    private String weather;
    
    @Override
    public void update(String weather){
        this.weather = weather;
        display();
    }
    
    private void display(){
        System.out.println("(Mobile)Weather is: " + weather);
    }
}

class TvSubscriber implements Observer{
    private String weather;
    
    @Override
    public void update(String weather){
        this.weather = weather;
        display();
    }
    
   private void display(){
       System.out.println("(TV)Weather is: " + weather);
   }
}

class WeatherApp {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();

        Observer mobileSubscriber = new MobileSubscriber();
        Observer tvSubscriber = new TvSubscriber();

        weatherService.subscribe(mobileSubscriber);
        
        weatherService.setWeather("Storm Incomming");
    }
}

