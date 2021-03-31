
package AFS.Models;

import java.io.Serializable;

public class question  implements Serializable {
//    private String quest;
//    private int ansType;
//    private int status;
//    
//    public question ( String quest, int ansType, int status )
//    {
//        this.quest = quest;
//        this.ansType = ansType;
//        this.status = status;
//    }
//
//    public String getQuest() {
//        return quest;
//    }
//
//    public int getAnsType() {
//        return ansType;
//    }
//
//    public int getStatus() {
//        return status;
//    }    
    
    private int uid;
    private int qno;
    private int ans;

    public question(int uid, int qno, int ans) {
        super();
        this.uid = uid;
        this.qno = qno;
        this.ans = ans;
    }

    public int getUid() {
        return uid;
    }

    public int getQno() {
        return qno;
    }

    public int getAns() {
        return ans;
    }
}
