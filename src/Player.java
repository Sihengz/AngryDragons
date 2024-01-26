public class Player {
    private String name;
    private int health = 100;
    private int gold = 0;
    private Sword sword = new Sword();
    private boolean hasHealthPotion = false;


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

            System.out.println("Dragon takes " + damage + " damage! 🐉");
            if (dodged) {
                System.out.println(name + " dodged!!! 🥾");
            } else {
                System.out.println(name + " takes " + dragonDamage + " damage! 🩸");
            }
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println("error");
            }
            System.out.println("Dragon has " + dragon.getHealth() + " health");
            System.out.println(name + " has " + health + " health\n");
        }
        return health <= 0;

    }

    public void search(Room room) {
        if (hasHealthPotion) {
            System.out.println("You only have enough hands to carry one potion and a sword");
        } else if (Math.random() > 0.5 && !room.isSearched()) {
            System.out.println("You found a health potion!!!!!");
            hasHealthPotion = true;
            room.setSearched(true);
        } else {
            System.out.println("No potions to be found, maybe search another room?");
            room.setSearched(true);
        }
    }

    public void drinkPotion() {
        if (hasHealthPotion) {
            health += (int) (Math.random() * 30) + 20;
            System.out.println("Glub Glub");
            System.out.println("You now have " + health + " health");
            hasHealthPotion = false;
        } else {
            System.out.println("You don't have one!");
        }
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

    public boolean isHasHealthPotion() {
        return hasHealthPotion;
    }

    public void setHealth(int health) {
        this.health += health;
    }
}
