package configParserTask;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigParserStagingTest {

    ConfigParser config = new ConfigParser("staging");


    @Test
    void testForStagingdbname(){
        assertEquals("sq04_db", config.get("dbname"));
    }

    @Test
    void testForStagingApplicationName(){
        assertEquals("fintek-staging", config.get("application.name"));
    }

    @Test
    void testForStagingmode(){
        assertEquals("staging", config.get("mode"));
    }

    @Test
    void testForStagingpipeline(){
        assertEquals("fast-staging", config.get("pipeline"));
    }

}