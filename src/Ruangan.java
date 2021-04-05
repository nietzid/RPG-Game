import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.format;

public class Ruangan {

    private Pintu objPintu;
    private NPC objNPC; 
    private ArrayList<Item> arrItem = new ArrayList<>();
    private String deskripsi;
    private GameInfo objGameInfo;
    private Scanner sc = new Scanner(System.in);


    //objgame juga diset pada pintu dan item2
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        objPintu.setObjGameInfo(objGameInfo);
        objNPC.setObjGameInfo(objGameInfo);
        for (Item objItem:arrItem) {
            objItem.setObjGameInfo(objGameInfo);
        }
    }

    public Ruangan() {
        // init ruangan
        // init pintu, kunci dan roti.
        objPintu = new Pintu();
        objNPC = new NPC("nina");
        //tambah item ke array
        arrItem.add(objPintu); //sekarang pintu bisa dimasukan ke arrItem karena polymorphism
    }

    //aksi yang dapat dilakukan di ruangan
    //agak kompleks tapi jadi fleksibel, logic aksi ada di masing2 item (bukan di game engine)
    //hardcode menu dikurangi
    public void pilihanAksi() {

        System.out.println("==== Pilihan Aksi pada Ruangan ===");
        int urutPil = 0;  //item, pintu
        int subPil;   //aksinya

        //aksi2 item
        System.out.println("Item di ruangan");
        for (Item objItem:arrItem) {
            urutPil++;
            subPil = 0;   //sistem penomorannya 11  12  13 dst
            System.out.println(objItem.getNama());
            //ambil pilihannya
            ArrayList <String> arrPil = objItem.getAksi();
            //print pilihan
            for (String strPil:arrPil) {
                subPil++;
                System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
            }
        }
        
        // aksi2 NPC
        urutPil++;
        subPil = 0;
        int pilNPC  = urutPil;
        System.out.println("NPC");
        for (String strPil:objNPC.getAksi()) {
            subPil++;
            System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
        }

        System.out.print("Pilihan anda?");
        String strPil = sc.next();
        System.out.println("--");

        //split pilihan dan subpilihan
        try {
            int pil = Integer.parseInt(strPil.substring(0, 1)); //ambil digit pertama, asumsikan jumlah tidak lebih dari 10
            subPil = Integer.parseInt(strPil.substring(1, 2)); //ambil digit kedua, asumsikan jumlah tidak lebih dari 10
            if (pil == pilNPC) {
                objNPC.prosesAksi(subPil);
            } else {
                //item
                Item objItemPilih = arrItem.get(pil - 1);
                objItemPilih.prosesAksi(subPil); //aksi item
            }
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Pilihan tidak ada!");
        }

    }

    // hapus item di ruangan berdasarkan namanya
    // digunakan saat suatu item diambil oleh player misalnya
    public void hapusItem(Item objItem) {
        arrItem.remove(objItem);  //buang item
    }

    public void addItem(Item objItem) {
        arrItem.add(objItem);
    }

    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public ArrayList<Item> getArrItem() {
        return arrItem;
    }

    public void setArrItem(ArrayList<Item> arrItem) {
        this.arrItem = arrItem;
    }
}
