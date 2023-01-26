package br.com.ada.exercicio.entities;

public class IphoneFactory {


    public Iphone cadastrarIphone (TypeIphoneEnum typeIphone){
        Iphone iphone;
        if (typeIphone == TypeIphoneEnum.IPHONE_9){
            iphone = new Iphone9();
            iphone.exibirDetalhes();
        } else if (typeIphone == TypeIphoneEnum.IPHONE_X){
            iphone = new IphoneX();
            iphone.exibirDetalhes();
        } else {
            iphone = new Iphone13Mini();
            iphone.exibirDetalhes();
        }

        return null;
    }
}
