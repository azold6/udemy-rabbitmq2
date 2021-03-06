package rabbitmq.two.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import rabbitmq.two.entity.DummyMessage;

import java.util.concurrent.TimeUnit;

//@Service
public class DummyPrefetchConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(DummyConsumer.class);

    @RabbitListener(queues = "q.dummy", concurrency = "2")
    public void listen(DummyMessage msg) throws InterruptedException {
        LOG.info("Consuming: {}", msg);
        TimeUnit.SECONDS.sleep(20);
    }
}
