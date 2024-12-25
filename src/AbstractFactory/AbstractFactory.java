package AbstractFactory;

public abstract class AbstractFactory {
    public abstract Button createButton();
    public abstract Checkbox createCheckbox();
}

class Windows extends AbstractFactory{
    public Button createButton(){
        WinButton b1 = new WinButton();
        return b1;
    }
    
    public Checkbox createCheckbox(){
        WinCheckbox c1 = new WinCheckbox();
        return c1;
    }
}

class Mac extends AbstractFactory{
    public Button createButton(){
        MacButton b1 = new MacButton();
        return b1;
    }
    
    public Checkbox createCheckbox(){
        MacCheckbox c1 = new MacCheckbox();
        return c1;
    }
}

class run{
    public static void main(String[] args) {
        AbstractFactory win = new Windows();
        Button WinButton = win.createButton();
        Checkbox wCheckbox = win.createCheckbox();
        
        AbstractFactory mac = new Mac();
        Button macButton = mac.createButton();
        Checkbox macCheckbox = mac.createCheckbox();
    }
}
