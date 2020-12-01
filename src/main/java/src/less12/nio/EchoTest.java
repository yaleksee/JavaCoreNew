package src.less12.nio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class EchoTest {

    Process server;
    NIOClient client;

    @Before
    public void setup() throws IOException, InterruptedException {
        server = NIOServer.start();
        client = NIOClient.start();
    }

    @Test
    public void givenServerClient__whenServerEchosMessage__thenCorrect() {
        String resp1 = client.sendMessage("hello");
        String resp2 = client.sendMessage("world");
        assertEquals("hello", resp1);
        assertEquals("world", resp2);
    }

    @After
    public void teardown() throws IOException {
        server.destroy();
        NIOClient.stop();
    }
}
