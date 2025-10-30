package testcase;

import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.type.TypeReference;

public class NewTestJSON {

    @DataProvider(name = "jsonData")
    public Object[][] data() {
        readJSON obj = new readJSON();
        List<ReadingPojo> list = obj.getJSON(".\\src\\test\\java\\testdata\\check.json", new TypeReference<List<ReadingPojo>>() {});
        
        Object[][] data = new Object[list.size()][1];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i);
        }
        return data;
    }

    @Test(dataProvider = "jsonData")
    public void testWithJsonData(ReadingPojo pojo) {
    	System.out.println("PASSED: " + pojo.getEmail() + ", " + pojo.getPassword());
    }
}

//package testcase;
//
//import java.util.List;
//
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//
//public class NewTestJSON {
////  @Test
////  public Object[][] data() {
////	  readJSON obj = new readJSON();
////	  obj.getJSON(".\\src\\test\\java\\testdata\\check.json", new TypeReference<List<ReadingPojo>>(){});
////	  
////  }
//  
//  @DataProvider(name = "jsonData")
//  public Object[][] data() {
//    readJSON obj = new readJSON();
//    List<ReadingPojo> list = obj.getJSON(".\\src\\test\\java\\testdata\\check.json", new TypeReference<List<ReadingPojo>>() {});
//    
//    Object[][] data = new Object[list.size()][1];
//    for (int i = 0; i < list.size(); i++) {
//      data[i][0] = list.get(i);
//    }
//    return data;
//  }
//
//  @Test(dataProvider = "jsonData")
//  public void testWithJsonData(ReadingPojo pojo) {
//    System.out.println("Testing: " + pojo);
//  }
//
//}
