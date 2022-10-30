import java.util.Set;
import java.util.HashMap;
public class HashMapFun {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Good is ffff", "Hell");
        trackList.put("Good is ooo", "Life");
        trackList.put("Good is oooo", "Good");
        trackList.put("Good is ooooo", "Byee");

        // get the keys by using the keySet method
        Set<String> keys = trackList.keySet();
        for (String key : keys) {
//            System.out.println(key);
//            System.out.println(trackList.get(key));
            System.out.println("Track: " + trackList.get(key) + " Lyrics: " + key);
        }
    }
}

