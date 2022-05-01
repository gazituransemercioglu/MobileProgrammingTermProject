# Personal Health Tracker
### Purpose of the project
An application that people can control activities and see history of their activities.

### Including Activities
- Step Counter
- Breath Excercise
- Sleep Time
- Calori Calculator

### Features
- User athentication / registration
- Start and end activities
- Log activity
- See history of activity
- Activity route on Google Maps
- Estimated energy consumption

### What we did ? 
- We created an main activity includes activity fragments, step counter and user's health informations.
- We created [`MainActivity.kt`](https://github.com/gazituransemercioglu/MobileProgrammingTermProject/blob/master/app/src/main/java/com/example/mobileprogrammingtermproject/MainActivity.kt)
- We designed [`activity_login.xml`](https://github.com/gazituransemercioglu/MobileProgrammingTermProject/blob/master/app/src/main/res/layout/activity_login.xml) and [`activity_signUp.xml`](https://github.com/gazituransemercioglu/MobileProgrammingTermProject/blob/master/app/src/main/res/layout/activity_sign_up.x).
- We created [`DatabaseHelper.kt`](https://github.com/gazituransemercioglu/MobileProgrammingTermProject/blob/master/app/src/main/java/com/example/mobileprogrammingtermproject/DatabaseHelper.kt) class includes some methods to used on login and sign up pages.
- - `insertData()` inserts id,username,name,email and password into table.
- - `readData()` reads id,username,name,email and password from table.
- We created [`LoginActivity.kt`](https://github.com/gazituransemercioglu/MobileProgrammingTermProject/blob/master/app/src/main/java/com/example/mobileprogrammingtermproject/LoginActivity.kt) class takes username and password also includes sign up button.
- We created [`SignUp.kt`](https://github.com/gazituransemercioglu/MobileProgrammingTermProject/blob/master/app/src/main/java/com/example/mobileprogrammingtermproject/MainActivity.kt) class add user into table with `DatabaseHelper.readData()` funciton.
- We created [`User.kt`](https://github.com/gazituransemercioglu/MobileProgrammingTermProject/blob/master/app/src/main/java/com/example/mobileprogramm) takes user's id,username,name,email and password.

### What we will do ? 
