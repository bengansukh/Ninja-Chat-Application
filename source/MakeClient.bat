javac -d . ./Graphic/*.java
javac -d . ./Server/*.java
javac -classpath .;assets/packages/json-simple.jar ./*.java
java -cp .;assets/packages/json-simple.jar Ninja client