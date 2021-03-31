
package AFS.ServiceLayer;

import AFS.Models.result;

public class resultServiceLayer {
    private result[] rs;
    private int index;
    
    public resultServiceLayer () {
        rs = new result[10];
        index = 0;
    }
    
    public void addResults (result res){
        rs[index] = res;
        index++;
    }
}
