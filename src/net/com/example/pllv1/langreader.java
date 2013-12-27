package net.com.example.pllv1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
//import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;

public class langreader extends Activity  implements OnClickListener, OnDrawerOpenListener, OnDrawerCloseListener {


		
	TextView t,t1; EditText editnotes;
	Button booksave,bookdisplay;
	@SuppressWarnings("deprecation")
	SlidingDrawer sd;
	int ii = 0;
	Button prev, next,savenotes,displaynotes;
	SharedPreferences bookmark;
	String var,data;
	
	String optionsc[] = { "INTRO", "First example", "Let's Compute", " Loops", "Symbolic Constants", "Conditionals", "Pointers",
			"Arrays", "Character Arrays", "I/O Capabilities", "Functions", " Command-line arguments", "Graphical Interfaces: Dialog Boxes" };
	String optionscvalues[] = {"Save the code in the file hello.c, then compile it by typing:\n\tgcc hello.c\nThis creates an executable file a.out, which is then executed simply by typing its name. The result is that the characters `` Hello World\'\' are printed out, preceded by an empty line.\n\nA C program contains functions and variables. The functions specify the tasks to be performed by the program. The \"main\'\' function establishes the overall logic of the code. It is normally kept short and calls different functions to perform the necessary sub-tasks. All C codes must have a \"main\'\' function.\n\nOur hello.c code calls printf, an output function from the I/O (input/output) library (defined in the file stdio.h)",
			"#include < stdio.h>\n\nvoid main()\n{\n printf(\"\\n\");\n printf(\"Hello World\");\n printf(\"\\n\");\n}", "The following program, sine.c, computes a table of the sine function for angles between 0 and 360 degrees.\n\n\t\t\t\t/************************/\n\t\t\t\t/* Table of \t\t*/\t\n\t\t\t\t/* Sine Function\t*/\n\t\t\t\t/************************/\n\t\t\t\t\n\t\t\t\t/* Michel Vallieres \t*/\n\t\t\t\t/* Written: Winter 1995\t*/\n#include < stdio.h>\n#include < math.h>\n\nvoid main()\n{\n int angle_degree;\n double angle_radian, pi, value;\n\n\t\t\t\t\t/* Print a header */\n printf (\"\\nCompute a table of the sine function\\n\\n\");\n\n\t\t\t\t\t/* obtain pi once for all */\n\t\t\t\t\t/* or just use pi = M_PI, where\n\t\t\t\t\t M_PI is defined in math.h \t*/\n pi = 4.0*atan(1.0);\n printf ( \" Value of PI = %f \\n\\n\", pi );\n\n printf ( \" angle Sine \\n\" );\n\n angle_degree=0;\t\t\t/* initial angle value \t\t */\n\t\t\t\t\t/* scan over angle \t\t */\n\n while ( angle_degree <= 360 )\t/* loop until angle_degree > 360 */\n {\n angle_radian = pi * angle_degree/180.0 ;\n value = sin(angle_radian);\n printf ( \" %3d %f \\n \", angle_degree, value );\n\n angle_degree = angle_degree + 10; /* increment the loop index\t */\n }\n}\n\nThe code starts with a series of comments indicating its the purpose, as well as its author. It is considered good programming style to identify and document your work (although, sadly, most people only do this as an afterthought). Comments can be written anywhere in the code: any characters between /* and */ are ignored by the compiler and can be used to make the code easier to understand. The use of variable names that are meaningful within the context of the problem is also a good idea.\nThe #include statements now also include the header file for the standard mathematics library math.h. This statement is needed to define the calls to the trigonometric functions atan and sin. Note also that the compilation must include the mathematics library explicitly by typing\n\n\tgcc sine.c -lm\nVariable names are arbitrary (with some compiler-defined maximum length, typically 32 characters). C uses the following standard variable types:\n\nint -> integer variable\nshort -> short integer\nlong -> long integer\nfloat -> single precision real (floating point) variable\ndouble -> double precision real (floating point) variable\nchar -> character variable (single byte)\nThe compilers checks for consistency in the types of all variables used in any code. This feature is intended to prevent mistakes, in particular in mistyping variable names. Calculations done in the math library routines are usually done in double precision arithmetic (64 bits on most workstations). The actual number of bytes used in the internal storage of these data types depends on the machine being used.\nThe printf function can be instructed to print integers, floats and strings properly. The general syntax is\n\n\tprintf( \"format\", variables );\nwhere \"format\" specifies the converstion specification and variables is a list of quantities to print. Some useful formats are\n%.nd\tinteger (optional n = number of columns; if 0, pad with zeroes)\n%m.nf\tfloat or double (optional m = number of columns,\n\t\t\t \t n = number of decimal places)\n%ns\tstring (optional n = number of columns)\n%c \tcharacter\n\\n \\t \tto introduce new line or tab\n\\g\tring the bell (``beep\'\') on the terminal",
			"Most real programs contain some construct that loops within the program, performing repetitive actions on a stream of data or a region of memory. There are several ways to loop in C. Two of the most common are the while loop:\n while (expression)\n {\n\t...block of statements to execute...\n }\nand the for loop:\n for (expression_1; expression_2; expression_3)\n {\n\t...block of statements to execute...\n }\nThe while loop continues to loop until the conditional expression becomes false. The condition is tested upon entering the loop. Any logical construction (see below for a list) can be used in this context.\nThe for loop is a special case, and is equivalent to the following while loop:\n\n expression_1;\n\n while (expression_2)\n {\n\t...block of statements...\n\n\texpression_3;\n }\nFor instance, the following structure is often encountered:\n i = initial_i;\n\n while (i <= i_max)\n {\n \t...block of statements...\n\n\ti = i + i_increment;\n }\nThis structure may be rewritten in the easier syntax of the for loop as:\n for (i = initial_i; i <= i_max; i = i + i_increment)\n {\n\t...block of statements...\n }\nInfinite loops are possible (e.g. for(;;)), but not too good for your computer budget! C permits you to write an infinite loop, and provides the break statement to ``breakout \'\' of the loop. For example, consider the following (admittedly not-so-clean) re-write of the previous loop:\n angle_degree = 0;\n\n for ( ; ; )\n {\n\t...block of statements...\n\n\tangle_degree = angle_degree + 10;\n\tif (angle_degree == 360) break;\n }\nThe conditional if simply asks whether angle_degree is equal to 360 or not; if yes, the loop is stopped.","You can define constants of any type by using the #define compiler directive. Its syntax is simple--for instance\n#define ANGLE_MIN 0\n#define ANGLE_MAX 360\nwould define ANGLE_MIN and ANGLE_MAX to the values 0 and 360, respectively. C distinguishes between lowercase and uppercase letters in variable names. It is customary to use capital letters in defining global constants.","Conditionals are used within the if and while constructs:\n if (conditional_1) \n {\n\t...block of statements executed if conditional_1 is true...\n }\n else if (conditional_2)\n {\n\t...block of statements executed if conditional_2 is true...\n }\n else\n {\n\t...block of statements executed otherwise...\n }\nand any variant that derives from it, either by omitting branches or by including nested conditionals.\nConditionals are logical operations involving comparison of quantities (of the same type) using the conditional operators:\n\n\t<\t\tsmaller than\n \t<=\t\tsmaller than or equal to\n\t==\t\tequal to\n\t!=\t\tnot equal to\n\t>=\t\tgreater than or equal to\n\t>\t\tgreater than\nand the boolean operators\n\t&& \t\tand\n\t||\t\tor\n\t!\t\tnot\nAnother conditional use is in the switch construct:\n\n switch (expression)\n {\n\tcase const_expression_1:\n\t{\n\t ...block of statements...\n break;\n\t}\n\tcase const_expression_2:\n\t{\n\t ...block of statements...\n break;\n\t}\n\tdefault:\n\t{\n\t ...block of statements..\n\t}\n }\nThe appropriate block of statements is executed according to the value of the expression, compared with the constant expressions in the case statement. The break statements insure that the statements in the cases following the chosen one will not be executed. If you would want to execute these statements, then you would leave out the break statements. This construct is particularly useful in handling input variables.","The C language allows the programmer to ``peek and poke\'\' directly into memory locations. This gives great flexibility and power to the language, but it also one of the great hurdles that the beginner must overcome in using the language.\nAll variables in a program reside in memory; the statements\n\n float x;\n x = 6.5;\nrequest that the compiler reserve 4 bytes of memory (on a 32-bit computer) for the floating-point variable x, then put the ``value\'\' 6.5 in it.\nSometimes we want to know where a variable resides in memory. The address (location in memory) of any variable is obtained by placing the operator ``&\'\' before its name. Therefore &x is the address of x. C allows us to go one stage further and define a variable, called a pointer, that contains the address of (i.e. ``points to\'\') other variables. For example:\n\n float x;\n float* px;\n\n x = 6.5;\n px = &x;\ndefines px to be a pointer to objects of type float, and sets it equal to the address of x:\n \nPointer use for a variable\nThe content of the memory location referenced by a pointer is obtained using the ``*\'\' operator (this is called dereferencing the pointer). Thus, *px refers to the value of x.\n\nC allows us to perform arithmetic operations using pointers, but beware that the ``unit\'\' in pointer arithmetic is the size (in bytes) of the object to which the pointer points. For example, if px is a pointer to a variable x of type float, then the expression px + 1 refers not to the next bit or byte in memory but to the location of the next float after x (4 bytes away on most workstations); if x were of type double, then px + 1 would refer to a location 8 bytes (the size of a double)away, and so on. Only if x is of type char will px + 1 actually refer to the next byte in memory.\n\nThus, in\n\n char* pc;\n float* px;\n float x;\n\n x = 6.5;\n px = &x;\n pc = (char*) px;\n(the (char*) in the last line is a ``cast\'\', which converts one data type to another), px and pc both point to the same location in memory--the address of x--but px + 1 and pc + 1 point to different memory locations.\nConsider the following simple code.\n\n\nvoid main()\n{\n float x, y;\t\t\t\t/* x and y are of float type\t */\n float *fp, *fp2;\t\t\t/* fp and fp2 are pointers to float */\n\n x = 6.5;\t\t\t\t/* x now contains the value 6.5\t */\n\n\t\t\t\t\t/* print contents and address of x */\n printf(\"Value of x is %f, address of x %ld\\n\", x, &x);\n\t\n fp = &x;\t\t\t\t/* fp now points to location of x */\n\t\t\n\t\t\t\t\t/* print the contents of fp\t */\n printf(\"Value in memory location fp is %f\\n\", *fp);\n\n\t\t\t\t\t/* change content of memory location */\n *fp = 9.2;\n printf(\"New value of x is %f = %f \\n\", *fp, x);\n\n\t\t\t\t\t/* perform arithmetic \t */\n *fp = *fp + 1.5;\n printf(\"Final value of x is %f = %f \\n\", *fp, x);\n\n\t\t\t\t\t/* transfer values */\n y = *fp;\n fp2 = fp;\n printf(\"Transfered value into y = %f and fp2 = %f \\n\", y, *fp2);\n}\n\nRun this code to see the results of these different operations. Note that, while the value of a pointer (if you print it out with printf) is typically a large integer, denoting some particular memory location in the computer,pointers are not integers--they are a completely different data type.","Arrays of any type can be formed in C. The syntax is simple:\n\ttype name[dim];\nIn C, arrays starts at position 0. The elements of the array occupy adjacent locations in memory. C treats the name of the array as if it were a pointer to the first element--this is important in understanding how to do arithmetic with arrays. Thus, if v is an array, *v is the same thing as v[0], *(v+1) is the same thing as v[1], and so on:\n \nPointer use for an array\nConsider the following code, which illustrates the use of pointers:\n\n\n#define SIZE 3\n\nvoid main()\n{\n float x[SIZE];\n float *fp;\n int i;\n\t\t\t\t\t/* initialize the array x */\n\t\t\t\t\t/* use a \"cast\" to force i */\n\t\t\t\t\t/* into the equivalent float */\n for (i = 0; i < SIZE; i++)\n\tx[i] = 0.5*(float)i;\n\t\t\t\t\t/* print x */\n for (i = 0; i < SIZE; i++)\n\tprintf(\" %d %f \\n\", i, x[i]);\n\t\t\t\t\t/* make fp point to array x */\n fp = x;\n\t\t\t\t\t/* print via pointer arithmetic */\n\t\t\t\t\t/* members of x are adjacent to */\n\t\t\t\t\t/* each other in memory\t */\n\t\t\t\t\t/* *(fp+i) refers to content of\t */\n\t\t\t\t\t/* memory location (fp+i) or x[i] */\n for (i = 0; i < SIZE; i++)\n\tprintf(\" %d %f \\n\", i, *(fp+i));\n}\n\n(The expression ``i++\'\' is C shorthand for ``i = i + 1\'\'.) Since x[i] means the i-th element of the array x, and fp = x points to the start of the x array, then *(fp+i) is the content of the memory address i locations beyond fp, that is, x[i].","A string constant , such as\n\t\"I am a string\"\nis an array of characters. It is represented internally in C by the ASCII characters in the string, i.e., ``I\'\', blank, ``a\'\', ``m\'\',... for the above string, and terminated by the special null character ``\\0\'\' so programs can find the end of the string.\nString constants are often used in making the output of code intelligible using printf ;\n\n\tprintf(\"Hello, world\\n\");\n\tprintf(\"The value of a is: %f\\n\", a);\nString constants can be associated with variables. C provides the char type variable, which can contain one character--1 byte--at a time. A character string is stored in an array of character type, one ASCII character per location. Never forget that, since strings are conventionally terminated by the null character ``\\0\'\', we require one extra storage location in the array!\n\nC does not provide any operator which manipulate entire strings at once. Strings are manipulated either via pointers or via special routines available from the standard string library string.h. Using character pointers is relatively easy since the name of an array is a just a pointer to its first element. Consider the following code:\n\n\nvoid main()\n{\n char text_1[100], text_2[100], text_3[100];\n char *ta, *tb;\n int i;\n /* set message to be an arrray */\n /* of characters; initialize it */\n /* to the constant string \"...\" */\n /* let the compiler decide on */\n /* its size by using [] */\n char message[] = \"Hello, I am a string; what are you?\";\n \n printf(\"Original message: %s\\n\", message);\n\n /* copy the message to text_1 */\n /* the hard way */\n i=0;\n while ( (text_1[i] = message[i]) != \'\\0\' )\n i++;\n printf(\"Text_1: %s\\n\", text_1);\n\n /* use explicit pointer arithmetic */\n ta=message;\n tb=text_2;\n while ( ( *tb++ = *ta++ ) != \'\\0\' ) \n ;\n printf(\"Text_2: %s\\n\", text_2);\n \n}\n\nThe standard ``string\'\' library contains many useful functions to manipulate strings; a description of this library can be found in an appendix of the K & R textbook. Some of the most useful functions are:\nchar *strcpy(s,ct) -> copy ct into s, including ``\\0\'\'; return s\nchar *strncpy(s,ct,n) -> copy ncharcater of ct into s, return s\nchar *strncat(s,ct) -> concatenate ct to end of s; return s\nchar *strncat(s,ct,n) -> concatenate n character of ct to end\n of s, terminate with ``\\0\'\'; return s\nint strcmp(cs,ct) -> compare cs and ct; return 0 if cs=ct,\n <0 if cs0 if cs>ct \nchar *strchr(cs,c) -> return pointer to first occurence of c\n in cs or NULL if not encountered\nsize_t strlen(cs) -> return length of cs\n(s and t are char*, cs and ct are const char*, c is an char converted to type int, and n is an int.)\nConsider the following code which uses some of these functions:\n\n\n#include < string.h>\n \nvoid main()\n{\n char line[100], *sub_text;\n\t\t\t\t\t/* initialize string */ \n strcpy(line,\"hello, I am a string;\");\n printf(\"Line: %s\\n\", line);\n\t\t\t\t\t/* add to end of string */ \n strcat(line,\" what are you?\");\n printf(\"Line: %s\\n\", line);\n\t\t\t\t\t/* find length of string */ \n \t\t\t\t\t/* strlen brings back */\n\t\t\t\t\t/* length as type size_t */\n\n printf(\"Length of line: %d\\n\", (int)strlen(line));\n\n\t\t\t\t\t/* find occurence of substrings */ \n if ( (sub_text = strchr ( line, \'W\' ) )!= NULL )\n printf(\"String starting with \\\"W\\\" ->%s\\n\", sub_text);\n \n if ( ( sub_text = strchr ( line, \'w\' ) )!= NULL )\n printf(\"String starting with \\\"w\\\" ->%s\\n\", sub_text);\n \n if ( ( sub_text = strchr ( sub_text, \'u\' ) )!= NULL )\n printf(\"String starting with \\\"w\\\" ->%s\\n\", sub_text);\n \n}","Character level I/O\n\nC provides (through its libraries) a variety of I/O routines. At the character level, getchar() reads one character at a time from stdin, while putchar() writes one character at a time to stdout. For example, consider\n\n#include < stdio.h>\n\nvoid main()\n{\n int i, nc;\n\t\n nc = 0;\n i = getchar();\n while (i != EOF) {\n\tnc = nc + 1;\n\ti = getchar();\n }\n printf(\"Number of characters in file = %d\\n\", nc);\n}\n\nThis program counts the number of characters in the input stream (e.g. in a file piped into it at execution time). The code reads characters (whatever they may be) from stdin (the keyboard), uses stdout (the X-terminal you run from) for output, and writes error messages to stderr (usually also your X-terminal). These streams are always defined at run time. EOF is a special return value, defined in stdio.h, returned by getchar() when it encounters an end-of-file marker when reading. Its value is computer dependent, but the C compiler hides this fact from the user by defining the variable EOF. Thus the program reads characters from stdin and keeps adding to the counter nc, until it encounters the ``end of file\'\'.\nAn experienced C programmer would probably code this example as:\n\n\n#include < stdio.h>\n\nvoid main()\n{\n int c, nc = 0;\n\n while ( (c = getchar()) != EOF ) nc++;\n\n printf(\"Number of characters in file = %d\\n\", nc);\n}\n\nC allows great brevity of expression, usually at the expense of readability!\nThe () in the statement (c = getchar()) says to execute the call to getchar() and assign the result to c before comparing it to EOF; the brackets are necessary here. Recall that nc++ (and, in fact, also ++nc) is another way of writing nc = nc + 1. (The difference between the prefix and postfix notation is that in ++nc, nc is incremented before it is used, while in nc++, nc is used before it is incremented. In this particular example, either would do.) This notation is more compact (not always an advantage, mind you), and it is often more efficiently coded by the compiler.\n\nThe UNIX command wc counts the characters, words and lines in a file. The program above can be considered as your own wc. Let\'s add a counter for the lines.\n\n\n#include < stdio.h>\n\nvoid main()\n{\n int c, nc = 0, nl = 0;\n\n while ( (c = getchar()) != EOF )\n {\n\tnc++;\n\tif (c == \'\\n\') nl++;\n }\n\n printf(\"Number of characters = %d, number of lines = %d\\n\",\n\t nc, nl);\n}\n\nCan you think of a way to count the number of words in the file?\nHigher-Level I/O capabilities\n\nWe have already seen that printf handles formatted output to stdout. The counterpart statement for reading from stdin is scanf. The syntax\n\tscanf(\"format string\", variables); \nresembles that of printf. The format string may contain blanks or tabs (ignored), ordinary ASCII characters, which must match those in stdin, and conversion specifications as in printf.\nEquivalent statements exist to read from or write to character strings. They are:\n\n sprintf(string, \"format string\", variables);\n scanf(string, \"format string\", variables);\nThe ``string\'\' argument is the name of (i.e. a pointer to) the character array into which you want to write the information.\nI/O to and from files\n\nSimilar statements also exist for handling I/O to and from files. The statements are\n\n#include < stdio.h>\n\n FILE *fp;\n\t\t\t\t\t\t\t\t\t\t\n fp = fopen(name, mode);\n\t\n fscanf(fp, \"format string\", variable list);\n fprintf(fp, \"format string\", variable list);\n\n fclose(fp );\nThe logic here is that the code must\ndefine a local ``pointer\'\' of type FILE (note that the uppercase is necessary here), which is defined in < stdio.h>\n``open\'\' the file and associate it with the local pointer via fopen\nperform the I/O operations using fscanf and fprintf\ndisconnect the file from the task with fclose\nThe ``mode\'\' argument in the fopen specifies the purpose/positioning in opening the file: ``r\'\' for reading, ``w\'\' for writing, and ``a\'\' for appending to the file. Try the following:\n\n#include < stdio.h>\n\nvoid main()\n{\n FILE *fp;\n int i;\n\n fp = fopen(\"foo.dat\", \"w\"); /* open foo.dat for writing */\n\n fprintf(fp, \"\\nSample Code\\n\\n\"); /* write some info */\n for (i = 1; i <= 10 ; i++)\n\tfprintf(fp, \"i = %d\\n\", i);\n\n fclose(fp);\t\t\t /* close the file */\n}\n\nCompile and run this code; then use any editor to read the file foo.dat.","Functions are easy to use; they allow complicated programs to be parcelled up into small blocks, each of which is easier to write, read, and maintain. We have already encountered the function main and made use of I/O and mathematical routines from the standard libraries. Now let\'s look at some other library functions, and how to write and use our own.\nCalling a Function\n\nThe call to a function in C simply entails referencing its name with the appropriate arguments. The C compiler checks for compatibility between the arguments in the calling sequence and the definition of the function.\nLibrary functions are generally not available to us in source form. Argument type checking is accomplished through the use of header files (like stdio.h) which contain all the necessary information. For example, as we saw earlier, in order to use the standard mathematical library you must include math.h via the statement\n\n#include < math.h>\nat the top of the file containing your code. The most commonly used header files are\n< stdio.h> -> defining I/O routines\n< ctype.h> -> defining character manipulation routines\n< string.h> -> defining string manipulation routines\n< math.h> -> defining mathematical routines\n< stdlib.h> -> defining number conversion, storage allocation \n \tand similar tasks\n< stdarg.h> -> defining libraries to handle routines with variable \n \tnumbers of arguments\n< time.h> -> defining time-manipulation routines\nIn addition, the following header files exist:\n< assert.h> -> defining diagnostic routines\n< setjmp.h> -> defining non-local function calls\n< signal.h> -> defining signal handlers\n< limits.h> -> defining constants of the int type\n< float.h> -> defining constants of the float type\nAppendix B in the K & R book describes these libraries in great detail.\nWriting Your Own Functions\n\nA function has the following layout:\nreturn-type function-name ( argument-list-if-necessary )\n{\n ...local-declarations...\n\n ...statements...\n\n return return-value;\n}\nIf return-type is omitted, C defaults to int. The return-value must be of the declared type.\nA function may simply perform a task without returning any value, in which case it has the following layout:\n\nvoid function-name ( argument-list-if-necessary )\n{\n ...local-declarations...\n\n ...statements...\n}\nAs an example of function calls, consider the following code:\n\n\n\t\t\t/* include headers of library */\n\t\t\t/* defined for all routines */\n\t\t\t/* in the file */\n#include < stdio.h>\n#include < string.h>\n\t\t\t/* prototyping of functions */\n\t\t\t/* to allow type checks by */\n\t\t\t/* the compiler */\n\nvoid main()\n{\n int n;\n char string[50];\n\t\t\t/* strcpy(a,b) copies string b into a */\n\t\t\t/* defined via the stdio.h header */\n strcpy(string, \"Hello World\");\n\n\t\t\t/* call own function */\n n = n_char(string);\t\n printf(\"Length of string = %d\\n\", n);\t\n}\n\n\t\t\t/* definition of local function n_char */\nint n_char(char string[])\n{\n\t\t\t/* local variable in this function */\n int n;\n\t\t\t/* strlen(a) returns the length of */\n\t\t\t/* string a */\n\t\t\t/* defined via the string.h header */\n n = strlen(string);\n if (n > 50) \n\tprintf(\"String is longer than 50 characters\\n\");\n\n\t\t\t/* return the value of integer n */\n return n;\n}\n\nArguments are always passed by value in C function calls. This means that local ``copies\'\' of the values of the arguments are passed to the routines. Any change made to the arguments internally in the function are made only to the local copies of the arguments. In order to change (or define) an argument in the argument list, this argument must be passed as an address, thereby forcing C to change the ``real\'\' argument in the calling routine.\n\nAs an example, consider exchanging two numbers between variables. First let\'s illustrate what happen if the variables are passed by value:\n\n\n\n#include < stdio.h>\n\nvoid exchange(int a, int b);\n\nvoid main()\n{\t\t\t/* WRONG CODE */\n int a, b;\n\n a = 5;\n b = 7;\n printf(\"From main: a = %d, b = %d\\n\", a, b);\n\n exchange(a, b);\n printf(\"Back in main: \");\n printf(\"a = %d, b = %d\\n\", a, b);\n}\n\nvoid exchange(int a, int b)\n{\n int temp;\n\n temp = a;\n a = b;\n b = temp;\n printf(\" From function exchange: \");\n printf(\"a = %d, b = %d\\n\", a, b);\n}\n\nRun this code and observe that a and b are NOT exchanged! Only the copies of the arguments are exchanged. The RIGHT way to do this is of course to use pointers:\n\n\n#include < stdio.h>\n\nvoid exchange ( int *a, int *b );\n\nvoid main()\n{\t\t\t/* RIGHT CODE */\n int a, b;\n\n a = 5;\n b = 7;\n printf(\"From main: a = %d, b = %d\\n\", a, b);\n\n exchange(&a, &b);\n printf(\"Back in main: \");\n printf(\"a = %d, b = %d\\n\", a, b);\n}\n\nvoid exchange ( int *a, int *b )\n{\n int temp;\n\n temp = *a;\n *a = *b;\n *b = temp;\n printf(\" From function exchange: \");\n printf(\"a = %d, b = %d\\n\", *a, *b);\n}\n\nThe rule of thumb here is that\nYou use regular variables if the function does not change the values of those arguments\nYou MUST use pointers if the function changes the values of those arguments","It is standard practice in UNIX for information to be passed from the command line directly into a program through the use of one or more command-line arguments, or switches. Switches are typically used to modify the behavior of a program, or to set the values of some internal parameters. You have already encountered several of these--for example, the \"ls\" command lists the files in your current directory, but when the switch -l is added, \"ls -l\" produces a so-called ``long\'\' listing instead. Similarly, \"ls -l -a\" produces a long listing, including ``hidden\'\' files, the command \"tail -20\" prints out the last 20 lines of a file (instead of the default 10), and so on.\nConceptually, switches behave very much like arguments to functions within C, and they are passed to a C program from the operating system in precisely the same way as arguments are passed between functions. Up to now, the main() statements in our programs have had nothing between the parentheses. However, UNIX actually makes available to the program (whether the programmer chooses to use the information or not) two arguments to main: an array of character strings, conventionally called argv, and an integer, usually called argc, which specifies the number of strings in that array. The full statement of the first line of the program is\n\n main(int argc, char** argv)\n(The syntax char** argv declares argv to be a pointer to a pointer to a character, that is, a pointer to a character array (a character string)--in other words, an array of character strings. You could also write this as char* argv[]. Don\'t worry too much about the details of the syntax, however--the use of the array will be made clearer below.)\nWhen you run a program, the array argv contains, in order, all the information on the command line when you entered the command (strings are delineated by whitespace), including the command itself. The integer argc gives the total number of strings, and is therefore equal to equal to the number of arguments plus one. For example, if you typed\n\n\ta.out -i 2 -g -x 3 4\nthe program would receive\n\targc = 7\n\targv[0] = \"a.out\"\n\targv[1] = \"-i\"\n\targv[2] = \"2\"\n\targv[3] = \"-g\"\n\targv[4] = \"-x\"\n\targv[5] = \"3\"\n\targv[6] = \"4\"\nNote that the arguments, even the numeric ones, are all strings at this point. It is the programmer\'s job to decode them and decide what to do with them.\nThe following program simply prints out its own name and arguments:\n\n#include < stdio.h>\n\nmain(int argc, char** argv)\n{\n int i;\n\n printf(\"argc = %d\\n\", argc);\n\n for (i = 0; i < argc; i++)\n\tprintf(\"argv[%d] = \\\"%s\\\"\\n\", i, argv[i]);\n}\nUNIX programmers have certain conventions about how to interpret the argument list. They are by no means mandatory, but it will make your program easier for others to use and understand if you stick to them. First, switches and key terms are always preceded by a ``-\'\' character. This makes them easy to recognize as you loop through the argument list. Then, depending on the switch, the next arguments may contain information to be interpreted as integers, floats, or just kept as character strings. With these conventions, the most common way to ``parse\'\' the argument list is with a for loop and a switch statement, as follows:\n#include < stdio.h>\n#include < stdlib.h>\n\nmain(int argc, char** argv)\n{\n /* Set defaults for all parameters: */\n\n int a_value = 0;\n float b_value = 0.0;\n char* c_value = NULL;\n int d1_value = 0, d2_value = 0;\n\n int i;\n\n /* Start at i = 1 to skip the command name. */\n\n for (i = 1; i < argc; i++) {\n\n\t/* Check for a switch (leading \"-\"). */\n\n\tif (argv[i][0] == \'-\') {\n\n\t /* Use the next character to decide what to do. */\n\n\t switch (argv[i][1]) {\n\n\t\tcase \'a\':\ta_value = atoi(argv[++i]);\n\t\t\t\tbreak;\n\n\t\tcase \'b\':\tb_value = atof(argv[++i]);\n\t\t\t\tbreak;\n\n\t\tcase \'c\':\tc_value = argv[++i];\n\t\t\t\tbreak;\n\n\t\tcase \'d\':\td1_value = atoi(argv[++i]);\n\t\t d2_value = atoi(argv[++i]);\n\t\t\t\tbreak;\n\n\t }\n\t}\n }\n\n printf(\"a = %d\\n\", a_value);\n printf(\"b = %f\\n\", b_value);\n if (c_value != NULL) printf(\"c = \\\"%s\\\"\\n\", c_value);\n printf(\"d1 = %d, d2 = %d\\n\", d1_value, d2_value);\n}\nNote that argv[i][j] means the j-th character of the i-th character string. The if statement checks for a leading ``-\'\' (character 0), then the switch statement allows various courses of action to be taken depending on the next character in the string (character 1 here). Note the use of argv[++i] to increase i before use, allowing us to access the next string in a single compact statement. The functions atoi and atof are defined in stdlib.h. They convert from character strings to ints and doubles, respectively.\nA typical command line might be:\n\n\ta.out -a 3 -b 5.6 -c \"I am a string\" -d 222 111\n(The use of double quotes with -c here makes sure that the shell treats the entire string, including the spaces, as a single object.)\nArbitrarily complex command lines can be handled in this way. Finally, here\'s a simple program showing how to place parsing statements in a separate function whose purpose is to interpret the command line and set the values of its arguments:\n\n\n\n\t\t\t/********************************/\n\t\t\t/* \t*/\n\t\t\t/* Getting arguments from \t*/\n\t\t\t/*\t\t\t\t*/\n\t\t\t/* the Command Line */\n\t\t\t/*\t\t\t\t*/\n\t\t\t/********************************/\n\n\n\t\t\t\t\t/* Steve McMillan \t*/\n\t\t\t\t\t/* Written: Winter 1995\t*/\n\n\n#include < stdio.h>\n#include < stdlib.h>\n\nvoid get_args(int argc, char** argv, int* a_value, float* b_value)\n{\n int i;\n\n /* Start at i = 1 to skip the command name. \n\n for (i = 1; i < argc; i++) {\n\n\t/* Check for a switch (leading \"-\"). */\n\n\tif (argv[i][0] == \'-\') {\n\n\t /* Use the next character to decide what to do. */\n\n\t switch (argv[i][1]) {\n\n\t\tcase \'a\':\t*a_value = atoi(argv[++i]);\n\t\t\t\tbreak;\n\n\t\tcase \'b\':\t*b_value = atof(argv[++i]);\n\t\t\t\tbreak;\n\n\t\tdefault:\tfprintf(stderr,\n\t\t\t\t\"Unknown switch %s\\n\", argv[i]);\n\t }\n\t}\n }\n}\n\nmain(int argc, char** argv)\n{\n /* Set defaults for all parameters: */\n\n int a = 0;\n float b = 0.0;\n\n get_args(argc, argv, &a, &b);\n\n printf(\"a = %d\\n\", a);\n printf(\"b = %f\\n\", b);\n}","Suppose you don\'t want to deal with command line interpretation, but you still want your program to be able to change the values of certain variables in an interactive way. You could simply program in a series printf/scanf lines to quiz the user about their preferences:\n\t.\n\t.\n\t.\n\tprintf(\"Please enter the value of n: \");\n\tscanf(\"%d\", &n);\n\n\tprintf(\"Please enter the value of x: \");\n\tscanf(\"%f\", &x);\n\n\t.\n\t.\n\t.\n\nand so on, but this won\'t work well if your program is to be used as part of a pipeline (see the UNIX primer), for example using ther graphics program plot_data, since the questions and answers will get mixed up with the data stream.\n\nA convenient alternative is to use a simple graphical interface which generates a dialog box, offering you the option of varying key parameters in your program. Our graphics package provides a number of easy-to-use tools for constructing and using such boxes. The simplest way to set the integer variable n and the float variable x (i.e. to perform the same effect as the above lines of code) using a dialog box is as follows:\n\n/* Simple program to illustrate use of a dialog box */\n\t\nmain()\n{\n /* Define default values: */\n\n int n = 0;\n float x = 0.0;\n\n /* Define contents of dialog window */\n\n create_int_dialog_entry(\"n\", &n);\n create_float_dialog_entry(\"x\", &x);\n\n /* Create window with name \"Setup\" and top-left corner at (0,0) */\n\n set_up_dialog(\"Setup\", 0, 0);\n\n /* Display the window and read the results */\n\n read_dialog_window();\n\n /* Print out the new values */\n\n printf(\"n = %d, x = %f\\n\", n, x);\n}\nCompile this program using the alias Cgfx (see the page on compilation) to link in all necessary libraries.\nThe two create lines define the entries in the box and the variables to be associated with them, set_up_dialog names the box and defines its location. Finally, read_dialog_window pops up a window and allows you to change the values of the variables. When the program runs, you will see a box that looks something like this:" };
	
