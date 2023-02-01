package br.com.ada.exercicio.entities;

public class Iphone13Mini implements Iphone{
    private String modelo = "Iphone 13 Mini";
    private String capacidade = "512";
    private String memoriaRam = "8GB" ;
    private String ios = "15";
    private String tamanhoTela = "5.42";
    private String conexaoRede = "5G";
    private String capacidadeBateria = "3240";
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
