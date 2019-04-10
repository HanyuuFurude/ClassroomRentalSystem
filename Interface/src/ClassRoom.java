class ClassRoom {
	private byte[] name;
	
	ClassRoom(byte[] name) {
		this.name = name;
		check();
	}
	
	public byte[] getName() {
		return name;
	}
	
	private void check() {
		if (name.length == 0) {
			throw Exception("[Interface.ClassRoom.Gen]:Invaild name [Hanyuu]");
		}
		return;
	}
}