	String filename="file";
	String NOTEFILE="NOTES";
	FileOutputStream fos;
	WakeLock wl;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		SharedPreferences getprefs11=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
/*		boolean lock=getprefs11.getBoolean("wlock", false);
		
		if(lock==true)
		{
			PowerManager pm=(PowerManager)getSystemService(Context.POWER_SERVICE); 
			wl=pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "what");
		}
*/
		super.onCreate(savedInstanceState);
	//	wl.acquire();
		
		fscreen();
		setContentView(R.layout.lang);
		String aa;
		SharedPreferences bookmark;
		t = (TextView) findViewById(R.id.maintext);
		t1 = (TextView) findViewById(R.id.heading);
		editnotes = (EditText) findViewById(R.id.editnotes);
		t1.setTextColor(Color.RED);
		 prev = (Button) findViewById(R.id.prev);
		 next = (Button) findViewById(R.id.next);
		 booksave=(Button)findViewById(R.id.booksave);
		 bookdisplay=(Button)findViewById(R.id.bookdisplay);
		 savenotes = (Button) findViewById(R.id.savenotes);
		 displaynotes = (Button) findViewById(R.id.displaynotes);
		 sd=(SlidingDrawer)findViewById(R.id.sld1);
		 sd.setOnDrawerOpenListener(this);
		 sd.setOnDrawerCloseListener(this);
		 booksave.setOnClickListener(this);
		 bookdisplay.setOnClickListener(this);
		 savenotes.setOnClickListener(this);
		 displaynotes.setOnClickListener(this);
		 prev.setOnClickListener(this);
		 next.setOnClickListener(this);
	     ActionBar actionBar1 = getActionBar();
	     actionBar1.setDisplayHomeAsUpEnabled(true);

