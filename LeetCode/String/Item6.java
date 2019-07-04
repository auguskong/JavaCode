// Avoid creating unneccessary objects

// this statement creates a new String instance each time it is executed
String s = new String("bikini"); // DON'T DO THIS!

String s = "bikini";