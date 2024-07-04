package model.dao;

import model.Livro;

public class DaoLivro {
    final public static int Tamanho_dao = 10;
    final public static int Crescimento_dao = 2;

    private static int numObjeto = 0;
    private static Livro[] lista_livro = new Livro[Tamanho_dao];

    public boolean adicionar(Livro novo){
        if(DaoLivro.numObjeto == Tamanho_dao){
            return false;
        }
    }
}
