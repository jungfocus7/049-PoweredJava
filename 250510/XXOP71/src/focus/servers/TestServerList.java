package focus.servers;

import java.util.Vector;

@SuppressWarnings("serial")
public final class TestServerList extends Vector<TestServer> {

	public TestServer createAndStart(String name) {
		TestServer server = new TestServer(name);
		add(server);
		server.start();

		return server;
	}

}
