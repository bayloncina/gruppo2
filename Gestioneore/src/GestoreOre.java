import java.util.ArrayList;
import java.util.Scanner;

public class GestoreOre {

                        private void inseisciOre(ArrayList dipendenti, Scanner scanner) {
			            int totaleOre = 0;
                        
                        System.out.println("Seleziona dipendente: ");
                        for (int i = 0; i < dipendenti.size(); i++) {
                            System.out.println(i + " - " + dipendenti.get(i).getNome());
                        }

                        int scelta = Integer.parseInt(scanner.nextLine());
                        Dipendente dip = dipendenti.get(scelta);

                        // mese
                        System.out.println("Inserisci mese:");
                        String meseInput = scanner.nextLine();
                        EnumMese mese = EnumMese.valueOf(meseInput);

                        // giorno
                        System.out.println("Inserisci giorno:");
                        int giorno = Integer.parseInt(scanner.nextLine());
                        
                        //totale ore
                        int ore = dip.getOreGiornaliere();
                        totaleOre += ore;
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
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {
                }
                case 4 -> {

                }
                case 0 -> {

                }
                default -> System.out.println("Scelta non valida.");
            }
        }

        scanner.close();
    }

}
