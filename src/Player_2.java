public class Player_2 extends Player_1{
    private boolean armour;

    public Player_2(String name, String weapon, int health, boolean armour) {
        super(name, weapon, health);
        this.armour = armour;
    }

    @Override
    public void Hit_By_Gun1() {
        // Changes for solve a liskov principle violation in the code

        // To mantain the liskov principle we need to change the code in the following way

        super.Hit_By_Gun1(); // This will call the method from the parent class and will reduce the health by 20

        if (getHealth() > 0) { 
            int extraDamage;
            if (armour) {
                extraDamage = -10; 
            } else {
                extraDamage = 20; 
            }

            setHealth(getHealth() - extraDamage);

            if (getHealth() <= 0) {
                setHealth(0);
                System.out.println(getName() + " is dead");
            } else {
                if (armour) {
                    System.out.println("Armour is on. Additional damage applied. New health is: " + getHealth());
                } else {
                    System.out.println("Armour is off. Additional damage applied. New health is: " + getHealth());
                }
            }
        }
    }

    @Override
    public void Hit_By_Gun2() {
        int damage;
        if (armour) {
            damage = 30;
        } else {
            damage = 60;
        }
    
        setHealth(getHealth() - damage); // Use the super class method to have consistent behavior
        if (getHealth() <= 0) {
            setHealth(0);
            System.out.println(getName() + " is dead");
        } else {
            if (armour) {
                System.out.println("Armour is on. Hit by gun 2. Health is reduced by " + damage + " and new health is: " + getHealth());
            } else {
                System.out.println("Armour is off. Hit by gun 2. Health is reduced by " + damage + " and new health is: " + getHealth());
            }
        }

    }
}
