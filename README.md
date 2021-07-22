# Craigs-Compiler
Fully operational compiler written in Java

This follows the compiler from "Compilers: Principles, Techniquies & Tools" ISBN 0-321-48681-1
This really helped me to learn so much about compiler construction.

A few changes were made from the original:
* There was no way for the code to actually read a file, so I had to implement the [Lexer](https://github.com/spencerstith/Craigs-Compiler/blob/3a51ed5c3967f2b3925240abde6e41047a8d135c/src/craigscode/lexer/Lexer.java#L11) to have a `BufferedReader` to read the [test file](https://github.com/spencerstith/Craigs-Compiler/blob/master/test)
* There were some inconsistencies within the code such as spacing
* Updated some of the older code styling to more modern code styles i.e. `if ( test )` -> `if (test)`
