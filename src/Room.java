public class Room {
    private Dragon[] dragons;
    private int numDragons;
    private int dragonNumber = 0;
    private boolean searched = false;
    private String name;

    public Room(String name) {
        this.name = name;
        numDragons = (int) (Math.random() * 2 + 1);
        dragons = new Dragon[numDragons];
        for (int i = 0; i < numDragons; i++) {
            dragons[i] = getRandomDragon();
        }
    }

    public Room(String name, int numDragons) {
        this.name = name;
        this.numDragons = numDragons;
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
        return (dragonNumber) > dragons.length - 1;
    }
    public String getName() {
        return name;
    }

    private Dragon getRandomDragon() {
        return new Dragon((int) (Math.random() * 2 + 1));
    }

    public boolean isSearched() {
        return searched;
    }

    public void setSearched(boolean searched) {
        this.searched = searched;
    }
}
