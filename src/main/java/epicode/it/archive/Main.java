package epicode.it.archive;

import epicode.it.classi.CatalogoBiblioteca;
import epicode.it.classi.Libri;
import epicode.it.classi.Periodicita;
import epicode.it.classi.Riviste;
import epicode.it.helpers.LibriHelper;
import epicode.it.helpers.RivisteHelper;
import epicode.it.stampe.StampaElementi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibriHelper libriHelper = new LibriHelper();
        RivisteHelper rivisteHelper = new RivisteHelper();
        Archivio archivio = new Archivio();
        archivio.getCatalogoArchivio().addAll(libriHelper.getCatalogoLibri());
        archivio.getCatalogoArchivio().addAll(rivisteHelper.getCatalogoRiviste());

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
            int scelta;
            try {
                System.out.println("Inserisci la tua scelta dal menu principale: ");
                scelta = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.err.println("Inserisci un numero valido");
                scanner.nextLine();
                continue;
            }
            switch (scelta) {
                case 1:
                    System.out.println("Hai scelto di aggiungere un elemento al catalogo: seleziona 1 per libro, 2 per rivista");
                    int scelta2;
                    try {
                        scelta2 = scanner.nextInt();
                        scanner.nextLine();
                    } catch (Exception e) {
                        System.err.println("Inserisci un numero valido: 1 per libro, 2 per rivista");
                        scanner.nextLine();
                        continue;
                    }
                    try {
                        if (scelta2 != 1 && scelta2 != 2) {
                            throw new Exception();
                        }
                        if (scelta2 == 1) {
                            System.out.println("Inserisci il codice ISBN: ");
                            String codiceIsbnAdd = scanner.nextLine();
                            System.out.println("Inserisci il titolo: ");
                            String titolo = scanner.nextLine();
                            System.out.println("Inserisci l'anno di pubblicazione: ");
                            int annoPubblicazione = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Inserisci il numero di pagine: ");
                            int numeroPagine = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Inserisci l'autore: ");
                            String autore = scanner.nextLine();
                            System.out.println("Inserisci il genere: ");
                            String genere = scanner.nextLine();
                            archivio.aggiungiElemento(new Libri(codiceIsbnAdd, titolo, annoPubblicazione, numeroPagine, autore, genere));
                        } else if (scelta2 == 2) {
                            System.out.println("Inserisci il codice ISBN: ");
                            String codiceIsbnAdd = scanner.next();
                            scanner.nextLine();
                            System.out.println("Inserisci il titolo: ");
                            String titolo = scanner.nextLine();
                            System.out.println("Inserisci l'anno di pubblicazione: ");
                            int annoPubblicazione = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Inserisci il numero di pagine: ");
                            int numeroPagine = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Inserisci la periodicità - 1: Settimanale, 2: Mensile, 3: Semestrale");
                            int periodicita = scanner.nextInt();
                            scanner.nextLine();
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
                            archivio.aggiungiElemento(new Riviste(codiceIsbnAdd, titolo, annoPubblicazione, numeroPagine, miaPeriodicita));
                        }
                    } catch (Exception e) {
                        System.err.println("Hai inserito un numero sbagliato: 1 per libro, 2 per rivista");
                    }
                    break;
                case 2:
                    System.out.println("Hai scelto di rimuovere un elemento dal catalogo: inserisci il codice ISBN: ");
                    String codiceIsbnRemove = scanner.next();
                    archivio.rimuoviElemento(codiceIsbnRemove);
                    break;
                case 3:
                    System.out.println("Hai scelto di modificare un elemento del catalogo: inserisci il codice ISBN: ");
                    String codiceIsbnModify = scanner.next();
                    try {
                        if (archivio.tipoElemento(codiceIsbnModify) == null) {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.err.println("Elemento con codice ISBN " + codiceIsbnModify + " non trovato");
                        break;
                    }
                    System.out.println("L'elemento che si vuole modificare di seguito: ");
                    StampaElementi.stampaListaElementi((CatalogoBiblioteca) archivio.tipoElemento(codiceIsbnModify));
                    if (archivio.tipoElemento(codiceIsbnModify) instanceof Libri) {
                        System.out.println("Stai modificando un Libro: ");
                        System.out.println("Modifica il titolo: ");
                        scanner.nextLine();
                        String titolo = scanner.nextLine();
                        System.out.println("Modifica l'anno di pubblicazione: ");
                        int annoPubblicazione = scanner.nextInt();
                        System.out.println("Modifica il numero di pagine: ");
                        int numeroPagine = scanner.nextInt();
                        System.out.println("Modifica l'autore: ");
                        scanner.nextLine();
                        String autore = scanner.nextLine();
                        System.out.println("Modifica il genere: ");
                        String genere = scanner.next();
                        archivio.modificaElemento(new Libri(codiceIsbnModify, titolo, annoPubblicazione, numeroPagine, autore, genere));
                    } else if (archivio.tipoElemento(codiceIsbnModify) instanceof Riviste) {
                        System.out.println("Stai modificando una Rivista: ");
                        System.out.println("Modifica il titolo: ");
                        scanner.nextLine();
                        String titolo = scanner.nextLine();
                        System.out.println("Modifica l'anno di pubblicazione: ");
                        int annoPubblicazione = scanner.nextInt();
                        System.out.println("Modifica il numero di pagine: ");
                        int numeroPagine = scanner.nextInt();
                        System.out.println("Modifica la periodicità - 1: Settimanale, 2: Mensile, 3: Semestrale");
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
                        archivio.modificaElemento(new Riviste(codiceIsbnModify, titolo, annoPubblicazione, numeroPagine, miaPeriodicita));
                    }

                    break;
                    case 4:
                    System.out.println("Hai scelto di cercare un elemento del catalogo: inserisci il codice ISBN: ");
                    String codiceIsbn2 = scanner.next();
                    archivio.ricercaElemento(codiceIsbn2);
                    break;
                    case 5:
                    System.out.println("Hai scelto di visualizzare le statistiche del catalogo: ");
                    archivio.statistiche();
                    break;
                    case 6:
                    System.out.println("Hai scelto di visualizzare tutti gli elementi di un determinato anno: inserisci l'anno: ");
                    int anno = scanner.nextInt();
                    archivio.ricercaPerAnno(anno);
                    break;
                    case 7:
                    System.out.println("Hai scelto di visualizzare tutti gli elementi di un determinato genere: inserisci il genere: ");
                    String genere = scanner.next();
                    archivio.ricercaPerGenere(genere.toLowerCase());
                    break;
                    case 8:
                    System.out.println("Hai scelto di visualizzare tutti gli elementi di un determinato autore: inserisci l'autore: ");
                    String autore = scanner.next();
                    archivio.ricercaPerAutore(autore.toLowerCase());
                    break;
                    case 9:
                    System.out.println("Hai scelto di visualizzare tutti gli elementi del catalogo: ");
                    StampaElementi.stampaListaElementi(archivio.getCatalogoArchivio());
                    break;
                    case 0:
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
