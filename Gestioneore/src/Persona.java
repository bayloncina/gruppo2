abstract class Persona {

    private String id;
    private int contatore = 0;
    private String nome;
    private String cognome;

    public Persona(String nome, String cognome) {
        if (nome == null || nome.trim().isEmpty()) {
            this.nome = "Utente sconosciuto";
        } else {
            this.nome = nome;
        }
        this.cognome = cognome;
        this.id = String.format("ID-%03d", ++contatore);
    }

}
