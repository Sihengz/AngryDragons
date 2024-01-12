public class Player {
    private String name;
    private int health = 100;
    private Sword sword = new Sword();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int attack() {
        double damage = sword.getAttackPower();
        damage *= Math.random() + 0.2;
        return (int) damage;
    }

    public void takedamage(int damage) {
        health -= damage;
    }
    // returns if gameover
    public boolean fightDragon(Dragon dragon) {
        int damage;
        int dragonDamage;
        while (health > 0 && dragon.getHealth() > 0) {
            damage = attack();
            dragonDamage = dragon.attack();
            health -= dragon.attack();
            dragon.takeDamage(damage);

            System.out.println("Dragon takes " + damage + " damage!");
            System.out.println(name + " takes " + dragonDamage + " damage!");
            System.out.println("Dragon has " + dragon.getHealth() + " health");
            System.out.println(name + " has " + health + " health");
        }
        if (health <= 0) {
            return true;
        } else {
            return false;
        }

    }
}
