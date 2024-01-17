public class Dragon {
    private int health = 100;
    private int level;

    public Dragon(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public int attack() {
        return (int) (level * 2 * Math.random() + 1);
    }
}
