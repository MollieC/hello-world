package BAExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BAEMain {
	
	static ArrayList<PersonClass>people = new ArrayList<PersonClass>();
	static ArrayList<AnimalClass>animal = new ArrayList<AnimalClass>();
	
	public static void main (String[] args){
		
	String everything = readFile();

	parseString(everything);
	
	listPersonDetails();
	
	listAnimalDetails();
	
	assignPet("Gareth", "Bob");
	
	assignPet("Devdetta", "Cosmo");
	
	animalOwner();
	
	wageCalculator("Cat");
	jobPet("Smash Player");
	}

	/////////////////////////////////How to read a file////////////////////////
	private static String readFile(){
		BufferedReader br = null;
		String fileName = "ExData.txt";
		
	
			try {
				br = new BufferedReader(new FileReader(fileName));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		
		String everything = null;
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator()); 
		        line = br.readLine();
		    }
		    everything = sb.toString();
		    
		} catch (IOException e)
		{
			e.printStackTrace();
			
		} finally 
		
		{
		    try {
				br.close(); 
			} catch (IOException e) 
		    {
				e.printStackTrace();
			}
		}
		return everything;
	}		
	
	public static void assignPet(String personName, String animalName){
		for(PersonClass p : people){
			if(p.getName().equals(personName)){
				for(AnimalClass a : animal){
					if(a.getName().equals(animalName)){
						p.ownAnimals(a);
						return;
					}
				}
			}
		}
		
	}	

	private static void parseString(String str1){//this is creating the arrays
		
		/////////////////////Parsing the File//////////////////////////////
		String[] PersonAnimal = str1.split("&"); //split first
		String[] personArray = PersonAnimal[0].split("%"); //then split again within the array, essentially splitting them into different people
		String[] animalArray = PersonAnimal[1].split("%");//split again for the second array, essentially splitting them into different animals
	
		//test JUnit here
		
		/////////////////////Animal Objects//////////////////////////////////
		String[] JeffData = animalArray[0].split("\n");
		AnimalClass Jeff = new AnimalClass(JeffData[1], JeffData[2]);
		animal.add(Jeff);
		
		String[] BobData = animalArray[1].split("\n");
		AnimalClass Bob = new AnimalClass(BobData[1].trim(), BobData[2].trim());
		animal.add(Bob);
		
		String[] CosmoData = animalArray[2].split("\n");
		AnimalClass Cosmo = new AnimalClass(CosmoData[1].trim(), CosmoData[2].trim());
		animal.add(Cosmo);
		
		String[] SirMeowsalotData = animalArray[3].split("\n");
		AnimalClass SirMeowsalot = new AnimalClass(SirMeowsalotData[1].trim(), SirMeowsalotData[2].trim());
		animal.add(SirMeowsalot);
		
		String[] ShelleyData = animalArray[4].split("\n");
		AnimalClass Shelley = new AnimalClass(ShelleyData[1].trim(), ShelleyData[2].trim());
		animal.add(Shelley);
		
		/////////////////////Person Objects//////////////////////////////////
		String[] GarethData = personArray[0].split("\n");//add to the array, including their position
		//in the array and splitting them again so that they become individual objects and
		//finally using \n to create a new line. Made them into individual arrays
		PersonClass Gareth = new PersonClass(GarethData[0].trim(), GarethData[1].trim(), GarethData[2].trim(), Integer.parseInt(GarethData[3].substring(1,(GarethData[3].length()-1))));// this is the object, not an array
		people.add(Gareth);// added them to the ArrayList that is declared at the top. Gareth has to start at 0 though because there's no empty line above it.
		 
		String[] DevdettaData = personArray[1].split("\n");
		PersonClass Devdetta = new PersonClass(DevdettaData[1].trim(), DevdettaData[2].trim(), DevdettaData[3].trim(), Integer.parseInt((DevdettaData[4].substring(1, DevdettaData[4].length()-1))));//length minus 1 is also another method of trimming an integer. 
		//Also have to start at 1, instead of 0 because the empty line counts as the first event in the array (as in, where we took out the percentage and made a new line)
		people.add(Devdetta);
		
		String[] ElliottData = personArray[2].split("\n");
		PersonClass Elliott = new PersonClass(ElliottData[1].trim(), ElliottData[2].trim(), ElliottData[3].trim(), Integer.parseInt(ElliottData[4].substring(1, ElliottData[4].length()-1)));// substring is telling it to take off the first letter or symbol (hence the 1) and then turn it into a string
		people.add(Elliott);
		}
		
		//////////////////////Details///////////////////////////////////////
		public static void listPersonDetails(){
			for(PersonClass p : people){
				System.out.println("\n" + "Name: " + p.getName() + "\n" + "DOB: " + p.getDob() + "\n" + "Occupation: " + p.getOccupation() + "\n" + "Salary: £" + p.getSalary());
			}
		}
		
		public static void listAnimalDetails(){
			for(AnimalClass a : animal){
				System.out.println("\n" + a.getName() + " is a " + a.getSpecies() + "\n");
			}
		}
	
		/////////////////////Relationships between Animals and People/////////////
		public static void animalOwner(){
			for(PersonClass p : people){
				if (p.getAnimals().isEmpty()){
				System.out.println(p.getName() + " has no pets");
				}
			for(AnimalClass a : p.getAnimals()){
				System.out.println(p.getName() + " has a "+ a.getSpecies()+ " called " + a.getName());
			}
			}
		}
		
		///////////////////Calculations///////////////////////////
		public static void wageCalculator(String str2){
			int sum = 0;
			int[] salaryArray = new int [people.size()];
			for (PersonClass p : people){
				if(p.getOccupation().equals(str2)){
				}
				for(AnimalClass a : p.getAnimals()){
					if(a.getSpecies().equals(str2)){
						System.out.println("\n"+ p.getName() + " earns £" + p.getSalary() + " per annum as a " + p.getOccupation());
					}
				}
			int i = 0;
			salaryArray [i]=p.getSalary();
			sum += p.getSalary();
			i++;
			
			sum = sum / salaryArray.length;
			}
			System.out.println("The average " + str2 + "owner earns £" + sum + ".");
		  	}
		
		private static void jobPet(String job) {
				for (PersonClass personC : people) 
				{
					if (personC.getOccupation().equals(job)) 
					{
						System.out.print("\n" + "People working as a " +job + " are likely to have a ");
						for (AnimalClass animal : personC.getAnimals()) 
						{
							System.out.print(animal.getSpecies() + ", ");
						}
						System.out.println(".");
					}
					
				}
		}
}
	

		

	

	
	



