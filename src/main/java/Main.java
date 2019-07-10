import mapper.TextMapper;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String usersText = "";
        while (!"quit".equals(usersText)) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Type your text:");
            usersText = scan.nextLine();

            TextMapper textMapper = new TextMapper();
            Map<String, String> stringStringMap = textMapper.mapWordsToLetter(usersText);
            if(!usersText.equals("quit")){
                stringStringMap.keySet().stream().forEach(letter -> System.out.println(letter + ": " + stringStringMap.get(letter)));
                System.out.println("If you want to end type: quit");
            }
        }
    }
}
