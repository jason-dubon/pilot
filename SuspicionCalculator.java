//Name: Jason Dubon
//UFL ID: jasondubon
//Section: 11H6
//Project Number: 1
//Program helps police identify the likely hood someone committed a crime
import java.util.Scanner;
import java.lang.*;

public class SuspicionCalculator {
	public static void main(String[] args){
	System.out.println("Hello and welcome to the UF suspect suspicion calculator");
	Scanner input = new Scanner(System.in);
	System.out.println("Please enter the time the crime was committed:");
	int crimetime = input.nextInt();
	if ((crimetime < 0000)||(crimetime > 2359)||crimetime%100 > 59){
		System.out.println("Error. Please enter time again.");
		System.exit(0);
	} 	
	System.out.println("Please enter the latitude of the crime:");
	int crimelatitude = input.nextInt();
		if ((crimelatitude <= 0)||(crimelatitude > 10)){
			System.out.println("Error. Please enter latitude again.");
			System.exit(0);
	}
	System.out.println("Please enter the longitude of the crime:");
	int crimelongitude = input.nextInt();
		if ((crimelongitude <= 0)||(crimelongitude > 10)){
		System.out.println("Error. Please enter longitude again.");
		System.exit(0);
	}	
	System.out.println("Please enter the student's UFID:");
	int ufid = input.nextInt();
		if ((ufid < 10000000)||(ufid > 99999999)){
			System.out.println("Error. Enter UFID again.");
			System.exit(0);
	}
	System.out.println("Please enter their last timestamp:");
	int timestamp = input.nextInt();
		if ((timestamp < 0000)||(timestamp > 2359)||timestamp%100 > 59){
		System.out.println("Error. Please enter time again.");
		System.exit(0);
	} 	
	System.out.println("Please enter the latitude of the student:");
	int studentlatitude = input.nextInt();
		if ((studentlatitude <= 0)||(studentlatitude > 10)){
		System.out.println("Error. Please enter latitude again.");
		System.exit(0);
	}
	System.out.println("Please enter the longitude of the student");
	int studentlongitude = input.nextInt();
		if ((studentlongitude <= 0)||(studentlongitude > 10)){
		System.out.println("Error. Please enter longitude again.");
		System.exit(0);
	}	
	System.out.println("Please enter their heart rate:");
	int bmp = input.nextInt();
	String bmpmeter = "";
	if (bmp >= 100){
		bmpmeter = "moving"; 
	}
	if (bmp < 100){
		bmpmeter = "sedentary"; 
	}
	int lat = studentlatitude - crimelatitude;
	double x = Math.pow(lat, 2);
	int lon = studentlongitude - crimelongitude;
	double y = Math.pow(lon, 2);
	double z = x + y; 
	double d = Math.sqrt(z);
	double num = d;
    String strDouble = String.format("%.1f", num);
    if (crimetime%10==0){
    	int temp = crimetime-40;
    	crimetime = temp;
    }
    if ((Math.abs(crimetime-timestamp)<=30)&&(num <= 1)&&(bmp >= 100)&&(ufid%100 < 49)){
    	System.out.println("Student "+ ufid +" who is on the safe list, and was "
    			+ strDouble+" block units away, at location "+ "("+studentlatitude+","+studentlongitude+")" +
    			" at "+timestamp+" and determined to be "+ bmpmeter+" is Highly Likely to be the Criminal.");
    	System.exit(0);
    }
    if ((Math.abs(crimetime-timestamp)<=100)&&(num <= 1)&&(ufid%100 > 49)){
    	System.out.println("Student "+ ufid +" who is on the unsafe list, and was "
    			+ strDouble+" block units away, at location "+ "("+studentlatitude+","+studentlongitude+")" +
    			" at "+timestamp+" and determined to be "+ bmpmeter+" is Highly Likely to be the Criminal.");
    	System.exit(0);
    }
    if ((Math.abs(crimetime-timestamp)<=100)&&(num <= 1)&&(ufid%100 < 49)&&(bmp >= 100)){
    	System.out.println("Student "+ ufid +" who is on the safe list, and was "
    			+ strDouble+" block units away, at location "+ "("+studentlatitude+","+studentlongitude+")" +
    			" at "+timestamp+" and determined to be "+ bmpmeter+" is Likely to be the Criminal.");
    	System.exit(0);
    }
    if ((Math.abs(crimetime -timestamp)<=130)&&(num <= 2)&&(ufid%100 > 49)&&(bmp >= 100)){
    	System.out.println("Student "+ ufid +" who is on the unsafe list, and was "
    			+ strDouble+" block units away, at location "+ "("+studentlatitude+","+studentlongitude+")" +
    			" at "+timestamp+" and determined to be "+ bmpmeter+" is Likely to be the Criminal.");
    	System.exit(0);
    }
    if ((Math.abs(crimetime -timestamp)<=130)&&(num > 3)&&(ufid%100 < 49)&&(bmp >= 100)){
    	System.out.println("Student "+ ufid +" who is on the safe list, and was "
    			+ strDouble+" block units away, at location "+ "("+studentlatitude+","+studentlongitude+")" +
    			" at "+timestamp+" and determined to be "+ bmpmeter+" is Unsure to be the Criminal.");
    	System.exit(0);
    }
    if ((Math.abs(crimetime -timestamp)<=200)&&(num > 2)&&(ufid%100 > 49)){
    	System.out.println("Student "+ ufid +" who is on the unsafe list, and was "
    			+ strDouble+" block units away, at location "+ "("+studentlatitude+","+studentlongitude+")" +
    			" at "+timestamp+" and determined to be "+ bmpmeter+" is Unsure to be the Criminal.");
    	System.exit(0);
    }
    if ((Math.abs(crimetime -timestamp)<=200)&&(num > 4)&&(ufid%100 < 49)&&(bmp < 100)){
    	System.out.println("Student "+ ufid +" who is on the safe list, and was "
    			+ strDouble+" block units away, at location "+ "("+studentlatitude+","+studentlongitude+")" +
    			" at "+timestamp+" and determined to be "+ bmpmeter+" is Unlikely to be the Criminal.");
    	System.exit(0);
    }
    if ((Math.abs(crimetime -timestamp)<=230)&&(num > 3)&&(ufid%100 > 49)&&(bmp < 100)){
    	System.out.println("Student "+ ufid +" who is on the unsafe list, and was "
    			+ strDouble+" block units away, at location "+ "("+studentlatitude+","+studentlongitude+")" +
    			" at "+timestamp+" and determined to be "+ bmpmeter+" is Unlikely to be the Criminal.");
    	System.exit(0);
    }
    	System.out.println("Student "+ ufid +" who is on the unsafe list, and was "
    			+ strDouble+" block units away, at location "+ "("+studentlatitude+","+studentlongitude+")" +
    			" at "+timestamp+" and determined to be "+ bmpmeter+" is Highly Unlikely to be the Criminal.");
    	
    
	}
	
}
//Student 11119999 who is on the unsafe list, and was 1.0 block units away, at location (5,6) at 1320 and determined to be sedentary is Highly Likely to be the Criminal 
