public class Room {
    private Dragon[] dragons;
    private int numDragons;
    private int dragonNumber = 0;
    private boolean searched = false;
    private String name;

    // Creates a list of dragons generated with makeRandomDragon
    public Room(String name) {
        this.name = name;
        numDragons = (int) (Math.random() * 3 + 1);
        dragons = new Dragon[numDragons];
        for (int i = 0; i < numDragons; i++) {
            dragons[i] = makeRandomDragon();
        }
    }

    public Room(String name, int numDragons) {
        this.name = name;
        this.numDragons = numDragons;
        dragons = new Dragon[numDragons];
        for (int i = 0; i < numDragons; i++) {
            dragons[i] = makeRandomDragon();
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSearched() {
        return searched;
    }

    public void setSearched(boolean searched) {
        this.searched = searched;
    }

    public int getNumDragons() {
        return numDragons;
    }

    public Dragon getDragon() {
        Dragon dragon = dragons[dragonNumber];
        dragonNumber += 1;
        return dragon;
    }

    public boolean allDragonsSlayed() {
        return dragonNumber > dragons.length - 1;
    }

    private Dragon makeRandomDragon() {
        return new Dragon((int) (Math.random() * 2 + 1));
    }


}
