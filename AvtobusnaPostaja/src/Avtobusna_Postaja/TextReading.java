package Avtobusna_Postaja;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TextReading {
  public static void main(String[] args) throws IOException, ParseException{
	  StopId stopName = new StopId("AL Masjid Al-nabawi (Clock Roundabout)");//HERE WE INPUT OUR BUS STOP NAME
	  
      LocalTime currentTime = LocalTime.now();//using local time on computer
      String time_nowFormatted = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));//formatting in string

	  Arrivals stop_time = new Arrivals (stopName.getStopName(), stopName.getStopId(), time_nowFormatted);//putting in name, id and time
  }
}

