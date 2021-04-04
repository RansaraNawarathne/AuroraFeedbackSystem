
package AFS.ServiceLayer;

import AFS.Models.analytic;
import AFS.Models.question;
import io.quickchart.QuickChart;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AFSChartGenerator {
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
