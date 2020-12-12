package ES_LETI_1Sem_2020_Grupo9;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GUITest extends GUI {

	
	private GUI test = new GUI();
	
	@Test
	  void updateQualityTable() {
		test.updateQualityValues(0,1,2,3,4);
		int output_1 = (int) test.getQualityReportTable().getValueAt(0, 1);
		int output_2 = (int) test.getQualityReportTable().getValueAt(0, 2);
		int output_3 = (int) test.getQualityReportTable().getValueAt(0, 3);
		int output_4 = (int) test.getQualityReportTable().getValueAt(0, 4);
		assertEquals(1, output_1);
		assertEquals(2, output_2);
		assertEquals(3, output_3);
		assertEquals(4, output_4);
	 }
	
	@Test
	void clearRulesInput() {
		test.clearRulesGUI();
		String t1 = test.getThreshold_1().getText();
		String t2 = test.getThreshold_2().getText();
		String t3 = test.getThreshold_3().getText();
		String t4 = test.getThreshold_4().getText();
		String s1 = test.getSignal_1().getSelectedItem().toString();
		String s2 = test.getSignal_2().getSelectedItem().toString();
		String s3 = test.getSignal_3().getSelectedItem().toString();
		String s4 = test.getSignal_4().getSelectedItem().toString();
		String l1 = test.getLogicOp_1().getSelectedItem().toString();
		String l2 = test.getLogicOp_2().getSelectedItem().toString();
		assertEquals("", t1);
		assertEquals("", t2);
		assertEquals("", t3);
		assertEquals("", t4);
		assertEquals("BIGGER_THAN", s1);
		assertEquals("BIGGER_THAN", s2);
		assertEquals("BIGGER_THAN", s3);
		assertEquals("BIGGER_THAN", s4);
		assertEquals("END", l1);
		assertEquals("END", l2);
	}
		
		 @Test
		  void feature_envy_exists() {
			 assertTrue(test.featureEnvyRules.isEmpty());
		  
		 }
		 
		 @Test
		  void long_method_exists() {
			 assertTrue(test.longMethodRules.isEmpty());
		  
		 }
		 
		 @Test
		  void list_is_not_empty() {
			 assertFalse(test.featureEnvyRules.size()!= 0);
		  
		 }
		 @Test
		  void plasma_adci() {
			 assertFalse(test.getiPlasma_ADCI()!=0);
			 
		 }	 
		 @Test
		 void plasma_adii() {
			 assertFalse(test.getiPlasma_ADII()!=0);
		 
	}
		 @Test
		 void plasma_dci() {
			 assertFalse(test.getiPlasma_DCI()!=0);
		 
	}
		 @Test
		 void plasma_dii() {
			 assertFalse(test.getiPlasma_DII()!=0);
		 
	}


		 @Test
		  void pmd_adci() {
			 assertFalse(test.getPMD_ADCI()!=0);
			 
		 }	 
		 @Test
		 void pmd_adii() {
			 assertFalse(test.getPMD_ADII()!=0);
		 
	}
		 @Test
		 void pmd_dci() {
			 assertFalse(test.getPMD_DCI()!=0);
		 
	}
		 @Test
		 void pmd_dii() {
			 assertFalse(test.getPMD_DII()!=0);
		 
	}
}