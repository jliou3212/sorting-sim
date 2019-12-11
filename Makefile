compile:
	javac -d bin -cp bin src/sorting/Sorting.java

run:
	java -cp bin sorting.SortingDriver;

compile2:
	javac -d bin -cp bin src/sorting/Options.java
	javac -d bin -cp bin src/sorting/Elements.java
	javac -d bin -cp bin src/sorting/Stats.java
	javac -d bin -cp bin src/sorting/Background.java
	javac -d bin -cp bin src/sorting/Sorting.java
	javac -d bin -cp bin src/sorting/SortingDriver.java
