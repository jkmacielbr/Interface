package entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Notification {

    HashMap<String, List<String>> message = new HashMap<>();
    public void messageLog(String message, List<String>listPeople) {
        this.message.put(message, listPeople);
        for (Map.Entry<String, List<String>> stringListEntry: this.message.entrySet()) {
            for (String people: stringListEntry.getValue()){
                System.out.println( people + " = received a message : -> " + stringListEntry.getKey());
            }
        }
    }
    public void sendNotification(){

        for (Map.Entry<String, List<String>> stringListEntry: message.entrySet()) {

            for (String pessoa: stringListEntry.getValue()){

                System.out.println("{" + pessoa + " = received a message : -> " + stringListEntry.getKey() + "}");
            }
        }
        message.clear();

    }


}
