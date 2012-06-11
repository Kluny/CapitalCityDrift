package capitaldriftqualification;

import java.util.Comparator;


/**
 * 
 * @author Shannon Graham
 *
 */

public class Racecar implements Comparable<Racecar>{
	

//At least three data fields
	private String model;
	private String driver;
	private int driverNumber;
	private int qualificationScore;
	

//At least two different constructors

	public Racecar() {
		model = "CorollaCoaster";
		driver = "Judge Instructional Dummy";
		qualificationScore = -1;
	}
	
	public Racecar(String inDriver, String inModel, int inNumber) {
            driver = inDriver;
            model = inModel;
            driverNumber = inNumber;
	    qualificationScore = -1;
	}
	
	
//An equals method
	public boolean equals(Racecar otherCar) {
                if (driverNumber != otherCar.getDriverNumber()) {
                    return false;
                }
		if (! driver.equals(otherCar.getDriver())) {
			return false;
		}
		
		
		return true;
	}

//A toString method
	public String toString() {
		String val = "";
                
                val += driverNumber;
		val += " | " + driver;
		val += " | " + model;
                
		return val;
	}
	
	public String toString(String qualifiedList) {
		String val = "";
                val += driverNumber + " | ";
		val += model + " | ";
		val += driver + "  ";
		
		val += " QS: " + qualificationScore;
		return val;
	}
	
//A compareTo method
	public int compareTo(Racecar otherCar) {
            if (getQualificationScore() - otherCar.getQualificationScore() > 0) {
                return getQualificationScore() - otherCar.getQualificationScore();
            }
            
            return driverNumber - otherCar.getDriverNumber();
		
	}
	
	
//A hashCode method
	public int hashCode() {
		return driver.hashCode() * model.hashCode();
	}
	
//At least one Comparator using a different field (you do remember Comparators, don't you?)
	
	public static Comparator <Racecar> sortByName() {
		return new Comparator<Racecar>() {
			public int compare(Racecar cCar, Racecar dCar) {
				String cDriver = cCar.getDriver();
				String dDriver =  dCar.getDriver();
				return cDriver.compareTo(dDriver);
			}
		};
	}
	
//A getter/setter combination for at least one of the fields. The setter should ignore any 
	//invalid information (that is, it should not blindly set bad/inconsistent data values).
	
	public void setScore(Score inScore) {
            if (qualificationScore == -1) {
                qualificationScore = inScore.getQualificationScore();
            }
            if (inScore.getQualificationScore() > qualificationScore) {
                qualificationScore = inScore.getQualificationScore();
            } 
            
	}
	
	public String getDriver() {
		return driver;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getDriverNumber() {
		return driverNumber;
	}
	
	public int getQualificationScore() {
		return qualificationScore;
	}

}
