package model;

public class Localizacao {
    private int numCorredor;
    private int numEstante;
    private int numPrateleira;

    final public static int tamanho_min_nums = 1;

    public Localizacao(int numCorredor, int numEstante, int numPrateleira) throws ModelException{
        this.setNumCorredor(numCorredor);
        this.setNumEstante(numEstante);
        this.setNumPrateleira(numPrateleira);
    }

    public int getNumCorredor() {
        return this.numCorredor;
    }

    public int getNumEstante() {
        return this.numEstante;
    }

    public int getNumPrateleira() {
        return this.numPrateleira;
    }

    public void setNumCorredor(int numCorredor) throws ModelException{
        validarNum(numCorredor);
        this.numCorredor = numCorredor;
    }

    public void setNumEstante(int numEstante) throws ModelException{
        validarNum(numEstante);
        this.numEstante = numEstante;
    }

    public void setNumPrateleira(int numPrateleira) throws ModelException{
        validarNum(numPrateleira);
        this.numPrateleira = numPrateleira;
    }

    public void validarNum(int numero) throws ModelException {
        if (numero < tamanho_min_nums){
            throw new ModelException("Tamanho mínimo do número é 1");
        }
    }
}
