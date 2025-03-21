package epicode.it.stampe;

public class StampaStatistiche {
    public static void stampaStatistiche(long countLibri, long countRiviste, int maxPagine, String titleMaxPage, String isbnMaxPage, double mediaPagine) {
        System.out.println("Numero totale di libri: " + countLibri);
        System.out.println("Numero totale di riviste: " + countRiviste);
        System.out.println("Elemento con più pagine: ISBN " + isbnMaxPage + " con titolo: " + titleMaxPage + " ("+ maxPagine + " pagine)");
        System.out.println("Media delle pagine: " + mediaPagine);
        System.out.println();
    }
}
