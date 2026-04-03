public class DipendentePartTime extends Dipendente {

    public DipendentePartTime(String nome, String cognome, String azienda, String mansione) {
        super(nome, cognome, azienda, mansione);
        setOreLavorateGiornalmente(4);
    }

}
