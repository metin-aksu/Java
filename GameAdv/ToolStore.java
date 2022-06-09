import java.util.Scanner;

public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "ESYA MAGAZASI");
    }

    @Override
    public boolean onLocation() {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Para : " + player.getMoney());
        System.out.println("EN IYI SILAHLAR ICIN  (1) || EN IYI ZIRHLAR ICIN  (2) || CIKIS ICIN (0)");
        int select = scan.nextInt();
        int selItemNum;
        switch (select) {
            case 1 -> {
                selItemNum = weaponMenu();
                buyWeapon(selItemNum);
            }
            case 2 -> {
                selItemNum = armorMenu();
                buyArmor(selItemNum);
            }
            default -> {
            }
        }
        return true;
    }


    public int armorMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("ZIRHLAR");
        System.out.println("Hafif Zirh  1 ---> HASAR : 2 --- PARA : 25");
        System.out.println("Orta Zirh   2 ---> HASAR : 3 --- PARA : 35");
        System.out.println("Agir Zirh   3 ---> HASAR : 7 --- PARA : 45");
        System.out.println("GERI 4");
        System.out.println("Seciminiz ");
        return scan.nextInt();
    }

    public void buyArmor(int itemNum) {
        int avoid = 0, price = 0;
        String aName = null;

        switch (itemNum) {
            case 1 -> {
                avoid = 1;
                aName = "Hafif Zirh";
                price = 15;
            }
            case 2 -> {
                avoid = 3;
                aName = "Orta Zirh";
                price = 25;
            }
            case 3 -> {
                avoid = 5;
                aName = "Agir Zirh";
                price = 40;
            }
            case 4 -> System.out.println("Cikis ! ");
            default -> System.out.println("Gecersiz Giris !");
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInventory().setArmorDefence(avoid);
                player.getInventory().setArmorName(aName);
                player.setMoney(player.getMoney() - price);
                System.out.println("Satin Aldin " + aName + " Engelleme : " + player.getInventory().getArmorDefence());
                System.out.println("Suanki Paraniz :" + player.getMoney());
            } else {
                System.out.println("Yetersiz Bakiye !");
            }
        }
    }

    public int weaponMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("SILAHLAR");
        System.out.println("Tabanca     1 ---> HASAR : 2 --- PARA : 15");
        System.out.println("Kilic       2 ---> HASAR : 3 --- PARA : 35");
        System.out.println("Tufek       3 ---> HASAR : 7 --- PARA : 45");
        System.out.println("GERI 4");
        System.out.println("Seciminiz ");

        return scan.nextInt();
    }

    public void buyWeapon(int itemNum) {
        int damage = 0, price = 0;
        String wName = null;

        switch (itemNum) {
            case 1 -> {
                damage = 2;
                wName = "Silah";
                price = 25;
            }
            case 2 -> {
                damage = 3;
                wName = "Kilic";
                price = 35;
            }
            case 3 -> {
                damage = 7;
                wName = "Tufek";
                price = 45;
            }
            case 4 -> System.out.println("Cikis.");
            default -> System.out.println("Gecersiz Giris !");
        }

        if (price > 0) {
            if (player.getMoney() > price) {
                player.getInventory().setWeaponDamage(damage);
                player.getInventory().setWeaponName(wName);
                player.setMoney(player.getMoney() - price);
                System.out.println( wName +"Satin Aldin "+ "  Eski Hasar :" + player.getDamage() + ", Yeni Hasar : "
                        + player.getTotalDamage());
                System.out.println("Suanki Paraniz :" + player.getMoney());
            } else {
                System.out.println("Yetersiz Bakiye !");
            }
        }

    }


}