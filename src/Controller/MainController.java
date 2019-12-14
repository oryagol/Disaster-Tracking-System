package Controller;

import java.util.Calendar;

import Model.Finder;
import Model.LostPerson;
import Model.Searcher;
import Model.SysData;

public class MainController {
	
	// a method that do a loop on the imported list and checks if there is a match in the missing list and counts matches
	public int syncLists() {
		int count = 0;
		for(LostPerson p : SysData.importedmissing) {
			Searcher s = null;
			s = findMatch(p);
			if(s != null) {
				p.setSearchBy(s);
				count++;
				sendEmail(p.getFoundedBy(), s);
			}
		}
		return count;
	}
	// a method to find a match of a person from the missing list to a person from the found list
	public Searcher findMatch(LostPerson p) {
			if(SysData.findById.get(p.getId()) != null)
			{
				SysData.findById.get(p.getId()).setDateFound(Calendar.getInstance());
				SysData.findById.get(p.getId()).setFoundedBy(p.getFoundedBy());
				return SysData.findById.get(p.getId()).getSearchBy();
			}
			else if(SysData.findByName.get(p.getName()) != null) {
				SysData.findByName.get(p.getName()).setDateFound(Calendar.getInstance());
				SysData.findById.get(p.getId()).setFoundedBy(p.getFoundedBy());
				return SysData.findByName.get(p.getName()).getSearchBy();
			}
			else
				return null;
	}
	// a method that inform the finder and searcher that we found a match
	public boolean sendEmail(Finder f, Searcher s) {
		return true;
	}
}
