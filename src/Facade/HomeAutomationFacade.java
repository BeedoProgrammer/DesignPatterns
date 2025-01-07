package Facade;

public class HomeAutomationFacade {
    // can take heatingSystem and lightingSystem as attributes to make it felxible
    public void changeTemperature(float x){
        HeatingSystem heatingSystem = new HeatingSystem(27);
        
        if(x < 0)
            heatingSystem.decreasetTemperature(Math.abs(x));
        else
            heatingSystem.increaseTemperature(x);
        heatingSystem.display();
    }
    
    public void controlLight(float x){
        LightingSystem lightingSystem = new LightingSystem(10);
        
        if(x < 0)
            lightingSystem.decreaseIntensity(Math.abs(x));
        else
            lightingSystem.increaseIntensity(x);
        lightingSystem.display();
    }
}

class LightingSystem{
    private float intensity;

    public LightingSystem(float intensity) {
        this.intensity = intensity;
    }
    
    public void increaseIntensity(float x){
        intensity += x;
    }
    
    public void decreaseIntensity(float x){
        if(x > intensity)
            intensity = 0;
        else
            intensity -= x; 
    }
    
    public void display(){
        System.out.println(intensity);
    }
}


class HeatingSystem{
    private float temperature;

    public HeatingSystem(float temperature) {
        this.temperature = temperature;
    }
    
    public void increaseTemperature(float x){
        temperature += x;
    }
    
    public void decreasetTemperature(float x){
        temperature -= x;
    }
    
    public void display(){
        System.out.println(temperature);
    }
}

class main{
    public static void main(String[] args) {
        HomeAutomationFacade homeAutomationFacade = new HomeAutomationFacade();
        homeAutomationFacade.changeTemperature(20);
        homeAutomationFacade.controlLight(-30);
    }
}

