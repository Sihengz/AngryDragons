public class Room {
    private Dragon[] dragons;
    private int numDragons;
    private int dragonNumber = 0;

    public Room() {
        numDragons = (int) (Math.random() * 2 + 1);
        dragons = new Dragon[numDragons];
        for (int i = 0; i < numDragons; i++) {
            dragons[i] = getRandomDragon();
        }
    }

    public Dragon getDragon() {
        Dragon dragon = dragons[dragonNumber];
        dragonNumber += 1;
        return dragon;
    }

    public boolean allDragonsSlayed() {
        return (dragonNumber) == numDragons;
    }
    private Dragon getRandomDragon() {
        return new Dragon((int) (Math.random() * 2 + 1));
    }
}
