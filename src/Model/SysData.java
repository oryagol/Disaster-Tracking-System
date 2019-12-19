package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;



public class SysData implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  final ArrayList<LostPerson> importedmissing;
	private  final ArrayList<LostPerson> missingSearched;
	private  final HashMap<String, LostPerson> findByName;
	private  final HashMap<Integer, LostPerson> findById;
	private static SysData database;
	

	private SysData() {
		importedmissing = new ArrayList<LostPerson>();;
		missingSearched = new ArrayList<LostPerson>();
		findByName = new HashMap<>();
		findById = new HashMap<>();
	}
	// singelton
	public static SysData getInstance() {
		if(database == null) 
			database = new SysData();
		return database;
	}
	
	

	public  ArrayList<LostPerson> getImportedmissing() {
		return importedmissing;
	}

	public  ArrayList<LostPerson> getMissingSearched() {
		return missingSearched;
	}


	public  HashMap<String, LostPerson> getFindByName() {
		return findByName;
	}


	public  HashMap<Integer, LostPerson> getFindById() {
		return findById;
	}
	//add a missing person from the form to the db
	public  void  addMissingForm(LostPerson lp)
	{
		missingSearched.add(lp);
		findByName.put(lp.getName(), lp);
		findById.put(lp.getId(), lp);
	}
	// remove a missing person from the db
	public  void  removeMissingForm(LostPerson lp)
	{
		missingSearched.remove(lp);
		findByName.remove(lp.getName());
		findById.remove(lp.getId());
	}
	// save the database
	public static boolean saveDataBase(String fileName) {
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
	// load the database to the system
	public static void loadDataBase(String fileName) {
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
