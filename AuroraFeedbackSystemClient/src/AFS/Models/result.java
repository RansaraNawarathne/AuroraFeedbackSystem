
package AFS.Models;

import java.io.Serializable;

/**
 * Result model class
 * @author Malindu Ransara Nawarathne
 */
public class result implements Serializable{
    private int qno;
    private String answer;

    /**
     * Constructor: Create a reservation object
     * @param qno: Question number
     * @param answer: answer that provide by customer
     */
    public result(int qno, String answer) {
        this.qno = qno;
        this.answer = answer;
    }

    /**
     * Get the question number
     * @return the question number
     */
    public int getQno() {
        return qno;
    }

    /**
     * Get the answer
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }
    
}

