public abstract class Location {
    public String name;
    public Player player;


    Location(Player player) {
        this.player = player;
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }
}