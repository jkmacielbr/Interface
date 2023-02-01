package br.com.ada.exercicio.entities;

public class IphoneFactory {


    public Iphone cadastrarIphone (TypeIphoneEnum typeIphone){
        if (typeIphone == TypeIphoneEnum.IPHONE_9){
            new Iphone9().exibirDetalhes();
        } else if (typeIphone == TypeIphoneEnum.IPHONE_X){
            new IphoneX().exibirDetalhes();
        } else {
            new Iphone13Mini().exibirDetalhes();
        }

        return null;
    }
}
