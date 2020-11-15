package GUI;

public enum rules_list_functions {
	EMPTY,
	LOC,
	CYCLO,
	ATFD,
	LAA,
	NOFA,
	WMCNAMM,
	NOMNAMM,
	RFC,
	NOAM,
	NIM;
	

    @Override
    public String toString() {
        return this == EMPTY ? "" : this.name();
	
	
    }
}