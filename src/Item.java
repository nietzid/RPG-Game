import java.util.ArrayList;

public class Item {
    protected String deskripsi;
    private String nama;
    protected ArrayList<String> arrAksi = new ArrayList<>(); //pilihan aksi untuk item
    private Ruangan objRuangan;  //ruangan tempat item, jika null artinya item dipegang npc atau plyaer
    protected GameInfo objGameInfo;

    //constructor
    public Item(String nama) {
        this.nama = nama;
    }

    public void prosesAksi(int pil) {
        //pilihan user untuk aksi yang akan diambil
        //urutan harus sama dengan isi arrAksi
        if (pil==1) {
            System.out.println(deskripsi);
        } else  if (pil==2) {  //bisa ambil atau buang
            if (objRuangan==null) {
               //dipegang player, buang ke ruangan
                dibuang();
            } else {
                //ada di ruangan, diambil player
                diambil();
            }
        }
    }

    private void dibuang() {
        System.out.println("Item dibuang player ke ruangan");
        objGameInfo.getObjPlayer().hapusItem(this); //hapus dari player
        objGameInfo.getObjRuangan().addItem(this);  //tambah ke ruangan
        objRuangan = objGameInfo.getObjRuangan(); // set ruangan
    }


    //pindahkan item dari ruangan ke player
    private void diambil() {
        System.out.println("Item diambil player");
        objGameInfo.getObjPlayer().addItem(this);     //tambahkan  objek ini (this) pada player
        objRuangan.hapusItem(this);                    //hapus dari ruangan
        objRuangan = null;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void printItem() {
        //print deskripsi item
        System.out.println(deskripsi);
    }

    public ArrayList<String> getAksi() {
        arrAksi.clear();
        //aksi dinamik tergantung ada di ruangan atau dipegang player/npc
        if (objRuangan==null) {
            //ada di player, ada opsi buang
            arrAksi.add("Deskripsi Item");
            arrAksi.add("Buang item");
        } else {
            //ada di ruangan ada opsi ambil
            arrAksi.add("Deskripsi Item");
            arrAksi.add("Ambil item");
        }
        return(arrAksi);
    }

    //setter getter
    public void setObjGameInfo(GameInfo objGameInfo) { this.objGameInfo = objGameInfo; }
    public void setObjRuangan(Ruangan objRuangan) {
        this.objRuangan = objRuangan;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }


}
