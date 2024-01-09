public class Room {
    private Dragon[] dragons;
    private int numDragons;

    public Room() {
        numDragons = (int) (Math.random() * 2 + 1);
        dragons = new Dragon[numDragons];
        for (int i = 0; i < numDragons; i++) {
            dragons[i] = getRandomDragon();
        }
    }
    private Dragon getRandomDragon() {
        return new Dragon((int) (Math.random() * 2 + 1));
    }
}
