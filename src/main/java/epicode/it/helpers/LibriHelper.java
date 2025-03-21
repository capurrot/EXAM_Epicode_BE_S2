package epicode.it.helpers;

import epicode.it.classi.CatalogoBiblioteca;
import epicode.it.classi.Libri;
import epicode.it.classi.Riviste;

import java.util.List;

public class LibriHelper {
    //inserisco una lista di libri che vanno ad alimentare il catalogo della biblioteca
    List<CatalogoBiblioteca> catalogo = List.of(
            new Libri("1234", "Il Signore degli Anelli", 1954, 1200, "J.R.R. Tolkien", "Fantasy"),
            new Libri("1235", "1984", 1949, 328, "George Orwell", "Distopia"),
            new Libri("1236", "Il Codice da Vinci", 2003, 689, "Dan Brown", "Thriller"),
            new Libri("1237", "Harry Potter e la Pietra Filosofale", 1997, 309, "J.K. Rowling", "Fantasy"),
            new Libri("1238", "Il Grande Gatsby", 1925, 180, "F. Scott Fitzgerald", "Romanzo"),
            new Libri("1239", "Cronache del ghiaccio e del fuoco", 2009, 800, "George R.R. Martin", "Fantasy"),
            new Libri("1240", "Il Nome della Rosa", 1980, 507, "Umberto Eco", "Romanzo"),
            new Libri("1241", "Il Signore degli Anelli", 1954, 1170, "J.R.R. Tolkien", "Fantasy"),
            new Libri("1242", "Il Signore degli Anelli", 1954, 1170, "J.R.R. Tolkien", "Fantasy"),
            new Libri("1243", "Il Signore degli Anelli", 1954, 1170, "J.R.R. Tolkien", "Fantasy"),
            new Libri("1244", "Il Signore degli Anelli", 1954, 1170, "J.R.R. Tolkien", "Fantasy"),
            new Libri("1245", "Il Signore degli Anelli", 1954, 1170, "J.R.R. Tolkien", "Fantasy")
    );

    public List<CatalogoBiblioteca> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<CatalogoBiblioteca> catalogo) {
        this.catalogo = catalogo;
    }
}
