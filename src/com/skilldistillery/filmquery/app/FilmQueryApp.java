package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		//app.test();
		app.launch();
	}

	private void test() {
		Film film = db.findFilmById(2);
		System.out.println(film);
		
		Actor actor = db.findActorById(2);
		System.out.println(actor);
		
		//List<Actor> actors = db.findActorsByFilmId(1);		
		//for(Actor a:actors) {
		//	System.out.println(a);
		//}
		
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
			
		int choice = -1;
		
		while(!(choice == 3)) {
			System.out.println("1.Look up a film by its id");
			System.out.println("2.Look up a film by a search keyword");
			System.out.println("3.Exit the application");
		
			choice = input.nextInt();
		
			if(choice == 1) {
				seachFilmById(input);				
			}else if(choice == 2){
				seachFilmByKeyword(input);
			}else {
				
			}
			
			System.out.println(" ");
		}
	}

	private void showSubMenu(Scanner input,Film film){
		System.out.println(" ");
		System.out.println("1.Return to the main menu ");
		System.out.println("2.View all film details");
		
		int choice = input.nextInt();
		
		if(choice == 1) {
			
		}else if(choice == 2){
			printAllFilmDetails(film);
		}else {
			
		}
		
		System.out.println(" ");
	}
	
	private void seachFilmById(Scanner input) {
		System.out.print("Enter film id : ");
		int filmId = input.nextInt();
		Film film = db.findFilmById(filmId);
		
		if(film == null) {
			System.out.println("The film is not found !");
		}else {
			System.out.println("-------FILM INFO----------");
			printFilmDetails(film);	
			showSubMenu(input,film);
		}	
		
	}
	
	private void seachFilmByKeyword(Scanner input) {
		System.out.print("Enter keyword to use for the search : ");
		String keyword = input.next();
		List<Film> films = db.findFilmByKeyword(keyword);
		
		if(films  == null) {
			System.out.println("No films were found from the keyword !");
		}else {
			System.out.println("-------FILM INFO----------");
			for(Film film: films) {				
				printFilmDetails(film);				
				System.out.println("--------------------------");
			}
		}		
		
	}
	
	
	private void printFilmDetails(Film film) {
		System.out.println("Title : " + film.getTitle());
		System.out.println("Year : " + film.getReleaseYear());
		System.out.println("Rating : " + film.getRating());
		System.out.println("Description : " + film.getDescription());
		System.out.println("Language : " + db.findFilmLanguage(film.getLanguageId()));
		System.out.println("Categories : " + film.getCategoriesList());
		System.out.println("Actors : " + film.listOfActors());
	}
	
	private void printAllFilmDetails(Film film) {
		System.out.println("Id : " + film.getId());
		System.out.println("Title : " + film.getTitle());
		System.out.println("Year : " + film.getReleaseYear());
		System.out.println("Rating : " + film.getRating());
		System.out.println("Description : " + film.getDescription());
		System.out.println("Language : " + db.findFilmLanguage(film.getLanguageId()));
		System.out.println("Categories : " + film.getCategoriesList());
		System.out.println("Length : " + film.getLength());
		System.out.println("Replacement Cost : " + film.getReplacementCost());
		System.out.println("Special Features : " + film.getSpecialFeatures());
		System.out.println("Rental Rate : " + film.getRentalRate());
		System.out.println("Rental Duration : " + film.getRentalDuration());
		System.out.println("Actors : " + film.listOfActors());
	}
	
	
	
}
