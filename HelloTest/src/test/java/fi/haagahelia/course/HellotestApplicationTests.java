package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fi.haagahelia.course.web.HelloController;

/**
 * Testing that the context is creating your controller
 * 
 * @author h01270
 *
 */
//@ExtendWith(SpringExtension.class) not needed when using JUnit5
@SpringBootTest
public class HellotestApplicationTests {

    @Autowired
    private HelloController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }	
}
