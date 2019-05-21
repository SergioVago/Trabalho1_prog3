import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author SergioVago
 */
public class ListaDeArtigos {
    private ArrayList<Artigo> listaCurto;
    private ArrayList<Artigo> listaLongo;
    private ArrayList<Artigo> listaPeriodico;
    private int qtdTotalPaginas;
    private int qtdPaginaPeriodico;
    private int qtdPaginaCurto;
    private int qtdPaginaLongo;
    private HashMap<String, Integer> mapa;    
    
    public ListaDeArtigos() {
        this.mapa = new HashMap<String, Integer>();
        this.listaCurto = new ArrayList<>();
        this.listaLongo = new ArrayList<>();
        this.listaPeriodico = new ArrayList<>();
        this.qtdTotalPaginas = 0;
        this.qtdPaginaPeriodico = 0;
        this.qtdPaginaCurto = 0;
        this.qtdPaginaLongo = 0;
        
    }
    
    public void adicionaArtigo(Artigo artigo){
        if(artigo.ehValido()){
            int qtdPaginas = artigo.getQtdPaginas();
            switch (artigo.verificaTipo()) {
                case 0:
                    this.listaCurto.add(artigo);
                    this.qtdPaginaCurto += qtdPaginas;
                    break;
                case 1:
                    this.listaLongo.add(artigo);
                    this.qtdPaginaLongo += qtdPaginas;
                    break;
                case 2:
                    this.listaPeriodico.add(artigo);
                    this.qtdPaginaPeriodico += qtdPaginas;
                    break;
                default:
                    System.out.println("Erro ao verificar o tipo de artigo");
                    System.out.println("Tipo Errado :" + artigo.getTipoArtigo());
                    break;
            }
            
            String qualis = artigo.getQualis();
            if(this.mapa.containsKey(qualis)){
                int qtdPaginasTotal = this.mapa.get(qualis) + qtdPaginas ;
                this.mapa.put(qualis, qtdPaginasTotal);
            } else {
                this.mapa.put(qualis, qtdPaginas);
            }
                    
            this.qtdTotalPaginas += artigo.getQtdPaginas(); 
        } else {
            artigo.imprimeInvalido();
        }
    }
    
    public void calculaMediaLista(){
        System.out.printf("Media por tipo: curto %.2f/ "
                + "longo %.2f/ "
                + "periodico %.2f\n", 
                (double) qtdPaginaCurto/listaCurto.size(),
                (double) qtdPaginaLongo/listaLongo.size(),
                (double) qtdPaginaPeriodico/listaPeriodico.size()
        );
    }
    
    public void imprimeQualis(){
        
    }
    
    public void imprimeLista(){
        System.out.println("Total de paginas produzidas: " + this.qtdTotalPaginas);
        calculaMediaLista();
    }
    
}
