package poly.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import poly.dto.CalendarDTO;
import poly.util.GoogleCalendarService;


@Controller
public class CalenderController {

	private Logger log = Logger.getLogger(this.getClass());
	
	/*@Resource(name = "calenderController")
	*/
	
	@RequestMapping(value = "/calendar/calendarEventAdd")
	public @ResponseBody boolean calendarEventAdd(CalendarDTO calDto) throws java.text.ParseException, IOException, GeneralSecurityException {
		boolean isc = false;
		log.info("summary : " + calDto.getSummary());
		log.info("Description : " + calDto.getDescription());
		log.info("startdateTime : " + calDto.getStartDateTime());
		log.info("enddateTime : " + calDto.getEndDateTime());
		log.info("calendarEventAdd "+calDto.toString());
		
		String summary = calDto.getSummary();
		String description = calDto.getDescription();
		String reg_name = calDto.getReg_name();
		
		if(summary.contains("& lt;") || summary.contains("& gt;") || summary.contains("& #40;") || summary.contains("& #41;")){ 
			summary = summary.replaceAll("& lt;", "<");
			summary = summary.replaceAll("& gt;", ">");
			summary = summary.replaceAll("& #40;", "(");
			summary = summary.replaceAll("& #41;", ")");
		}
		if(description.contains("& lt;") || description.contains("& gt;") || description.contains("& #40;") || description.contains("& #41;")){ 
			description = description.replaceAll("& lt;", "<");
			description = description.replaceAll("& gt;", ">");
			description = description.replaceAll("& #40;", "(");
			description = description.replaceAll("& #41;", ")");
		}
		if(reg_name.contains("& lt;") || reg_name.contains("& gt;") || reg_name.contains("& #40;") || reg_name.contains("& #41;")){ 
			reg_name = reg_name.replaceAll("& lt;", "<");
			reg_name = reg_name.replaceAll("& gt;", ">");
			reg_name = reg_name.replaceAll("& #40;", "(");
			reg_name = reg_name.replaceAll("& #41;", ")");
		}
        
		if(calDto.getStartDateTime().equals(calDto.getEndDateTime())) {
			calDto.setSummary(reg_name + " : " + summary);
			log.info("calDto.getSummary() : " + calDto.getSummary());
			log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}

        try {
        	
        	Calendar service = GoogleCalendarService.getCalendarService();

            Event event = new Event().setSummary(calDto.getSummary()).setDescription(description);

            
            calDto.setCalendarId("ghdtjrals3@gmail.com");
            
            //시작일

            DateTime startDateTime = new DateTime(calDto.getStartDateTime());

            EventDateTime start = new EventDateTime().setDateTime(startDateTime).setTimeZone("America/Los_Angeles");

            event.setStart(start);

            //종료일

            DateTime endDateTime = new DateTime(calDto.getEndDateTime());

            EventDateTime end = new EventDateTime().setDateTime(endDateTime).setTimeZone("America/Los_Angeles");

            event.setEnd(end);
            
            event.setColorId("2");

            event = service.events().insert(calDto.getCalendarId(), event).execute();

            isc = true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return isc;

    }    



	
	@RequestMapping(value = "/calendar/success")
	public String getMessasge(HttpServletRequest request, HttpServletResponse reponse)
		throws Exception {
		log.info(this.getClass().getName() + ".getMessasge Start !!");
		
		
		
		log.info(this.getClass().getName() + ".getMessasge End !!");
		return "success";
	}
	
	@RequestMapping(value = "/calendar/mainPage")
	public String getCalendar(HttpServletRequest request, HttpServletResponse reponse)
			throws Exception {
			log.info(this.getClass().getName() + ".getCalendar Start !!");
			
			
			
			log.info(this.getClass().getName() + ".getCalendar End !!");
			return "/calendar/mainPage";
		}
	
	@RequestMapping(value="/calendar/insertPage")
	public String insertPage(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		log.info(this.getClass().getName() + ".insertPage start !!");
		
		log.info(this.getClass().getName() + ".insertPage end !!");
		return "/calendar/insertData";
	}
	
	@RequestMapping(value="/calendar/insertInterviewPage")
	public String insertInterviewPage(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		log.info(this.getClass().getName() + ".insertPage start !!");
		
		log.info(this.getClass().getName() + ".insertPage end !!");
		return "/calendar/insertInterviewData";
	}

	@RequestMapping(value="/calendar/insertSchedulePage")
	public String insertScheduleData() throws Exception {
		log.info(this.getClass().getName() + ".insertScheduleData Start !!");
		log.info(GoogleCalendarService.class.getResource("/").getPath());
		log.info(GoogleCalendarService.class.getResource("/"));
		log.info(this.getClass().getName() + ".insertScheduleData End !!");
		return "/calendar/insertScheduleData";
	}
	
	
}