		 try {
			fos=openFileOutput(NOTEFILE,MODE_PRIVATE | MODE_APPEND);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 bookmark=getSharedPreferences(filename,0);


				
		

				Bundle gotbasket = getIntent().getExtras();
				var = gotbasket.getString("a1");
				 
		while(ii < 13){
	
			String ss = optionsc[ii];
			if (var.equals(ss))
			{

			break;
			}
			else
			{
				ii++;
			}
		}
		t.setText(optionscvalues[ii]);
		t1.setText(optionsc[ii]);
		getcolor();
		getsize();

		
		

		
		

	}
	
	
	
	

	
	private void getsize() {
		// TODO Auto-generated method stub
		
		
		SharedPreferences getpref=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String fsize=getpref.getString("fsize", "s1") ;

		
			if(fsize.contentEquals("s1"))
		{
			t.setTextSize(25);
		}
		
		else if(fsize.contentEquals("s2"))
		{
			t.setTextSize(30);
		}

		else if(fsize.contentEquals("s3"))
		{
			t.setTextSize(35);
		}

		else if(fsize.contentEquals("s4"))
		{
			t.setTextSize(40);
		}

		else if(fsize.contentEquals("s5"))
		{
			t.setTextSize(45);
		}

		else if(fsize.contentEquals("s6"))
		{
			t.setTextSize(50);
		}


		
	}


