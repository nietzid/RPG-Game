import java.util.Scanner;

public class GameEngine {
    // user interface game
    Scanner sc = new Scanner(System.in);
    Player objPlayer = new Player("budiwati");
    Ruangan objRuangan = new Ruangan(); //cuma satu ruangan
    GameInfo objGameInfo = new GameInfo();
    Item objCincin = new Item("Cincin Emas");
    Item objRoti = new Item("Roti");



    public static void main(String[] args) {
        GameEngine objGameEngine;
        objGameEngine = new GameEngine();
        objGameEngine.mulai();
    }

    //constructor
    public GameEngine() {
        //init game
        objRuangan.setObjGameInfo(objGameInfo);
        objRuangan.setDeskripsi("Ruangan kecil, dengan satu pintu dan jendela");

        objGameInfo.setObjPlayer(objPlayer);
        objGameInfo.setObjRuangan(objRuangan);

        objPlayer.setObjGameInfo(objGameInfo);

        objCincin.setDeskripsi("Cincin emas bertuliskan suatu kalimat..");
        objPlayer.getArrItem().add(objCincin);
        objCincin.setObjGameInfo(objPlayer.getObjGameInfo());

        objRoti.setDeskripsi("Roti rasa coklat dalam bungkusan plastik");
        objRoti.setObjRuangan(objRuangan);
        objRuangan.getArrItem().add(objRoti);
        objRuangan.setObjGameInfo(objPlayer.getObjGameInfo());
    }


    private void aksi() {
        System.out.println();
        System.out.println("==============================================");
        System.out.println("1. Aksi yang dapat dilakukan di ruangan");
        System.out.println("2. Aksi terhadap player");
        System.out.println("3. Keluar");
        System.out.println("==============================================");
        System.out.print("Pilihan anda?");
        int pil = sc.nextInt();
        System.out.println("--");
        if (pil==3) {
            objGameInfo.setGameOver(true); //keluar
        } else if (pil==1) {
            objRuangan.pilihanAksi(); //
        } else if (pil==2) {
            objPlayer.pilihanAksi();
        }
    }

    public void mulai() {
        while (!objGameInfo.getGameOver()) {
            aksi();
        }
    }
}
