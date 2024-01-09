public class Player {
    private int health = 100;
    private Sword sword = new Sword();

    public int attack() {
        double damage = sword.getAttackPower();
        damage *= Math.random() + 0.2;
        return (int) damage;
    }
}
