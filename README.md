# NBA-Info
An android application that displays the information and descriptions on a couple NBA teams along with an embedded youtube video.

#Design Doc:
    *I did have a line in to stop the scrolling from being glitchy (cutting off content and moving slow) but the fragment implementation fixed that.
    *This change dropped cpu usage while scrolling from ~60-65% to a maximum of 27.

    *Stuff I forgot to mention, recyclerview caches all the items, to reduce calling onbindviewholder.
    *With this the recyclerview doesn't bash memory and cpu on scrolling.

    *Converted the hero image into a webp and this removed all the speed problems on the main activity.
    *Note webp's are only supported api 18 and up aka not a problem.

    *Memory usage when up from 50mb avg after the load settles that one time to 100mb. avg.

    *Hardware acceleration was enabled for the entire app.
    *Ram usages went up to 120mb max and cpu dropped to 15% avg. It just scrolls smoother barely noticeable but very satisfying.
    *"Energy" usage went down from high-medium to straight up low

    *Hardware acceleration was disabled for the splashscreen cause that was causing a harsh transition upon loading the main activity.

    *Added the lazy nightmode, weird graphical glitches around the cardview in the nightmode.
    *"app:cardBackgroundColor="@android:color/transparent"" solved this.

    *Fully switched to both activties being fragments. The youtube is still a bitch, it now crashes when nightmode activates or when it rotates in the detail activty.
    *Its a mess at this point. Also screw the youtube api.
    *But at least we have transitions between the fragments. Yeah they don't come with em naturally. #UseYaOwn!
    *And yes you need four animations for it to work.

    *Without the default constructor for a fragment it will crash on config change

#Tips:
    *Keep the view-group that onbindviewholder() would be calling to simplified state as complex layouts slow down this function.
    **Text views can slow down the recycler views.

    *Fragment xml thingy crashes the app. Use FrameLayout instead

    *I can pass everything to a fragment on the start in the same way as a class

#Sources:
    https://github.com/mikescamell/shared-element-transitions
