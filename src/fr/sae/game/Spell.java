package fr.sae.game;

public interface Spell {
	
	//Attaque de base
	void AttaqueMelee();
	
	void InvocationDeSatan();
	
	//Attaque spécial
	void Foudre();
	void Glace();
	void Feu();
	void Terre();

	void Soins();
	
	//Quitter le combat
	void Fuite();

	//Attaque ennemis
	void CoupDeGriffe();
	void Miaulement();
	
}
