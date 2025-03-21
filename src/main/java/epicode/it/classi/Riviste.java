package epicode.it.classi;

public class Riviste extends CatalogoBiblioteca {
    private Periodicita periodicita;

    public Riviste(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }
}
