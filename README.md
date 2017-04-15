<h1>Tasky</h1>

<h2>Task description:</h2>

<p>
Create an app that uses a simple database for storing user notes(some sort of To do list). 
It is necessary to enable user to create tasks, store them in database and view them in some kind of list and delete them.
Use examples from this and previous exercises. 
</p>

<h2>Solution review and problems:</h2>

<p>
<h4>Review:</h4>
For the user interface there are three activities with their .xml files. These activities are used to show the list(MainActivity), 
add new categories and delete existing categories(NewCategory) and to add tasks wit their attributes(NewTask).<br>
Long click on list item in main activity and NewCategory activity will call a dialog box asking to confirm or cancel delete [3].
If tasks have the same title all of them will be deleted because of the query in SQLite database(and this is something to work on in the future).
After creating a category the user is able to choose form a spinner which category he wants and if no category is created and task
is created, then  a Toast message will display saying that no category is selected.
It is also possible to create completely blank tasks with the exception of priorities(which are mandatory).
<h4>Testing</h4>
Testing was done on Vivax tablet and Meizu MX3 devices.
</p>

<p>
<h4>Problems:</h4>
The first problem occured when creating the database and this problem was fixed by studying the laboration preparation closely[1].
Second problem occured when trying to populate spinner from database and the fix was found on [2].
Third problem was with if-else statements where comparing strings was done wrong, this problem was fixed by using java function equals()
and not "==". 
</p>

<h1>Sources</h1>
 <ul type="none">
  <li>[1] Loomen site laborations</li>
  <li>[2] http://www.androidhive.info/2012/06/android-populating-spinner-data-from-sqlite-database/</li>
  <li>[3] http://stackoverflow.com/questions/2115758/how-do-i-display-an-alert-dialog-on-android</li>
</ul> 
