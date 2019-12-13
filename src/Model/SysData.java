package Model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SysData {
	
	
	public static ArrayList<LostPerson> importedmissing=new ArrayList<LostPerson>();
	public static ArrayList<LostPerson> missingSearched=new ArrayList<LostPerson>();
	
	//reads the question.json file
		/*important! this should be called only in system startup
		 * (this method clears the importedQuestions list and initializes it again with the values from the json file)
		*/
		@SuppressWarnings("unchecked")
		public static void readLostPersonList() {
			importedmissing.clear();
			try (Reader reader = new FileReader("src\\Data\\foundPersons.json")) {
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
				JSONArray jsonArray = (JSONArray) jsonObject.get("LostPersons");
				jsonArray.forEach(lostPerson -> parseQuestion( (JSONObject) lostPerson ));
				System.out.println("All Missing Persons were read from file");
				reader.close();
				}
				

			 catch (IOException e) {
				e.printStackTrace();
			 } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//parses each json object from the file to a question object
		
		public static void parseQuestion(JSONObject jsonMissingPerson) {
			JSONObject finderObj  = (JSONObject) jsonMissingPerson.get("finder");
			String finderFirstName=(String)finderObj.get("First Name");
			String finderLastName=(String)finderObj.get("Last Name");
			String finderID=(String)finderObj.get("id");
			String finderEmail=(String)finderObj.get("email");
			String finderPhone=(String)finderObj.get("phone");
            Finder finder=new Finder(finderFirstName,finderLastName,finderPhone,finderEmail,finderID);
			String missingId  = (String) jsonMissingPerson.get("id");
			String missingFirstName = (String) jsonMissingPerson.get("First Name");
			String missingLastName = (String) jsonMissingPerson.get("Last Name");
			String missingEmail = (String) jsonMissingPerson.get("email");
			String missingPhone = (String) jsonMissingPerson.get("phone");
			String missingHeight = (String) jsonMissingPerson.get("Height");
			String missingWeight = (String) jsonMissingPerson.get("Weight");
			String missingAdditionalInfo = (String) jsonMissingPerson.get("team");
			Calendar date= Calendar.getInstance();
			LostPerson lp= new LostPerson(finder);
			lp.setAdditionalInfo(missingAdditionalInfo);
			lp.setFirstName(missingFirstName);
			lp.setLastName(missingLastName);
			lp.setId(missingId);
			lp.setEmail(missingEmail);
			lp.setPhone(missingPhone);
			lp.setHeight(missingHeight);
			lp.setWeight(missingWeight);
			lp.setDateFound(date);
			importedmissing.add(lp);
			System.out.println(lp+ " was imported successfully.");
		}
		
		
	
		
		public static void  addMissingForm(LostPerson lp)
		{
			missingSearched.add(lp);
		}
		
		public static void  removeMissingForm(LostPerson lp)
		{
			missingSearched.remove(lp);
		}
		
	
		
}
