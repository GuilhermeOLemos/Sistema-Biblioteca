package model;

public class Livro extends Obra {
    private String isbn;
    private String autor;

    final public static int tamanho_padrao_isbn = 17;
    final public static int tamanho_max_autor = 40;

    public Livro(String titulo, int anoPublicacao, int mes, Localizacao localizacao, String isbn, String autor) throws ModelException {
        super(titulo, anoPublicacao, mes, localizacao);
        this.setIsbn(isbn);
        this.setAutor(autor);
    }

    public String getIsbn() {
        return this.isbn;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setIsbn(String isbn) throws ModelException {
        validarIsbn(isbn);
        this.isbn = isbn;
    }

    public void validarIsbn(String isbn) throws ModelException {
        if (isbn == null) {
            throw new ModelException("ISBN não preenchido");
        }

        int tamanho_isbn = isbn.length();

        if (tamanho_isbn != tamanho_padrao_isbn) {
            throw new ModelException("Tamanho do ISBN excede o limite");
        }

        for (int posicao = 0; posicao < tamanho_padrao_isbn; posicao++) {
            char caractere = isbn.charAt(posicao);

            switch (posicao) {
                case 3:
                case 6:
                case 10:
                case 15:
                    if (caractere != '-') {
                        throw new ModelException("ISBN inválido! Formato correto 999-99-999-9999-9");
                    }
                    break;
                default:
                    if (!Character.isDigit(caractere)) {
                        throw new ModelException("ISBN inválido! Deve conter apenas dígitos");
                    }
            }
        }
    }

    public void setAutor(String autor) throws ModelException {
        validarAutor(autor);
        this.autor = autor;
    }

    public void validarAutor(String autor) throws ModelException {
        if (autor == null){
            throw new ModelException("Autor não preenchido");
        }

        int tamanho_autor = autor.length();

        if (tamanho_autor > tamanho_max_autor){
            throw new ModelException("Tamanho do autor excede o limite");
        }

        for (int posicao = 0; posicao < tamanho_max_autor; posicao++){
            char caractere = autor.charAt(posicao);

            if (!Character.isAlphabetic(caractere)){
                throw new ModelException("Autor inválido! Deve conter apenas letras");
            }
        }
    }
}
