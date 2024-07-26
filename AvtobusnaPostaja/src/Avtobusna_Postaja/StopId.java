package Avtobusna_Postaja;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StopId {
	public static String stop_name;
	public static String stop_id;
	
	public StopId(String stop_name) throws IOException{
		StopId.stop_name = stop_name;//declaring stop_name for getStopId()
		
	    	File myStops = new File("C:\\Podatki_AvtobusnaPostaja\\stops.txt");//declaring File object and navigation
	    	Scanner Reader = new Scanner(myStops);//scanning strings
	    	while (Reader.hasNextLine()) {//clause for stopping when there is no string left
	    		String data = Reader.nextLine();//putting strings one by one in data
	            String[] stops = data.split(",");//array string for easer search

	            if (stops.length > 3) {//when array has everything we need
	                if (stops[2].equals(stop_name)) {//looking for id
	                    stop_id = stops[0];
	                    break;
	                }
	            }
	        }

	        Reader.close();
	    }

	    public String getStopId() {
	        return stop_id;//getting id
	    }
	    public String getStopName() {
	    	return stop_name;//getting name
	    }
	}
