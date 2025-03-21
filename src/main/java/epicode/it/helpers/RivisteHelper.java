package epicode.it.helpers;

import epicode.it.classi.CatalogoBiblioteca;
import epicode.it.classi.Libri;
import epicode.it.classi.Periodicita;
import epicode.it.classi.Riviste;

import java.util.List;

public class RivisteHelper {
    //inserisco una lista di riviste che vanno ad alimentare il catalogo della biblioteca
    List<CatalogoBiblioteca> catalogo = List.of(
            new Riviste("1234", "Il Signore degli Anelli", 1954, 1200, Periodicita.SETTIMANALE),
            new Riviste("1235", "1984", 1949, 328, Periodicita.MENSILE),
            new Riviste("1236", "Il Codice da Vinci", 2003, 689, Periodicita.SEMESTRALE),
            new Riviste("1237", "Harry Potter e la Pietra Filosofale", 1997, 309, Periodicita.SETTIMANALE),
            new Riviste("1238", "Il Grande Gatsby", 1925, 180, Periodicita.MENSILE),
            new Riviste("1239", "Cronache del ghiaccio e del fuoco", 2009, 800, Periodicita.SEMESTRALE),
            new Riviste("1240", "Il Nome della Rosa", 1980, 507, Periodicita.SETTIMANALE),
            new Riviste("1241", "Il Signore degli Anelli", 1954, 1170, Periodicita.MENSILE),
            new Riviste("1242", "Il Signore degli Anelli", 1954, 1170, Periodicita.SEMESTRALE),
            new Riviste("1243", "Il Signore degli Anelli", 1954, 1170, Periodicita.SETTIMANALE),
            new Riviste("1244", "Il Signore degli Anelli", 1954, 1170, Periodicita.MENSILE),
            new Riviste("1245", "Il Signore degli Anelli", 1954, 1170, Periodicita.SEMESTRALE)
    );

    public List<CatalogoBiblioteca> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<CatalogoBiblioteca> catalogo) {
        this.catalogo = catalogo;
    }
}
