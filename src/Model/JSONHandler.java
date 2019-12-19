package Model;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONHandler {

	
	//reads the question.json file
	/*important! this should be called only in system startup
	 * (this method clears the importedQuestions list and initializes it again with the values from the json file)
	*/
	@SuppressWarnings("unchecked")
	public static Boolean readLostPersonList() {
		SysData.getInstance().getImportedmissing().clear();
		try (Reader reader = new FileReader("src\\Data\\foundPersons.json")) {
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
		String finderID=(String)finderObj.get("id");
		String finderEmail=(String)finderObj.get("email");
		String finderPhone=(String)finderObj.get("phone");
		String location = (String)finderObj.get("location");
        Finder finder=new Finder(finderName ,finderPhone,finderEmail,Integer.parseInt(finderID), location);
		String missingId  = (String) jsonMissingPerson.get("id");
		String missingFirstName = (String) jsonMissingPerson.get("Name");
		String missingHeight = (String) jsonMissingPerson.get("Height");
		String missingWeight = (String) jsonMissingPerson.get("Weight");
		Calendar date= Calendar.getInstance();
		LostPerson lp= new LostPerson(finder);
		lp.setName(missingFirstName);
		lp.setId(Integer.parseInt(missingId));
		lp.setHeight(Double.parseDouble(missingHeight));
		lp.setWeight(Double.parseDouble(missingWeight));
		lp.setDateFound(date);
		SysData.getInstance().getImportedmissing().add(lp);
		System.out.println(lp+ " was imported successfully.");
	}
}
