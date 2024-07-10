package model.dao;

import model.Localizacao;

public class DaoLocalizacao {
    final public static int Tamanho_dao = 10;
    final public static int Crescimento_dao = 2;

    private static int numObjeto = 0;
    private static Localizacao[] lista = new Localizacao[Tamanho_dao];

    public boolean adicionar(Localizacao novo) {
        if (DaoLocalizacao.numObjeto == Tamanho_dao) {
            return false;
        }

        if (DaoLocalizacao.numObjeto == DaoLocalizacao.lista.length) {
            Localizacao[] nova_lista = new Localizacao[DaoLocalizacao.lista.length + Crescimento_dao];
            for (int posicao = 0; posicao < DaoLocalizacao.numObjeto; posicao++) {
                nova_lista[posicao] = DaoLocalizacao.lista[posicao];
            }
            DaoLocalizacao.lista = nova_lista;
        }

        DaoLocalizacao.lista[DaoLocalizacao.numObjeto] = novo;
        DaoLocalizacao.numObjeto++;
        Serializador.salvarObjetos();
        return true;
    }

    public boolean remover(Localizacao l) {
        for (int i = 0; i < DaoLocalizacao.numObjeto; i++) {
            if (DaoLocalizacao.lista[i] == l) {
                for (int j = i; j < DaoLocalizacao.numObjeto - 1; j++) {
                    DaoLocalizacao.lista[j] = DaoLocalizacao.lista[j + 1];
                }
                DaoLocalizacao.lista[DaoLocalizacao.numObjeto - 1] = null;
                DaoLocalizacao.numObjeto--;
                Serializador.salvarObjetos();
                return true;
            }
        }
        return false;
    }

    public Localizacao obter(int indice) {
        if (indice < 0 || indice > DaoLocalizacao.numObjeto) {
            return null;
        }
        return DaoLocalizacao.lista[indice];
    }

    public int qtdObjetos() {
        return DaoLocalizacao.numObjeto;
    }

    public Localizacao[] obterLista() {
        Localizacao[] copia = new Localizacao[DaoLocalizacao.numObjeto];
        System.arraycopy(DaoLocalizacao.lista, 0, copia, 0, DaoLocalizacao.numObjeto);
        return copia;
    }

    public void adicionarTodos(Localizacao[] copia) {
        for (int i = 0; i < copia.length; i++) {
            this.adicionar(copia[i]);
        }
    }
}
