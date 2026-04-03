public class Calendario {
    private EnumMese mese;

    public Calendario(EnumMese mese) {
        this.mese = mese;
    }

    public EnumMese getMese() {
        return mese;
    }

    public void setMese(EnumMese mese) {
        this.mese = mese;
    }

    public void stampaInfo() {
        System.out.println("mese.name() è ");
    }
}