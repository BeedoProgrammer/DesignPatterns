package Builder;

public class Burger {
    private String main_dish;
    private String side;
    private String drink;
    private String dessert;

    private Burger(BurgerBuilder builder) {
        this.main_dish = builder.main_dish;
        this.side = builder.side;
        this.drink = builder.drink;
        this.dessert = builder.dessert;
    }

  
    public static class BurgerBuilder{
        private String main_dish;
        private String side = "";
        private String drink = "";
        private String dessert = "";

        public BurgerBuilder(String main_dish) {
            this.main_dish = main_dish;
        }
        
        public BurgerBuilder side(String side){
            this.side = side;
            return this;
        }
        
        public BurgerBuilder drink(String drink){
            this.drink = drink;
            return this;
        }
        
        public BurgerBuilder dessert(String dessert){
            this.dessert = dessert;
            return this;
        }
        
        public Burger build(){
            return new Burger(this);
        }
        
    }
    
    public static void main(String[] args) {
        Burger b1 = new Burger.BurgerBuilder("veggie burger").side("salad").drink("water").build();
        Burger b2 = new Burger.BurgerBuilder("chicken burger").side("fries").drink("cola").build();
    }
 
}

