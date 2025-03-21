package epicode.it.archive;

// classe archivio che implementa i metodi aggiunta di un elemento del catalogo

import epicode.it.classi.CatalogoBiblioteca;
import epicode.it.classi.Libri;
import epicode.it.classi.Riviste;
import epicode.it.exceptions.RicercaException;
import epicode.it.stampe.StampaElementi;
import epicode.it.stampe.StampaStatistiche;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Archivio {
    List<CatalogoBiblioteca> catalogo = new ArrayList<>();

    public void aggiungiElemento(CatalogoBiblioteca elemento) {
        try {
            // Controllo se l'ISBN è già presente nel catalogo
            if (catalogo.stream().anyMatch(e -> e.getcodiceIsbn().equals(elemento.getcodiceIsbn()))) {
                throw new Exception("ISBN già presente nel catalogo: " + elemento.getcodiceIsbn());
            } else {
                catalogo.add(elemento);
                System.out.println();
                System.out.println("Elemento con ISBN " + elemento.getcodiceIsbn() + " aggiunto con successo!");
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'aggiunta dell'elemento: " + e.getMessage());
        }
    }

    //metodo per rimovere un elemento del catalogo dato un ISBN e restituisce una exception se l'isbn non è presente
    public void rimuoviElemento(String elemento) {
        try {
            if (catalogo.stream().noneMatch(e -> e.getcodiceIsbn().equals(elemento))) {
                throw new Exception("ISBN non presente nel catalogo " + elemento);
            } else {
                catalogo.removeIf(e -> e.getcodiceIsbn().equals(elemento));
                System.out.println();
                System.out.println("Elemento con ISBN " + elemento + " rimosso con successo!");
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println("Errore durante la rimozione dell'elemento: " + e.getMessage());
        }
    }

    // metodo per modificare un elemento del catalogo dato un ISBN e restituisce una exception se l'isbn non è presente
    public void modificaElemento(CatalogoBiblioteca elemento) {
        try {
            if (catalogo.stream().noneMatch(e -> e.getcodiceIsbn().equals(elemento.getcodiceIsbn()))) {
                throw new RicercaException();
            } else {
                catalogo.removeIf(e -> e.getcodiceIsbn().equals(elemento.getcodiceIsbn()));
                catalogo.add(elemento);
                System.out.println();
                System.out.println("Elemento con ISBN " + elemento.getcodiceIsbn() + " modificato con successo!");
                System.out.println();
            }
        } catch (RicercaException e) {
            System.err.println(e.getMessage());
        }
    }

    //metodo per ricercare un elemento del catalogo dato un ISBN e restituisce una exception se l'isbn non è presente
    public void ricercaElemento(String codiceIsbn) {
        try {
            if (catalogo.stream().noneMatch(e -> e.getcodiceIsbn().equals(codiceIsbn))) {
                throw new RicercaException();
            } else {
                System.out.println("Elemento trovato: ");
                System.out.println();
                StampaElementi.stampaListaElementi(catalogo.stream().filter(e -> e.getcodiceIsbn().equals(codiceIsbn)).findFirst().get());
            }
        } catch (RicercaException e) {
            System.err.println(e.getMessage());
        }
    }

    //metodo con ricerca per anno di pubblicazione
    public void ricercaPerAnno(int anno) {
        System.out.println("Elementi pubblicati nel " + anno);
        System.out.println();
        catalogo.stream().filter(e -> e.getAnnoPubblicazione() == anno).forEach(StampaElementi::stampaListaElementi);
    }

    // metodo con ricerca per autore
    public void ricercaPerAutore(String autore) {
        System.out.println("Elementi dell'autore " + autore);
        System.out.println();
        catalogo.stream().filter(e -> e instanceof Libri && ((Libri) e).getAutore().toLowerCase().contains(autore)).forEach(StampaElementi::stampaListaElementi);
    }

    //metodo con ricerca per genere (è un'aggiunta rispetto alla traccia)
    public void ricercaPerGenere(String genere) {
        System.out.println("Elementi del genere " + genere);
        System.out.println();
        catalogo.stream().filter(e -> e instanceof Libri && ((Libri) e).getGenere().toLowerCase().contains(genere)).forEach(StampaElementi::stampaListaElementi);
    }

    //metodo per statistiche del catalogo: numero totale di libri, numero totale di riviste, elemento con più pagine, media delle pagine di tutti gli elementi
    public void statistiche() {
        long countLibri = catalogo.stream().filter(e -> e instanceof Libri).count();
        long countRiviste = catalogo.stream().filter(e -> e instanceof Riviste).count();
        int maxPagine = catalogo.stream().mapToInt(CatalogoBiblioteca::getNumeroPagine).max().orElse(0);
        String titleMaxPage = catalogo.stream().filter(e -> e.getNumeroPagine() == maxPagine).findFirst().get().getTitolo();
        String isbnMaxPage = catalogo.stream().filter(e -> e.getNumeroPagine() == maxPagine).findFirst().get().getcodiceIsbn();
        double mediaPagine = catalogo.stream().mapToInt(CatalogoBiblioteca::getNumeroPagine).average().orElse(0.0);
        StampaStatistiche.stampaStatistiche(countLibri, countRiviste, maxPagine, titleMaxPage, isbnMaxPage, mediaPagine);
    }

    public List<CatalogoBiblioteca> getCatalogoArchivio() {
        return catalogo;
    }

    public void setCatalogoArchivio(List<CatalogoBiblioteca> catalogo) {
        this.catalogo = catalogo;
    }

    public Object tipoElemento(String codiceIsbn) {
        return catalogo.stream().filter(e -> e.getcodiceIsbn().equals(codiceIsbn)).findFirst().get();
    }
}
