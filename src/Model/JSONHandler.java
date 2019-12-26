package Model;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONHandler {

	public static ArrayList<LostPerson> importedPersonsTempList = new ArrayList<>();
	public static String path = GetExecutionPath();
	
	//reads the question.json file
	/*important! this should be called only in system startup
	 * (this method clears the importedQuestions list and initializes it again with the values from the json file)
	*/
	@SuppressWarnings("unchecked")
	public static Boolean readLostPersonList() {
		SysData.getInstance().getImportedmissing().clear();
		try (Reader reader = new FileReader(path+"src/Data/foundPersons.json")) {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			JSONArray jsonArray = (JSONArray) jsonObject.get("LostPersons");
			jsonArray.forEach(lostPerson -> parseQuestion( (JSONObject) lostPerson ));
			System.out.println("All Missing Persons were read from file");
			reader.close();
			return true;
			}
			

		 catch (IOException e) {
			e.printStackTrace();
			return false;
		 } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//parses each json object from the file to a question object
	
	public static void parseQuestion(JSONObject jsonMissingPerson) {
		JSONObject finderObj  = (JSONObject) jsonMissingPerson.get("finder");
		String finderName=(String)finderObj.get("Name");
		long  finderID=(Long)finderObj.get("id");
		String finderEmail=(String)finderObj.get("email");
		String finderPhone=(String)finderObj.get("phone");
		String location = (String)finderObj.get("Location");
        Finder finder=new Finder(finderName ,finderPhone,finderEmail,(int)finderID, location);
		long missingId  =(Long) jsonMissingPerson.get("id");
		String missingName = (String) jsonMissingPerson.get("Name");
		String missingHeight = (String) jsonMissingPerson.get("Height");
		String missingWeight = (String) jsonMissingPerson.get("Weight");
		String missingState = (String) jsonMissingPerson.get("State");
		long year=(Long) jsonMissingPerson.get("Found Year");
		long month=(Long) jsonMissingPerson.get("Found Month");
		long day=(Long) jsonMissingPerson.get("Found Day");
		String hairColor=(String) jsonMissingPerson.get("Hair Color");
		
		Calendar date= Calendar.getInstance();
		date.set(Calendar.YEAR, (int) year);
	    date.set(Calendar.MONTH,(int) month);
	    date.set(Calendar.DAY_OF_MONTH, (int)day);
	    
		LostPerson lp= new LostPerson(finder);
		lp.setName(missingName);
		lp.setId((int)missingId);
		lp.setHeight(Double.parseDouble(missingHeight));
		lp.setWeight(Double.parseDouble(missingWeight));
		lp.setDateFound(date);
		lp.setDateFound(date);
		lp.setColor(hairColor);
		lp.setState(missingState);
		lp.setMatchPercent(0.0);
		finder.setFoundPerson(lp);
		importedPersonsTempList.add(lp);
		System.out.println(lp+ " was imported successfully.");

	}

	public String getPath() {
		return path;
	}
	
	public static String GetExecutionPath(){
		String abpath = JSONHandler.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String decodedPath = null;
		try {
			decodedPath = URLDecoder.decode(abpath, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = decodedPath.substring(1, decodedPath.length()-8);
		System.out.println(path);
	    return path;
	}
	
	
}
