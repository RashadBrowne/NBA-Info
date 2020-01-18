# NBA-Info
An android application that displays the information and descriptions on a couple NBA teams along with an embedded youtube video.

## Changelog:
- I did have a line in to stop the scrolling from being glitchy (cutting off content and moving slow) but the fragment implementation fixed that. Cause the Recyclerview didn't like being in a scrollview and would end up cropping the bottle set of items. Somehow fragmentation solved this and dropped cpu usage while scrolling from ~60-65% to a maximum of 27%.

- The Recyclerview is set to cache(20 when we have 11) all the items, to reduce calling onbindviewholder which drops performance when called. With this change the recyclerview doesn't bash memory and cpu on scrolling.

- Converted the hero image into a webp and this removed all the speed problems on the main activity.
Note: webp's are only supported api 18 and up aka not a problem since the minimum we support is api 21 / Android os.

- Memory usage when up from 50mb avg after the load settles that one time to 100mb average.

- Hardware acceleration was enabled for the main activity and was disabled for the splashscreen cause that was causing a harsh transition upon loading the main activity possibly just a first install thing.

- Ram usages went up to 120mb max and cpu dropped to 15% avg. It just scrolls smoother barely noticeable but very satisfying.
"Energy" usage went down from high-medium to straight up low.

- Added the lazy nightmode, weird graphical glitches around the cardview in the nightmode.
"app:cardBackgroundColor="@android:color/transparent"" solved this.

- Fully switched to both activties being fragments. ~~The youtube api is still a bitch so I temporarily removed it~~, it now crashes when nightmode activates or when it rotates in the detail activty.
- But at least we have transitions between the fragments. Yeah they don't come with em naturally. #UseYaOwn!
And yes you need four animations for it to work.

- Without the default constructor for a fragment or it will crash on config change. The detail activity used to crash as it couldn't find information it was calling on which was solved using "onsavedinstance()" and onrestoreinstance()


## ChangeLog Summary:
* Resigned the app: Put both fragments in scrollviews and then set the main activity in a linear layout and changed the size of some things on the splashscreen.
* Sped up the recycler view.
* Added hardware acceleration to the main activity.
* Put the ui into fragments.
* Added Nightmode.
* Tidyed up the code a little bit.
* Temporarily removed the youtube player soon to be replaced with the fragment version.


## Tips:
- Keep the view-group that onbindviewholder() would be calling to simplified state as complex layouts slow down this function.

- Text views can slow down the recycler views.

- Fragment xml thingy crashes the app. Use FrameLayout instead.

- I can pass everything to a fragment on the start in the same way as a class though not recommended.

## Sources:
**Shared Element Transisions**

[Mike Scamell's Github](https://github.com/mikescamell/shared-element-transitions)



**Saved Instance on Config Change**

[Coding Flow](https://codinginflow.com/tutorials/android/restore-variables-on-configuration-change)

[CoderWall](https://coderwall.com/p/ujapga/persisting-data-between-configurations-changes-fragments)

[RetainInstance](https://www.androiddesignpatterns.com/2013/04/retaining-objects-across-config-changes.html)



**Recyclerview Optimizations**

[Restoring recyclerview positions (though not necessary)](https://stackoverflow.com/questions/36568168/how-to-save-scroll-position-of-recyclerview-in-android/36569778)

[Improving scrolling](https://stackoverflow.com/questions/27188536/recyclerview-scrolling-performance)



**Fragments**


**Fragment Interfaces**  


**Misc**

[Cardview Glitch](https://stackoverflow.com/questions/56747314/cardview-corneredges-display-with-dark-color-how-to-resolve-this/56747390#56747390)

