
package AFS.Models;

import java.io.Serializable;

public class question  implements Serializable {
    private int qno;
    private String question;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;

    public question(int qno, String question, String ans1, String ans2, String ans3, String ans4) {
        this.qno = qno;
        this.question = question;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
    }

    public int getQno() {
        return qno;
    }

    public String getQuestion() {
        return question;
    }

    public String getAns1() {
        return ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public String getAns4() {
        return ans4;
    }

}
