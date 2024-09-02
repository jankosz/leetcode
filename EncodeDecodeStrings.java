import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
 * Please implement encode and decode
 *
 * https://leetcode.com/problems/encode-and-decode-strings
 */


public class EncodeDecodeStrings {

    private static final String DELIMITER = "<XXX>";

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "empty";
        }
        return strs.stream().collect(Collectors.joining(DELIMITER)) + DELIMITER;
    }

    public List<String> decode(String str) {
        if(str.equals("empty")) {
             return new ArrayList<>();
        }
        if(str.equals(DELIMITER)) {
             return Arrays.asList("");
        }
        String[] split = str.split(DELIMITER);
        return Arrays.asList(split);
    }


    public static void main(String[] args) {
        EncodeDecodeStrings ed = new EncodeDecodeStrings();
        List<String> strs = Arrays.asList("");
        System.out.println(ed.encode(strs));

        System.out.println(ed.decode(ed.encode(strs)));
        System.out.println(ed.decode(ed.encode(strs)).size());
    }
}
