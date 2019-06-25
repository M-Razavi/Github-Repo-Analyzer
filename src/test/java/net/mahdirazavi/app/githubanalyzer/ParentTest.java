package net.mahdirazavi.app.githubanalyzer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <h1>ParentTest3</h1>
 * The ParentTest3
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 6/14/2019
 */

public class ParentTest {
    public static ObjectMapper jsonMapper = new ObjectMapper();

    static {
        jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

}
