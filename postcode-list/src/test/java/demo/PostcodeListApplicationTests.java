package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import postcode.PostcodeListApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PostcodeListApplication.class)
@WebAppConfiguration
public class PostcodeListApplicationTests {

	@Test
	public void contextLoads() {
	}

}
