package br.com.ada.exercicio;

import br.com.ada.exercicio.entities.IphoneFactory;
import br.com.ada.exercicio.entities.TypeIphoneEnum;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

        Scanner tc = new Scanner(System.in);
        int resposta;
        do{
            System.out.println("Qual modelo deseja fabricar");
            System.out.println("[1] IPHONE_9\t\t [2]IPHONE_X\t\t [3]IPHONE_13_MINI\t\t [0]SAIR");

            try {


            resposta = tc.nextInt();
            IphoneFactory iphoneCadastro = new IphoneFactory();
            switch (resposta){
                case 1 -> iphoneCadastro.cadastrarIphone(TypeIphoneEnum.IPHONE_9);


                case 2 -> iphoneCadastro.cadastrarIphone(TypeIphoneEnum.IPHONE_X);

                case 3 -> iphoneCadastro.cadastrarIphone(TypeIphoneEnum.IPHONE_13_MINI);
                default -> {
                    if (resposta == 0){break;}
                    System.out.println("RESPOSTA INVALIDA");
                }
            }
            }catch (InputMismatchException e){
                System.out.println("DIGITE UM VALOR NÚMERICO");
                resposta = -1;
                tc.nextLine();
            }

        }while (resposta != 0);

    }
}
