package ES_LETI_1Sem_2020_Grupo9;


/**
 * The Enum rules_list_functions.
 */
public enum rules_list_functions {
	
	/** EMPTY CONFIGURATION DEFAULT */
	EMPTY,
	
	/** The LINES OF CODE */
	LOC,
	
	/** The CYCLOMATIC COMPLEXITY */
	CYCLO,
	
	/** The ACCESS TO FOREIGN DATA */
	ATFD,
	
	/** The LOCALITY OF ATTRIBUTE ACCESSES  */
	LAA;
	

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return this == EMPTY ? "" : this.name();
	
	
    }
}