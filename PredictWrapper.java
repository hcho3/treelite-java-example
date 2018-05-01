import hcho3.treelite_java_example.*; 

public class PredictWrapper {
  public PredictWrapper() {
    num_feature = Main.get_num_feature();
    data = new Entry[num_feature];
    for (int i = 0; i < num_feature; ++i) {
      data[i] = new Entry();
    }
  }

  // value[i] contains a floating-point value or NaN (Not A Number).
  // value[i]=NaN indicates that feature i is missing
  public float Predict(float[] value, boolean pred_margin) {
    assert num_feature == value.length;
    for (int i = 0; i < num_feature; ++i) {
      if (Float.isNaN(value[i])) {
        data[i].missing.set(-1);
      } else {
        data[i].fvalue.set(value[i]);
      }
    }
    return Main.predict(data, pred_margin);
  }

  public int GetNumFeature() {
    return num_feature;
  }

  private final int num_feature;
  private Entry[] data;
}
