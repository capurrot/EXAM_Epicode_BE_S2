package epicode.it.classi;

public class Libri extends CatalogoBiblioteca {
    private String autore;
    private String genere;

    public Libri(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }
}
