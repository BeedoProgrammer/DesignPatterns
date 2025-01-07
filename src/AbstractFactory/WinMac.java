package AbstractFactory;

class WinButton implements Button {
    @Override
    public void paintButton(){
        System.out.println("WinButton");
    }
}

class WinCheckbox implements Checkbox {
    @Override
    public void paintCheckbox(){
        System.out.println("WinCheckbox");
    }
}

class MacButton implements Button {
    @Override
    public void paintButton(){
        System.out.println("MacButton");
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void paintCheckbox(){
        System.out.println("MacCheckbox");
    }
}
