import java.nio.file.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class Test {
  public static void main(String[] args) throws IOException {
    String test_data = "mushroom.test";

    Path path = Paths.get(test_data);
    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
    PredictWrapper predict_wrapper_context = new PredictWrapper();
    int num_feature = predict_wrapper_context.GetNumFeature();
    float[] example = new float[num_feature];

    int example_id = 0;
    for (String line : lines) {
      Arrays.fill(example, Float.NaN);
      String[] token = line.split(" ");
      int label = Integer.parseInt(token[0]);
      for (int i = 1; i < token.length; ++i) {
        String[] subtoken = token[i].split(":");
        int feature_id = Integer.parseInt(subtoken[0]);
        float feature_value = Float.parseFloat(subtoken[1]);
        example[feature_id] = feature_value;
      }
      System.out.format("Prediction for test example %d: %f\n", example_id,
                        predict_wrapper_context.Predict(example, false));
      ++example_id;
    }
  }
}
