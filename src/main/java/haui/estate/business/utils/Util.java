package haui.estate.business.utils;

import com.fasterxml.uuid.Generators;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;

public class Util {
    public static String generateMD5(String item){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(item); }

    public static String generateUUID() {
        return Generators.randomBasedGenerator().generate().toString();
    }

    /**
     * check str is not null & empty
     *
     * @param str input string
     * @return true if not null & empty
     */
    public static boolean notNullAndEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }

    /**
     * @param collection
     * @return
     */
    public static boolean notNullAndEmpty(Collection<? extends Object> collection) {
        return collection != null && collection.size() > 0;
    }

    /**
     * @param objects
     * @return
     */
    public static boolean notNullAndEmpty(int[] objects) {
        return objects != null && objects.length > 0;
    }

}
