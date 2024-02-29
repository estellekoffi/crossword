
module Crossword {
	
	requires javafx.controls;
	requires transitive javafx.graphics;
	requires java.sql;
	requires javafx.fxml;
	requires javafx.base;
	
	exports estelle;
	exports estelle.controllers;
	exports estelle.dbconnections;
	exports estelle.models;
	
	opens estelle.controllers to javafx.fxml;
}