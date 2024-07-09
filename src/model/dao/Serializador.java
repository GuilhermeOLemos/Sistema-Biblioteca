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

            oos.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void recuperarObjetos() {

    }
}
