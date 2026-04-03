import java.util.Scanner;

public class GestoreOre {

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
