import treelite.predictor.*;

public class Wrapper {
  // value[i] contains a floating-point value or NaN (Not A Number).
  // value[i]=NaN indicates that feature i is missing
  public static float Predict(float[] value, boolean pred_margin) {
    final int num_feature = Main.get_num_feature();
    assert num_feature == value.length;
    Entry[] data = new Entry[num_feature];
    for (int i = 0; i < num_feature; ++i) {
      if (Float.isNaN(value[i])) {
        data[i].missing.set(-1);
      } else {
        data[i].fvalue.set(value[i]);
      }
    }
    return Main.predict(data, pred_margin);
  }
}
