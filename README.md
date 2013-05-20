[c:geo](http://www.cgeo.org) is a simple yet powerful unofficial geocaching client for Android and Blackberry 10 devices. In contrast to other similar applications, c:geo doesn't require a web browser nor file exports. You can just go geocaching with your phone and without any home preparation or worries. Of course, you can go without paying - it's free.

This is a fork from the official Android port. It contains modifications and enhancements required for the Blackberry BB10 devices.

### Limitations on BB10 ###
- No Google Maps/Satellite images available. This could only be solved by Blackberry supporting Google Maps. How ever you can save Google Satellite as offline maps for each Geocache.
- Some features are disabled as they are not yet supported (i.e. list of useful programs).
- Several other Android programs work well together with c:geo, how ever they currently have to get manually sideloaded: GCC, Google Maps/Navigation, GPS Test.



Get the source
--------------

Fork the [project source code](https://github.com/cgeo/c-geo-opensource), make changes to your clone and [create a pull request](https://help.github.com/articles/using-pull-requests) afterwards.

### Branches ###

- **master** is for development of new features. Nightly builds are created from this branch.
- **release** is for all bug fixes of already existing features. So if a bug is reported in released version, it should be fixed on this branch (and merged to master afterwards).

A more complex bugfix can be first tested against the `master` branch and integrated in the nightly builds, while kept compatible with the `release` branch for a later integration.
Such a procedure is [described in the wiki](https://github.com/cgeo/c-geo-opensource/wiki/How-to-get-a-bug-fix-into-the-release).

Set up Eclipse
--------------

- Install an Eclipse distribution for your OS from http://eclipse.org/downloads/ (you may choose the Java developers distribution).
- Start Eclipse, choose any directory as workspace. Close the welcome screen, if it appears.
- After the workbench has started, select File | Import | Install | Install Software Items From File and select a locally downloaded copy of https://github.com/cgeo/c-geo-opensource/tree/master/main/project/eclipse%20installation/cgeo%20eclipse%20components.p2f. This way you can easily install all necessary plugins.
- After forking the project you should import the Eclipse projects in your workspace with File | Import | Projects from Git.

Build
-----

### Prerequisites ###

- [Android SDK](http://developer.android.com/sdk) (latest version) including Google APIs V11 (although we target API 4)
- [Ant](http://ant.apache.org) 1.6.0+ for building c:geo on the command line (not necessary when using only Eclipse)
- If you use Microsoft Windows, [Google USB Driver](http://developer.android.com/sdk/win-usb.html) to install the application on the smartphone

### Structure ###

c:geo sources and executables are located in the `main` directory. Tests are located in the `tests` directory.

### Known limitations ###

If the workspace directory name contains a space and leads to errors in the -dex Ant target, then you need to set the property "basedir" in your `local.properties` to the 8.3 name of the directory where this script is located on your disk.

### Configuration ###

1. copy `./main/templates/private.properties` to `./main/`
2. edit `private.properties` (see comments in the file. Note: This not needed for BB10 as we dont use Google Maps)
3. edit `local.properties` (see comments in the file)
4. copy `./main/templates/local.properties` to `./main/`
5. copy `./main/templates/local.properties` to `./tests/`
6. copy `./main/templates/mapsapikey.xml` to `./main/res/values/`
7. edit `./main/res/values/mapsapikey.xml` and insert your Maps API key (see comments in the file. Note: This not needed for BB10 as we dont use Google Maps)

### Building with Ant ###

Run one of the following commands in `./main`

    ant help
    ant clean
    ant debug
    ant release

or use the Ant view of Eclipse

### Debugging ###

In Eclipse, create a Debug Configuration for an Android Application using the menu Run | Debug Configurations

### Testing ###

The Test classes can be found in the project cgeo-os-test. Test classes should be located in the same package as
the class under test.
Every class can be "Run As" (or "Debug As") an [Android JUnit Test](http://developer.android.com/guide/topics/testing/testing_android.html) from Eclipse.
To run all tests use the same "Run As" menu item from the context menu of the test project.

### Converting for BB10 ###
To get a working BAR file for BB10, you have to do the following:

1. Make sure it builds successfully in Eclipe
2. In the Project Explorer, right click on the project, then go to Android Tools > Export Signen Application Package
3. Sign it with a locally generated Android key
3. Convert the APK file to a BB10 BAR file (i.e. by using apk2bar-HaTaX, see http://forums.crackberry.com/android-app-sideloading-f258/tools-help-make-apk-bar-process-easier-662772/)
4. Sign the BAR file with your Blackberry Vendor key (i.e. by using signbar-HaTaX, see same link as above).


License
-------

c:geo is distributed under [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

Contact
-------

- Official c:geo website: http://www.cgeo.org/

