package myProjects;

import java.util.Scanner;

public class Bicycle_Planner_App {
	
	static Scanner userinput = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("___Bicycle Excercise Planner___");
		
		System.out.print("Enter name: ");
		String ownerName = userinput.nextLine();
		
		System.out.print("Enter bicycle type: ");
		String bikeType = userinput.nextLine();
		
		System.out.print("Enter target cadence RPM: ");
		int targetCadence = userinput.nextInt();
		
		System.out.print("Enter target speed MPH: ");
		int targetSpeed = userinput.nextInt();
		
		System.out.print("Ente target gear(1-21): ");
		int targetGear = userinput.nextInt();
		
		System.out.println("");
		
		Bicycle userBike = new Bicycle(targetCadence, targetSpeed, targetGear, bikeType, ownerName);
		
		System.out.println("___Bicycle Profile___");
		System.out.println(userBike.getInfo());
		
		System.out.println("");
		
		System.out.print("Enter your weight Lbs: ");
		double weightLbs = userinput.nextInt();
		
		System.out.print("Enter workout duration mins: ");
		int duration = userinput.nextInt();
		
		System.out.println("");
		
		double weightKg = weightLbs * 0.453592;
		double hoursWorked = duration / 60.0;
		double metValue = estimateMET(targetCadence, targetSpeed);
		double estCalories = weightKg * hoursWorked * metValue;
		
		double estCaloriesRounded = Math.round(estCalories * 2) / 2;
		
		System.out.println("___Excercise Plan___");
		System.out.println("Duration  : " + duration + " minutes");
		System.out.println("Intensity : " + intensity(metValue));
		System.out.println("Est. Calories Burned: " + estCaloriesRounded);
		
	}
	
	static double estimateMET(int cadence, int speed) {
        if (speed < 10) return 4.0;
        if (speed < 12) return 6.0;
        if (speed < 14) return 8.0;
        if (speed < 16) return 10.0;
        return 12.0;
    }
 
    static String intensity(double met) {
        if (met < 5.0) return "Light";
        if (met < 8.0) return "Moderate";
        if (met < 11.0) return "Vigorous";
        return "Very Vigorous";
    }
}
