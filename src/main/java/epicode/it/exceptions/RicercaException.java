package epicode.it.exceptions;

public class RicercaException extends Exception {
    public RicercaException() {
        super("ISBN non presente nel catalogo!");
    }
}
