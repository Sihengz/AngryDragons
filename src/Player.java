public class Player {
    private String name;
    private int health = 100;
    private int gold = 0;
    private Sword sword = new Sword();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int attack() {
        double damage = sword.getAttackPower();
        damage *= (Math.random() + 0.2);
        return (int) damage;
    }
    // returns if dodged
    public boolean takeDamage(int damage) {
        if (Math.random() < sword.getDodgeRating()) {
            return true;
        }
        health -= damage;
        return false;
    }
    // returns if gameover
    public boolean fightDragon(Dragon dragon) {
        int damage;
        int dragonDamage;
        while (health > 0 && dragon.getHealth() > 0) {
            damage = attack();
            dragonDamage = dragon.attack();
            boolean dodged = takeDamage(dragon.attack());
            dragon.takeDamage(damage);

            System.out.println("Dragon takes " + damage + " damage!");
            if (dodged) {
                System.out.println(name + " dodged!!!");
            } else {
                System.out.println(name + " takes " + dragonDamage + " damage!");
            }
            System.out.println("Dragon has " + dragon.getHealth() + " health");
            System.out.println(name + " has " + health + " health\n");
        }
        return health <= 0;

    }

    public Sword getSword() {
        return sword;
    }

    public int getGold() {
        return gold;
    }

    public void gainGold(int gold) {
        this.gold += gold;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health += health;
    }
}