	void fscreen() {
		// TODO Auto-generated method stub
	
	SharedPreferences getprefs=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	boolean screen=getprefs.getBoolean("fscreen", false);
	
	if(screen==true)
	{
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

	}

		
	}

	
	private void getcolor() {
		// TODO Auto-generated method stub
		
		SharedPreferences getpref=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String fcolor=getpref.getString("fcolor", "Black") ;
		
		
		if(fcolor.contentEquals("Black"))
	{
		t.setTextColor(Color.BLACK);
	}
	
	else if(fcolor.contentEquals("Blue"))
	{
		t.setTextColor(Color.BLUE);
	}

	else if(fcolor.contentEquals("Red"))
	{
		t.setTextColor(Color.RED);
	}
	else if(fcolor.contentEquals("Cyan"))
	{
		t.setTextColor(Color.CYAN);
	}
	else if(fcolor.contentEquals("Gray"))
	{
		t.setTextColor(Color.GRAY);
	}
	else if(fcolor.contentEquals("Green"))
	{
		t.setTextColor(Color.GREEN);
	}
		
		
	}

	


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.prev:
			
			ii--;
			if(ii<0)
			{
				ii=(optionsc.length)-1;
			}
			t.setText(optionscvalues[ii]);
			t1.setText(optionsc[ii]);
			getcolor();
			getsize();
			  Vibrator v1 = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
			  v1.vibrate(100);

