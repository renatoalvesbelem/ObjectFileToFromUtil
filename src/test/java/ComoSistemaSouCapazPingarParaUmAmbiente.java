import br.com.ssh.controller.PingHost;
import br.com.ssh.model.HostServer;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ComoSistemaSouCapazPingarParaUmAmbiente {
    private PingHost pingHost;
    private boolean reached, unreached = false;

    @Before
    public void instancePingHost() throws IOException {
        pingHost = new PingHost();
    }

    @Test
    public void whenEnviromentIsReched() {
        reached = pingHost.isReachable("127.0.0.1");
        unreached = pingHost.isReachable("172.25.25.2");
    }

    @After
    public void thenValuesHadReturned() {
        Assert.assertEquals(true, reached);
        Assert.assertEquals(false, unreached);
    }
}