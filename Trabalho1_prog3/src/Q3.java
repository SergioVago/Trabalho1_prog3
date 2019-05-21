import java.util.Scanner;

/**
 *
 * @author SergioVago
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListaDeArtigos listaDeArtigos = new ListaDeArtigos();
        
        int qtdArtigos = in.nextInt();
        in.nextLine();
        for(int i = 0; i < qtdArtigos; i++){
            String tipoArtigo = in.nextLine();
            String titulo = in.nextLine();
            String paginas = in.nextLine();
            String nomeConfPer = in.nextLine();
            String Qualis = in.nextLine();
            
            Artigo artigo = new Artigo(tipoArtigo, titulo, paginas, nomeConfPer, Qualis);
            listaDeArtigos.adicionaArtigo(artigo);
        }
        
        listaDeArtigos.imprimeLista();
    }
}
