package model;

abstract public class Obra {
    private String titulo;
    private int anoPublicacao;
    private int mes;
    private Localizacao localizacao;

    final public static int tamanho_max_titulo = 50;
    final public static int tamanho_min_mes = 1;
    final public static int tamanho_max_mes = 12;
    final public static int tamanho_min_ano = 1994;
    final public static int tamanho_max_ano = 2024;

    public Obra(String titulo, int anoPublicacao, int mes, Localizacao localizacao) throws ModelException {
        this.setTitulo(titulo);
        this.setAnoPublicacao(anoPublicacao);
        this.setMes(mes);
        this.setLocalizacao(localizacao);
    }

    public String getTitulo() {
        return this.titulo;
    }

    public int getAnoPublicacao() {
        return this.anoPublicacao;
    }

    public int getMes() {
        return this.mes;
    }

    public Localizacao getLocalizacao() {
        return this.localizacao;
    }

    public void setTitulo(String titulo) throws ModelException {
        validarTitulo(titulo);
        this.titulo = titulo;
    }

    public void validarTitulo(String titulo) throws ModelException {
        int tamanho_titulo = titulo.length();

        if(tamanho_titulo > tamanho_max_titulo){
            throw new ModelException("Tamanho do título excede o limite");
        }
    }

    public void setAnoPublicacao(int anoPublicacao) throws ModelException {
        validarAnoPublicacao(anoPublicacao);
        this.anoPublicacao = anoPublicacao;
    }

    public void validarAnoPublicacao(int anoPublicacao) throws ModelException {
        if (anoPublicacao < tamanho_min_ano || anoPublicacao > tamanho_max_ano){
            throw new ModelException("Ano excede o limite");
        }
    }

    public void setMes(int mes) throws ModelException {
        validarMes(mes);
        this.mes = mes;
    }

    public void validarMes(int mes) throws ModelException {
        if (mes < tamanho_min_mes || mes > tamanho_max_mes) {
            throw new ModelException("Mês excede o limite");
        }
    }

    public void setLocalizacao(Localizacao localizacao) throws ModelException {
        validarLocalizacao(localizacao);
        this.localizacao = localizacao;
    }

    public void validarLocalizacao(Localizacao localizacao) throws ModelException {
        if (localizacao == null) {
            throw new ModelException("Localização inválida");
        }
    }

    @Override
    public String toString() {
        return "Obra{" +
                "titulo='" + titulo + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", mes=" + mes +
                ", localizacao=" + localizacao +
                '}';
    }
}
