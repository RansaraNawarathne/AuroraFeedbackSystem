
package AFS.Models;

import java.io.Serializable;


/**
 * Question model class
 * @author Malindu Ransara Nawarathne
 */
public class question implements Serializable {
    private int qno;
    private String question;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;

   /**
     * Constructor: Create question object
     * @param qno: question number
     * @param question: question
     * @param ans1: Answer 1
     * @param ans2: Answer 2
     * @param ans3: Answer 3
     * @param ans4: Answer 4
     */
    public question(int qno, String question, String ans1, String ans2, String ans3, String ans4) {
        this.qno = qno;
        this.question = question;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
    }

    /**
     * Get the question number
     * @return question number
     */
    public int getQno() {
        return qno;
    }

    /**
     * Get the question
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Get the answer 1
     * @return answer 1
     */
    public String getAns1() {
        return ans1;
    }

    /**
     *  Get the answer 2
     * @return the answer 2
     */
    public String getAns2() {
        return ans2;
    }

    /**
     * Get the answer 3
     * @return the answer 3
     */
    public String getAns3() {
        return ans3;
    }

    /**
     * Get the answer 4
     * @return the answer 4
     */
    public String getAns4() {
        return ans4;
    }

}
