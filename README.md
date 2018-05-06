Android Development Workshop
==
**Shenkar** <br/>
[Amir Uval](shenkar@mindtheapps.com)

## Useful links
- [Android Developers YouTube Channel](https://www.youtube.com/user/androiddevelopers)
- [DevBites short videos](https://www.youtube.com/playlist?list=PLWz5rJ2EKKc_XOgcRukSoKKjewFJZrKV0)
- [Markdown](https://guides.github.com/pdfs/markdown-cheatsheet-online.pdf)
  The syntax used for this README.md file

## Workshop Lessons

---

### Lesson #1

[Slides](https://goo.gl/j8laap)

#### Installing & Configuring Android Studio

Install Android SDK's

**Recommended Plugins**:
  - .ignore
  - Markdown Support (JetBrain)
  - [Grep Console](https://github.com/krasa/GrepConsole)

**Useful Android Studio shortcuts**: [(And More Shortcuts)](https://gautam.io/work/android_studio_shortcuts/)
 
|	**Operation**	|	**Shortcut**	|
|	---	|	:---	|
|	Comment line	|	Ctrl+/	|
|	Duplicate line (or selection)	|	ctrl+d	|
|	Go to last edited location	|	ctrl+shift+Backspace	|
|	Jump to a particular type or file	|	Shift, Shift	|
|	Move lines up *or* down	|	ctrl+shift+up *or* ctrl+shift+down arrow	|
|	Navigate left	|	Alt+Left arrow (Mac: Command+Shift+[)	|
|	Navigate right	|	Alt+right arrow (Mac: Command+Shift+])	|
|	Navigate to the source definition	|	Windows+Click (Linux: ctrl+click, Mac: Command+click)	|
|	Open Settings	|	ctrl+alt+s	|
|	Organize the import statements	|	Ctrl+Alt+O	|
|	Reformat file	|	alt+ctrl+shit+L	|
|	Rename an object	|	Shift+F6	|
|	Search through files	|	Ctrl+Shift+F  (Mac: Command+Shift+F)	|

Tips:
* Use middle button of the mouse to select across rows, and edit all.

Homework: Create a project in Android studio and upload it to your GitHub account.

---

### Lesson #2

[Slides](https://goo.gl/4EHTQi)

Useful **git** commands:

- git status
- git log
- git show: Show various types of objects
- git tag: tag specific points in history as being important
  - for example, these commits were tagged with annotation and comment:
      - git tag -a 2 -m "lecture #2"
      - git tag -a 2.1 -m "lecture #2.1"
  - you can now jump between them using:
      - git checkout 2  (..or 2.1)
  - you can see the diff between 2 tags (or between branches) by adding `/compare` to the end of the github workspace URL. 
- git add .
  - adds all un-staged files to your local git index

---

### Lesson #3

[Slides](https://goo.gl/P2hWLP)

####class exercise

- Demonstrate how to: 
  - Create a new project
  - Use ConstraintLayout
  - Register onClick listener
  - get/set text from views

#### Homework:

- Complete the calculator shown in class
  - add all the missing buttons, make the layout as nice as you can
  - support operations +, - , *, /, =, and clear button
  - 


### Lesson #4

RecyclerView, Refactoring

[Slides](https://goo.gl/CXtCcy)

- RecycleView (few words only + reference to code)
    - [Official Training](https://developer.android.com/guide/topics/ui/layout/recyclerview)

#### Homework:
- Make main menu for the homework list
  - Refactoring: rename MainActivity and related layout to Lesson2Activity and lesson2_layout
  - Create a new MainActivity to serve as a high level menu for exercises
  - Mark the new activity as MAIN in the manifest
  - Create a RecyclerView for the list
  - The data (row) should include a way to launch the correct activity, without passing a context (to avoid memory leak). How?

---

### Lesson 5

[Slides](https://goo.gl/gVRMt2)

#### [Playing with raw SQL](/misc/SQLSample.md)


#### Homework

Create a mini birthdays app as part of your homework project.
[Specifications](https://docs.google.com/presentation/d/1SSIPLbCHPEO2b7ZG1y2c_tFYi85pYzn5AR8PKF9uhMY/edit#slide=id.g3706e4d7df_1_144)


#### Tips

##### print the content of the property file from the emulator
 `app=com.amiru.shenkar2018`
 `adb  -e shell 'cat /data/data/${app}/shared_prefs/*'`
 
##### online 9 patch tool 
 https://romannurik.github.io/AndroidAssetStudio/nine-patches.html

---

### Lesson 6

     Scene Transitions, Low Level Graphics

[Slides](https://goo.gl/hY7ALc)


- Scene transition
    - example: [SceneTransitionActivity](app/src/main/java/org/shenkar/auval/codesamples/SceneTransitionActivity.java)
    - [diff](https://github.com/auval/AndroidWorkshop/compare/5...5.1)



- Low level graphics and animation

- [A lesson on Resources by Chaim Michael (with his permission)](https://youtu.be/SCLs7jyGs9k)


- [Settings walkthrough](https://docs.google.com/document/d/1PVNrj7HtfjqAsHtnUnfLOSoTKthzemtfpbvQ-3CBE4U/edit?usp=sharing)
  Every student implements on his/her pc during class.
    - [the resulting project](https://github.com/auval/MinimalSettingsActivity) - use this as a reference!
    


##### creating App Toolbar activity
  - Follow the [tutorial](https://developer.android.com/training/appbar/index.html)
    - It's missing some important steps, so read here as well.
  - create an svg resource icon
    - New > “Vector Asset” from the context menu
  - define some menu options
    - New > “Android resource directory” from the context menu
    - Change the “Resource type” drop-down to be “menu”, then click OK to create the directory
    - right-click over your new res/menu/ directory and choose New > “Menu resource file” from the context menu
    - name it "lesson3.xml"
    - add \<item> resources, like the example in the tutorial or your own.
  - Add  `onCreateOptionsMenu(Menu menu) {}` to the activity, to inflate menu items


#### Code compare
- [Adding action bar](https://github.com/auval/AndroidWorkshop/compare/4...4.1)
- [Adding settings](https://github.com/auval/AndroidWorkshop/compare/4.1...4.2)
   - Simply create a new "Settings Activity" from the `new > activity` command menu.
- [Enabling "< Back" from settings](https://github.com/auval/AndroidWorkshop/compare/4.2...4.2.1)
   - By overriding `onOptionsItemSelected()`
- [Showing how to read values from SharedPreferences](https://github.com/auval/AndroidWorkshop/compare/4.2.1...4.2.2)
  - And using AsyncHandler and UiHandler on the way
- [Showing how to write values to SharedPreferences from code](https://github.com/auval/AndroidWorkshop/compare/4.2.2...4.2.3)
- [Added SQL implementation and example](https://github.com/auval/AndroidWorkshop/compare/4.2.3...4.3)




---

### Lesson 7

     Layout without xml
     Custom View Animation

[Slides](https://goo.gl/adGjJf)

Lots of examples are on last year's project [here](https://github.com/auval/AndroidWorkshop). You can clone it and use it as a reference.

1. Animated view (rotating dot): [MyAnimatedGraphicsView](https://github.com/auval/AndroidWorkshop/blob/master/app/src/main/java/org/shenkar/auval/codesamples/MyAnimatedGraphicsView.java)
    - This view draws directly on the screen buffer, which clears every frame.
    - <img src="https://github.com/auval/AndroidWorkshop/blob/master/examples/7a_llanim.png" width="144">
2. Animated view (rotating dot on offscreen Bitmap): [MyBitmapAnimatedGraphicsView](https://github.com/auval/AndroidWorkshop/blob/master/app/src/main/java/org/shenkar/auval/codesamples/MyBitmapAnimatedGraphicsView.java)
    - This view draws on an offscreen Bitmap I created, so on each draw I add just one dot, and
    the bitmaps keeps all the past drawings.
    - It calculates dot position as a function of time, so the movement is independent
    neither of the speed of the phone nor hiccups of the UI thread.
    - <img src="https://github.com/auval/AndroidWorkshop/blob/master/examples/7a_llanim_wbmp.png" width="144">
3. [SpriteAnimationActivity](https://github.com/auval/AndroidWorkshop/blob/master/app/src/main/java/org/shenkar/auval/codesamples/SpriteAnimationActivity.java)
      just puts a custom ViewGroup on the screen.
    - Notice that instead of ConstraintsLayout as root in
    [the xml](https://github.com/auval/AndroidWorkshop/blob/master/app/src/main/res/layout/activity_sprite_animation.xml) I use SpriteAnimationView.
     custom ViewGroup.
    - The animation happens in [SpriteAnimationView](https://github.com/auval/AndroidWorkshop/blob/master/app/src/main/java/org/shenkar/auval/codesamples/SpriteAnimationView.java)
    - <img src="https://github.com/auval/AndroidWorkshop/blob/master/examples/7b_llsa.png" width="144">
4. [SvgViewsActivity](https://github.com/auval/AndroidWorkshop/blob/master/app/src/main/java/org/shenkar/auval/codesamples/SvgViewsActivity.java) demonstrates using SVG as a background image,
and 4 svgs as frames for [animation-list](https://github.com/auval/AndroidWorkshop/blob/master/app/src/main/res/drawable/butterfly.xml) drawable.
    - The drawable is set as src of ImageView, and
    [started](https://github.com/auval/AndroidWorkshop/blob/master/app/src/main/java/org/shenkar/auval/codesamples/SvgViewsActivity.java#L35) from the Activity.
    - When touching a butterfly, it will fly elsewhere, using
    [Scene Transition](https://github.com/auval/AndroidWorkshop/blob/master/app/src/main/java/org/shenkar/auval/codesamples/SvgViewsActivity.java#L60).
     This may be a useful reference for building your own game.
    - Notice that this activity has fixed orientation set in
    [AndroidManifest.xml](https://github.com/auval/AndroidWorkshop/blob/master/app/src/main/AndroidManifest.xml#L45).
    - <img src="https://github.com/auval/AndroidWorkshop/blob/master/examples/7c_al_svg.png" height="144">
5. [BmpAndSvgActivity](https://github.com/auval/AndroidWorkshop/blob/master/app/src/main/java/org/shenkar/auval/codesamples/BmpAndSvgActivity.java) is not animated. It demonstrates combining
simple Bitmap as a [background](https://github.com/auval/AndroidWorkshop/blob/master/src/main/res/layout/activity_bmp_and_svg.xml#L8) and an SVG as a
[srcCompat](https://github.com/auval/AndroidWorkshop/blob/master/src/main/res/layout/activity_bmp_and_svg.xml#L15) drawable of a view.
    - Notice how the svg doesn't lose quality when scaled up or down.
    - On the upper right corner there's a cool (but complex) hack: I took the SVG parsing code
    from the support library, and [here](https://github.com/auval/AndroidWorkshop/blob/master/app/src/main/java/org/shenkar/auval/codesamples/MyLowLevelSvgView.java#L75) I demonstrate how I turned a raw SVG to a Path object that
     Canvas can draw directly.
    - <img src="https://github.com/auval/AndroidWorkshop/blob/master/examples/7d_svg_and_bmp.png" width="144">


**Note regarding working on the project**:
You should [learn](http://nvie.com/posts/a-successful-git-branching-model/) this method on how to
collaborate using GitHub. Both students must contribute.

      
**Note regarding working on the project**: 
You should [learn](http://nvie.com/posts/a-successful-git-branching-model/) this method on how to 
collaborate using GitHub. Both students must contribute.



---

Rest of the course plan:
-
---


---

### Lesson 8

     Sound & Music

[Slides](https://goo.gl/d8mepK)

---

### Lesson 9

    - Help with projects

[Slides](https://goo.gl/ekn88F)

### Lesson 10

	- Testing
	- Firebase Analytics
	- Building APK for production

[Slides](https://goo.gl/W8wHJx)


testing from command line: `gradlew test`


---

####Download
[Project apk](examples/app-debug.apk)     
    

####All the lessons slides
- Lesson #1: https://goo.gl/j8laap
- Lesson #2: https://goo.gl/4EHTQi
- Lesson #3: https://goo.gl/P2hWLP
- Lesson #4: https://goo.gl/CXtCcy
- Lesson #5: https://goo.gl/gVRMt2
   - [Homework Review](https://docs.google.com/presentation/d/1v51eXGzaS7Ge1cYj5Z81LMd_B9h7yuwAVAjvr-zVFPA/edit?usp=sharing)
     Settings of activity transition
- Lesson #6: https://goo.gl/hY7ALc
   - [Homework Review](https://docs.google.com/presentation/d/1GlmWs3S3YwVh0ZrKXt7ePNtEFHEtJ6aI7rGwN6L-lds/edit?usp=sharing)
     Low level graphics: Stretched Hello
- Lesson #7: https://goo.gl/adGjJf
- Lesson #8: https://goo.gl/d8mepK
- Lesson #9: https://goo.gl/ekn88F
- Lesson #10: https://goo.gl/W8wHJx

---

[project specifications](https://docs.google.com/document/d/1ENtrWbBxyko6rBAhz2BS_AixoPC0ouw-7P3f4nj_FiY/edit?usp=sharing)
test commit