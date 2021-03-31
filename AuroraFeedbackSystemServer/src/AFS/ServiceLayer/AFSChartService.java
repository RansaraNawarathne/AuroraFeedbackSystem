
package AFS.ServiceLayer;

import io.quickchart.QuickChart;

public class AFSChartService {
    
  public static void main(String[] args) {
		QuickChart chart = new QuickChart();
		chart.setWidth(500);
		chart.setHeight(300);
		chart.setConfig("{"
				+ "    type: 'bar',"
				+ "    data: {"
				+ "        labels: ['Q1', 'Q2', 'Q3', 'Q4'],"
				+ "        datasets: [{"
				+ "            label: 'Users',"
				+ "            data: [50, 60, 70, 180]"
				+ "        }]"
				+ "    }"
				+ "}"
		);
		
		System.out.println(chart.getUrl());
  }
}
