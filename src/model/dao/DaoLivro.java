package model.dao;

import model.Livro;

public class DaoLivro {
    final public static int Tamanho_dao = 10;
    final public static int Crescimento_dao = 2;

    private static int numObjeto = 0;
    private static Livro[] lista = new Livro[Tamanho_dao];

    public boolean adicionar(Livro novo) {
        if (DaoLivro.numObjeto == Tamanho_dao) {
            return false;
        }

        if (DaoLivro.numObjeto == DaoLivro.lista.length) {
            Livro[] nova_lista = new Livro[DaoLivro.lista.length + Crescimento_dao];
            for (int posicao = 0; posicao < DaoLivro.numObjeto; posicao++) {
                nova_lista[posicao] = DaoLivro.lista[posicao];
            }
            DaoLivro.lista = nova_lista;
        }

        DaoLivro.lista[DaoLivro.numObjeto] = novo;
        DaoLivro.numObjeto++;
//        Serializador.salvarObjetos();
        return true;
    }

    public boolean remover(Livro l) {
        for (int i = 0; i < DaoLivro.numObjeto; i++) {
            if (DaoLivro.lista[i] == l) {
                for (int j = i; j < DaoLivro.numObjeto - 1; j++) {
                    DaoLivro.lista[j] = DaoLivro.lista[j + 1];
                }
                DaoLivro.lista[DaoLivro.numObjeto - 1] = null;
                DaoLivro.numObjeto--;
//                Serializador.salvarObjetos();
                return true;
            }
        }
        return false;
    }

    public Livro obter(int indice){
        if(indice < 0 || indice > DaoLivro.numObjeto){
            return null;
        }
        return DaoLivro.lista[indice];
    }

//    ToDo: Método qtdObjetos
//    ToDo: Método obterLista
//    ToDo: Método adicionarTodos
}
