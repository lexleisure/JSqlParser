
# Instruction

## add new features for mysql, list as below:

### modify:
1.show full columns from my_table;

### add：
support sql like below:
1.show index from my_table;
2.show table status like 'my_table';

## how to package
### install javacc first
* firstly, with mac osx+,just install homebrew ,
* secondly,you could install javacc via homebrew:brew install javacc
* thirdly, cd src/jjtree/net/sf/jsqlparser/parser
```text
#jjtree is a command installed with javacc
jjtree JSqlParserCC.jjt
javacc JSqlParserCC.jj
```
then javacc will generate many files under current directory,copy these java files to net/sf/jsqlparser/parser
attention,ignore SimpleCharStream.java file

* now you can package to local
```text
mvn clean compile package
```

