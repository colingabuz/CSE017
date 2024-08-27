import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;


public class Airplane {
	public char [][] seatMap;
	
	
	public Airplane() {
		seatMap = new char[9][8];
		for (int i = 0; i < seatMap.length; i++) {
			for (int j = 0; j < seatMap[i].length; j++) {
				seatMap[i][j] = '.';
			}
		}
	}
	
	
	public Airplane(String filename) {
		seatMap = new char[9][8];
		try {
			readMapFromFile(filename);
		}
		catch (FileNotFoundException e) {
			System.out.println("Unable to read file " + filename);
		}
		
	}
	
	
	private void readMapFromFile(String filename) throws FileNotFoundException {
		Scanner fileScanner = null;
        int m = 0;
        try {
            fileScanner = new Scanner(new FileInputStream(filename));
            String file = fileScanner.nextLine();
            for (int i = 0; i < seatMap.length; i++) {
                for (int j = 0; j < seatMap[i].length; j++) {
                    seatMap[i][j] = file.charAt(m);
                    m++;
                }
            }
        } catch (FileNotFoundException e) {
            for (int n = 0; n < seatMap.length; n++) {
                for (int i = 0; i < seatMap[n].length; i++) {
                    seatMap[n][i] = '.';
                }
            }
        }

	}
	
	
	
	private boolean checkSeat(String seat) throws InvalidSeatException{
		String regex = "\\d{1}[ABCDEFGH]";
		boolean valid = false;
			
		try {
			if(seat.matches(regex)) {
				valid = true;
				return valid;
			}
			else {
				throw new InvalidSeatException("The seat sections are: 1-9 and A-H. Enter another seat:");
			}
		}
		
		catch (InvalidSeatException e) {
			//System.out.println(e.getMessage());
			System.out.println("The seat sections are: 1-9 and A-H. ");
			valid = false;
			return valid;
		}
	}
	
	public boolean reserveSeat(String seat) {
		try {
			
		if (checkSeat(seat)) {
			int row = seat.charAt(0) - '1';
			int col = seat.charAt(1) - 'A';
			if (seatMap[row][col] == '.') {
				seatMap[row][col] = 'X';
			}
			return true;
		}
		else {
			throw new InvalidSeatException("This seat cannot be reserved. ");
			
		}
	}
		catch (InvalidSeatException e) {
			//System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean freeSeat(String seat) {
		try {
			if (checkSeat(seat)) {
				int row = seat.charAt(0) - '1';
				int col = seat.charAt(1) - 'A';
				if (seatMap[row][col] == 'X') {
					seatMap[row][col] = '.';
				}
				return true;
			}
			else {
				throw new InvalidSeatException("Seat Unavailable. ");
			}
		}
		catch (InvalidSeatException e) {
			//System.out.print(e.getMessage());
			return false;
		}
	}
	
	
	public void saveMap(String filename) {
        PrintWriter fileWriter = null;
        try {
            fileWriter = new PrintWriter(new FileOutputStream(filename));
            String text = "";
            for (int i = 0; i < seatMap.length; i++) {
                for (int j = 0; j < seatMap[i].length; j++) {
                    text += seatMap[i][j];
                }
            }
            fileWriter.print(text);
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found  " + filename);
        }
    }
	
		
	
	public String toString() {
		int counter = 1;
		String s = "";
		System.out.println("  A B C D E F G H \n");
		for (int i = 0; i < seatMap.length; i++) {
			s += counter++ + " ";
			for (int j = 0; j < seatMap[i].length; j++) {
				s += seatMap[i][j] + " ";
			}
			s += " \n";
		}
		return s;	
	}
	
}
