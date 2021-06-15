package poly.util;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;


public class AuthCalendarUtil {
	
		private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";
	    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	    private static final String TOKENS_DIRECTORY_PATH = "tokens";
	    /*static Calendar service;*/
	    
	    //임시 패스 잡아주기
	    public static final boolean IS_WINDOWS = System.getProperty("os.name").toLowerCase().startsWith("windows");
	    /**
	     * Global instance of the scopes required by this quickstart.
	     * If modifying these scopes, delete your previously saved tokens/ folder.
	     */
	    private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR_READONLY);
	    private static final String CREDENTIALS_FILE_PATH = System.getProperty("os.name").toLowerCase().startsWith("windows")?  "C:\\calendar\\client_secret.json" : "";

	    /**
	     * Creates an authorized Credential object.
	     * @param HTTP_TRANSPORT The network HTTP Transport.
	     * @return An authorized Credential object.
	     * @throws IOException If the credentials.json file cannot be found.
	     */
	    public static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
	    	InputStream in = new FileInputStream(CREDENTIALS_FILE_PATH);
	    	// Load client secrets.
	        		//AuthCalendarUtil.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
	        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

	        // Build flow and trigger user authorization request.
	        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
	                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
	                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
	                .setAccessType("offline")
	                .build();
	        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8080).build();
	        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
	    }

	    public static void main() throws IOException, GeneralSecurityException {
	        // Build a new authorized API client service.
	        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
	        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
	                .setApplicationName(APPLICATION_NAME)
	                .build();

	        // List the next 10 events from the primary calendar.
	        DateTime now = new DateTime(System.currentTimeMillis());
	        Events events = service.events().list("primary")
	                .setMaxResults(10)
	                .setTimeMin(now)
	                .setOrderBy("startTime")
	                .setSingleEvents(true)
	                .execute();
	        List<Event> items = events.getItems();
	        if (items.isEmpty()) {
	            System.out.println("No upcoming events found.");
	        } else {
	            System.out.println("Upcoming events");
	            for (Event event : items) {
	                DateTime start = event.getStart().getDateTime();
	                
	                //임시 데이터
	                
	                //일정 제목
	                String title = event.getSummary();
	                //일정 시작 날짜, 시간
	                String googleStartDate = event.getStart().toString();
	                String startDate = googleStartDate.substring(13,29);
	                //일정 끝나는 날짜, 시간
	                String googleEndDate = event.getEnd().toString();
	                String endDate = googleEndDate.substring(13,29);
	                //내용
	                String type = "";
	                String description = "";
	                String content = event.getDescription();
	                String [] contentArr = content.split(":");
	                if(contentArr.length == 0) {
	                	
	                } else if(contentArr.length==1) {
	                	description = contentArr[0];
	                } else { 
	                	type = contentArr[0];
		                description = contentArr[1];
	                }
	                
	                //일정 색깔
	                String colorId = event.getColorId();
	                
	                String eventId = event.getRecurringEventId();
	                String calendarId = event.getICalUID();
	                //
	                if (start == null) {
	                    start = event.getStart().getDate();
	                }
	                System.out.printf("%s (%s)\n", event.getSummary(), start);
	                System.out.printf("title : %s | startData : %s | endData : %s | "
	                		+ "description : %s | eventId : %s | calendarId : %s | type : %s",title, startDate,endDate,description,eventId,calendarId,type);
	            }
	        }
	        // Retrieve a specific calendar list entry
	        CalendarListEntry calendarListEntry = service.calendarList().get("ghdtjrals3@gmail.com").execute();

	        System.out.println(calendarListEntry.getSummary() + "ㅋㅋ");
	        
	        
	    }
	    
	    /*public void addEvents() throws IOException { 
	    	Event event = new Event()
	    		    .setSummary("Google I/O 2015")
	    		    .setLocation("800 Howard St., San Francisco, CA 94103")
	    		    .setDescription("A chance to hear more about Google's developer products.");

	    		DateTime startDateTime = new DateTime("2021-06-01T09:00:00-07:00");
	    		EventDateTime start = new EventDateTime()
	    		    .setDateTime(startDateTime)
	    		    .setTimeZone("America/Los_Angeles");
	    		event.setStart(start);

	    		DateTime endDateTime = new DateTime("2021-06-01T17:00:00-07:00");
	    		EventDateTime end = new EventDateTime()
	    		    .setDateTime(endDateTime)
	    		    .setTimeZone("America/Los_Angeles");
	    		event.setEnd(end);

	    		String[] recurrence = new String[] {"RRULE:FREQ=DAILY;COUNT=2"};
	    		event.setRecurrence(Arrays.asList(recurrence));

	    		EventAttendee[] attendees = new EventAttendee[] {
	    		    new EventAttendee().setEmail("lpage@example.com"),
	    		    new EventAttendee().setEmail("sbrin@example.com"),
	    		};
	    		event.setAttendees(Arrays.asList(attendees));

	    		EventReminder[] reminderOverrides = new EventReminder[] {
	    		    new EventReminder().setMethod("email").setMinutes(24 * 60),
	    		    new EventReminder().setMethod("popup").setMinutes(10),
	    		};
	    		Event.Reminders reminders = new Event.Reminders()
	    		    .setUseDefault(false)
	    		    .setOverrides(Arrays.asList(reminderOverrides));
	    		event.setReminders(reminders);

	    		String calendarId = "primary";
	    		event = service.events().insert(calendarId, event).execute();
	    		System.out.printf("Event created: %s\n", event.getHtmlLink());
	    }*/
	    




}
