package configParserTask;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigParserProductionTest {


    ConfigParser config = new ConfigParser("production");

    @Test
    void testForProductiondbname(){
        assertEquals("sq04_db", config.get("dbname"));
    }

    @Test
    void testForProductionApplicationName(){
        assertEquals("fintek", config.get("application.name"));
    }

    @Test
    void testForProductiontheme(){
        assertEquals("green", config.get("theme"));
    }

    @Test
    void testForProductionApplicationcontexturl(){
        assertEquals("/api/v1", config.get("application.context-url"));
    }

}