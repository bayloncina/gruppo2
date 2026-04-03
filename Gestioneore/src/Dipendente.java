public class Dipendente extends Persona {

    private String mansione;
    private String azienda;
    private int oreLavorateGiornalmente;

    public Dipendente(String nome, String cognome, String mansione, int oreLavorateGiornalmente) {
        super(nome, cognome);
        this.mansione = mansione;
        this.oreLavorateGiornalmente = oreLavorateGiornalmente;
    }

    public String getAzienda() {
        return azienda;
    }

    public int getOreLavorateGiornalmente() {
        return oreLavorateGiornalmente;
    }

    public String getMansione() {
        return mansione;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }

    public void setOreLavorateGiornalmente(int oreLavorateGiornalmente) {
        this.oreLavorateGiornalmente = oreLavorateGiornalmente;
    }

    public void setMansione(String mansione) {
        this.mansione = mansione;
    }
}
