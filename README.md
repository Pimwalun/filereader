# Input-Output Tasks
by Pimwalun Witchawanitchanun (5910546686)

I ran the tasks on a MacbookPro with 2.3 Ghz, and got these results:

Task														|	Time
---------------------------------------------------------|----------------
Read file 1-char at a time to String					    |	0.839230 sec
Read file 1-char at a time to StringBulider				|	0.006941 sec
Read file line at a time using BufferedReader			|	0.019344 sec

## Explanation of Results
String is slower than others. Because when I append chars to a String, String will be create new by also keeping the old value inside. It repeats again and again until the end of the inserted.