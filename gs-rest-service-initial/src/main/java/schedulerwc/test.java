package schedulerwc;

import java.util.*;

/*
class Team{
 int number;
 String hometown ;
 
 Team(int id, String town){
	 this.number=id;
	 this.hometown=town;
 }
}
*/
public class test {
	
	public static void main(String args[]){
		System.out.println("hello");
		int i,j,numberofteams=7;
		
		int actualNumberofTeams=numberofteams;
		if (actualNumberofTeams %2 == 1) {
			numberofteams=actualNumberofTeams+1;
		}
		
		List<Team> playingTeams = new ArrayList<Team>();
		List<String> tournamentFixture = new ArrayList<String>();
		
		
		for(i=0;i<numberofteams;i++){
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

	            // Last team stays in the same place while the others
	            // rotate around it.
	            if (match == 0) {
	                away = playingTeams.size() - 1;
	            }
	            
	            if (actualNumberofTeams!=numberofteams && ( home==(numberofteams-1) || away==(numberofteams-1)) ) {
	                continue;
	            }
	    	    
	            
	    	    if (round < halfRoundMark) {
	    	    	matchTitle = ("Day " + ( ((matchesPerRound*round)+match)/2 +1 ) +" Match of team " + playingTeams.get((home)).getNumber()
	                        + " playing against team " + playingTeams.get((away)).getNumber() +" at " + playingTeams.get((home)).getHometown()  );
	            } else {
	            	matchTitle = ("Day "+( ((matchesPerRound*round)+match)/2 +1 ) +" Match of team " + playingTeams.get((away)).getNumber()
	                        + " playing against team " + playingTeams.get((home)).getNumber() +" at " + playingTeams.get((away)).getHometown() );
	            }
	    	    tournamentFixture.add(matchTitle);
	            
	        }
	    }
		
		
		String fixtures="";
		for ( i = 0; i < tournamentFixture.size(); i++) {
	        System.out.println( tournamentFixture.get(i) );
	        fixtures+=tournamentFixture.get(i)+"<br><br>";
	    }
		
	}
	
}
	
	
