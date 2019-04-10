interface Client {
	public abstract Object[] login();
	
	public abstract void logout();
	
	public abstract InfoList update();
	
	public abstract StatusCode post();
	
	public abstract InfoList getReservationInformation();
	
	public abstract InfoList getReservationInformationByClassRoom(ClassRoom);
}