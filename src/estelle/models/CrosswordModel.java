package estelle.models;

public record CrosswordModel(
		long numeroMot,
		String definition,
		int horizontal,
		long ligne,
		long colonne,
		String solution,
		long numeroGrille
		
) {

}
