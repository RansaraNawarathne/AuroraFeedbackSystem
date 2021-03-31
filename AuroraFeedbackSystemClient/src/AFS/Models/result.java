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

