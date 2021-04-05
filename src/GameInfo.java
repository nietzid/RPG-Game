//variabel2 global
public class GameInfo {
    private Boolean isGameOver = false;
    private Player objPlayer; //player aktif
    private Ruangan objRuangan; //ruangan aktif

    public Ruangan getObjRuangan() {
        return objRuangan;
    }

    public void setObjRuangan(Ruangan objRuangan) {
        this.objRuangan = objRuangan;
    }

    public Player getObjPlayer() {
        return objPlayer;
    }

    public void setObjPlayer(Player objPlayer) {
        this.objPlayer = objPlayer;
    }

    public Boolean getGameOver() {
        return isGameOver;
    }

    public void setGameOver(Boolean gameOver) {
        isGameOver = gameOver;
    }
}
