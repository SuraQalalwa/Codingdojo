

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class TestPuzzle {
    public static void main(String[] args) {
        JavaPuzzle puzzle = new JavaPuzzle();
        ArrayList<Integer> randomNumber = puzzle.getTenRolls();
        System.out.println(randomNumber);

        char randomCharacter=puzzle.getRandomLetter();
        System.out.println(randomCharacter);

        String pass=puzzle.generatePassword();
        System.out.println(pass);

        ArrayList<String> newPass = puzzle.getNewPasswordSet();
        System.out.println(newPass);
    }


}