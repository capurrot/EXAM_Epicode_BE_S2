package epicode.it.helpers;

import epicode.it.classi.CatalogoBiblioteca;
import epicode.it.classi.Libri;
import epicode.it.classi.Periodicita;
import epicode.it.classi.Riviste;

import java.util.List;

public class RivisteHelper {
    //inserisco una lista di riviste che vanno ad alimentare il catalogo della biblioteca
    List<CatalogoBiblioteca> catalogoRiviste = List.of(
            new Riviste("1246", "Il Signore degli Anelli", 1954, 1200, Periodicita.SETTIMANALE),
            new Riviste("1247", "1984", 1949, 328, Periodicita.MENSILE),
            new Riviste("1248", "Il Codice da Vinci", 2003, 689, Periodicita.SEMESTRALE),
            new Riviste("1249", "Harry Potter e la Pietra Filosofale", 1997, 309, Periodicita.SETTIMANALE),
            new Riviste("1250", "Il Grande Gatsby", 1925, 180, Periodicita.MENSILE),
            new Riviste("1251", "Cronache del ghiaccio e del fuoco", 2009, 800, Periodicita.SEMESTRALE),
            new Riviste("1252", "Il Nome della Rosa", 1980, 507, Periodicita.SETTIMANALE),
            new Riviste("1253", "Il Signore degli Anelli", 1954, 1170, Periodicita.MENSILE),
            new Riviste("1254", "Il Signore degli Anelli", 1954, 1170, Periodicita.SEMESTRALE),
            new Riviste("1255", "Il Signore degli Anelli", 1954, 1170, Periodicita.SETTIMANALE),
            new Riviste("1256", "Il Signore degli Anelli", 1954, 1170, Periodicita.MENSILE),
            new Riviste("1257", "Il Signore degli Anelli", 1954, 1170, Periodicita.SEMESTRALE)
    );

    public List<CatalogoBiblioteca> getCatalogoRiviste() {
        return catalogoRiviste;
    }
}
