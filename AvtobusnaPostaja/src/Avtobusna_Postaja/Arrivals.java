package Avtobusna_Postaja;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;
import java.text.*;

public class Arrivals {
	
	
	public Arrivals(String stop_name, String stop_id, String time_now) throws FileNotFoundException, ParseException {
		
		
        File myStops = new File("C:\\Podatki_AvtobusnaPostaja\\stop_times.txt");//File
        Scanner Reader = new Scanner(myStops);//scanning
        SimpleDateFormat formatting = new SimpleDateFormat("HH:mm:ss");//setting up for formatting date
        Date date_now = formatting.parse(time_now);
        long twoHoursInMillis = 2 * 60 * 60 * 1000; // 2 hours in milliseconds

        while (Reader.hasNextLine()) {
            String data = Reader.nextLine();
            String[] stop_times = data.split(",");

            if (stop_times.length > 3 && stop_times[3].equals(stop_id)) {
                String time_arrival = stop_times[1];
                Date bus_arrival = formatting.parse(time_arrival);

                long differenceInMilliSeconds = Math.abs(bus_arrival.getTime() - date_now.getTime());
                if (differenceInMilliSeconds <= twoHoursInMillis && bus_arrival.getTime() >= date_now.getTime()) {
                    System.out.println("Avtobus " + RouteId(stop_times) + " prispe ob " + time_arrival + " na postajo " + stop_name);
                    
                }
            }
        }

        Reader.close();
    }
	public String RouteId(String[] stop_times) {
		String trip_id = stop_times[0];
		String[] divide = trip_id.split("_");
		return divide[2];
	}
}
