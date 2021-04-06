package configParserTask;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigParserDevelopmentTest {

    ConfigParser config = new ConfigParser("development");

    @Test
    void testForDevelopmentdbname(){
        assertEquals("sq04_db-development", config.get("dbname"));
    }

    @Test
    void testForDevelopmentApplicationName(){
        assertEquals("fintek-development", config.get("application.name"));
    }

    @Test
    void testForDevelopmenthost(){
        assertEquals("127.0.0.1", config.get("host"));
    }

    @Test
    void testForDevelopmentApplicationport(){
        assertEquals("8082", config.get("application.port"));
    }

}