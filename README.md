# Gradle for Android and Java Final Project

In this project, we created an app with multiple flavors that uses
multiple libraries and Google Cloud Endpoints. The finished app consists
of four modules: 

* A Java library that provides jokes (called jokelib)
* A Google Cloud Endpoints (GCE) project that serves those jokes (called backend)
* an Android Library containing an activity for displaying jokes (called punchlineandroidlib)
* and an Android app that fetches jokes from the GCE module and passes them to the Android Library for display.

## Why this Project?

As Android projects grow in complexity, it becomes necessary to customize the
behavior of the Gradle build tool, allowing automation of repetitive tasks.
Particularly, factoring functionality into libraries and creating product
flavors allow for much bigger projects with minimal added complexity.

## What I Learned?

We learned the role of Gradle in building Android Apps and how to use
Gradle to manage apps of increasing complexity. I learned to:

* Add free and paid flavors to an app, and set up your build to share code between them
* Factor reusable functionality into a Java library
* Factor reusable Android functionality into an Android library
* Configure a multi project build to compile your libraries and app
* Use the Gradle App Engine plugin to deploy a backend
* Configure an integration test suite that runs against the local App Engine development server

# App Functionality

### Connecting Build It Bigger to the Google Cloud App Engine
<img src="https://github.com/AndreaWolff/AndroidNanoDegreeBuildItBigger/blob/master/images/Screen%20Shot%202018-05-18%20at%201.41.41%20PM.png" height="600" width="800">

### Build It Bigger App flavours
<img src="https://github.com/AndreaWolff/AndroidNanoDegreeBuildItBigger/blob/master/images/Screen%20Shot%202018-05-19%20at%205.22.51%20PM.png" height="100" width="300">

### Build It Bigger Paid Version
<img src="https://github.com/AndreaWolff/AndroidNanoDegreeBuildItBigger/blob/master/images/Paid-Version.png" height="450" width="250">

### Build It Bigger Free Version
<img src="https://github.com/AndreaWolff/AndroidNanoDegreeBuildItBigger/blob/master/images/Free-Version.png" height="450" width="250">

### Build It Bigger Punch Line
<img src="https://github.com/AndreaWolff/AndroidNanoDegreeBuildItBigger/blob/master/images/PunchLine.png" height="450" width="250">

### Build It Bigger Endpoints Dev Server Not Connected
<img src="https://github.com/AndreaWolff/AndroidNanoDegreeBuildItBigger/blob/master/images/AppEngine-NotConnected.png" height="450" width="250">

# Rubric

### Required Components

* Project contains a Java library for supplying jokes
* Project contains an Android library with an activity that displays jokes passed to it as intent extras.
* Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task.
* Project contains connected tests to verify that the async task is indeed loading jokes.
* Project contains Paid/Free flavors. The Paid flavor has no ads, and no unnecessary dependencies.

### Required Behavior

* App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library.

### Optional Components

More features add to Build It Bigger include:

* Having the app display a loading indicator while the joke is being fetched from the server.
* Writing a Gradle task that starts the GCE dev server, runs all the Android test, and shuts down the dev server. This task is found under the Gradle Project folder and can be run from terminal using the command -> gradle run_android_test. <i>NOTE: Before running this gradle task you must have a emulator running. This task will open and close the dev server connection.</i>
