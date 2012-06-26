/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmodel;

import protocolcontrol.FactoryProtocolEvMngr;
import protocolcontrol.ProtocolEventMngr;
import java.util.Arrays;
import java.util.Collection;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

  
@RunWith(Parameterized.class)
public class FactoryProtocolEvManagerTest {
	private String type;
	private String ds;
	
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
				{ "lbby", "ConnectListEvMngr" }, 
				{ "gmxo", "GamePlistEvMngr" },
				{ "test", null },
				};
		return Arrays.asList(data);
	}
	
	public FactoryProtocolEvManagerTest(String file, String ds) {
		this.type = file;
		this.ds = ds;
	}
	
	@Test
	public void test() {
		ProtocolEventMngr iDS = FactoryProtocolEvMngr.getInstance(type);
		assertEquals(ds, iDS == null ? null : iDS.getClass().getSimpleName());
	}

	@Test
	public void testSingleton() {
		assertEquals(FactoryProtocolEvMngr.getInstance(type), FactoryProtocolEvMngr.getInstance(type));
	}
}
