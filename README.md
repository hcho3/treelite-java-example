Deploying compiled tree model to Java application using Treelite
================================================================
This is a short example of how you can deploy decision tree models to a
Java-based serving system using Treelite.

1. Checkout this repository with
```bash
git clone --recursive https://github.com/hcho3/treelite-java-example
```
2. Compile Treelite by running
```bash
mkdir treelite/build
cd treelite/build
cmake ..
make -j4
cd ../..
```
3. Run the Python script `gencode.py` to compile `mushroom.model` into a
   collection of Java source files. The collection will be saved to a directory
   named `model/`.
4. Now run `mvn package` inside the `model/` directory.
5. Run `javac -cp model/target/model-1.0-SNAPSHOT.jar *.java` to
   compile `PredictWrapper.java` and `Test.java`.
6. Run `Test` by typing
   `java -cp "${PWD}:model/target/model-1.0-SNAPSHOT.jar" Test`.
