import java.util.LinkedList;
import java.util.Scanner;

public class AiportSimulation {
	public static void main(String [] args) {
		Scanner input = new Scanner (System.in);
		
		System.out.println("Enter the following information separated by a comma: simulation time, takeoff time, landing time, takeoff rate, landing rate.");
		
		String info = input.next();
			String [] infoSplit = info.split(",");	
			
		int simTime = Integer.parseInt(infoSplit[0]);
		
		int takeoffTime = Integer.parseInt(infoSplit[1]);
		
		int landingTime = Integer.parseInt(infoSplit[2]);
		
		int takeoffRate = Integer.parseInt(infoSplit[3]);
		
		int landingRate = Integer.parseInt(infoSplit[4]);
		
		LinkedList<Integer> landingQueue = new LinkedList<>();
		
		LinkedList<Integer> takeoffQueue = new LinkedList<>();
		
		int landRequests = 0;
		int takeoffRequests = 0; 
		int landingSize = 0; 
		int takeoffSize = 0;
		int totalLandingWaitingTime = 0;
		int totalTakeoffWaitingTime = 0;
		
		
		int runway = 0;
		
		
		double rand1 = 0;
		double rand2 = 0;
		
		for (int time = 0; time < simTime; time++) {
			rand1 = Math.random();
			rand2 = Math.random();
			if (rand1 < (landingRate/60.0)) {
				landingQueue.addLast(time);
				landRequests++;
				landingSize++;
			}
			if (rand2 < (takeoffRate / 60.0)) {
				takeoffQueue.addLast(time);
				takeoffRequests++;
				takeoffSize++;
			}
			if (runway == 0 && !landingQueue.isEmpty()) {
				runway = landingTime;
				totalLandingWaitingTime += time - landingQueue.poll();
			}
			if (runway == 0 && landingQueue.isEmpty() && !takeoffQueue.isEmpty()) {
				runway = takeoffTime; 
				totalTakeoffWaitingTime += time - takeoffQueue.poll();
				
			}
			if (runway != 0) {
				runway--;
			}
			landingSize += landingQueue.size();
			takeoffSize += takeoffQueue.size();
		}
		
		while (!landingQueue.isEmpty()) {
			
			totalLandingWaitingTime += simTime - landingQueue.poll();
			
		}
		
		
		while (!takeoffQueue.isEmpty()) {
			totalTakeoffWaitingTime += simTime - takeoffQueue.poll();
		}
		
		int avgLand = totalLandingWaitingTime / landRequests;
		int avgTakeoff = totalTakeoffWaitingTime / takeoffRequests;
		
		
		
		System.out.println("Simulation time: " + simTime);
		System.out.println("Landing Rate: " + landingRate + " airplanes/hour, Landing Time: " + landingTime);
		System.out.println("Takeoff Rate: " + takeoffRate + " airplanes/hour, Takeoff Time: " + takeoffTime);
		
		
		
		System.out.println();
		System.out.println();
		System.out.println("Average waiting time for landing airplanes is:  " + avgLand + " minutes");
		System.out.println("Average waiting time for taking off airplanes is:  " + avgTakeoff + " minutes");
		
		
		
		System.out.println();
		System.out.println();
		System.out.println("Average queue size for landing: " + (landingSize / simTime));
		System.out.println("Average queue size for taking off: " + (takeoffSize / simTime));
		
		
	}
}
