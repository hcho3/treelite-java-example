import sys
import os
sys.path.insert(0, os.path.join(os.path.dirname(os.path.abspath(__file__)),
                                'treelite/python'))
import treelite
model = treelite.Model.load('my.model', 'xgboost')
params = {'quantize':1, 'java_package':'hcho3.treelite_java_example',
          'java_file_prefix': 'src/main/java/hcho3/treelite_java_example/',
          'java_package_version': '1.0-SNAPSHOT'}
model.compile(dirpath='./model', compiler='ast_java', params=params, verbose=True)
