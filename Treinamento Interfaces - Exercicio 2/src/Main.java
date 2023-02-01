import model.MFile;
import model.MFileAnnotationTypeEnum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int op;

        do {

            telaMenu();
            op = tc.nextInt();
            tc.nextLine();
            switch (op) {
                case 1 -> {
                    System.out.println("TIPO DE PASTA");

                    String typeFolder = tc.nextLine();
                    new HandlerFile().createAFolder("src/Diretorios Arquivos/" + typeFolder);
                    telaMenu();

                }
                case 2 -> {
                    System.out.println("Nome da imagem");
                    String nameFile = tc.nextLine();
                    String content = "https://raw.githubusercontent.com/gabiandrade/programacao-orientada-objetos-java/" +
                            "main/src/com/ada/example/segunda/aula/exercicio/File_.jpeg";
                    new HandlerFile(new MFile(content, nameFile, MFileAnnotationTypeEnum.IMAGE));
                    telaMenu();

                }
                case 3 -> {
                    new HandlerFile().listAllImageFiles("src/Diretorios Arquivos/images");
                    telaMenu();
                }
                case 4 -> {
                    System.out.println("Nome da Imagem");
                    String nameImage = tc.nextLine();
                    new HandlerFile().removeImageFile("src/Diretorios Arquivos/images/", nameImage);
                    telaMenu();

                }
                case 5 -> {
                    System.out.println("Nome do diretório");
                    String directoryDelete = tc.nextLine();
                    new HandlerFile().removeAFolder("src/Diretorios Arquivos/" + directoryDelete);
                    telaMenu();

                }
            }


            op = tc.nextInt();
        }while (op != 0);


    }

    public static void telaMenu(){
        System.out.println("[1] CRIAR DIRETÓRIO");
        System.out.println("[2] CADASTRAR IMAGENS");
        System.out.println("[3] LISTAR IMAGENS");
        System.out.println("[4] REMOVER IMAGEM");
        System.out.println("[5] REMOVER DIRETÓRIO");
        System.out.println("[0] PARA SAIR");

    }
}