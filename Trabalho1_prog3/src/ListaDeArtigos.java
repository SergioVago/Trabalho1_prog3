
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
    private HashMap<String, Integer> mapaQualis;

    public ListaDeArtigos() {
        this.criaMapa();
        this.listaCurto = new ArrayList<>();
        this.listaLongo = new ArrayList<>();
        this.listaPeriodico = new ArrayList<>();
        this.qtdTotalPaginas = 0;
        this.qtdPaginaPeriodico = 0;
        this.qtdPaginaCurto = 0;
        this.qtdPaginaLongo = 0;

    }

    private void criaMapa() {
        this.mapaQualis = new HashMap<String, Integer>();
        this.mapaQualis.put("A1", 0);
        this.mapaQualis.put("A2", 0);
        this.mapaQualis.put("B1", 0);
        this.mapaQualis.put("B2", 0);
        this.mapaQualis.put("B3", 0);
        this.mapaQualis.put("B4", 0);
        this.mapaQualis.put("B5", 0);
        this.mapaQualis.put("C", 0);
    }

    public void adicionaArtigo(Artigo artigo) {
        int qtdPaginas = 0;
        if (artigo.ehValido()) {
            qtdPaginas = artigo.getQtdPaginas();
        } else {
            artigo.imprimeInvalido();
        }

        String qualis = artigo.getQualis();
        int qtdPulbicacoes = 1 + this.mapaQualis.get(qualis);
        switch (artigo.verificaTipo()) {
            case 0:
                if (artigo.ehValido()) this.listaCurto.add(artigo);
                this.qtdPaginaCurto += qtdPaginas;
                break;
            case 1:
                if (artigo.ehValido()) this.listaLongo.add(artigo);
                this.qtdPaginaLongo += qtdPaginas;
                this.mapaQualis.put(qualis, qtdPulbicacoes);
                break;
            case 2:
                if (artigo.ehValido()) this.listaPeriodico.add(artigo);
                this.qtdPaginaPeriodico += qtdPaginas;
                this.mapaQualis.put(qualis, qtdPulbicacoes);
                break;
            default:
                System.out.println("Erro ao verificar o tipo de artigo");
                System.out.println("Tipo Errado :" + artigo.getTipoArtigo());
                break;
        }

        this.qtdTotalPaginas += qtdPaginas;
    }

    public void calculaMediaLista() {
        System.out.printf("Media por tipo: curto %.2f / "
                + "longo %.2f / "
                + "periodico %.2f\n",
                (double) qtdPaginaCurto / listaCurto.size(),
                (double) qtdPaginaLongo / listaLongo.size(),
                (double) qtdPaginaPeriodico / listaPeriodico.size()
        );

    }

    public void imprimeQualis() {
        System.out.printf("Publicacoes por Qualis: %d x A1; %d x A2; %d x B1; %d x B2; %d x B3; %d x B4; %d x B5; %d x C;\n",
                mapaQualis.get("A1"),
                mapaQualis.get("A2"),
                mapaQualis.get("B1"),
                mapaQualis.get("B2"),
                mapaQualis.get("B3"),
                mapaQualis.get("B4"),
                mapaQualis.get("B5"),
                mapaQualis.get("C"));

    }

    public void imprimeLista() {
        System.out.println("Total de paginas produzidas: " + this.qtdTotalPaginas);
        calculaMediaLista();
        imprimeQualis();
    }

}
