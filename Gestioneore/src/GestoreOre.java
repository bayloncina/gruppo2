import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class GestoreOre {

    private ArrayList<Dipendente> dipendenti = new ArrayList<>();
    int totaleOre;

    public static void main(String[] args) {
        GestoreOre gestore = new GestoreOre();
        gestore.inizializzaDipendenti();
        gestore.avviaGUI();
    }

    private void avviaGUI() {
        JFrame frame = new JFrame("Gestionale Ore");

        String html = """
                <html>
                <body style='font-family: Arial; text-align:center;'>
                    <h1>GESTIONALE ORE</h1>
                    <br>
                    <a href='azione:1'>Inserisci ore</a><br><br>
                    <a href='azione:2'>Modifica ore</a><br><br>
                    <a href='azione:3'>Elimina ore</a><br><br>
                    <a href='azione:4'>Mostra ore lavorate</a><br><br>
                    <a href='azione:5'>Mostra HTML dipendenti</a><br><br>
                    <a href='azione:0'>Esci</a>
                </body>
                </html>
                """;

        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setEditable(false);
        editorPane.setText(html);

        editorPane.addHyperlinkListener(e -> {
            if (e.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED) {
                String desc = e.getDescription();

                if (desc.startsWith("azione:")) {
                    int scelta = Integer.parseInt(desc.split(":")[1]);
                    gestisciAzione(scelta);
                }
            }
        });

        frame.add(new JScrollPane(editorPane));
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void gestisciAzione(int scelta) {
        switch (scelta) {
            case 1 -> inserisciOreGUI();
            case 2 -> modificaOreGUI();
            case 3 -> eliminaOreGUI();
            case 4 -> mostraOreLavorateGUI();
            case 5 -> mostraListaDipendentiHTML();
            case 0 -> System.exit(0);
            default -> JOptionPane.showMessageDialog(null, "Scelta non valida");
        }
    }

    private void inserisciOreGUI() {
        Dipendente dip = selezionaDipendente();
        if (dip == null)
            return;

        String meseInput = JOptionPane.showInputDialog("Inserisci mese (es. GENNAIO):");
        EnumMese mese = EnumMese.valueOf(meseInput);

        int giorno = Integer.parseInt(JOptionPane.showInputDialog("Inserisci giorno:"));

        if (giorno < 1 || giorno > mese.getGiorni()) {
            JOptionPane.showMessageDialog(null, "Giorno non valido");
            return;
        }

        int ore = dip.getOreLavorateGiornalmente();
        dip.setTotaleOreLavorate(dip.getTotaleOreLavorate() + ore);
    }

    private void modificaOreGUI() {
        Dipendente dip = selezionaDipendente();
        if (dip == null)
            return;

        int oreAttuali = dip.getOreLavorateGiornalmente();

        int nuoveOre = Integer.parseInt(
                JOptionPane.showInputDialog("Ore attuali: " + oreAttuali + "\nNuove ore:"));

        int totale = dip.getTotaleOreLavorate();
        totale = totale - oreAttuali + nuoveOre;

        dip.setTotaleOreLavorate(totale);
    }

    private void eliminaOreGUI() {
        Dipendente dip = selezionaDipendente();
        if (dip == null)
            return;

        int ore = dip.getOreLavorateGiornalmente();
        dip.setTotaleOreLavorate(dip.getTotaleOreLavorate() - ore);
    }

    private void mostraOreLavorateGUI() {
        Dipendente dip = selezionaDipendente();
        if (dip == null)
            return;

        String tipo = (dip instanceof DipendenteFullTime) ? "Full Time" : "Part Time";

        String msg = """
                Nome: %s %s
                Mansione: %s
                Azienda: %s
                Tipo: %s
                Ore giornaliere: %d
                Totale ore: %d
                """.formatted(
                dip.getNome(),
                dip.getCognome(),
                dip.getMansione(),
                dip.getAzienda(),
                tipo,
                dip.getOreLavorateGiornalmente(),
                dip.getTotaleOreLavorate());

        JOptionPane.showMessageDialog(null, msg);
    }

    private Dipendente selezionaDipendente() {
        String[] nomi = dipendenti.stream()
                .map(d -> d.getNome() + " " + d.getCognome())
                .toArray(String[]::new);

        int scelta = JOptionPane.showOptionDialog(
                null,
                "Seleziona dipendente",
                "Dipendenti",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                nomi,
                nomi[0]);

        if (scelta < 0)
            return null;

        return dipendenti.get(scelta);
    }

    /*
     * public void menu() {
     * Scanner scanner = new Scanner(System.in);
     * boolean running = true;
     * 
     * while (running) {
     * System.out.println("\n===== GESTIONALE ORE =====");
     * System.out.println("1. Inserisci ore");
     * System.out.println("2. Modifica ore inserite");
     * System.out.println("3. Elimina ore inserite");
     * System.out.println("4. Mostra ore lavorate");
     * System.out.println("5. Mostra Html");
     * System.out.println("0. Esci");
     * System.out.print("Scelta: ");
     * 
     * int scelta = scanner.nextInt();
     * scanner.nextLine();
     * 
     * switch (scelta) {
     * case 1 -> inserisciOre(dipendenti, scanner);
     * case 2 -> modificaOre(dipendenti, scanner);
     * case 3 -> eliminaOre(dipendenti, scanner);
     * case 4 -> mostraOreLavorate(dipendenti, scanner);
     * case 5 -> mostraListaDipendentiHTML();
     * case 0 -> {
     * running = false;
     * System.out.println("Chiusura del programma");
     * }
     * default -> System.out.println("Scelta non valida.");
     * }
     * }
     * 
     * scanner.close();
     * }
     */

    // inserisci Ore
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

    private void modificaOre(ArrayList<Dipendente> dipendenti, Scanner scanner) {
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

        int oreAttuali = dip.getOreLavorateGiornalmente();

        System.out.println("Ore attuali giornaliere: " + oreAttuali);
        System.out.println("Inserisci nuove ore giornaliere:");
        int nuoveOre = Integer.parseInt(scanner.nextLine());

        int totale = dip.getTotaleOreLavorate(); // tolgo vecchie ore e aggiungo nuove
        totale = totale - oreAttuali + nuoveOre;

        dip.setTotaleOreLavorate(totale);

        System.out.println("Ore modificate correttamente.");
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

    // Mostra ore lavorate per dipendente
    private void mostraOreLavorate(ArrayList<Dipendente> dipendenti, Scanner scanner) {
        if (dipendenti.isEmpty()) {
            System.out.println("Nessun dipendente presente.");
            return;
        }

        System.out.println("Seleziona dipendente:");
        for (int i = 0; i < dipendenti.size(); i++) {
            System.out.println(i + " - " + dipendenti.get(i).getNome());
        }

        int scelta = Integer.parseInt(scanner.nextLine());
        Dipendente dip = dipendenti.get(scelta);

        String tipo = (dip instanceof DipendenteFullTime) ? "Full Time" : "Part Time";
        System.out.println("\n===== ORE LAVORATE =====");
        System.out.println("Nome: " + dip.getNome() + " " + dip.getCognome());
        System.out.println("Mansione: " + dip.getMansione());
        System.out.println("Azienda: " + dip.getAzienda());
        System.out.println("Tipo: " + tipo);
        System.out.println("Ore giornaliere: " + dip.getOreLavorateGiornalmente());
        System.out.println("Totale ore lavorate: " + dip.getTotaleOreLavorate());
    }

    private void mostraListaDipendentiHTML() {
        // costruisci l'HTML
        StringBuilder html = new StringBuilder();
        html.append("<html><body>");
        html.append("<h2>Lista Dipendenti</h2>");
        html.append("<table border='1' cellpadding='8'>");
        html.append(
                "<tr><th>Nome</th><th>Cognome</th><th>Mansione</th><th>Azienda</th><th>Tipo</th><th>Ore giornaliere</th></tr>");

        for (Dipendente dip : dipendenti) {
            String tipo = (dip instanceof DipendenteFullTime) ? "Full Time" : "Part Time";
            html.append("<tr>")
                    .append("<td>").append(dip.getNome()).append("</td>")
                    .append("<td>").append(dip.getCognome()).append("</td>")
                    .append("<td>").append(dip.getMansione()).append("</td>")
                    .append("<td>").append(dip.getAzienda()).append("</td>")
                    .append("<td>").append(tipo).append("</td>")
                    .append("<td>").append(dip.getOreLavorateGiornalmente()).append("</td>")
                    .append("</tr>");
        }

        html.append("</table>");
        html.append("</body></html>");

        // mostra nella GUI
        JFrame frame = new JFrame("Lista Dipendenti");
        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setEditable(false);
        editorPane.setText(html.toString());

        frame.add(new JScrollPane(editorPane));
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void inizializzaDipendenti() {
        dipendenti.add(new DipendenteFullTime("Mario", "Rossi", "Acme Srl", "Sviluppatore"));
        dipendenti.add(new DipendenteFullTime("Luca", "Bianchi", "Acme Srl", "Analista"));
        dipendenti.add(new DipendentePartTime("Sara", "Verdi", "Acme Srl", "Designer"));
        dipendenti.add(new DipendentePartTime("Anna", "Neri", "Acme Srl", "Tester"));
    }
}