			break;
		case R.id.next:
			
			ii++;
			if(ii>((optionsc.length)-1))
			{
				ii=0;
			}

			t.setText(optionscvalues[ii]);
			t1.setText(optionsc[ii]);
			getcolor();
			getsize();
			  Vibrator v11 = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
			  v11.vibrate(100);

			break;
			
		case R.id.booksave :
			int jx;
			 jx=ii;
			 String bookvalue=Integer.toString(jx);
			 bookmark=getSharedPreferences(filename,0);
			 String bm=bookmark.getString("starting", "");
			 String cm=bookmark.getString("pass", "");
			 database12 sd= new database12(this);
			 sd.open();
			 int f=sd.updateEntry(bm,cm,bookvalue);
			 sd.close();
			  Vibrator v1211 = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
			  v1211.vibrate(100);
			 //t.setText(bm + "and " +cm );
			 
				/*			int start=s.indexOf("");
				String startingname=s.substring(start); */
			 if(f==1)
			 {
			Toast toast = Toast.makeText(langreader.this, "bookmark page saved",Toast.LENGTH_LONG);	
			toast.show();
			 }

			break;
		
		case R.id.bookdisplay :
			 bookmark=getSharedPreferences(filename,0);
			 String bm1=bookmark.getString("starting", "");
			 String cm1=bookmark.getString("pass", "");

