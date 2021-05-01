/*
Quickchart.io. 2021. Documentation. [online] Available at: <https://quickchart.io/documentation/#library-java>.
*/
package AFS.ServiceLayer;

import AFS.Models.analytic;
import AFS.Models.question;
import io.quickchart.QuickChart;

/**
 * AFS Chart Generator Class
 * @author Malindu Ransara Nawarathne
 */
public class AFSChartGenerator {

    /**
     * Generate Chart
     * @param chartType: Chart Type 
     * @param qno: Question Number
     * @return the URL of the Generated Chart 
     */
    public String generateChart ( String chartType, int qno ) {
        String charturl = "";
        question ques = null;
        ques = questionServiceLayer.retrieveQuestions(qno);
        System.out.println("Question: "+ques.getQuestion());
        analytic res = null;
        res = analyticServiceLayer.retrieveAnalyticData( qno );
        QuickChart chart = new QuickChart();
        chart.setWidth(500);
        chart.setHeight(300);
        chart.setConfig("{"
                + "    type: '"+chartType+"',"
                        + "    data: {"
                        + "        labels: ['"+ques.getAns1()+"', '"+ques.getAns2()+"', '"+ques.getAns3()+"', '"+ques.getAns4()+"'],"
                                + "        datasets: [{"
                                + "            label: '"+ques.getQuestion()+"',"
                                        + "            data: ["+res.getAns1Count()+", "+res.getAns2Count()+", "+res.getAns3Count()+", "+res.getAns4Count()+"]"
                                                + "        }]"
                                                + "    }"
                                                + "}"
        );
        charturl = chart.getShortUrl();
        return charturl;
    }
}
