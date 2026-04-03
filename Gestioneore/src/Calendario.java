public class Calendario {
    private Mese mese;
    
    public Calendario(Mese mese) {
        this.mese = mese;
    }

    public Mese getMese() {
        return mese;
    }

    public void setMese(Mese mese) {
        this.mese = mese;
    }

    public void stampaInfo() {
        System.out.println("mese.name() è ");
    }
}