			 database12 sd1= new database12(this);
			 sd1.open();
			 String fa=sd1.validatebookc(bm1,cm1);
			 sd1.close();
			 int y=Integer.parseInt(fa);

			
			t.setText(optionscvalues[y]);
			t1.setText(optionsc[y]);


			Toast toast1 = Toast.makeText(langreader.this, "bookmark page opened",Toast.LENGTH_LONG);			
			toast1.show();   

			break;
			
		case R.id.savenotes :
			 String timezoneID = TimeZone.getDefault().getID();
			/* SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");
			 sdf2.setTimeZone(TimeZone.getTimeZone(timezoneID));*/
			 
		//	 Log.d("Time zone","="+tz.getDisplayName());
		//	 String time = "";
			 TimeZone tz = TimeZone.getTimeZone("GMT+05:30");
			 Calendar c = Calendar.getInstance(tz);
		//	 String d=c.get(Calendar.DATE);
			  Vibrator v123 = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
			  v123.vibrate(100);
			 
			 String time = "DATE :"+c.get(Calendar.DATE)+ " "+/*c.get(Calendar.NOVEMBER)*/"11" +"  "+c.get(Calendar.YEAR) 
					 +"   TIME : "+c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
			 data="C LANGUAGE"+"\n"+time + "\n" + editnotes.getText().toString() + "\n\n";
			 bookmark=getSharedPreferences(filename,0);
			 String bm2=bookmark.getString("starting","");
			 String cm2=bookmark.getString("pass","");
			 String dm2=bm2.concat(cm2);
			 
		     

