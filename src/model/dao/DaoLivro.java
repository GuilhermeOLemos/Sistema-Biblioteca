package model.dao;

import model.Livro;

public class DaoLivro {
    final public static int Tamanho_dao = 10;
    final public static int Crescimento_dao = 2;

    private static int numObjeto = 0;
    private static Livro[] lista = new Livro[Tamanho_dao];

    public boolean adicionar(Livro novo){
        if(DaoLivro.numObjeto == Tamanho_dao){
            return false;
        }

        if (DaoLivro.numObjeto == DaoLivro.lista.length){
            Livro[] nova_lista = new Livro[DaoLivro.lista.length + Crescimento_dao];
            for (int posicao = 0; posicao < DaoLivro.numObjeto; posicao++){
                nova_lista[posicao] = DaoLivro.lista[posicao];
            }
            DaoLivro.lista = nova_lista;
        }

        DaoLivro.lista[DaoLivro.numObjeto] = novo;
        DaoLivro.numObjeto++;
//        Finalizar Classe Serializador
//        Serializador.salvarObjetos();
        return true;
    }

//    Método remover
//    Método obter
//    Método qtdObjetos
//    Método obterLista
//    Método adicionarTodos
}
