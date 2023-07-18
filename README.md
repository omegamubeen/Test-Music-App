# Test application

### <b>Requirement</b>: We want to develop an application that automatically plays music and displays an image on the screen. After playing all the songs in the list, it will automatically re-play. The project has been given some code structures, and we hoped you could help us complete it.

### Please read all the information and make sure you clear the requirements before starting the implementation.

### Tasks:

1. Firstly, load playlists from web service when the app started.
   > API = https://raw.githubusercontent.com/eim-test/remote/main/api/playlist

2. Next, make the app play the songs (bgm) in the playlist sequentially.
3. Display the image on the screen via url given in the data.
4. Get the initials text of the name in the data and show it on text view by the following rules
   below:
   ```
   TODO:
   - Implement a logic to get an initials text
   - Rules:
       "Rowan Paul Nelson"   -> "RN"
       "Amanda Pollard"      -> "AP"
       "Elizabeth"           -> "EL"
       ""                    -> ""
   ```
5. Implement button click events to play previous/next playlist.
6. Make the app re-play after finishing all the playlists.

### Bonus section:

- Write a unit test for the get initials function (optional).
- Apply dependency injection by Dagger Hilt (optional).
- Adhere to clean architecture in project (optional).

### Notice:

* **BASE_URL** and **API_PLAYLIST** have been given in the source code.
* Project is running on **Java_17**. If you use **Java_1_8**, please config it in the build.gradle (
  app).
* MVVM and Coroutines are used in the project. But you can choose another approach that you are the
  most friendly with.
* After finishing the test, please build one APK for installation and zip the whole thing.
* Submit the zip file directly by email or share drive link (make sure it is public to view)

Give it your best shot.<br>
Wishing you success in the test.