package capitaldriftqualification;

import java.util.ArrayList;
import java.util.List;

public class Score {
	
	private List<Integer> lapScores;
	private int qualificationScore;
	private int lapCount;

        public Score() {
            lapScores = new ArrayList<Integer>();
            qualificationScore = 0;
            lapCount = 0;
        }
        
        public void addLapScore(Integer inScore) {

            lapScores.add(inScore);
            lapCount = getLapCount();
            if (lapScores.size() == 2) {
                calculateQualificationLapScore();
            }

        }

        private void calculateQualificationLapScore() {
            if (lapScores.get(0) > lapScores.get(1)) {
                qualificationScore = lapScores.get(0);
            } else {
                qualificationScore = lapScores.get(1);
            }

        }

        public int getLapCount() {
            
            return lapScores.size();
        }

        public int getQualificationScore() {
            return qualificationScore;
        }       
        
        public String toString() {
            String val = "";
            
            val += "QS: " + qualificationScore + "\n";
            val += "Lap: " + lapCount + "\n";
            
            return val;
        }
        
        /**
        public static void main (String args[]) {
             Score testScore = new Score();
                
             testScore.addLapScore(3);
             
             System.out.println(testScore.toString());
             
             testScore.addLapScore(4);
             
             System.out.println(testScore.toString());
            
        }
        * 
        */
        
}