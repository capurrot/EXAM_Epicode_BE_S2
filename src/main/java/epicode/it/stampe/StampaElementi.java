package epicode.it.stampe;

import epicode.it.classi.CatalogoBiblioteca;
import epicode.it.classi.Libri;
import epicode.it.classi.Riviste;

import java.util.List;

public class StampaElementi {

    public static void stampaListaElementi(List<CatalogoBiblioteca> catalogo) {
        catalogo.stream().forEach(StampaElementi::stampaListaElementi);
    }

    public static void stampaListaElementi(CatalogoBiblioteca elemento) {
        System.out.println("Codice ISBN: " + elemento.getcodiceIsbn());
        System.out.println("Titolo: " + elemento.getTitolo());
        System.out.println("Anno di pubblicazione: " + elemento.getAnnoPubblicazione());
        System.out.println("Numero di pagine: " + elemento.getNumeroPagine());

        if (elemento instanceof Libri libro) {
            System.out.println("Tipo: Libro");
            System.out.println("Autore: " + libro.getAutore());
            System.out.println("Genere: " + libro.getGenere());
        } else if (elemento instanceof Riviste rivista) {
            System.out.println("Tipo: Rivista");
            System.out.println("Periodicità: " + rivista.getPeriodicita());
        }
        System.out.println();
    }
}
