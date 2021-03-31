/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFS.Models;

import java.io.Serializable;

/**
 *
 * @author ransa
 */
public class question implements Serializable {
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
