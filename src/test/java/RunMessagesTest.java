import config.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import send.SpringJmsProducer;

/**
 * Created by tatiana.biliaieva on 4/29/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ApplicationConfig.class)
public class RunMessagesTest {
  private static final Logger logger = LoggerFactory
      .getLogger(RunMessagesTest.class);
  @Autowired
  private SpringJmsProducer springJmsProducer;

  @Test
  public void run() throws Exception {

    System.out.print("OP");
    // springJmsProducer.sendMessage("SECOND");
  }

}
