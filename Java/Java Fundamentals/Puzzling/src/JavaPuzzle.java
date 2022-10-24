import java.util.ArrayList;
import java.util.Random;
public class JavaPuzzle {
    Random randMachine = new Random();

    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> randArray = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            int randomNum = randMachine.nextInt(21); //limit 0 <= limit < 21
//                 System.out.println(randomNum);
            randArray.add(randomNum);
        }
        return randArray;
    }

    public Character getRandomLetter() {
        Character[] charArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int randNum = randMachine.nextInt(26);
        char randChar = charArray[randNum];
        return randChar;
    }

    public String generatePassword() {
        String password = new String();
        String letter = "";
        for (int i = 0; i < 8; i++) {
            Character thisPass = getRandomLetter();
            String passLetter = Character.toString(thisPass);
            password += letter.concat(passLetter);
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet() {
        System.out.println("Please Enter A Number of words");
        String input = System.console().readLine();
        int arrayLen = Integer.parseInt(input);
        ArrayList<String> newPass = new ArrayList<String>();
        String letter = "";
        for (int a = 0; a < 8; a++) {
            String word = "";
            for (int i = 0; i < 8; i++) {
                    Character thisCharI = getRandomLetter();
                    String passLetterI = Character.toString(thisCharI);
                    word += letter.concat(passLetterI);
                }
                newPass.add(word);
            }
        return newPass;
    }
    }

