public class Screen {

    public static void screenMenu() {
        System.out.println("[1] DIRECTORY MANAGER");
        System.out.println("[2] IMAGE MANAGER");
        System.out.println("[3] FILE MANAGER");
        System.out.println("[0] EXIT");

    }
    public static void screenImage() {
        System.out.println("[1] SAVE IMAGE");
        System.out.println("[2] DELETE IMAGE");
        System.out.println("[3] LIST IMAGES");
        System.out.println("[4] RECOVERY IMAGE");
        System.out.println("[0] EXIT");
    }

    public static void screenFolder(){
        System.out.println("[1] CREATE FOLDER");
        System.out.println("[2] DELETE FOLDER");
        System.out.println("[3] LIST FOLDER");
        System.out.println("[0] EXIT");
    }

    public static void screenFile() {
        System.out.println("[1] SAVE FILE");
        System.out.println("[2] RECOVERY FILE");
        System.out.println("[3] REMOVE FILE");
        System.out.println("[4] LIST FILES");
        System.out.println("[0] EXIT");

    }
}
