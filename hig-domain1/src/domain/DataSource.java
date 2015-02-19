package domain;

import java.time.LocalDate;
import java.util.Map;

/**
 * @author Alexander Eriksson nbt12aen
 */
public interface DataSource {
	
	String getName();
	
	String getUnit();
	
	Map<LocalDate, Double> getData();

}

