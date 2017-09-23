package schedulerwc;


//import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TournamentFixtures {

    //private static final String template = "Hello, %s!";
    //private final AtomicLong counter = new AtomicLong();

//@RequestMapping(method=GET) to narrow this mapping.

    @RequestMapping("/matchfixtures")
    public String getTournamentFixtures(@RequestParam(value="teams", defaultValue="8") String playingTeams) {
    	int numberOfTeams= 0;
    	 try
    	    {
    		 numberOfTeams=Integer.parseInt(playingTeams);
    	    } catch (NumberFormatException ex)
    	    {
    	        return "Please Enter Valid Team Number";
    	    }
    	if(numberOfTeams<0 || numberOfTeams>30 ){
    		return "Please Enter Valid Team Number";
    	}
    	
    	return new TournamentFixtureService().getTournamentMatchList(numberOfTeams);
    }
}