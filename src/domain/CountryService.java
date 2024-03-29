package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryService {
	private Map<String, Country> countries = new HashMap<String, Country>();

	public void addCountry(Country country){
		countries.put(country.getName(), country);
	}
	
	public void create(String name){
		Country country = new Country(name);
		countries.put(name, country);
	}
	
	public List<Country> getCountries(){
		return new ArrayList<Country>(countries.values());
	}

	public Country getMostPopularCountry() {
		int highestVotes = -1;
		Country mostPopular = null;
		List<Country> countryList = getCountries();
		for(int i = 0; i < countryList.size(); i++){
			if(countryList.get(i).getVotes() > highestVotes){
				mostPopular = countryList.get(i);
				highestVotes = mostPopular.getVotes();
			}
		}
		return mostPopular;
	}
}
