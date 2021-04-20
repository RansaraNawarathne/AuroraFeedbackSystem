
package AFS.Models;

import java.io.Serializable;

public class result implements Serializable{
    private int qno;
    private String answer;

    public result(int qno, String answer) {
        this.qno = qno;
        this.answer = answer;
    }

    public int getQno() {
        return qno;
    }

    public String getAnswer() {
        return answer;
    }
    
}

