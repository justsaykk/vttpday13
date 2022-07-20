package day13workshop.day13wrkshop;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class FunctionTest {
    private Logger logger = Logger.getLogger(FunctionTest.class.getName());
    private Path workingDir;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void readContact() throws IOException {
        this.workingDir = Path.of("", "/Users/kaikeinwoo/Desktop/VTTP/projects/day13/dump");
        Path file = this.workingDir.resolve("0cbf4cdd");
        String content = Files.readString(file);
        assertThat(content, is(notNullValue()));
    }

    @Test
    public void saveContact() throws IOException{
        MultiValueMap<String, String> payload = new LinkedMultiValueMap<>();
        payload.add("name", "kk");
        payload.add("email", "kawoo@visa.com");
        payload.add("phone", "909090");

        logger.log(Level.INFO, "" + objectMapper.writeValueAsString(payload));
    }

}
