package epicode.it.archive;

// classe archivio che implementa i metodi aggiunta di un elemento del catalogo

import epicode.it.classi.CatalogoBiblioteca;
import epicode.it.classi.Libri;

import java.util.ArrayList;
import java.util.List;

public class Archivio {
    private List<CatalogoBiblioteca> catalogo = new ArrayList<>();

    public void aggiungiElemento(CatalogoBiblioteca elemento) {
        //controllo con stream che il parametro ISBN sia univoco e aggiungo una exception altrimenti inserisco l'elemento
        try {
            if (catalogo.stream().anyMatch(e -> e.getCodiceISBN().equals(elemento.getCodiceISBN()))) {
                throw new IllegalArgumentException("ISBN già presente nel catalogo");
            } else {
                catalogo.add(elemento);
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    //metodo per rimovere un elemento del catalogo dato un ISBN e restituisce una exception se l'isbn non è presente
    public void rimuoviElemento(CatalogoBiblioteca elemento) {
        if (catalogo.stream().noneMatch(e -> e.getCodiceISBN().equals(elemento.getCodiceISBN()))) {
            throw new IllegalArgumentException("ISBN non presente nel catalogo");
        } else {
            catalogo.remove(elemento);
        }
    }

    // metodo per modificare un elemento del catalogo dato un ISBN e restituisce una exception se l'isbn non è presente
    public void modificaElemento(CatalogoBiblioteca elemento) {
        if (catalogo.stream().noneMatch(e -> e.getCodiceISBN().equals(elemento.getCodiceISBN()))) {
            throw new IllegalArgumentException("ISBN non presente nel catalogo");
        } else {
            catalogo.set(catalogo.indexOf(elemento), elemento);
        }
    }

    //metodo per ricercare un elemento del catalogo dato un ISBN e restituisce una exception se l'isbn non è presente
    public CatalogoBiblioteca ricercaElemento(String codiceISBN) {
        try {
            return catalogo.stream().filter(e -> e.getCodiceISBN().equals(codiceISBN)).findFirst().orElse(null);
        } catch (Exception RicercaException) {
            throw new RuntimeException(RicercaException);
        }
    }

    //metodo con ricerca per anno di pubblicazione
    public List<CatalogoBiblioteca> ricercaPerAnno(int anno) {
        return catalogo.stream().filter(e -> e.getAnnoPubblicazione() == anno).toList();
    }

    // metodo con ricerca per autore
    public List<CatalogoBiblioteca> ricercaPerAutore(String autore) {
        return catalogo.stream().filter(e -> e instanceof Libri && ((Libri) e).getAutore().equals(autore)).toList();
    }
}
