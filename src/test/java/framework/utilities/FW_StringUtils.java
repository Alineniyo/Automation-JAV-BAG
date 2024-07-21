package framework.utilities;

import java.util.Arrays;
//import java.util.Collections;

//import org.checkerframework.checker.units.qual.s;

/**
 * This class provides methods for reading the POM file.
 */
public class FW_StringUtils {

    /**
     * Modifies original string by inserting inset string directly after first occurrence of "]" character.
     *
     * @param original The original string containing a meta which will be modified.
     * @param insert The string to insert into the original string containing thge meta
     *
     * @return The modified string containing the meta with the insert string.
     */
    public static String metaInsert(String original, String insert) {
        return original.replaceFirst("]", "] - " + insert);
    }

    /**
     * Formats the given multiline string with a border and padding.
     *
     * @param input The string to format.
     * 
     * @return The formatted string.
     */
    public static String formatWithBorder(String input) {
        String[] lines = input.split("\n");
        int maxLength = Arrays.stream(lines).mapToInt(String::length).max().orElse(0);
    
        String border = "═".repeat(maxLength + 2); // 2 is for the padding
        StringBuilder result = new StringBuilder("╔").append(border).append("╗\n");
    
        for (String line : lines) {
            String spaces = " ".repeat(maxLength - line.length());
            result.append("║ ").append(line).append(spaces).append(" ║\n");
        }
        result.append("╚").append(border).append("╝");
        return result.toString();
    }

}