import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
public class Main {

    static Map<Character, Integer> lettersToNumbers = Map.ofEntries(
            Map.entry('A', 1),
            Map.entry('B', 2),
            Map.entry('C', 3),
            Map.entry('D', 4),
            Map.entry('E', 5),
            Map.entry('F', 6),
            Map.entry('G', 7),
            Map.entry('H', 8),
            Map.entry('I', 9),
            Map.entry('J', 10),
            Map.entry('K', 11),
            Map.entry('L', 12),
            Map.entry('M', 13),
            Map.entry('N', 14),
            Map.entry('O', 15),
            Map.entry('P', 16),
            Map.entry('Q', 17),
            Map.entry('R', 18),
            Map.entry('S', 19),
            Map.entry('T', 20),
            Map.entry('U', 21),
            Map.entry('V', 22),
            Map.entry('W', 23),
            Map.entry('X', 24),
            Map.entry('Y', 25),
            Map.entry('Z', 26));
    
        static Map<Integer, Character> numbersToEncodedLetters = Map.ofEntries(
            Map.entry(0, 'C'),
            Map.entry(1, 'I'),
            Map.entry(2, 'X'),
            Map.entry(3, 'Y'),
            Map.entry(4, 'Z'),
            Map.entry(5, 'T'),
            Map.entry(6, 'A'),
            Map.entry(7, 'B'),
            Map.entry(8, 'C'),
            Map.entry(9, 'D'));
    
        public static String encrypt(String code) {
                StringBuilder sb = new StringBuilder();
                StringBuilder doubleLetter = new StringBuilder();
                for (Character ch : code.toCharArray()) {
                    if (ch != ' ') {
                        try {
                            Integer number = lettersToNumbers.get(Character.toUpperCase(ch));
                        if (number >= 10) {
                            for (Character num : number.toString().toCharArray()) {
                                char finalLetter = numbersToEncodedLetters.get(Integer.parseInt(Character.toString(num)));
                                doubleLetter.append(finalLetter);
                            }
                            sb.append("(" + doubleLetter.toString() + ")");
                            doubleLetter.delete(0, doubleLetter.length());
                        } else {
                            char finalLetter = numbersToEncodedLetters.get(number);
                            sb.append(finalLetter);
                        }
                        } catch (NullPointerException ignore) {
                            sb.append(ch);
                        }
                    } else {
                        sb.append(" + ");
                    }
                }
            return sb.toString();
        }
    
        public String decrypt(String code) {
            return code;
        }
    
        public static void main(String[] args) {
    
            Scanner cmd = new Scanner(System.in);
            System.out.print("Encrypt or Decrypt? (E/D): ");
            String cmdInput = cmd.nextLine();
    
            if (Arrays.asList("E", "Encrypt").contains(cmdInput)) {
                Scanner text = new Scanner(System.in);
                System.out.print("Input the text you would like to encrypt: ");
                System.out.println(encrypt(text.nextLine()));
                text.close();
            
            cmd.close();    
        }
    }
}