package ES_LETI_1Sem_2020_Grupo9;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GUITest extends GUI {

	
	private final GUI test = new GUI();
		
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