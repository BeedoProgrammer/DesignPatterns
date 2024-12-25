package AbstractFactory;

class WinButton implements Button {
    public void paintButton(){
        System.out.println("WinButton");
    }
}

class WinCheckbox implements Checkbox {
    public void paintCheckbox(){
        System.out.println("WinCheckbox");
    }
}

class MacButton implements Button {
    public void paintButton(){
        System.out.println("MacButton");
    }
}

class MacCheckbox implements Checkbox {
    public void paintCheckbox(){
        System.out.println("MacCheckbox");
    }
}
