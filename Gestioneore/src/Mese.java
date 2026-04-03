package calendario;

public enum Mese {
    Gennaio(31),
    Febbraio(28),
    Marzo(31),
    Aprile(30),
    Maggio(31),
    Giugno(30),
    Luglio(31),
    Agosto(31),
    Settembre(30),
    Ottobre(31),
    Novembre(30),
    Dicembre(31);

    private final int giorni;
    
    Mese(int giorni) {
        this.giorni = giorni;
    }

    public int getGiorni () { return giorni; }
}
