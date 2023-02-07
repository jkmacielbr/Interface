package br.com.ada.exercicio.entities;

public class IphoneX implements Iphone{
    private String modelo = "Iphone X";
    private String capacidade = "256";
    private String memoriaRam = "6GB" ;
    private String ios = "13";
    private String tamanhoTela = "5.8";
    private String conexaoRede = "LTE 4G";
    private String capacidadeBateria = "2716 mAh";

    @Override
    public void exibirDetalhes() {
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Capacidade: " + this.getCapacidade());
        System.out.println("RAM: "+ this.getMemoriaRam());
        System.out.println("iOS: " + this.getIos());
        System.out.println("Tela: " + this.getTamanhoTela());
        System.out.println("REDE: " + this.getConexaoRede());
        System.out.println("Bateria: " + this.getCapacidadeBateria());
        System.out.println();

    }

    public String getModelo() {
        return modelo;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public String getMemoriaRam() {
        return memoriaRam;
    }

    public String getIos() {
        return ios;
    }

    public String getTamanhoTela() {
        return tamanhoTela;
    }

    public String getConexaoRede() {
        return conexaoRede;
    }

    public String getCapacidadeBateria() {
        return capacidadeBateria;
    }

}
