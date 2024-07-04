package model;

public class Periodico extends Obra{
    private int numero;
    private String subtitulo;
    private int numArtigos;
    
    final public static int tamanho_min_numero = 1;
    final public static int tamanho_max_subtitulo = Livro.tamanho_max_titulo;
    final public static int tamanho_min_artigos = 1;
    final public static int tamanho_max_artigos = 10;
    
    public Periodico(String titulo, int anoPublicacao, int mes, Localizacao localizacao, int numero, String subtitulo,int numArtigos) throws ModelException {
        super(titulo, anoPublicacao, mes, localizacao);
        this.setNumero(numero);
        this.setSubtitulo(subtitulo);
        this.setNumArtigos(numArtigos);
    }

    public int getNumero() {
        return this.numero;
    }

    public String getSubtitulo() {
        return this.subtitulo;
    }

    public int getNumArtigos() {
        return this.numArtigos;
    }

    public void setNumero(int numero) throws ModelException{
        validarNumero(numero);
        this.numero = numero;
    }

    private void validarNumero(int numero) throws ModelException {
        if (numero < tamanho_min_numero){
            throw new ModelException("Número abaixo do limite");
        }
    }

    public void setSubtitulo(String subtitulo) throws ModelException{
        validarSubtitulo(subtitulo);
        this.subtitulo = subtitulo;
    }

    private void validarSubtitulo(String subtitulo) throws ModelException {
        int tamanho_subtitulo = subtitulo.length();

        if(tamanho_subtitulo > tamanho_max_subtitulo){
            throw new ModelException("Tamanho do subtitulo excede o limite");
        }
    }

    public void setNumArtigos(int numArtigos) throws ModelException{
        validarNumArtigos(numArtigos);
        this.numArtigos = numArtigos;
    }

    private void validarNumArtigos(int numArtigos) throws ModelException {
        if(numArtigos < tamanho_min_artigos || numArtigos > tamanho_max_artigos){
            throw new ModelException("Número de artigos excede o limite");
        }
    }
}
