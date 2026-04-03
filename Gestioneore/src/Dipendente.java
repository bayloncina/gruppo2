public abstract class Dipendente extends Persona {

    private String mansione;
    private String azienda;
    private int oreLavorateGiornalmente;
    private int totaleOreLavorate;

    public Dipendente(String nome, String cognome, String azienda, String mansione) {
        super(nome, cognome);
        this.mansione = mansione;
        this.azienda = azienda;
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

    public int getTotaleOreLavorate() {
        return totaleOreLavorate;
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

    public void setTotaleOreLavorate(int totaleOreLavorate) {
        this.totaleOreLavorate = totaleOreLavorate;
    }
}
