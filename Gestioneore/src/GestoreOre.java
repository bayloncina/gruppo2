import java.util.ArrayList;
import java.util.Scanner;

public class GestoreOre {

    private ArrayList<Dipendente> dipendenti = new ArrayList<>();
    int totaleOre;

    public static void main(String[] args) {
        GestoreOre gestore = new GestoreOre();

        gestore.menu();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== GESTIONALE ORE =====");
            System.out.println("1. Inserisci ore");
            System.out.println("2. Modifica ore inserite");
            System.out.println("3. Elimina ore inserite");
            System.out.println("4. Mostra ore lavorate");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1 -> inserisciOre(dipendenti, scanner);
                case 2 -> { }
                case 3 -> eliminaOre(dipendenti, scanner);
                case 4 -> mostraOreLavorate();
                case 0 -> {
                    running = false;
                    System.out.println("Chiusura del programma");
                }
                default -> System.out.println("Scelta non valida.");
            }
        }

        scanner.close();
    }

    private void inserisciOre(ArrayList<Dipendente> dipendenti, Scanner scanner) {
        System.out.println("Seleziona dipendente: ");
        for (int i = 0; i < dipendenti.size(); i++) {
            System.out.println(i + " - " + dipendenti.get(i).getNome());
        }

        int scelta = Integer.parseInt(scanner.nextLine());
        Dipendente dip = dipendenti.get(scelta);

        System.out.println("Inserisci mese:");
        String meseInput = scanner.nextLine();
        EnumMese mese = EnumMese.valueOf(meseInput);

        System.out.println("Inserisci giorno:");
        int giorno = Integer.parseInt(scanner.nextLine());

        if (giorno < 1 || giorno > mese.getGiorni()) {
            System.out.println("Giorno non valido per il mese selezionato.");
            return;
        }

        // totale ore
        int ore = dip.getOreLavorateGiornalmente();
        dip.setTotaleOreLavorate(dip.getTotaleOreLavorate() + ore);
    }
    
    private void eliminaOre(ArrayList<Dipendente> dipendenti, Scanner scanner) {
        System.out.println("Seleziona dipendente: ");
        for (int i = 0; i < dipendenti.size(); i++) {
            System.out.println(i + " - " + dipendenti.get(i).getNome());
        }

        int scelta = Integer.parseInt(scanner.nextLine());
        Dipendente dip = dipendenti.get(scelta);

        System.out.println("Inserisci mese:");
        String meseInput = scanner.nextLine();
        EnumMese mese = EnumMese.valueOf(meseInput);

        System.out.println("Inserisci giorno:");
        int giorno = Integer.parseInt(scanner.nextLine());

        if (giorno < 1 || giorno > mese.getGiorni()) {
            System.out.println("Giorno non valido per il mese selezionato.");
            return;
        }

        int ore = dip.getOreLavorateGiornalmente();
        dip.setTotaleOreLavorate(dip.getTotaleOreLavorate() - ore);
    }


    private void mostraOreLavorate() {
    if (dipendenti.isEmpty()) {
        System.out.println("Nessun dipendente presente.");
        return;
    }

    System.out.println("\nOre Lavorate");
    for (Dipendente dip : dipendenti) {
        String tipo = (dip instanceof DipendenteFullTime) ? "Full Time" : "Part Time";
        System.out.println("Nome: " + dip.getNome() + " " + dip.getCognome());
        System.out.println("Mansione: " + dip.getMansione());
        System.out.println("Azienda: " + dip.getAzienda());
        System.out.println("Tipo: " + tipo);
        System.out.println("Ore giornaliere: " + dip.getOreLavorateGiornalmente());
    }
    System.out.println("Totale ore accumulate: " + totaleOre);
}
}