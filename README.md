# Theme-Android
Related to theming an Adroid App

In Editext view inputType is added because of that a specific keyboard pops-up at time of writing like for phone no. entry, numberic keyboard open's.

Shape file in resource directory related to Shape of elements. Views are categorized by their size like button comes under SmallComponent.
But for FAB we have to use shapeAppearanceOverlay in view to over-ride default theme/style , it's style is also define in shape.xml.

Font directory have a font family we need all the font which we want to use in that family, check font directory in resources , 
after that we allocated font from that family to type.xml and from there we extract in views using textAppearance .

MotionLayout - https://youtu.be/ROkKPgXpd1Y
Watch linked video to apply motion/transition in views. MotionLayout is a part of ConstraintLayout
In this app RadioButtons shrink if we pull-up from the bottom to top.

Transition From MainActivity to OrderedActivity
used transition explode see commit history fortunetaly I commited it separately.

I also attached land layout for mainActivity, which is basically same but we have to use ScrollView as Views are not able to fix in Horizontal screen.
Remember: ScrollView can have only one View inside it.
Tip: we have to create a new directory with name layout-land and file name should be same to the file for which we are creating a horizontal file layout like here activity_main.

RadioButtons are inside a RadioGroup so we are able to enable only one option at a time. 