			try {
				fos=openFileOutput(dm2,MODE_PRIVATE | MODE_APPEND);
				fos.write(data.getBytes());
				fos.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}

			Toast toast111 = Toast.makeText(langreader.this, "Notes Saved",Toast.LENGTH_LONG);			
			toast111.show();   
			editnotes.setText("");
			
			break;
			
		case R.id.displaynotes :
			
			String collected=null;
			FileInputStream fis=null;
			 bookmark=getSharedPreferences(filename,0);
			 String bm4=bookmark.getString("starting", "");
			 String cm4=bookmark.getString("pass", "");
			 String dm4=bm4.concat(cm4);

			try {
				fis=openFileInput(dm4);
				byte[] dataArray =new byte[fis.available()];
				while(fis.read(dataArray)!=-1)
				{
					collected=new String(dataArray);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			Bundle basket=new Bundle();
			basket.putString("collect", collected);
			Intent a=new Intent(langreader.this,displaynotes.class);
			a.putExtras(basket);
			startActivity(a);	
			
			Toast toast134 = Toast.makeText(langreader.this, "Here's Your Notes",Toast.LENGTH_LONG);			
			toast134.show();   

			
			
			break;

			
		}
	}



	@Override
	public void onDrawerOpened() {
		// TODO Auto-generated method stub
		
		MediaPlayer Oursong=MediaPlayer.create(langreader.this, R.raw.slider);
		Oursong.start();

		
	}



	@Override
	public void onDrawerClosed() {
		// TODO Auto-generated method stub
		
		MediaPlayer Oursong=MediaPlayer.create(langreader.this, R.raw.slider);
		Oursong.start();

		
	}
	
	
	
	
	

	
	
	


	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowup=getMenuInflater();
		blowup.inflate(R.menu.main, menu);
		return true;
	}






	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		//return super.onOptionsItemSelected(item);
		switch(item.getItemId())
		{
		case (R.id.about):
		Intent i=new Intent("net.com.example.pllv1.ABOUTUS");
		startActivity(i);
		break;
		
		case (R.id.pref):
			Intent s=new Intent("net.com.example.pllv1.PREFFS");
			startActivity(s);
			
			break;
		case (R.id.exit):
			//finish();
			System.exit(0);
		default:         startActivity(new Intent(langreader.this,c.class)); 
        

		}
		return false;

	}



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
//		wl.release();
	}

	
	
	
}
