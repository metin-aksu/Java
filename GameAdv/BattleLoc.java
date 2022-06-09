import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location {
    Obstacle obstacle;
    String award;

    BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.name = name;
        this.obstacle = obstacle;
        this.award = award;
    }

    public int printStart() {
        int obsCount = obstacle.count();
        System.out.println("Suan buradasiniz : " + this.getName());
        System.out.println("Dikkatli Ol ! Burada : " +obsCount + " tane "+ obstacle.getName() + " Yasiyor ! ");
        System.out.println("<S>avas veya <K>ac ");
        return obsCount;
    }

    @Override
    public boolean onLocation() {
        if (this.getName().equals("Maden")) {
            return getLocationMines();
        }
        Scanner scan = new Scanner(System.in);
        int obsCount = printStart();
        String selectCase = scan.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S")) {
            if (combat(obsCount)) {
                System.out.println(this.getName() + " Temizlendi !");
                if (this.award.equals("Yemek") && !player.getInventory().isFood()) {
                    System.out.println("Kazandin " + this.award);
                    player.getInventory().setFood(true);
                } else if (this.award.equals("Su") && !player.getInventory().isWater()) {
                    System.out.println("Kazandin " + this.award);
                    player.getInventory().setWater(true);
                } else if (this.award.equals("Odun") && !player.getInventory().isFirewood()) {
                    System.out.println("Kazandin " + this.award);
                    player.getInventory().setFirewood(true);
                }
                return true;
            }
            if (player.getHealthy() <= 0) {
                System.out.println("Oldun !");
                return false;
            }
        }
        return true;
    }

    public boolean getLocationMines() {
        Scanner scan = new Scanner(System.in);
        int obsCount = printStart();
        String selCase = scan.nextLine();
        selCase = selCase.toUpperCase();
        if (selCase.equals("S")) {
            if (combat(obsCount)) {
                System.out.println(this.getName() + " Temizlendi !");

                Random random = new Random();
                int luckyNumber = random.nextInt(101);

                if (luckyNumber >= 55) {
                    System.out.println("Malesef hicbir sey kazanamadiniz!");
                }

                else if(luckyNumber >= 30) {
                    System.out.println("Rastgele miktarda para kazandınız!");
                    luckyNumber = random.nextInt(101);
                    if (luckyNumber >= 50) {
                        System.out.println("1 Altin kazandiniz! ");
                        player.setMoney(player.getMoney() + 1);
                    }
                    else if (luckyNumber >= 20) {
                        System.out.println("3 Altin kazandiniz! ");
                        player.setMoney(player.getMoney() + 3);
                    }
                    else {
                        System.out.println("Buyuk ikramiye :)! 10 Altin kazandiniz! ");
                        player.setMoney(player.getMoney() + 10);
                    }
                }

                else if (luckyNumber >= 15) {
                    System.out.println("Rastgele zirh kazandiniz!");
                    luckyNumber = random.nextInt(101);
                    if (luckyNumber >= 50) {
                        System.out.println("Hafif zirh kazandiniz! ");
                        if (player.getInventory().getArmorDefence() > 1) {
                            System.out.println("Daha iyi zirhiniz var! degisiklik olmadi");
                        }
                        else {
                            player.getInventory().setArmorDefence(1);
                            System.out.println("Zirhi kusandin!");
                        }
                    }
                    else if (luckyNumber >= 20) {
                        System.out.println("Orta zirh kazandiniz! ");
                        if (player.getInventory().getArmorDefence() > 3) {
                            System.out.println("Daha iyi zirhiniz var! degisiklik olmadi");
                        }
                        else {
                            player.getInventory().setArmorDefence(3);
                            System.out.println("Zirhi kusandin!");
                        }
                    }
                    else {
                        System.out.println("Agir zirh kazandiniz! ");
                        if (player.getInventory().getArmorDefence() > 5) {
                            System.out.println("Daha iyi zirhiniz var! degisiklik olmadi");
                        }
                        else {
                            player.getInventory().setArmorDefence(5);
                            System.out.println("Zirhi kusandin!");
                        }
                    }
                }

                else {
                    System.out.println("Rastgele silah kazandiniz!");
                    luckyNumber = random.nextInt(101);
                    if (luckyNumber >= 50) {
                        System.out.println("Tabanca kazandiniz ");
                        if (player.getInventory().getWeaponDamage() > 2) {
                            System.out.println("Daha iyi silahiniz var! degisiklik olmadi");
                        }
                        else {
                            player.getInventory().setWeaponDamage(2);
                            System.out.println("Silahi kusandiniz !");
                        }
                    }
                    else if (luckyNumber >= 20) {
                        System.out.println("Kilic kazandiniz! ");
                        if (player.getInventory().getWeaponDamage() > 3) {
                            System.out.println("Daha iyi silahiniz var! degisiklik olmadi");
                        }
                        else {
                            player.getInventory().setWeaponDamage(3);
                            System.out.println("Silahi kusandiniz!");
                        }
                    }
                    else {
                        System.out.println("Tufek kazandiniz ! ");
                        if (player.getInventory().getWeaponDamage() > 7) {
                            System.out.println("Daha iyi silahiniz var! degisiklik olmadi");
                        }
                        else {
                            player.getInventory().setWeaponDamage(7);
                            System.out.println("Silahi kusandiniz !");
                        }
                    }
                }

                return true;
            }

            if(player.getHealthy() <= 0) {
                System.out.println("Oldun!");
                return false;
            }

        }
        return true;
    }
    public boolean combat(int obsCount) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < obsCount; i++) {


            int defObsHealth = obstacle.getHealthy();
            playerStats();
            enemyStats();
            while (player.getHealthy() > 0 && obstacle.getHealthy() > 0) {
                System.out.print("<S>avas or <K>ac :");
                String selCase = scan.nextLine();
                selCase = selCase.toUpperCase();
                Random random = new Random();
                boolean playerStarts = random.nextInt(2) == 1;

                if (playerStarts) {
                    if (selCase.equals("S")) {
                        System.out.println("Vurdun!");
                        obstacle.setHealthy(obstacle.getHealthy() - player.getTotalDamage());
                        afterHit();
                        if (obstacle.getHealthy() > 0) {
                            System.out.println();
                            System.out.println("Canavar sana vurdu!");
                            player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInventory().getArmorDefence()));
                            afterHit();
                        }
                    } else {
                        return false;
                    }
                } else {
                    if (selCase.equals("S")) {
                        System.out.println("Canavar sana vurdu!");
                        player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInventory().getArmorDefence()));
                        afterHit();
                        if (obstacle.getHealthy() > 0) {
                            System.out.println();
                            System.out.println("Vurdun !");
                            obstacle.setHealthy(obstacle.getHealthy() - player.getTotalDamage());
                            afterHit();
                        }
                    } else {
                        return false;
                    }
                }
            }

            if (obstacle.getHealthy() < player.getHealthy()) {
                System.out.println("Canavari oldurdun !");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Suanki paraniz  : " + player.getMoney());
                obstacle.setHealthy(defObsHealth);
            } else {
                return false;
            }
            System.out.println("-------------------");
        }
        return true;
    }

    public void playerStats() {
        System.out.println("Oyuncu Bilgileri\n--------------");
        System.out.println("Saglik:" + player.getHealthy());
        System.out.println("Hasar:" + player.getTotalDamage());
        System.out.println("Para:" + player.getMoney());
        if (player.getInventory().getWeaponDamage() > 0) {
            System.out.println("Silah:" + player.getInventory().getWeaponName());
        }
        if (player.getInventory().getArmorDefence() > 0) {
            System.out.println("Zirh:" + player.getInventory().getArmorName());
        }
    }

    public void enemyStats() {
        System.out.println("\n" + obstacle.getName() + " Bilgi \n--------------");
        System.out.println("Saglik:" + obstacle.getHealthy());
        System.out.println("Hasar:" + obstacle.getDamage());
        System.out.println("Odul:" + obstacle.getAward());
    }

    public void afterHit() {
        System.out.println("Oyuncu Sagligi:" + player.getHealthy());
        System.out.println(obstacle.getName() + "'Sagligi:" + obstacle.getHealthy());
        System.out.println();
    }

}