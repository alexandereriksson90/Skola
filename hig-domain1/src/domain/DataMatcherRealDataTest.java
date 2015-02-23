package domain;

/**
 * @author Alexander Eriksson nbt12aen
 */
import static org.junit.Assert.*;
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
		dm = new DataMatcher(source1, source2, Resolution.DAY);
		ResultingData rsd = dm.searchDataForMatch();
		assertEquals(rsd.getTitle(),
				"Antal mål per matchdag i fotbollsallsvenskan vs Sinewave");
		assertEquals(rsd.getXUnit(), "Antal mål");
		assertEquals(rsd.getYUnit(), "undefinedForSinewave");
	}

	@Test
	public void testMonthWithRealData() {
		dm = new DataMatcher(source1, source2, Resolution.MONTH);
		Map<String, DataPair> result = dm.searchDataForMatch().getData();
		assertNotNull(result);
		assertEquals(new Double(11.0), result.get("2014-03").getX());
		assertEquals(new Double(3.5), result.get("2014-04").getX());
		assertEquals(new Double(0.966428374821654), result.get("2014-03")
				.getY());
		assertEquals(new Double(0.7976843827047911), result.get("2014-04")
				.getY());
	}

	@Test
	public void testYearWithRealData() {
		dm = new DataMatcher(source1, source2, Resolution.YEAR);
		Map<String, DataPair> result = dm.searchDataForMatch().getData();
		assertNotNull(result);
		assertEquals(new Double(5.0), result.get("2014").getX());
		assertEquals(new Double(-0.008002062669153681), result.get("2014")
				.getY());
	}

	@Test
	public void testQuarterWithRealData() {
		dm = new DataMatcher(source1, source2, Resolution.QUARTER);
		Map<String, DataPair> result = dm.searchDataForMatch().getData();
		assertNotNull(result);
		assertEquals(new Double(11.0), result.get("2014-Q1").getX());
		assertEquals(new Double(3.5), result.get("2014-Q2").getX());
		assertEquals(new Double(0.9501485330278084), result.get("2014-Q1")
				.getY());
		assertEquals(new Double(0.4930992349106489), result.get("2014-Q2")
				.getY());
	}

}
