import java.util.ArrayList;
//belum menggunakan inheritance, idealnya turunan dari Item

public class Pintu extends Item{

    //constrcutor
    public Pintu() {
        super("Pintu");
        deskripsi = "Pintu berwarna merah dengan tulisan 'EXIT' di atas ";
        //init pilihan
        arrAksi.add("Deskripsikan pintu");
        arrAksi.add("Coba buka pintu");
    }
    @Override //override prosesAksi di class super (Item)
    public void prosesAksi(int subPil) {
        //1: deskripsikan
        //2: buka pintu
        if (subPil==1) {
            System.out.println(deskripsi);
        } else if (subPil==2) {
            //cek apakah mempunyai kunci
            if (objGameInfo.getObjPlayer().cariItem("Kunci")) {
                //kunci ada, pintu terbuka
                System.out.println("Player menggunakan kunci untuk membuka pintu dan pintu terbuka!");
                objGameInfo.setGameOver(true); //game over
            } else {
                //kunci tidak ada
                System.out.println("Player mencboa membuka pintu. TERKUNCI!");
            }
        }
    }

    @Override //override getAksi di class super (Item)
    public ArrayList<String> getAksi() {
        return(arrAksi);
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
    }

}
