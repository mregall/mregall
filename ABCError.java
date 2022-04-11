package interview_questions;

import java.util.*;
public class ABCError {
    public static void main(String[] args) {
        /*

        When the user types the order A, B, C they get an error.  No other sequence gets an error.

        A -> B -> C = ERROR
        Other orders are okay

        Create a function that outputs all the users who experience the error
        Logs are chronological
         */

        //Format: {"Action:UserID", "Action:UserID", ...}

        String[] logs = {"A:1","A:1","A:2","A:3","A:1","B:1","B:1","B:2","B:3","A:3","C:3","C:2","C:1","B:1","C:1" };

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        //First Approach

        // will create 3 Strings to store Button sequence
        String u1="", u2="", u3="";
        //Will start a loop to store my sequences for each user
        for (String each : logs) {
//  If current value ends with 1 than will store it to String for user 1 sequence
            if (each.endsWith("1")) u1 += ""+each.charAt(0);
            if (each.endsWith("2")) u2 += ""+each.charAt(0);
            if (each.endsWith("3")) u3 += ""+each.charAt(0);
        }
        // Will create a map for storing all the logs divided by user
        Map<Integer, String> logsMap=new HashMap<>();
        // Putting each users logs to map
        logsMap.put(1, u1);
        logsMap.put(2, u2);
        logsMap.put(3, u3);
        // Will start entrySet loop for my map. To check if we have ABC pattern
        // And if there is a pattern then will print out the user
        for (Map.Entry<Integer, String> entry : logsMap.entrySet()) {
            if (entry.getValue().contains("ABC")) {
                System.out.println("User "+entry.getKey()+" Experienced error");
            }
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        //Second Approach

        for (String log : logs) {
            String[] action = log.split(":");
            if (action[1].equals("1")) {
                u1 += action[0];
            } else if (action[1].equals("2")) {
                u2 += action[0];
            } else {
                u3 += action[0];
            }

        }
        if(u1.contains("ABC")) {
            System.out.println("User 1 is experiencing an error");
        }
        if(u2.contains("ABC")) {
            System.out.println("User 2 is experiencing an error");
        }
        if(u3.contains("ABC")) {
            System.out.println("User 3 is experiencing an error");
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        //this was my first try it just sorts the array with a lambda by the position index 2

        Arrays.sort(logs, (str1, str2) -> {
            String substr1 = str1.substring(2);
            String substr2 = str2.substring(2);

            return Integer.valueOf(substr1).compareTo(Integer.valueOf(substr2));
        });

        System.out.println(Arrays.toString(logs));
    }
}
