package focus.servers;

import java.text.MessageFormat;

public final class TestServer extends Thread implements IMoreServer {

	private String _name;

	private boolean _bLoop = true;

	private static final MessageFormat _msgfm = new MessageFormat("name: {0}");

	public TestServer(String name) {
		_name = name;
	}

	private static void println(String txt) {
		System.out.println(txt);
	}

	public String get_name() {
		return _name;
	}

	@Override
	public void kill() {
		_bLoop = false;
	}

	@Override
	public void run() {
		println("Thread Start");

		workCore();

		println("Thread End");
	}

	private void workCore() {
		while (_bLoop) {
			try {
				Thread.sleep(500);

				String txt = _msgfm.format(new Object[] { _name, Integer.valueOf(10) });
				println(txt);
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}

			if (_name == "박종명") {

			}
			else if (_name == "임헌진") {

			}
			else if (_name == "이중호") {

			}

			switch (_name) {
				case "박종명": {
					break;
				}
			}

		}
	}

}
