package uk.ac.cam.ga354.tick7;

public class PatternFormatException extends Exception {
String errorMessage;

public PatternFormatException(String s){
	errorMessage = s;
}
}
