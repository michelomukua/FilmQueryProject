# FilmQueryProject

## Overview
	A command-line application was created that retrieved and displayed film data. It was menu-based, allowing the user to choose actions and submit query data.

	All JDBC (Java Database Connectivity API)code were encapsulated in methods of the com.skilldistillery.filmquery.database.DatabaseAccessorObject class. New database access methods were first declared in the DatabaseAccessor interface, then implemented in the DatabaseAccessorObject. The Methods returned objects such as Film, Actor, and List<Actor>.

	The app.launch() method was initiated as the starting point to accept all the user input then dispalyed as output in com.skilldistillery.filmquery.app.FilmQueryApp 

## Requirements
	1. The user was presented with a menu to look up film by id, by search keyword or to exit the application

	2. When the user looked up a film by its id, they were prompted to enter the film id. When the film was not found, they got the message to that effect. But when the film was found, its title, year, rating, and description were displayed.

	3. When the user looked up a film by search keyword, they were prompted to enter it. If no matching films were found, they saw a message saying so. Otherwise, they saw a list of films for which the search term was found anywhere in the title or description, with each film displayed exactly as it was for the requirement number 2 above.

	4. Whenever a film was displayed, its language (English,Japanese, etc.) was displayed too, in addition to its title, year, rating, and description.

	5. For the displayed film, its list of actors, title, year, rating, description, and language were displayed as well.

## Optional requirements
	1. For the displayed film, the user chose from a submenu to either return to the main menu or view all film details where they saw all column values of that chosen film.


	2. When viewing film details, the user was expected to a list of all the film's categories (Family, Comedy, etc.) for that film.



## Technologies Used
	- Java Database Connectivity API (Application Programming Interface) was used to access, read and analyze relationships between elements in a film database
	- SQL (Structured Querry Language) application was used explore the relationships between and within elements of the film database



## Lessons Learned
	1. JDBC is effective in allowing java application to interact with the databases. 
	2. Mysql software was used to effectively demonstrated the relationships between and within elements of the film database. 
