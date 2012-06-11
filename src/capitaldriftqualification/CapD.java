package capitaldriftqualification;

import capitaldriftqualification.Racecar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CapD {

	private List <Racecar> allDrivers;
	private List <Racecar> qualifiedDrivers;
	private int maxQualifiedDrivers;
	private int maxDrivers;
        
	public CapD(int inMaxDrivers) {
		
		allDrivers = new ArrayList<Racecar>();
		qualifiedDrivers = new ArrayList<Racecar>();
		maxQualifiedDrivers = 3;                            //MAGIC NUMBER!!!
                maxDrivers = inMaxDrivers; 
		
	}
	
        /**
         * Sign a car up for the event; this event constructs a new car using parameters.
         * 
         * @param driverName
         * @param carModelInfo
         * @param driverNumber 
         */
	public void registerCar(String driverName, String carModelInfo, int driverNumber ) {
            //redundant if statement; I'll leave it for now.
            if (allDrivers.size() < maxDrivers) {
            Racecar aCar = new Racecar(driverName, carModelInfo, driverNumber);
		allDrivers.add(aCar);
            }
            //else throw an exception, I guess?
           
	}
	
        /**
         * Used by the getQualifedList method.
         */
	private void compileQualifiedList() {
            Collections.sort(allDrivers);
            Collections.reverse(allDrivers);
            for (Racecar car : allDrivers) {
                    if (qualifiedDrivers.size() >= maxQualifiedDrivers) {
                        break;
                    }

                    if(qualifiedDrivers.size() >= maxDrivers) {
                        break;
                    }

                    if(car.getQualificationScore() < 0) {
                        break;
                    }

                    qualifiedDrivers.add(car);
            }

	}
        
        /**
         * Default toString, gives the drivers personal info
         * @return 
         */
        public String toString() {
            String val = "# | Driver  | Car \n\n";
            
            for (Racecar aCar : allDrivers) {
                val += aCar.toString();
                val += "\n\n";
            }
            
            return val;
        }
        
        /**
         * Second toString to be used to find qualified drivers.
         * @return 
         */
        public String otherToString() {
            String val = "   # | Driver | Car \n\n";
            List<Racecar> list = getQualifiedList();
            
            for (Racecar aCar : list) {
                val += (list.indexOf(aCar) + 1) + ". ";
                val += aCar.toString("x");
                val += "\n\n";
            }
            
            return val;
        }
        
        
        //getters and setters
        
        public Racecar getCar(int inDriverNumber) {
		for(Racecar car : allDrivers) {
			if (car.getDriverNumber() == inDriverNumber) {
				return car;
			}	
		}
		return null;
	}
        
	public List<Racecar> getAllDriversSoFar(){
            return allDrivers;
        } 
        
	public List<Racecar> getQualifiedList() {
            compileQualifiedList();
            return qualifiedDrivers;
	}

        public int driversSoFar() {
            return allDrivers.size();
	}
        
        public int getMaxDrivers() {
            return  maxDrivers;
        }

        public void setMaxDrivers(int newMax) {
            maxDrivers = newMax;
        }
        
        public void removeDriver(int driverToRemove) {
            allDrivers.remove(driverToRemove - 1);
        }
        
        public Racecar getRemovedDriver(int driverToRemove) {
            return allDrivers.remove(driverToRemove - 1);
        }
        
        /**
        
        public static void main(String args[]) {
            
            CapD event = new CapD(5);
            
            event.registerCar("aMan", "aCar", 1);
            event.registerCar("bMan", "bCar", 2);
            event.registerCar("cMan", "cCar", 3);
            event.registerCar("dMan", "dCar", 4);
            event.registerCar("eMan", "eCar", 5);
            
            Score aScore = new Score();
            
            aScore.addLapScore(25);
            aScore.addLapScore(20);
            
            System.out.println(event.toString());
            
            
            for (Racecar aCar : event.allDrivers) {
                aCar.setScore(aScore);
            }
            
            event.compileQualifiedList();

            System.out.println(event.otherToString());
            
            
        }
        */
}
