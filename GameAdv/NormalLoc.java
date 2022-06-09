public abstract class NormalLoc extends Location {
    NormalLoc( Player player,String name) {
        super(player);
        this.name = name;
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}