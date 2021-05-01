
package AFS.Models;

/**
 * Analytics model class
 * @author Malindu Ransara Nawarathne
 */
public class analytic {
    private int qno;
    private int ans1Count;
    private int ans2Count;
    private int ans3Count;
    private int ans4Count;

    /**
     * Constructor: Create an analytic object 
     * @param qno: Question number
     * @param ans1Count: Answer 1 count
     * @param ans2Count: Answer 2 count
     * @param ans3Count: Answer 3 count
     * @param ans4Count: Answer 4 count
     */
    public analytic(int qno, int ans1Count, int ans2Count, int ans3Count, int ans4Count) {
        this.qno = qno;
        this.ans1Count = ans1Count;
        this.ans2Count = ans2Count;
        this.ans3Count = ans3Count;
        this.ans4Count = ans4Count;
    }

    /**
     * Get the question number
     * @return the question number
     */
    public int getQno() {
        return qno;
    }

    /**
     * Get the answer 1 count
     * @return answer 1 count
     */
    public int getAns1Count() {
        return ans1Count;
    }

    /**
     * Get the answer 2 count
     * @return answer 2 count
     */
    public int getAns2Count() {
        return ans2Count;
    }

    /**
     * Get the answer 3 count
     * @return answer 3 count
     */
    public int getAns3Count() {
        return ans3Count;
    }

    /**
     * Get the answer 4 count
     * @return answer 4 count
     */
    public int getAns4Count() {
        return ans4Count;
    }
    
}
