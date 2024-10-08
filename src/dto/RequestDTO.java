package dto;

public class RequestDTO {

    private String opcao;
    private int valor1;
    private int valor2;

    public RequestDTO(String opcao, int valor1, int valor2) {
        this.opcao = opcao;
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    public int getValor1() {
        return valor1;
    }

    public void setValor1(int valor1) {
        this.valor1 = valor1;
    }

    public int getValor2() {
        return valor2;
    }

    public void setValor2(int valor2) {
        this.valor2 = valor2;
    }

}
