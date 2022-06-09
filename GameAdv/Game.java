import java.util.Scanner;

public class Game {
    Location location;

    public void start() {

        String selectName;
        Scanner scan = new Scanner(System.in);
        System.out.println("------------- OYUN BASLADI -------------");
        System.out.println();
        System.out.println("Lutfen isminizi giriniz : ");
        selectName = scan.nextLine();
        Player player = new Player(selectName);
        player.selectChar();
        System.out.println("HOŞ GELDIN " + player.getName());
        while (true) {
            System.out.println();
            System.out.println("Bir bolge sec  : ");
            System.out.println();
            System.out.println("1. Guvenli Ev --> Burasi sizin icin guvenli bir ev,dusman yoktur!");
            System.out.println("2. Esya Dukkani --> Silah veya zirh satin alabilirsiniz");
            System.out.println("3. Orman --> Odul <Odun> ! Dikkatli Ol Vampir Cikabilir !!");
            System.out.println("4. Magara --> Odul <Yemek> ! Dikkatli Ol Zombi Cikabilir !!");
            System.out.println("5. Nehir --> Odul <Su> ! Dikkatli Ol Ayi Cikabilir !!");
            System.out.println("6. Maden --> Odul <Rastgele> Dikkatli ol Yilan Cikabilir !!");
            System.out.println("0- Cikis Yap --> Oyunu Sonlandir.");
            System.out.println("Lutfen gitmek istediginiz bolgeyi seciniz :   ");
            int select = scan.nextInt();

            while (select < 0 || select > 6) {
                System.out.print("Lutfen gecerli bir giris yapiniz  : ");
                select = scan.nextInt();
            }
            switch (select) {

                case 0 :
                    location = null;
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    if (!player.getInventory().isFirewood())
                        location = new Forest(player);
                    else {
                        System.out.println("Buraya tekrar giremezsiniz! ");
                    }
                    break;
                case 4:
                    if (!player.getInventory().isFood())
                        location = new Cave(player);
                    else{
                        System.out.println("Buraya tekrar giremezsiniz ! ");
                    }
                    break;
                case 5:
                    if(!player.getInventory().isWater())
                        location = new River(player);
                    else{
                        System.out.println("Buraya tekrar giremezsiniz ! ");
                    }
                    break;
                case 6:
                    location = new Mines(player);
                    break;
                default:
                    location = new SafeHouse(player);

            }
            assert location != null;
            if (location.getClass().getName().equals("SafeHouse")) {
                if (player.getInventory().isFirewood() && player.getInventory().isFood() && player.getInventory().isWater()) {
                    System.out.println("TEBRIKLER KAZANDINIZ");
                    break;
                }
            }
            if (!location.onLocation()) {
                System.out.println("O !");
                break;
            }
        }
    }


}