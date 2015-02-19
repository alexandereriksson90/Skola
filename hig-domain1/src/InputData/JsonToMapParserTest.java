package InputData;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.owlike.genson.Genson;
import com.owlike.genson.stream.JsonType;

public class JsonToMapParserTest {
	private JsonToMapParser instance;
	private String urlFetcher;
	@Before
	public void setUp() throws Exception {
		urlFetcher = new UrlFetcher(
				"http://api.everysport.com/v1/events?apikey=1769e0fdbeabd60f479b1dcaff03bf5c&league=63925&limit=2")
				.getContent();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetEmptyResult() {
		instance = new JsonToMapParser("{}");
		assertEquals(instance.getResult().size(), 0);
	}
	@Test
	public void testGetSingleResult() {
		Map<String,Object> resultingMap = new JsonToMapParser("{ \"key\": \"value\" }").getResult();
		assertEquals(resultingMap.size(), 1);
		assertEquals("value", resultingMap.get("key"));
//		System.out.println(resultingMap);
	}
	@Test
	public void testurlFetcherResult() {
		Map<String,Object> resultingMap = new JsonToMapParser(urlFetcher).getResult();
		System.out.println(resultingMap.get("events"));
		
		assertEquals(resultingMap.size(), 3);
		Map<String,Object> mapTest1 = (Map<String, Object>) resultingMap.get("events");
		ArrayList arlist = (ArrayList) resultingMap.get("events");
		Map<String,Object> mapTest2 = (Map<String, Object>) mapTest1.get("league");
		Map<String,Object> mapTest3 = (Map<String, Object>) mapTest2.get("level");
//		Map<String,Object> resultingMapi = new JsonToMapParser(s).getResult();
//		assertEquals("Provided by Everysport.com", resultingMap.get("message"));
		
		System.out.println(mapTest2);
		System.out.println();

		
		
		
	}

}
