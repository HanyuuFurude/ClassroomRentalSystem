package Interface;

public class ClassRoom {
	private byte[] name;
	
	ClassRoom(byte[] name) throws Exception {
		this.name = name;
		check();
	}
	
	public byte[] getName() {
		return name;
	}
	
	private void check() throws Exception {
		if (name.length == 0) {
			throw new Exception("[Interface.ClassRoom.Gen]:Invaild name [Hanyuu]");
		}
		return;
	}
}