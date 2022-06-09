public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super(player, "Guvenli Ev");
    }

    @Override
    public boolean onLocation() {
        player.setHealthy(player.getrHealthy());
        System.out.println("Caniniz Yenilendi !");
        System.out.println("Guvenli Evdesiniz !! ");
        return true;
    }
}