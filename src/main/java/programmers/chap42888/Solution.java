package programmers.chap42888;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static class Command {
        String command;
        String index;
        String name;

        public Command(String command, String index, String name) {
            this.command = command;
            this.index = index;
            this.name = name;
        }
    }

    public static class Recode {
        String command;
        String index;

        public Recode(String command, String index) {
            this.command = command;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        ArrayList<Command> list = new ArrayList<>();
        ArrayList<Recode> save = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        String[] recodes = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        Arrays.stream(recodes).forEach(recode -> {
            String[] command = recode.split(" ");
            System.out.println(Arrays.toString(command));
            if(command[0].equals("Leave")) list.add(new Command(command[0],command[1],null));
            else list.add(new Command(command[0],command[1],command[2]));
            if(!map.containsKey(command[1])) map.put(command[1],command[2]);
        });

        list.stream().forEach(command -> {
            if(command.command.equals("Enter") || command.command.equals("Leave")) {
                if(command.command.equals("Enter")) {
                    if(map.containsKey(command.index)) {
                        map.put(command.index,command.name);
                    }
                }
                save.add(new Recode(command.command, command.index));
            } else {
                map.put(command.index,command.name);
            }
        });
        list.stream().filter(i -> i.command.equals("Enter")).forEach(p -> {

        });
        System.out.println(map);
        ArrayList<String> answerTemp = new ArrayList<>();
        save.stream().forEach(recode -> {
            if(recode.command.equals("Enter")) {
                answerTemp.add(map.get(recode.index)+"님이 들어왔습니다.");
            } else {
                answerTemp.add(map.get(recode.index)+"님이 나갔습니다.");
            }
        });
        String[] answer = answerTemp.toArray(new String[answerTemp.size()]);
        System.out.println(Arrays.toString(answer));
    }
}
