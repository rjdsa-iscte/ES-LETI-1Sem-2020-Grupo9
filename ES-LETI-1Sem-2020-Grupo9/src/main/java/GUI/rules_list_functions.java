package GUI;

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