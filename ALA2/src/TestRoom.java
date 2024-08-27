
public class TestRoom {
	public static void main (String [] args) {
		Room [] cseRooms = new Room[5];
		cseRooms[0] = new Room("sandbox lab","PL-112",65,15.5,30.75);
		cseRooms[1] = new Room("sunlab","PL-122",45,10,15);
		cseRooms[2] = new Room("classroom","PL-415",80,20,30);
		cseRooms[3] = new Room("faculty" , "PL-252" , 1, 10.5, 10.75);
		cseRooms[4] = new Room("admin office","PL-115",1,12.25,10.35);
		System.out.printf("%-20s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n", "Name", "Room Number", "Capacity", "Length", "Width", "Area");
		System.out.println("");
		for (int i = 0; i < 5; i++) {
		System.out.printf("%-20s\t%-15s\t%-15d\t%-15.2f\t%-15.2f\t%-15.2f\n", cseRooms[i].getName(), cseRooms[i].getLocation(),cseRooms[i].getCapacity(), cseRooms[i].getLength(), cseRooms[i].getWidth(), cseRooms[i].getArea(cseRooms[i].getLength(), cseRooms[i].getWidth()));	
		}
	}
}
