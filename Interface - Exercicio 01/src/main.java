import entities.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int amount;
        List<String> people = new ArrayList<>();
        String message;

        do {
            System.out.print("Enter of number people receive a message: ");
            amount = tc.nextInt();
            if (amount != 0) {
                tc.nextLine();

                for (int i = 0; i < amount; i++) {
                    System.out.print("Name: ");
                    people.add(tc.nextLine());
                }

                System.out.println("Enter the menssage: ");
                message = tc.nextLine();

                Notification menssenger = new Notification();

                menssenger.messageLog(message, people);
                menssenger.sendNotification();



            }

        } while (amount != 0);


    }
}
