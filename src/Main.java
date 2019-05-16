import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String> definitions = new HashMap<String, String>();
        Scanner scan = new Scanner(System.in);
        try {
            File dictionary = new File("src/dictionary.txt");
            Scanner reader = new Scanner(dictionary);
            while (reader.hasNextLine()) {
                String text = reader.nextLine();
                String word = text.substring(0, text.indexOf(","));
                String definition = text.substring(text.indexOf(",") + 1, text.length());
                definitions.put(word, definition);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(definitions);

        System.out.println("Do you want to look up a word?");
        String search = scan.next();

        while ((search.contentEquals("yes"))) {
            System.out.println("What do you want to look up?");
            String term = scan.next();
//            if (definitions.containsKey(term)) {
//                System.out.println(definitions.get(term));
//            }
//            else
//                {
//                    System.out.println("Item not found");
//                }

//            String result =  definitions.containsKey(term) ? definitions.get(term) : "Not Found";
//            System.out.println(result);
            System.out.println(definitions.getOrDefault(term,"not found"));
            System.out.println("Do you want to keep searching?");
            search = scan.next();
        }
    }
}
