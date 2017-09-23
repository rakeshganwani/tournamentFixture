package schedulerwc;

public class Team{
	 
	private int number;
	private String hometown ;
	 
	 
	 
	 public Team(int id, String town){
		 this.number=id;
		 this.hometown=town;
	 }



	public int getNumber() {
		return number;
	}



	public void setNumber(int number) {
		this.number = number;
	}



	public String getHometown() {
		return hometown;
	}



	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
}