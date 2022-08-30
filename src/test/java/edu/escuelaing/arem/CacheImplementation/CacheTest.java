package edu.escuelaing.arem.CacheImplementation;
import static org.junit.Assert.*;
import org.junit.Test;

public class CacheTest {
	public CacheTest() {
		
	}
	
	@Test
	public void deberiaAgregarCache() {
		Cache cache = new Cache();
		try {
			cache.almacenarCache("IBMmonth", "{\"ticker\":\"IBM\",\"queryCount\":21,\"resultsCount\":1,\"adjusted\":true,\"results\":[{\"v\":1.12432481e+08,\"vw\":140.7464,\"o\":146.96,\"c\":140.96,\"h\":147.5,\"l\":136.2089,\"t\":1625112000000,\"n\":1363555}],\"status\":\"OK\",\"request_id\":\"5d7f71c815cdbae036d1d79b7301f069\",\"count\":1}");
			
			assertEquals(cache.getCache("IBMmonth"), "{\"ticker\":\"IBM\",\"queryCount\":21,\"resultsCount\":1,\"adjusted\":true,\"results\":[{\"v\":1.12432481e+08,\"vw\":140.7464,\"o\":146.96,\"c\":140.96,\"h\":147.5,\"l\":136.2089,\"t\":1625112000000,\"n\":1363555}],\"status\":\"OK\",\"request_id\":\"5d7f71c815cdbae036d1d79b7301f069\",\"count\":1}");
		} catch (CacheException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void noDeberiaAgregarDobleCache() {
		Cache cache = new Cache();
		try {
			cache.almacenarCache("IBMmonth", "{\"ticker\":\"IBM\",\"queryCount\":21,\"resultsCount\":1,\"adjusted\":true,\"results\":[{\"v\":1.12432481e+08,\"vw\":140.7464,\"o\":146.96,\"c\":140.96,\"h\":147.5,\"l\":136.2089,\"t\":1625112000000,\"n\":1363555}],\"status\":\"OK\",\"request_id\":\"5d7f71c815cdbae036d1d79b7301f069\",\"count\":1}");
			cache.almacenarCache("IBMmonth", "{\"ticker\":\"IBM\",\"queryCount\":21,\"resultsCount\":1,\"adjusted\":true,\"results\":[{\"v\":1.12432481e+08,\"vw\":140.7464,\"o\":146.96,\"c\":140.96,\"h\":147.5,\"l\":136.2089,\"t\":1625112000000,\"n\":1363555}],\"status\":\"OK\",\"request_id\":\"5d7f71c815cdbae036d1d79b7301f069\",\"count\":1}");
		} catch (CacheException e) {
			assertEquals(e.getMessage(),CacheException.EXISTE_CACHE);
		}
	}
	
	@Test
	public void noDeberiaConsultarCacheQueNoExiste() {
		Cache cache = new Cache();
		try {
			cache.getCache("IBMmonth");
		} catch (CacheException e) {
			assertEquals(e.getMessage(),CacheException.NO_EXISTE_CACHE);
		}
	}
	
	@Test
	public void deberiaConsultarSiHayCahche() {
		Cache cache = new Cache();
		try {
			cache.almacenarCache("IBMmonth", "{\"ticker\":\"IBM\",\"queryCount\":21,\"resultsCount\":1,\"adjusted\":true,\"results\":[{\"v\":1.12432481e+08,\"vw\":140.7464,\"o\":146.96,\"c\":140.96,\"h\":147.5,\"l\":136.2089,\"t\":1625112000000,\"n\":1363555}],\"status\":\"OK\",\"request_id\":\"5d7f71c815cdbae036d1d79b7301f069\",\"count\":1}");
			assertTrue(cache.hayCache("IBMmonth"));
			assertFalse(cache.hayCache("MSFTmonth"));
		} catch (CacheException e) {
			e.printStackTrace();
		}
	}
	
}
