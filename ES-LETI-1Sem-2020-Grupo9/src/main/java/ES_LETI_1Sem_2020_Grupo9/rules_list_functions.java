package ES_LETI_1Sem_2020_Grupo9;

public enum rules_list_functions {
	EMPTY,
	LOC,
	CYCLO,
	ATFD,
	LAA;
	

    @Override
    public String toString() {
        return this == EMPTY ? "" : this.name();
	
	
    }
}