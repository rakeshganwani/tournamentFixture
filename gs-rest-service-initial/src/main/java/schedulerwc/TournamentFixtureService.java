package schedulerwc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TournamentFixtureService {
	
	String getTournamentMatchList(Integer numberOfTeams){
		
		
		int i;
		//int numberOfTeams=8;
		int actualNumberofTeams=numberOfTeams;
		if (actualNumberofTeams %2 == 1) {
			numberOfTeams=actualNumberofTeams+1;
		}
		
		List<Team> playingTeams = new ArrayList<Team>();
		List<String> tournamentFixture = new ArrayList<String>();
		
		
		for(i=0;i<numberOfTeams;i++){
			Team playing=new Team( (i+1), ("HomeTown"+(i+1)) );
			playingTeams.add(playing);
		}
		
		int totalRounds = (playingTeams.size() - 1)*2;
		int matchesPerRound = playingTeams.size() / 2;
		int halfRoundMark = (totalRounds/2);
		String matchTitle;
		
		for (int round = 0; round < totalRounds; round++) {
	        for (int match = 0; match < matchesPerRound; match++) {
	            int home = (round + match) % (playingTeams.size() - 1);
	            int away = (playingTeams.size() - 1 - match + round) % (playingTeams.size() - 1);

	            if (match == 0) {
	                away = playingTeams.size() - 1;
	            }
	            
	            if (actualNumberofTeams!=numberOfTeams && ( home==(numberOfTeams-1) || away==(numberOfTeams-1)) ) {
	                continue;
	            }
	    	    
	            //+" Match # "+(matchesPerRound*round+match+1)
	    	    if (round < halfRoundMark) {
	    	    	matchTitle = ("Day " + ( ((matchesPerRound*round)+match)/2 +1 )  +" of team " + playingTeams.get((home)).getNumber()
	                        + " playing against team " + playingTeams.get((away)).getNumber() +" at " + playingTeams.get((home)).getHometown()  );
	            } else {
	            	matchTitle = ("Day "+( ((matchesPerRound*round)+match)/2 +1 ) +" of team " + playingTeams.get((away)).getNumber()
	                        + " playing against team " + playingTeams.get((home)).getNumber() +" at " + playingTeams.get((away)).getHometown() );
	            }
	    	    tournamentFixture.add(matchTitle);
	            
	        }
	    }
		
		String fixtures="";
		for ( i = 0; i < tournamentFixture.size(); i++) {
	        System.out.println( tournamentFixture.get(i) );
	        fixtures+="Match # "+ (i+1) +" "+ tournamentFixture.get(i)+"<br><br>";
	    }
		
		return fixtures;
		
	}

}
