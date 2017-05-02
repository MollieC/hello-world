package BAExercise;

public class AnimalClass {
///////////////////Attributes/////////////////
private String name;
private String species;

///////////////////Constructors///////////////
public AnimalClass(String name, String species)
{this.name = name;
this.species = species;}

//////////////////Methods/////////////////////
public String getName()
{return this.name;}
public void setName(String newName)
{this.name = newName;}

public String getSpecies()
{return this.species;}
public void setSpecies(String newSpecies)
{this.species = newSpecies;}


}
