# ex1-websites_statistics
Java program that opens a list of URLs and displays some statistics

The program will take as input (command line argument) a file containing URLs, and it will produce as output the following output

http://www.a.b links:5 images:10 lines:200
http://www.c.d/f.html error
http://www.z.com/q/d.asp links:0 images:1 lines:1
etc..

The input file will include a list of URLs, one per line:

http://a.b.c
http://a.b.c/d
The program will count lines and images/links based on: the number of occurrences of the tags IMG, HREF (case insensitive).

The output for each URL will be "error" in case
* The URL cannot be opened
* It is not a valid URL (meaning non reachable URL or not HTML document - any exception returned creating  or opening the URL object).
* If you have any kind of I/O error after opening the URL (for example the network can fail while you are reading)
* In case of error you go to next URL in the list.

If the input file is empty the program will display the string "empty file".
If the input file cannot be open the program will display the string "missing file".
