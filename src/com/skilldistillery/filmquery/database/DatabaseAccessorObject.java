package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Category;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	private static final String USERNAME = "student";
	private static final String PASSWORD = "student";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {

		Film foundFilm = null;
		try {
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "SELECT * FROM film WHERE id = ?  ";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);

			ResultSet filmData = stmt.executeQuery();

			if (filmData.next()) {

				foundFilm =getFilmData(filmData);

			}

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foundFilm;
	}

	@Override
	public Actor findActorById(int actorId) {

		Actor Actor = null;

		try {
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "SELECT * FROM Actor WHERE actor_id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);

			ResultSet actorData = stmt.executeQuery();

			if (actorData.next()) {
				Actor = new Actor();
				Actor.setId(actorData.getInt("actor_id"));
				Actor.setFirstName(actorData.getString("first_name"));
				Actor.setLastName(actorData.getString("last_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		
		List<Actor> actors = new ArrayList<>();
		
		try {
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "SELECT actor.id, actor.first_name, actor.last_name "
					+ "FROM actor "
					+ "JOIN film_actor ON  actor.id = film_actor.actor_id "
					+ "WHERE film_id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);

			ResultSet actorsData = stmt.executeQuery();

			while(actorsData.next()) {
				Actor actor = new Actor();
				actor.setId(actorsData.getInt("id"));
				actor.setFirstName(actorsData.getString("first_name"));
				actor.setLastName(actorsData.getString("last_name"));
				actors.add(actor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return actors;
	}
	
	
	
	public List<Film> findFilmByKeyword(String keyword) {
		
		List<Film> films = new ArrayList<>();
		
		try {
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "SELECT * FROM film WHERE title LIKE ? OR description like ?" ;
			
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			
			ResultSet filmsData = stmt.executeQuery();

			while(filmsData.next()) {
				Film film = getFilmData(filmsData);				
				films.add(film);			}

		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return films;
	}
	
	public String findFilmLanguage(int languageId) {
		String language = "";
		
		try {
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "SELECT name FROM language WHERE id = ? " ;
						
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1,languageId);
						
			ResultSet languageData = stmt.executeQuery();

			if (languageData.next()) {
				language = languageData.getString("name");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return language;
		
	}
	
	public List<Category> findFilmCategories(int filmId) {
		
		List<Category> categories = new ArrayList<>();
		
		try {
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "SELECT category.name FROM category "
					+ "JOIN film_category ON category.id = film_category.category_id "
					+ "WHERE film_category.film_id = ? ";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);

			ResultSet categoriesData = stmt.executeQuery();

			while(categoriesData.next()) {
				Category category = new Category();
				category.setName(categoriesData.getString("name"));
				categories.add(category);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return categories;
	}
	
	private Film getFilmData(ResultSet filmsData) {
		Film film = new Film();
		try {
			film.setId(filmsData.getInt("id"));
			film.setTitle(filmsData.getString("title"));
			film.setDescription(filmsData.getString("description"));
			film.setReleaseYear(filmsData.getInt("release_year"));
			film.setLanguageId(filmsData.getInt("language_id"));
			film.setRentalDuration(filmsData.getInt("rental_duration"));
			film.setRentalRate(filmsData.getDouble("rental_rate"));
			film.setLength(filmsData.getInt("length"));
			film.setReplacementCost(filmsData.getDouble("replacement_cost"));
			film.setRating(filmsData.getString("rating"));
			film.setSpecialFeatures(filmsData.getString("special_features"));
			film.setActors(findActorsByFilmId(filmsData.getInt("id")));			
			film.setCategories(findFilmCategories(filmsData.getInt("id")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return film;
		
	}



}
