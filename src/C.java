import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C {
    public static void main(String[] args) {
        int listSize = 0;
        int numbersOfTableRowsList;
        int numberOfTableValuesList;
        List<String> listsOfInsertionQuery = new ArrayList<>();
        String line = "INSERT INTO (name,city,gender,age) VALUES (\"name\",\"value\",\"male\",\"18\")";
        String[] splitLine = line.split(" ");
        for (String el : splitLine){
            if(el.contains("(")){
                listsOfInsertionQuery.add(el);
            }
        }
        if(listsOfInsertionQuery.size() == 2){
            numbersOfTableRowsList = getNumberOfListElements(listsOfInsertionQuery.get(0));
            numberOfTableValuesList = getNumberOfListElements(listsOfInsertionQuery.get(1));
            if(numberOfTableValuesList == numbersOfTableRowsList){
                listSize = numbersOfTableRowsList;
            }
        }
        else{
            System.out.println(false);
        }

        //final String PATTERN_TEST = "(^INSERT INTO ([(])((\\w+),?){2}([)]) VALUES ([(])((\")(\\w+)(\"),?){2}([)])$)";
        final String PATTERN_TEST = "(^INSERT INTO ([(])((\\w+),?){"+listSize+"}([)]) VALUES ([(])((\")(\\w+)(\"),?){"+listSize+"}([)])$)";
        Pattern p = Pattern.compile(PATTERN_TEST);
        Matcher matcher = p.matcher(line);
        boolean result = matcher.find();
        System.out.println(result);
    }

    public static int getNumberOfListElements(String list){
        int counter = 0;
        for (Character ch : list.toCharArray()){
            if(ch == ','){
                counter++;
            }
        }
        return counter + 1;
    }
}
