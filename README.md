Deploying compiled tree model to Java application using Treelite
================================================================
This is a short example of how you can deploy decision tree models to a
Java-based serving system using Treelite.

1. Run the script `get_treelite.sh` to get the latest treelite.
2. Run the Python script `gencode.py` to compile `mushroom.model` into a
   collection of Java source files. The collection will be saved to a directory
   named `model/`.
4. Now run `mvn package` inside the `model/` directory.
5. Run `javac -cp model/target/model-1.0-SNAPSHOT.jar *.java` to
   compile `PredictWrapper.java` and `Test.java`.
6. Run `Test` by typing
   `java -cp "${PWD}:model/target/model-1.0-SNAPSHOT.jar" Test`.
