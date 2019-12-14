package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SysData implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static ArrayList<LostPerson> importedmissing;
	public static ArrayList<LostPerson> missingSearched;
	public static HashMap<String, LostPerson> findByName;
	public static HashMap<Integer, LostPerson> findById;
	public static SysData database;
	public static String fileName = "database.ser";
	
	private SysData() {
		importedmissing = new ArrayList<LostPerson>();
		missingSearched = new ArrayList<LostPerson>();
		findByName = new HashMap<>();;
		findById = new HashMap<>();
	}
	
	public static SysData getInstance() {
		if(database == null)
			database = new SysData();
		return database;
	}
	
	
	//reads the question.json file
		/*important! this should be called only in system startup
		 * (this method clears the importedQuestions list and initializes it again with the values from the json file)
		*/
		@SuppressWarnings("unchecked")
		public static Boolean readLostPersonList() {
			importedmissing.clear();
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
			importedmissing.add(lp);
			System.out.println(lp+ " was imported successfully.");
		}
		
		
	
		
		public static void  addMissingForm(LostPerson lp)
		{
			missingSearched.add(lp);
			findByName.put(lp.getName(), lp);
			findById.put(lp.getId(), lp);
		}
		
		public static void  removeMissingForm(LostPerson lp)
		{
			missingSearched.remove(lp);
		}
		
		public static boolean saveDataBase() {
			try {
				FileOutputStream fileOut = new FileOutputStream(fileName);
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
				objectOut.writeObject(database);
				objectOut.close();
				fileOut.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				return false;
			} catch (IOException e1) {
				e1.printStackTrace();
				return false;
			}
			return true;
		}

		public static void loadDataBase() {
			database = null;
			try {
				FileInputStream fileIn = new FileInputStream(fileName);
				ObjectInputStream obIn = new ObjectInputStream(fileIn);
				database = (SysData)obIn.readObject();
				obIn.close();
				fileIn.close();
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				try {
					database = getInstance();
					FileOutputStream fileOut = new FileOutputStream(fileName);
					ObjectOutputStream obOut = new ObjectOutputStream(fileOut);
					obOut.writeObject(database);
					obOut.close();
					fileOut.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
}
