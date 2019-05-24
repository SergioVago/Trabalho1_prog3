
/**
 *
 * @author SergioVago
 */
public class Artigo {

    private String tipoArtigo;
    private String titulo;
    private String paginas;
    private String nomeConfPer;
    private String qualis;
    private int qtdPaginas;
    private boolean valido;

    public Artigo(String tipoArtigo, String titulo, String paginas, String nomeConfPer, String Qualis) {
        this.tipoArtigo = tipoArtigo;
        this.titulo = titulo;
        this.paginas = paginas;
        this.nomeConfPer = nomeConfPer;
        this.qualis = Qualis;
    }

    public void calculaQtdPaginas() {
        for (int i = 0; i < this.paginas.length(); i++) {
            if (this.paginas.charAt(i) == '-') {
                String iniStr = (this.paginas.substring(0, i));
                String fimStr = (this.paginas.substring(i + 1));
                int ini = Integer.parseInt(iniStr);
                int fim = Integer.parseInt(fimStr);

                int qtdDePaginas = fim - ini;
                if (qtdDePaginas > 50 || fim < ini) {
                    this.valido = false;
                } else {
                    this.valido = true;
                    this.qtdPaginas = qtdDePaginas + 1;
                }
            }
        }
    }

    public boolean ehValido() {
        this.calculaQtdPaginas();
        return this.valido;
    }

    public int getQtdPaginas() {
        return this.qtdPaginas;
    }

    public String getTipoArtigo() {
        return this.tipoArtigo;
    }

    public void imprimeInvalido() {
        System.out.printf("Artigo %s informa dados de paginas inicial-final incorretos: "
                + "%s\n", this.titulo, this.paginas);
    }

    public int verificaTipo() {
        // 0 - Curto
        // 1 - Longo
        // 2 - Periodico

        if (this.tipoArtigo.equals("resumoExpandidoEmCongresso")
                || this.tipoArtigo.equals("resumoEmCongresso")) {
            return 0;
        }

        if (this.tipoArtigo.equals("trabalhoCompletoEmCongresso")) {
            return 1;
        }

        if (this.tipoArtigo.equals("artigoEmPeriodico")) {
            return 2;
        }

        return -1;
    }

    public String getQualis() {
        return this.qualis;
    }
}
