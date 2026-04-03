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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getContatore() {
        return contatore;
    }

    public void setContatore(int contatore) {
        this.contatore = contatore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
