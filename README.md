# Undo-Redo-LogReader

This project has as objective to simulate a database recover reading the database logs. 

How is it about a simulate, all the things are simplified. The folder 'test' contains
the input, output and logs, where all of them are '.txt' files.

The input file, (called 'entrada.txt') contains several equalities, that represents the
database table fields, for example, an input file with the follow content:

A=2<br />
B=3<br />
C=4<br />

Say that the databse table has the fields A,B and C and your current values are, respectively, 
2, 3 and 4.

With this values, are required to realize the recover of them. 

To it, is used the log file (called 'log.txt').

Exepected log file content: 

\<start T1><br/>
\<T1,A,4,5><br/>
\<start T2><br/>
\<Commit T1><br/>
\<T2,B,9,10><br/>
\<Start CKPT(T2)><br/>
\<T2,C,14,15><br/>
\<start T3><br/>
\<T3,D,19,20><br/>
\<Commit T3><br/>
\<END CKPT><br/>
