package ES_LETI_1Sem_2020_Grupo9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QualityCheckerTest {

	@Test
	void testRun_iPlasma() {
		QualityChecker qc_iPlasma = new QualityChecker(9, "C:/Users/luism/Desktop/ES/Defeitos.xlsx");
		qc_iPlasma.start();
		try{
			qc_iPlasma.join();
		}catch (InterruptedException e1){
			
		}
		int output_nDCI = qc_iPlasma.getnDCI();
		int output_nDII = qc_iPlasma.getnDII();
		int output_nADCI = qc_iPlasma.getnADCI();
		int output_nADII = qc_iPlasma.getnADII();
		assertEquals(140, output_nDCI);
		assertEquals(0,output_nDII);
		assertEquals(280,output_nADCI);
		assertEquals(0,output_nADII);
	}

	@Test
	void testRun_PMD() {
		QualityChecker qc_PMD = new QualityChecker(10, "C:/Users/luism/Desktop/ES/Defeitos.xlsx");
		qc_PMD.start();
		try{
			qc_PMD.join();
		}catch (InterruptedException e1){
			
		}
		int output_nDCI = qc_PMD.getnDCI();
		int output_nDII = qc_PMD.getnDII();
		int output_nADCI = qc_PMD.getnADCI();
		int output_nADII = qc_PMD.getnADII();
		assertEquals(140, output_nDCI);
		assertEquals(18,output_nDII);
		assertEquals(262,output_nADCI);
		assertEquals(0,output_nADII);
	}
	
//	@Test
//	void testQualityChecker() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetnColumn() {
		QualityChecker qc_iPlasma = new QualityChecker(9, "C:/Users/luism/Desktop/ES/Defeitos.xlsx");
		int output = qc_iPlasma.getnColumn();
		assertEquals(9, output);
	}

	@Test
	void testGetnDCI() {
		QualityChecker qc_iPlasma = new QualityChecker(9, "C:/Users/luism/Desktop/ES/Defeitos.xlsx");
		qc_iPlasma.setnDCI(1);
		int output = qc_iPlasma.getnDCI();
		assertEquals(1, output);
	}

	@Test
	void testGetnDII() {
		QualityChecker qc_iPlasma = new QualityChecker(9, "C:/Users/luism/Desktop/ES/Defeitos.xlsx");
		qc_iPlasma.setnDII(1);
		int output = qc_iPlasma.getnDII();
		assertEquals(1, output);
	}

	@Test
	void testGetnADCI() {
		QualityChecker qc_iPlasma = new QualityChecker(9, "C:/Users/luism/Desktop/ES/Defeitos.xlsx");
		qc_iPlasma.setnADCI(1);
		int output = qc_iPlasma.getnADCI();
		assertEquals(1, output);
	}

	@Test
	void testGetnADII() {
		QualityChecker qc_iPlasma = new QualityChecker(9, "C:/Users/luism/Desktop/ES/Defeitos.xlsx");
		qc_iPlasma.setnADII(1);
		int output = qc_iPlasma.getnADII();
		assertEquals(1, output);
	}

}
