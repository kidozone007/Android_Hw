package tw.edu.ntut.csie.app01_105590014;

/**
 * Created by NTUTCSIE on 2018/4/25.
 */

public class letterGrade {
    private char getGrade(int score){
        if (score>100)
            return 'X';
        else if (score>=90)
            return 'A';
        else if (score>=80)
            return 'B';
        else if (score>=70)
            return 'C';
        else if (score>=60)
            return 'D';
        else if (score>=0)
            return 'F';
        else
            return 'X';
    }
}