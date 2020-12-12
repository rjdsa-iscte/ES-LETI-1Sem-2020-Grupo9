package ES_LETI_1Sem_2020_Grupo9;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Robot;
import java.util.ArrayList;

import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

class GUITest extends GUI {

	private GUI test = new GUI();

	@Test
	void updateQualityTable() {
		test.updateQualityValues(0, 1, 2, 3, 4);
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
	void featureMethod() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("ATFD");
		aux.add("BIGGER_THAN");
		aux.add("10");
		aux.add("AND");
		aux.add("LAA");
		aux.add("BIGGER_THAN");
		aux.add("2.3");
		test.setFeatureEnvyRules(aux);
		assertTrue(test.hasFeatureEnvy(11, 2.4));
	}

	@Test
	void featureMethodv1() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("ATFD");
		aux.add("BIGGER_THAN");
		aux.add("10");
		aux.add("AND");
		aux.add("LAA");
		aux.add("SMALLER_THAN");
		aux.add("3.5");
		test.setFeatureEnvyRules(aux);
		;
		assertTrue(test.hasFeatureEnvy(20, 2));
	}

	@Test
	void featureMethodv2() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("ATFD");
		aux.add("SMALLER_THAN");
		aux.add("10");
		aux.add("AND");
		aux.add("LAA");
		aux.add("SMALLER_THAN");
		aux.add("3.2");
		test.setFeatureEnvyRules(aux);
		assertTrue(test.hasFeatureEnvy(9, 2));
	}

	@Test
	void featureMethodv3() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("ATFD");
		aux.add("SMALLER_THAN");
		aux.add("10");
		aux.add("AND");
		aux.add("LAA");
		aux.add("BIGGER_THAN");
		aux.add("1");
		test.setFeatureEnvyRules(aux);
		assertTrue(test.hasFeatureEnvy(9, 2));
	}

	@Test
	void featureMethodv4() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("ATFD");
		aux.add("BIGGER_THAN");
		aux.add("10");
		aux.add("OR");
		aux.add("LAA");
		aux.add("BIGGER_THAN");
		aux.add("1");
		test.setFeatureEnvyRules(aux);
		assertTrue(test.hasFeatureEnvy(4, 2));
	}

	@Test
	void featureMethodv5() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("ATFD");
		aux.add("BIGGER_THAN");
		aux.add("10");
		aux.add("OR");
		aux.add("LAA");
		aux.add("SMALLER_THAN");
		aux.add("3");
		test.setFeatureEnvyRules(aux);
		assertTrue(test.hasFeatureEnvy(4, 2));
	}

	@Test
	void featureMethodv6() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("ATFD");
		aux.add("SMALLER_THAN");
		aux.add("10");
		aux.add("OR");
		aux.add("LAA");
		aux.add("SMALLER_THAN");
		aux.add("3");
		test.setFeatureEnvyRules(aux);
		assertTrue(test.hasFeatureEnvy(20, 2));
	}

	@Test
	void featureMethodv7() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("ATFD");
		aux.add("SMALLER_THAN");
		aux.add("10");
		aux.add("OR");
		aux.add("LAA");
		aux.add("BIGGER_THAN");
		aux.add("1");
		test.setFeatureEnvyRules(aux);
		assertTrue(test.hasFeatureEnvy(20, 2));
	}

	@Test
	void featureMethodv8() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("ATFD");
		aux.add("BIGGER_THAN");
		aux.add("10");
		aux.add("END");
		test.setFeatureEnvyRules(aux);
		assertTrue(test.hasFeatureEnvy(20, 2));
	}

	@Test
	void featureMethodv9() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("ATFD");
		aux.add("SMALLER_THAN");
		aux.add("10");
		aux.add("END");
		test.setFeatureEnvyRules(aux);
		assertTrue(test.hasFeatureEnvy(9, 20));
	}

	@Test
	void featureMethodv10() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("LAA");
		aux.add("SMALLER_THAN");
		aux.add("10");
		aux.add("END");
		test.setFeatureEnvyRules(aux);
		assertTrue(test.hasFeatureEnvy(1, 8));
	}

	@Test
	void featureMethod11() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("LAA");
		aux.add("BIGGER_THAN");
		aux.add("10");
		aux.add("END");
		test.setFeatureEnvyRules(aux);
		assertTrue(test.hasFeatureEnvy(2, 15));
	}

	@Test
	void longMethod() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("LOC");
		aux.add("BIGGER_THAN");
		aux.add("10");
		aux.add("AND");
		aux.add("CYCLO");
		aux.add("BIGGER_THAN");
		aux.add("1");
		test.setLongMethodRules(aux);
		assertTrue(test.isLongMethod(20, 2));
	}

	@Test
	void longMethodv1() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("LOC");
		aux.add("BIGGER_THAN");
		aux.add("10");
		aux.add("AND");
		aux.add("CYCLO");
		aux.add("SMALLER_THAN");
		aux.add("3");
		test.setLongMethodRules(aux);
		assertTrue(test.isLongMethod(20, 2));
	}

	@Test
	void longMethodv2() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("LOC");
		aux.add("SMALLER_THAN");
		aux.add("10");
		aux.add("AND");
		aux.add("CYCLO");
		aux.add("SMALLER_THAN");
		aux.add("3");
		test.setLongMethodRules(aux);
		assertTrue(test.isLongMethod(9, 2));
	}

	@Test
	void longMethodv3() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("LOC");
		aux.add("SMALLER_THAN");
		aux.add("10");
		aux.add("AND");
		aux.add("CYCLO");
		aux.add("BIGGER_THAN");
		aux.add("1");
		test.setLongMethodRules(aux);
		assertTrue(test.isLongMethod(9, 2));
	}

	@Test
	void longMethodv4() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("LOC");
		aux.add("BIGGER_THAN");
		aux.add("10");
		aux.add("OR");
		aux.add("CYCLO");
		aux.add("BIGGER_THAN");
		aux.add("1");
		test.setLongMethodRules(aux);
		assertTrue(test.isLongMethod(20, 2));
	}

	@Test
	void longMethodv5() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("LOC");
		aux.add("BIGGER_THAN");
		aux.add("10");
		aux.add("OR");
		aux.add("CYCLO");
		aux.add("SMALLER_THAN");
		aux.add("3");
		test.setLongMethodRules(aux);
		assertTrue(test.isLongMethod(20, 2));
	}

	@Test
	void longMethodv6() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("LOC");
		aux.add("SMALLER_THAN");
		aux.add("10");
		aux.add("OR");
		aux.add("CYCLO");
		aux.add("SMALLER_THAN");
		aux.add("3");
		test.setLongMethodRules(aux);
		assertTrue(test.isLongMethod(9, 2));
	}

	@Test
	void longMethodv7() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("LOC");
		aux.add("SMALLER_THAN");
		aux.add("10");
		aux.add("OR");
		aux.add("CYCLO");
		aux.add("BIGGER_THAN");
		aux.add("1");
		test.setLongMethodRules(aux);
		assertTrue(test.isLongMethod(9, 2));
	}

	@Test
	void longMethodv8() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("LOC");
		aux.add("BIGGER_THAN");
		aux.add("10");
		aux.add("END");
		test.setLongMethodRules(aux);
		assertTrue(test.isLongMethod(20, 0));
	}

	@Test
	void longMethodv9() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("LOC");
		aux.add("SMALLER_THAN");
		aux.add("10");
		aux.add("END");
		test.setLongMethodRules(aux);
		assertTrue(test.isLongMethod(9, 1));
	}

	@Test
	void longMethodv10() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("CYCLO");
		aux.add("SMALLER_THAN");
		aux.add("10");
		aux.add("END");
		test.setLongMethodRules(aux);
		assertTrue(test.isLongMethod(9, 1));
	}

	@Test
	void longMethodv11() {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("CYCLO");
		aux.add("BIGGER_THAN");
		aux.add("10");
		aux.add("END");
		test.setLongMethodRules(aux);
		assertTrue(test.isLongMethod(11, 12));
	}

	@Test
	void saveTofile() {
		test.getThreshold_1().setText("20");
		test.getSignal_1().setSelectedIndex(0);
		test.save();
		test.loadRulesfromFile();
		ArrayList<String> aux = test.getLongMethodRules();
		assertEquals("LOC", aux.get(0));
		assertEquals("BIGGER_THAN", aux.get(1));
		assertEquals("20", aux.get(2));
	}

	@Test
	void saveTofilev1() {
		test.getThreshold_1().setText("20");
		test.getSignal_1().setSelectedIndex(0);
		test.getLogicOp_1().setSelectedIndex(1);
		test.getThreshold_2().setText("20");
		test.getSignal_2().setSelectedIndex(0);
		test.save();
		test.loadRulesfromFile();
		ArrayList<String> aux = test.getLongMethodRules();
		assertEquals("LOC", aux.get(0));
		assertEquals("BIGGER_THAN", aux.get(1));
		assertEquals("20", aux.get(2));
		assertEquals("OR", aux.get(3));
		assertEquals("CYCLO", aux.get(4));
		assertEquals("BIGGER_THAN", aux.get(5));
		assertEquals("20", aux.get(6));
	}

	@Test
	void saveTofilev2() {
		test.getThreshold_2().setText("20");
		test.getSignal_2().setSelectedIndex(0);
		test.save();
		test.loadRulesfromFile();
		ArrayList<String> aux = test.getLongMethodRules();
		assertEquals("CYCLO", aux.get(0));
		assertEquals("BIGGER_THAN", aux.get(1));
		assertEquals("20", aux.get(2));
	}

	@Test
	void saveTofilev3() {
		test.getThreshold_3().setText("20");
		test.getSignal_3().setSelectedIndex(0);
		test.save();
		test.loadRulesfromFile();
		ArrayList<String> aux = test.getFeatureEnvyRules();
		assertEquals("ATFD", aux.get(0));
		assertEquals("BIGGER_THAN", aux.get(1));
		assertEquals("20", aux.get(2));
	}

	@Test
	void saveTofilev4() {
		test.getThreshold_3().setText("20");
		test.getSignal_3().setSelectedIndex(0);
		test.getLogicOp_2().setSelectedIndex(1);
		test.getThreshold_4().setText("20");
		test.getSignal_4().setSelectedIndex(0);
		test.save();
		test.loadRulesfromFile();
		ArrayList<String> aux = test.getFeatureEnvyRules();
		assertEquals("ATFD", aux.get(0));
		assertEquals("BIGGER_THAN", aux.get(1));
		assertEquals("20", aux.get(2));
		assertEquals("OR", aux.get(3));
		assertEquals("LAA", aux.get(4));
		assertEquals("BIGGER_THAN", aux.get(5));
		assertEquals("20", aux.get(6));
	}

	@Test
	void saveTofilev5() {
		test.getThreshold_4().setText("20");
		test.getSignal_4().setSelectedIndex(0);
		test.save();
		test.loadRulesfromFile();
		ArrayList<String> aux = test.getFeatureEnvyRules();
		assertEquals("LAA", aux.get(0));
		assertEquals("BIGGER_THAN", aux.get(1));
		assertEquals("20", aux.get(2));
	}

	@Test
	void editTest() {
		test.getThreshold_1().setText("20");
		test.getSignal_1().setSelectedIndex(0);
		test.save();
		test.getLongMethodRulesList().setSelectedIndex(0);
		test.getThreshold_1().setText("30");
		test.getSignal_1().setSelectedIndex(1);
		test.edit();
		test.loadRulesfromFile();
		ArrayList<String> aux = test.getLongMethodRules();
		assertEquals("LOC", aux.get(0));
		assertEquals("SMALLER_THAN", aux.get(1));
		assertEquals("30", aux.get(2));
	}

	@Test
	void editTestv1() {
		test.getThreshold_3().setText("20");
		test.getSignal_3().setSelectedIndex(0);
		test.save();
		test.getFeatureEnvyRulesList().setSelectedIndex(0);
		test.getThreshold_3().setText("30");
		test.getSignal_3().setSelectedIndex(1);
		test.edit();
		test.loadRulesfromFile();
		ArrayList<String> aux = test.getFeatureEnvyRules();
		assertEquals("ATFD", aux.get(0));
		assertEquals("SMALLER_THAN", aux.get(1));
		assertEquals("30", aux.get(2));
	}

	@Test
	void editTestv2() {
		test.getThreshold_1().setText("20");
		test.getSignal_1().setSelectedIndex(0);
		test.save();
		test.getLongMethodRulesList().setSelectedIndex(0);
		test.getThreshold_3().setText("30");
		test.getSignal_3().setSelectedIndex(1);
		test.edit();
		test.loadRulesfromFile();
		ArrayList<String> aux = test.getLongMethodRules();
		assertEquals("LOC", aux.get(0));
		assertEquals("BIGGER_THAN", aux.get(1));
		assertEquals("20", aux.get(2));
	}

	@Test
	void editTestv3() {
		test.getThreshold_3().setText("20");
		test.getSignal_3().setSelectedIndex(0);
		test.save();
		test.getFeatureEnvyRulesList().setSelectedIndex(0);
		test.getThreshold_2().setText("30");
		test.getSignal_2().setSelectedIndex(1);
		test.edit();
		test.loadRulesfromFile();
		ArrayList<String> aux = test.getFeatureEnvyRules();
		assertEquals("ATFD", aux.get(0));
		assertEquals("BIGGER_THAN", aux.get(1));
		assertEquals("20", aux.get(2));
	}

	@Test
	void editTestv4() {
		test.getThreshold_3().setText("20");
		test.getSignal_3().setSelectedIndex(0);
		test.save();
		test.edit();
		test.loadRulesfromFile();
		ArrayList<String> aux = test.getFeatureEnvyRules();
		assertEquals("ATFD", aux.get(0));
		assertEquals("BIGGER_THAN", aux.get(1));
		assertEquals("20", aux.get(2));
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
		assertFalse(test.featureEnvyRules.size() != 0);

	}

	@Test
	void plasma_adci() {
		assertFalse(test.getiPlasma_ADCI() != 0);

	}

	@Test
	void plasma_adii() {
		assertFalse(test.getiPlasma_ADII() != 0);

	}

	@Test
	void plasma_dci() {
		assertFalse(test.getiPlasma_DCI() != 0);

	}

	@Test
	void plasma_dii() {
		assertFalse(test.getiPlasma_DII() != 0);

	}

	@Test
	void pmd_adci() {
		assertFalse(test.getPMD_ADCI() != 0);

	}

	@Test
	void pmd_adii() {
		assertFalse(test.getPMD_ADII() != 0);

	}

	@Test
	void pmd_dci() {
		assertFalse(test.getPMD_DCI() != 0);

	}

	@Test
	void pmd_dii() {
		assertFalse(test.getPMD_DII() != 0);

	}
}