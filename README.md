# Google Camera -> Immich redirect

Google Camera's recent shot thumbnail is a button that opens Google Photos. I don't use Google Photos, which causes the button to not function and display a popup nagging me to install it ("Photos required - To view your photos and media, install Google Photos from Play Store").

This app is a simple stub for `com.google.android.apps.photos` which responds to the intent Google Camera uses to launch Google Photos, and forwards it to the Immich app as `ACTION_VIEW` so the image opens directly in Immich photo view.

Requires an Immich build newer than 2026-06-03 (see [#26109](https://github.com/immich-app/immich/pull/26109))

Before:

<img width="1080" height="2424" alt="before" src="https://github.com/user-attachments/assets/03039d60-2a86-4009-a59d-0f9b8d3fff79" />

After:

https://github.com/user-attachments/assets/af8ec282-6c91-47aa-8bad-66073351c867
