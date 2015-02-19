
package domain;
/**
 * @author Alexander Eriksson nbt12aen
 */
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataMatcherRealDataTest {
	private DataSource source1, source2;
	private DataMatcher dm;

	@Before
	public void setUp() throws Exception {
		source1 = new FootballGoalsSource();
		source2 = new SineWave();		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testResultingData() {
//		dm = new DataMatcher(source1, source2, Resolution.DAY);
//		ResultingData rsd = dm.searchDataForMatch();
//		assertEquals(rsd.getTitle(), "Antal mål per matchdag i fotbollsallsvenskan vs sinewave");
//		assertEquals(rsd.getXUnit(), "Antal mål");
//		assertEquals(rsd.getYUnit(), "undefined");
	}

	@Test
	public void testDay() {
		dm = new DataMatcher(source1, source2, Resolution.YEAR);
		Map<String, DataPair> result = dm.searchDataForMatch().getData();
		assertNotNull(result);
		System.out.println(result.size());
		assertEquals(new Double(5.0), result.get("2014").getX());
		assertEquals(new Double(13.0), result.get("2014").getY());
	}


}
