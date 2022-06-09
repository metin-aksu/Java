import java.util.Scanner;

public class Player {
    Inventory inventory;
    private int damage;
    private int healthy, rHealthy;
    private int money;
    private String name;
    Scanner scan = new Scanner(System.in);

    public Player(String name) {

        this.name = name;
        this.inventory = new Inventory();

    }

    public Inventory getInventory() {
        return inventory;
    }



    public int getDamage() {
        return damage;
    }



    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    public String getName() {
        return name;
    }

    public int getrHealthy() {
        return rHealthy;
    }


    public int charMenu() {
        System.out.println("-----------KARAKTER SINIFINI SECINIZ----------");
        System.out.println("1- Samuray \t Hasar : 5 \t Saglik :21 \t Para :25");
        System.out.println("2- Okcu \t Hasar : 7 \t Saglik :18 \t Para :30");
        System.out.println("3- Sovalye \t Hasar : 8 \t Saglik :24 \t Para :15");
        System.out.print("Seciminizi giriniz : ");
        int chaID = scan.nextInt();

        while (chaID < 1 || chaID > 3) {
            System.out.print("Lutfen bir karakter seciniz  :");
            chaID = scan.nextInt();
        }
        return chaID;
    }

    public int getTotalDamage() {
        return this.getDamage() + this.getInventory().getWeaponDamage();
    }

    public void selectChar() {
        switch (charMenu()) {
            case 1 -> {
                System.out.println();
                System.out.println("Samuray karakterini seçtiniz ...");
                this.name = "Samuray " + getName();
                this.damage = 5;
                this.rHealthy = 21;
                this.healthy = 21;
                this.money = 25;
                System.out.println("Hasar :" + this.damage + " Saglik :" + this.healthy + " Altin :" + this.money);
            }
            case 2 -> {
                System.out.println();
                System.out.println("Okcu karakterini seçtiniz ...");
                this.name = "Okçu " + getName();
                this.damage = 7;
                this.healthy = 18;
                this.rHealthy = 18;
                this.money = 30;
                System.out.println("Hasar :" + this.damage + " Saglik :" + this.healthy + " Altin :" + this.money);
            }
            case 3 -> {
                System.out.println();
                System.out.println("Sovalye karakterini seçtiniz ...");
                this.name = "Sovalye " + getName();
                this.damage = 8;
                this.healthy = 24;
                this.rHealthy = 24;
                this.money = 15;
                System.out.println("Hasar :" + this.damage + " Saglik :" + this.healthy + " Altin :" + this.money);
            }
            default -> System.out.println("Hatalı giris yaptiniz ...!");
        }
    }
}