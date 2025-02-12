package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Livro;
import model.Localizacao;
import model.Periodico;

public class Serializador {
    public static void salvarObjetos() {
        try {
            FileOutputStream fos = new FileOutputStream("objetos.data");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            Livro[] listaLivros = new DaoLivro().obterLista();
            oos.writeObject(listaLivros);

            Periodico[] listaPeriodicos = new DaoPeriodico().obterLista();
            oos.writeObject(listaPeriodicos);

            Localizacao[] listaLocalizacoes = new DaoLocalizacao().obterLista();
            oos.writeObject(listaLocalizacoes);

            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void recuperarObjetos() {
        try {
            FileInputStream fis = new FileInputStream("objetos.data");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Livro[] listaLivros = (Livro[]) ois.readObject();
            Periodico[] listaPeriodicos = (Periodico[]) ois.readObject();
            Localizacao[] listaLocalizacoes = (Localizacao[]) ois.readObject();

            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
