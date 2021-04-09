
package AFS.ServiceLayer;

import AFS.DatabaseLayer.DatabaseConnection;
import AFS.Models.analytic;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class analyticServiceLayer {
    private static Connection conn;
    private static Statement state;
    private static PreparedStatement prestate;
    private static ResultSet rsts;
    
    public static analytic retrieveAnalyticData (int qno) {
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            rsts = state.executeQuery("SELECT * FROM `analysed` WHERE `questionNo` = "+qno+";");
            
            analytic res = null;
            
            while ( rsts.next() ) {
                res = new analytic(rsts.getInt(1), rsts.getInt(2), rsts.getInt(3), rsts.getInt(4), rsts.getInt(5));
            }
            
            return res;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static boolean analyseProcess () {
        try {
            int q1 [] = new int [4];
            int q2 [] = new int [4];
            int q3 [] = new int [2];
            int q4 [] = new int [2];
            int q5 [] = new int [2];
            int q6 [] = new int [4];
            int q7 [] = new int [4];
            int q8 [] = new int [4];
            int q9 [] = new int [4];
            int q10 [] = new int [4];
            boolean s1,s2,s3,s4,s5,s6,s7,s8,s9,s10 = false;
            boolean updateStatus = false;
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            q1 = analyseQuestion1();
            q2 = analyseQuestion2();
            q3 = analyseQuestion3();
            q4 = analyseQuestion4();
            q5 = analyseQuestion5();
            q6 = analyseQuestion6();
            q7 = analyseQuestion7();
            q8 = analyseQuestion8();
            q9 = analyseQuestion9();
            q10 = analyseQuestion10();
            
            prestate = (PreparedStatement) conn.prepareStatement("UPDATE `analysed` SET `answer1` = '"+q1[0]+"', `answer2` = '"+q1[1]+"', `answer3` = '"+q1[2]+"', `answer4` = '"+q1[3]+"' WHERE `analysed`.`questionNo` = 1;");
            s1 = prestate.executeUpdate()> 0;
            prestate = (PreparedStatement) conn.prepareStatement("UPDATE `analysed` SET `answer1` = '"+q2[0]+"', `answer2` = '"+q2[1]+"', `answer3` = '"+q2[2]+"', `answer4` = '"+q2[3]+"' WHERE `analysed`.`questionNo` = 2;");
            s2 = prestate.executeUpdate()> 0;
            prestate = (PreparedStatement) conn.prepareStatement("UPDATE `analysed` SET `answer1`='"+q3[0]+"',`answer2`='"+q3[1]+"' WHERE `questionNo` = 3;");
            s3 = prestate.executeUpdate()> 0;
            prestate = (PreparedStatement) conn.prepareStatement("UPDATE `analysed` SET `answer1`='"+q4[0]+"',`answer2`='"+q4[1]+"' WHERE `questionNo` = 4;");
            s4 = prestate.executeUpdate()> 0;
            prestate = (PreparedStatement) conn.prepareStatement("UPDATE `analysed` SET `answer1`='"+q5[0]+"',`answer2`='"+q5[1]+"' WHERE `questionNo` = 5;");
            s5 = prestate.executeUpdate()> 0;
            prestate = (PreparedStatement) conn.prepareStatement("UPDATE `analysed` SET `answer1` = '"+q6[0]+"', `answer2` = '"+q6[1]+"', `answer3` = '"+q6[2]+"', `answer4` = '"+q6[3]+"' WHERE `analysed`.`questionNo` = 6;");
            s6 = prestate.executeUpdate()> 0;
            prestate = (PreparedStatement) conn.prepareStatement("UPDATE `analysed` SET `answer1` = '"+q7[0]+"', `answer2` = '"+q7[1]+"', `answer3` = '"+q7[2]+"', `answer4` = '"+q7[3]+"' WHERE `analysed`.`questionNo` = 7;");
            s7 = prestate.executeUpdate()> 0;
            prestate = (PreparedStatement) conn.prepareStatement("UPDATE `analysed` SET `answer1` = '"+q8[0]+"', `answer2` = '"+q8[1]+"', `answer3` = '"+q8[2]+"', `answer4` = '"+q8[3]+"' WHERE `analysed`.`questionNo` = 8;");
            s8 = prestate.executeUpdate()> 0;
            prestate = (PreparedStatement) conn.prepareStatement("UPDATE `analysed` SET `answer1` = '"+q9[0]+"', `answer2` = '"+q9[1]+"', `answer3` = '"+q9[2]+"', `answer4` = '"+q9[3]+"' WHERE `analysed`.`questionNo` = 9;");
            s9 = prestate.executeUpdate()> 0;
            prestate = (PreparedStatement) conn.prepareStatement("UPDATE `analysed` SET `answer1` = '"+q10[0]+"', `answer2` = '"+q10[1]+"', `answer3` = '"+q10[2]+"', `answer4` = '"+q10[3]+"' WHERE `analysed`.`questionNo` = 10;");
            s10 = prestate.executeUpdate()> 0;
            
            if ( s1 && s2 && s3 && s4 && s5 && s6 && s7 && s8 && s9 && s10 ) {
            updateStatus = true;
        } else {
                updateStatus = false;
                }
            return updateStatus;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static int [] analyseQuestion1 () {
        try {
            int count[] = new int [4];
            int iTempCount = 0;
            String tempCount = "";
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            rsts = state.executeQuery("SELECT COUNT(CASE WHEN `question1` BETWEEN 16 AND 30 THEN 1 END) FROM `response`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    iTempCount = Integer.parseInt(tempCount);
                    System.out.println("16 AND 30: " + iTempCount);
                    
                    count [0] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    
                    rsts = state.executeQuery("SELECT COUNT(CASE WHEN `question1` BETWEEN 31 AND 40 THEN 1 END) FROM `response`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    iTempCount = Integer.parseInt(tempCount);
                    System.out.println("31 AND 40: " + iTempCount);
                    
                    count [1] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    rsts = state.executeQuery("SELECT COUNT(CASE WHEN `question1` BETWEEN 41 AND 60 THEN 1 END) FROM `response`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    iTempCount = Integer.parseInt(tempCount);
                    System.out.println("41 AND 60: " + iTempCount);
                    
                    count [2] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    rsts = state.executeQuery("SELECT COUNT(CASE WHEN `question1` BETWEEN 61 AND 80 THEN 1 END) FROM `response`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    iTempCount = Integer.parseInt(tempCount);
                    System.out.println("61 AND 80: " + iTempCount);
                    
                    count [3] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    return count;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static int [] analyseQuestion2 () {
        try {
            int count[] = new int [4];
            int iTempCount = 0;
            String tempCount = "";
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question2` = 'Punctual' GROUP BY `question2`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Punctual Count: " + iTempCount);
                    
                    count [0] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question2` = 'Slightly late' GROUP BY `question2`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Slightly late Count: " + iTempCount);
                    
                    count [1] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question2` = 'Late' GROUP BY `question2`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Late Count: " + iTempCount);
                    
                    count [2] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question2` = 'Extremely late' GROUP BY `question2`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Extremely late Count: " + iTempCount);
                    
                    count [3] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    return count;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static int [] analyseQuestion3 () {
        try {
            int count[] = new int [2];
            int iTempCount = 0;
            String tempCount = "";
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question3` = 'Yes' GROUP BY `question3`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Yes Count: " + iTempCount);
                    
                    count [0] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question3` = 'No' GROUP BY `question3`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("No Count: " + iTempCount);
                    
                    count [1] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    return count;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static int [] analyseQuestion4 () {
        try {
            int count[] = new int [2];
            int iTempCount = 0;
            String tempCount = "";
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question4` = 'Yes' GROUP BY `question3`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Yes Count: " + iTempCount);
                    
                    count [0] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question4` = 'No' GROUP BY `question3`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("No Count: " + iTempCount);
                    
                    count [1] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    return count;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static int [] analyseQuestion5 () {
        try {
            int count[] = new int [2];
            int iTempCount = 0;
            String tempCount = "";
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question5` = 'Yes' GROUP BY `question3`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Yes Count: " + iTempCount);
                    
                    count [0] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question5` = 'No' GROUP BY `question3`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("No Count: " + iTempCount);
                    
                    count [1] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    return count;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static int [] analyseQuestion6 () {
        try {
            int count[] = new int [4];
            int iTempCount = 0;
            String tempCount = "";
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question6` = 'Strongly agree' GROUP BY `question6`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Strongly Agree Count: " + iTempCount);
                    
                    count [0] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question6` = 'Agree' GROUP BY `question6`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Agree Count: " + iTempCount);
                    
                    count [1] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question6` = 'Disagree' GROUP BY `question6`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Disagree Count: " + iTempCount);
                    
                    count [2] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question6` = 'Strongly disagree' GROUP BY `question6`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Strongly Disagree Count: " + iTempCount);
                    
                    count [3] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    return count;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static int [] analyseQuestion7 () {
        try {
            int count[] = new int [4];
            int iTempCount = 0;
            String tempCount = "";
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question7` = 'Excellent' GROUP BY `question7`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Excellent Count: " + iTempCount);
                    
                    count [0] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question7` = 'Good' GROUP BY `question7`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Good Count: " + iTempCount);
                    
                    count [1] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question7` = 'Neutral' GROUP BY `question7`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Neutral Count: " + iTempCount);
                    
                    count [2] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question7` = 'Bad' GROUP BY `question7`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Bad Count: " + iTempCount);
                    
                    count [3] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    return count;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static int [] analyseQuestion8 () {
        try {
            int count[] = new int [4];
            int iTempCount = 0;
            String tempCount = "";
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question8` = 'Strongly agree' GROUP BY `question8`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Strongly Agree Count: " + iTempCount);
                    
                    count [0] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question8` = 'Agree' GROUP BY `question8`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Agree Count: " + iTempCount);
                    
                    count [1] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question8` = 'Disagree' GROUP BY `question8`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Disagree Count: " + iTempCount);
                    
                    count [2] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question8` = 'Strongly disagree' GROUP BY `question8`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Strongly Disagree Count: " + iTempCount);
                    
                    count [3] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    return count;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static int [] analyseQuestion9 () {
        try {
            int count[] = new int [4];
            int iTempCount = 0;
            String tempCount = "";
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question9` = 'Excellent' GROUP BY `question9`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Excellent Count: " + iTempCount);
                    
                    count [0] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question9` = 'Good' GROUP BY `question9`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Good Count: " + iTempCount);
                    
                    count [1] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question9` = 'Neutral' GROUP BY `question9`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Neutral Count: " + iTempCount);
                    
                    count [2] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question9` = 'Bad' GROUP BY `question9`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Bad Count: " + iTempCount);
                    
                    count [3] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    return count;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static int [] analyseQuestion10 () {
        try {
            int count[] = new int [4];
            int iTempCount = 0;
            String tempCount = "";
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question10` = 'Toyota Corolla Axio' GROUP BY `question10`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Axio Count: " + iTempCount);
                    
                    count [0] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question10` = 'Toyota Premio' GROUP BY `question10`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Premio Count: " + iTempCount);
                    
                    count [1] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question10` = 'Audi S4' GROUP BY `question10`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("Audi Count: " + iTempCount);
                    
                    count [2] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    rsts = state.executeQuery("SELECT COUNT(*) FROM `response` WHERE `question10` = 'BMW 520d' GROUP BY `question10`;");
                    while (rsts.next()) {
                        tempCount = rsts.getString(1);
                    }
                    if ( tempCount.compareTo("") == 0 ) {
                            iTempCount = 0;
                        } else {
                            iTempCount = Integer.parseInt(tempCount);
                        }
                    System.out.println("BMW Count: " + iTempCount);
                    
                    count [3] = iTempCount;
                    iTempCount = 0;
                    tempCount = "";
                    rsts = null;
                    
                    return count;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}