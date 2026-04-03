public class DipendenteFullTime extends Dipendente {

    public DipendenteFullTime(String nome, String cognome, String azienda, String mansione) {
        super(nome, cognome, azienda, mansione);
        setOreLavorateGiornalmente(8);
    }

}
