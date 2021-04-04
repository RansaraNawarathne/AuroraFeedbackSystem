
package AFS.Models;

public class analytic {
    private int qno;
    private int ans1Count;
    private int ans2Count;
    private int ans3Count;
    private int ans4Count;

    public analytic(int qno, int ans1Count, int ans2Count, int ans3Count, int ans4Count) {
        this.qno = qno;
        this.ans1Count = ans1Count;
        this.ans2Count = ans2Count;
        this.ans3Count = ans3Count;
        this.ans4Count = ans4Count;
    }

    public int getQno() {
        return qno;
    }

    public int getAns1Count() {
        return ans1Count;
    }

    public int getAns2Count() {
        return ans2Count;
    }

    public int getAns3Count() {
        return ans3Count;
    }

    public int getAns4Count() {
        return ans4Count;
    }
    
}
