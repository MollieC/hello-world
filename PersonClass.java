package BAExercise;

import java.util.ArrayList;

public class PersonClass {
///////////////////Attributes/////////////////
private String name;
private String dob;
private String occupation;
private int salary;
private ArrayList<AnimalClass> animals = new ArrayList<AnimalClass>();

///////////////////Constructors///////////////
public PersonClass(String name, String dob, String occupation, int salary)
{this.name = name;
this.dob = dob;
this.occupation = occupation;
this.salary = salary;} 

//////////////////Methods/////////////////////
public String getName()
{return this.name;}
public void setName(String newName)
{this.name = newName;}

public String getDob()
{return this.dob;}
public void setDob(String newDob)
{this.dob = newDob;}

public String getOccupation()
{return this.occupation;}
public void setOccupation(String newOccupation)
{this.occupation = newOccupation;}

public int getSalary()
{return this.salary;}
public void setSalary(int newSalary)
{this.salary = newSalary;}


public void ownAnimals(AnimalClass a) {
	animals.add(a);
}

public ArrayList<AnimalClass> getAnimals() {
	return animals;//getter for putting animals with people
}

public void setAnimals(ArrayList<AnimalClass> animals) {
	this.animals = animals;//setter for putting animals with people
}

}

