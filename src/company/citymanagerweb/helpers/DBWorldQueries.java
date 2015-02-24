package company.citymanagerweb.helpers;

public class DBWorldQueries {
	public static String getCitiesByDistrictByPopulation() {
		return "SELECT * FROM districts ORDER BY id ASC";
	}
	
	public static String getCountriesByName()
	{
		return "select Code, Name, Population "
				+ "from country " 
			    + "order by Name";
	}
}
