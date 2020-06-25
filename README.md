# Gesture Recognition using LSTM models and Accelerometer Data

Contributers: @sridharnandigam, @175552, and @SunghuJustinKim 

## Project Concept
  - As the title suggests, this project uses a Keras LSTM model to recognize gestures with accelerometer data from an Android device.
  
## Relevant Links and Sources
  - The gesture recognition effort is intended to be paired with the Talkmotion app. The source code for this android app can be found here: https://github.com/MartinZugs/Gesture-Recognition-Android-App/blob/master/README.md
  - We used a human activity recoginition tutorial as a starting point which can be found here: https://towardsdatascience.com/time-series-classification-for-human-activity-recognition-with-lstms-using-tensorflow-2-and-keras-b816431afdff
  - The code for the tutorial's model can be found here:https://github.com/curiousily/Deep-Learning-For-Hackers

  
## Setup Guide
### Model Setup with Colab
  1. To work with the model efficiently, you will need to use either Jupyter Notebooks or Google Colab. Colab is highly recommended because of access to a GPU and easier team collaboration.
  2. Fork the repository to be able to make your own edits.
  3. Open the file **"gesture_rec_model.ipynb"** file in Colab. You can simply click the "Open in Colab" option on Github to be able to edit and access the file.
  4. Download the gesture_data.csv file=
  5. Upload it into the Google Colab runtime. By doing this the Colab notebook will be able to access the data.
  6. Run each cell of the notebook and check to see if each output matches the ones shown in the github.
  
### Running SensorDroid
  1. In order to create your own dataset, you will need an Android device and a Python editor (Pycharm recommended).
  2. Download Pycharm
  3. Load the code with Pycharm
  4. From the command line, run 'pip install sensor droids' to install the necessary packages for the program.
  5. Looking back onto the code, it should have 
  '''
  (something = str(25) + ",gestures," + str(int(currenttime)) + "," + first + "," + second + "," + third + ";" + "\n")
  with open('test.txt', 'a+') as f:
  '''
  6. Edit the “gestures” based on the name of the gesture being recorded  and the text field can be edited for better organization
  7. Install the Sensor Droid application on Anroid from the Google Play Store.
  8. Using a USB cable, connect your Android device to your computer
  9. With the application downloaded, run the code on your computer and have the sensor droid application running on your phone at the same time.
  10. It should automatically connect your phone to the code through a notification on your phone or through the app itself. 
  11. If it does not connect, reset the application on the app, or reset the Python editor and rerun the code.
  12. All the data will be located in the text file and is recommended to be transferred to excel and formatted into a CSV file. This step is not necessary as it can be read through the function even if it is a text file.
  13. Follow the documentation instructions if there is any confusion and follow installation instructions here: https://sites.google.com/view/sensordroid/getting-started/python?authuser=0

  
## Warnings and Issues
  This model still needs to be tested on a completely seperate **TEST dataset**. We were only able to create a training and validation dataset due to limited resources.
  
## For Future Developers
  Here are some important next steps.
  1. First and **most importantly**, you will need to record new data and create a larger dataset. This project was started in special conditions and there were only two subjects to record the accelerometer data. It is **HIGHLY RECOMMENDED** that you add more data from different users in order to train a more accurate model.
  2. Secondly, you will need to edit the parsing code in the notebook and **create a TEST set**. The current dataset was only big enough for a training and validation dataset. Although, technically, it does not affect the model, in order to be ***statistically correct***, it is crucial that you set some data aside for a completely fresh test dataset.
  3. Once you have a large enough dataset and ensured that you have been able to parse it into a dataframe properly, check the model to see how accurate it is. If the model's predictions are skew, then your real task begins. Tune the hyperparameters and the model structure until you find the best one to reduce the loss curve. 
  4. The ultimate goal of this project is for it to be integrated into the Talkmotion app mentioned above. To do this, you will have to be able to save the pretrained Tensorflow model and be able to access it again in Java for the Android app. There are a few resources such as DeepLearning4J and Tensorflow Lite. Here is a tutorial to help you get started: https://towardsdatascience.com/deploying-keras-deep-learning-models-with-java-62d80464f34a

