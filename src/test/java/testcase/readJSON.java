package testcase;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class readJSON {
	public <T> List<T> getJSON(String fileloc, TypeReference<List<T>> ref) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(new File(fileloc), ref);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}

//package testcase;
//
//import java.util.List;
//
//import org.apache.poi.ss.formula.functions.T;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
////we are gonna read the pojo class so as to access the elements in the json file
//
//public class readJSON {
//	public Object[][] getJSON(String fileloc, TypeReference<List<T>> ref) throws JsonMappingException, JsonProcessingException {
//		ObjectMapper obj = new ObjectMapper();
//		List<T> lst = obj.readValue(fileloc, ref);
//		Object[][] info = null;
//		for(int i = 0; i < lst.size(); i++) {
//			info[i][0] = lst.get(i);
//		}
//		return info;
//	}
//}
