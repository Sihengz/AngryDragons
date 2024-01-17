public class Sword {
    private int attackPower = 10;
    private double dodgeRating = 0.2;

    public int getAttackPower() {
        return attackPower;
    }

    public double getDodgeRating() {
        return dodgeRating;
    }

    public void gainAttackPower(int attackPower) {
        this.attackPower += attackPower;
    }

    public void gainDodgeRating(double dodgeRating) {
        this.dodgeRating += dodgeRating;
    }
}
