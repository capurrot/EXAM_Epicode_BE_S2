package epicode.it.archive;

import epicode.it.classi.Libri;
import epicode.it.classi.Periodicita;
import epicode.it.classi.Riviste;
import epicode.it.helpers.LibriHelper;
import epicode.it.helpers.RivisteHelper;
import epicode.it.stampe.StampaCatalogo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibriHelper libriHelper = new LibriHelper();
        RivisteHelper rivisteHelper = new RivisteHelper();
        Archivio archivio = new Archivio();
        archivio.setCatalogo(libriHelper.getCatalogo());
        archivio.setCatalogo(rivisteHelper.getCatalogo());

        System.out.println("########################################################");
        System.out.println("############ BENVENUTO NELLA MIA BIBLIOTECA ############");
        System.out.println("########################################################");
        System.out.println();
        System.out.println("Menu di scelta: ");
        System.out.println("1. Aggiungi un elemento al catalogo");
        System.out.println("2. Rimuovi un elemento dal catalogo");
        System.out.println("3. Modifica un elemento del catalogo");
        System.out.println("4. Ricerca un elemento del catalogo");
        System.out.println("5. Visualizza statistiche del catalogo");
        System.out.println("6. Visualizza tutti gli elementi di un determinato anno");
        System.out.println("7. Visualizza tutti gli elementi di un determinato genere");
        System.out.println("8. Visualizza tutti gli elementi di un determinato autore");
        System.out.println("9. Visualizza tutti gli elementi del catalogo");
        System.out.println("0. Esci");
        System.out.println();
        System.out.println("########################################################");
        System.out.println("########################################################");
        System.out.println();


        while (true) {
            System.out.print("Inserisci la tua scelta: ");
            int scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    System.out.println("Hai scelto di aggiungere un elemento al catalogo: seleziona 1 per libro, 2 per rivista");
                    int scelta2 = scanner.nextInt();
                    if (scelta2 == 1) {
                        System.out.println("Inserisci il codice ISBN: ");
                        String codiceISBN = scanner.next();
                        System.out.println("Inserisci il titolo: ");
                        String titolo = scanner.next();
                        System.out.println("Inserisci l'anno di pubblicazione: ");
                        int annoPubblicazione = scanner.nextInt();
                        System.out.println("Inserisci il numero di pagine: ");
                        int numeroPagine = scanner.nextInt();
                        System.out.println("Inserisci l'autore: ");
                        String autore = scanner.next();
                        System.out.println("Inserisci il genere: ");
                        String genere = scanner.next();
                        archivio.aggiungiElemento(new Libri(codiceISBN, titolo, annoPubblicazione, numeroPagine, autore, genere));
                    } else if (scelta2 == 2) {
                        System.out.println("Inserisci il codice ISBN: ");
                        String codiceISBN = scanner.next();
                        System.out.println("Inserisci il titolo: ");
                        String titolo = scanner.next();
                        System.out.println("Inserisci l'anno di pubblicazione: ");
                        int annoPubblicazione = scanner.nextInt();
                        System.out.println("Inserisci il numero di pagine: ");
                        int numeroPagine = scanner.nextInt();
                        System.out.println("Inserisci la periodicità - 1: Settimanale, 2: Mensile, 3: Semestrale");
                        int periodicita = scanner.nextInt();
                        Periodicita miaPeriodicita = null;
                        switch (periodicita) {
                            case 1:
                                miaPeriodicita = Periodicita.SETTIMANALE;
                                break;
                            case 2:
                                miaPeriodicita = Periodicita.MENSILE;
                                break;
                            case 3:
                                miaPeriodicita = Periodicita.SEMESTRALE;
                                break;
                            default:
                                System.out.println("Scelta non valida");
                                break;
                        }
                        archivio.aggiungiElemento(new Riviste(codiceISBN, titolo, annoPubblicazione, numeroPagine, miaPeriodicita));
                    } else {
                        System.out.println("Scelta non valida");
                    }
                    break;
                case 2:
                    System.out.println("Hai scelto di rimuovere un elemento dal catalogo: inserisci il codice ISBN: ");
                    break;
                case 3:
                    System.out.println("Hai scelto di modificare un elemento del catalogo: inserisci il codice ISBN: ");
                    String codiceISBN = scanner.next();
                    //controllo se l'elemento è un libro o una rivista
                    if (archivio.ricercaElemento(codiceISBN) instanceof Libri) {
                        System.out.println("Hai scelto di modificare un libro: inserisci il titolo: ");
                        String titolo = scanner.next();
                        System.out.println("Inserisci l'anno di pubblicazione: ");
                        int annoPubblicazione = scanner.nextInt();
                        System.out.println("Inserisci il numero di pagine: ");
                        int numeroPagine = scanner.nextInt();
                        System.out.println("Inserisci l'autore: ");
                        String autore = scanner.next();
                        System.out.println("Inserisci il genere: ");
                        String genere = scanner.next();
                        archivio.modificaElemento(new Libri(codiceISBN, titolo, annoPubblicazione, numeroPagine, autore, genere));
                    } else if (archivio.ricercaElemento(codiceISBN) instanceof Riviste) {
                        System.out.println("Hai scelto di modificare una rivista: inserisci il titolo: ");
                        String titolo = scanner.next();
                        System.out.println("Inserisci l'anno di pubblicazione: ");
                        int annoPubblicazione = scanner.nextInt();
                        System.out.println("Inserisci il numero di pagine: ");
                        int numeroPagine = scanner.nextInt();
                        System.out.println("Inserisci la periodicità - 1: Settimanale, 2: Mensile, 3: Semestrale");
                        int periodicita = scanner.nextInt();
                        Periodicita miaPeriodicita = null;
                        switch (periodicita) {
                            case 1:
                                miaPeriodicita = Periodicita.SETTIMANALE;
                                break;
                            case 2:
                                miaPeriodicita = Periodicita.MENSILE;
                                break;
                            case 3:
                                miaPeriodicita = Periodicita.SEMESTRALE;
                                break;
                            default:
                                System.out.println("Scelta non valida");
                                break;
                        }
                        archivio.modificaElemento(new Riviste(codiceISBN, titolo, annoPubblicazione, numeroPagine, miaPeriodicita));
                    } else {
                        System.out.println("Scelta non valida");
                    }
                    break;
                    case 4:
                    System.out.println("Hai scelto di cercare un elemento del catalogo: inserisci il codice ISBN: ");
                    String codiceISBN2 = scanner.next();
                    System.out.println(archivio.ricercaElemento(codiceISBN2));
                    break;
                    case 5:
                    System.out.println("Hai scelto di visualizzare le statistiche del catalogo: ");
                    archivio.statistiche();
                    break;
                    case 6:
                    System.out.println("Hai scelto di visualizzare tutti gli elementi di un determinato anno: inserisci l'anno: ");
                    int anno = scanner.nextInt();
                    System.out.println(archivio.ricercaPerAnno(anno));
                    break;
                    case 7:
                    System.out.println("Hai scelto di visualizzare tutti gli elementi di un determinato genere: inserisci il genere: ");
                    String genere = scanner.next();
                    System.out.println(archivio.ricercaPerGenere(genere));
                    break;
                    case 8:
                    System.out.println("Hai scelto di visualizzare tutti gli elementi di un determinato autore: inserisci l'autore: ");
                    String autore = scanner.next();
                    System.out.println(archivio.ricercaPerAutore(autore));
                    break;
                    case 9:
                    System.out.println("Hai scelto di visualizzare tutti gli elementi del catalogo: ");
                    StampaCatalogo.stampaListaCatalogo(archivio.getCatalogo());
                    break;


                    case 0:
                    System.out.println("Arrivederci!");
                    break;
                    default:
                    System.out.println("Scelta non valida");
            }
            if (scelta == 0) {
                System.out.println("Arrivederci!");
                break;
            }
            System.out.println("########################################################");
            System.out.println("########################################################");
            System.out.println();
        }
    }

}
