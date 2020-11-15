package ES_LETI_1Sem_2020_Grupo9;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class rules {
	 public String function;
	  public String comparator;
	  public int value;
	  public String operator;

	  public void rule(String function, String comparator, int value,
	    String operator) {
	    this.function = function;
	    this.comparator = comparator;
	    this.value = value;
	    this.operator = operator;
	  }

	  Workbook rule_list= new XSSFWorkbook();
	  Sheet sheet = rule_list.createSheet("Rule List");
	  
	 
	}

