package com.example.quizzlet;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    public static List<QuestionList> javaQuestion(){
         List<QuestionList> questionLists=new ArrayList<>();

        //method to create question for the quiz with option1,option2,option3,option4,answer,userselectedAnswer
         QuestionList question1=new QuestionList("Number of primitive data types in Java are?",
                 "6",
                 "7",
                 "8",
                 "9",
                 "8");
         QuestionList question2=new QuestionList("Who invented Java Programming?",
                 "Guido van Rossum",
                 "James Gosling",
                 "Dennis Ritchie",
                 "Bjarne Stroustrup",
                 "James Gosling");
         QuestionList question3=new QuestionList(" Which statement is true about Java?",
                 "Java is a sequence-dependent programming language",
                 "Java is a code dependent programming language",
                 "Java is a platform-dependent programming language",
                 "Java is a platform-dependent programming language",
                 "Java is a platform-dependent programming language");
         QuestionList question4=new QuestionList("Which component is used to compile, debug and execute the java programs?",
                 "JRE",
                 "JIT",
                 "JDK",
                 "JVM",
                 "JDK");
         QuestionList question5=new QuestionList("Which one of the following is not a Java feature?",
                 "Object-oriented",
                 "Use of pointers",
                 "Portable",
                 "Dynamic and Extensible",
                 "Use of pointers");

        //method to pass
        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);

        return questionLists;
    }

    public static List<QuestionList> phpQuestion(){
        final List<QuestionList> questionLists=new ArrayList<>();

        //method to create question for the quiz with option1,option2,option3,option4,answer,userselectedAnswer
        final QuestionList question1=new QuestionList("Which function is used to get ASCII value of a character in PHP ?",
                "asc()",
                "chr( )",
                "ascii()",
                "val( )",
                "chr( )");
        final QuestionList question2=new QuestionList("Which of following is not a Superglobals in PHP?",
                "$_SERVER",
                "$_ENV",
                "$_FILES",
                "$_PUT",
                "$_PUT");
        final QuestionList question3=new QuestionList(" Which sign is used to access variable of variable in PHP?",
                "$$",
                "$",
                "#@",
                "$|",
                "$$");
        final QuestionList question4=new QuestionList( "Which of the following symbol is used to add multiple line comments in PHP ?",
                "//",
                "/* */",
                "{{ }}",
                "1{1 1}",
                "/* */");
        final QuestionList question5=new QuestionList( "PHP is a ............",
                "Open Source Laguage",
                "Widely Used Language",
                "Server side scripting language",
                "All of the above",
                "All of the above");


        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);

        return questionLists;

    }

    public  static  List<QuestionList> rustQuestion(){

        final List<QuestionList> questionLists=new ArrayList<>();

        final QuestionList question1=new QuestionList("Who designed Rust?",
                "Doug Cutting",
                "JetBrains",
                "Graydon Hoare",
                "Robert Griesemer",
                "Graydon Hoare");
        final QuestionList question2=new QuestionList("Rust is syntatically similar to which programming language?",
                "C++",
                "Python",
                "C Sharp",
                "Java",
                "C++");
        final QuestionList question3=new QuestionList("Which among the following is permitted by rust? ",
                "Null Pointers",
                "let keyword ",
                "Data Races ",
                "Automated Garbage Collectors",
                "let keyword ");
        final QuestionList question4=new QuestionList("Which among the following is not a valid keyword in Rust?",
                "mut",
                "impl",
                "let",
                "var",
                "var");
        final QuestionList question5=new QuestionList("Which keyword is used to write a function in rust?",
                "fn",
                "function",
                "func",
                "f",
                "fn");


        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);

        return questionLists;

    }

    public static  List<QuestionList> cppQuestion(){

        final  List<QuestionList> questionLists=new ArrayList<>();
        final QuestionList question1=new QuestionList("Who invented C++?",
                "Dennis Ritchie",
                "Ken Thompson",
                "Brian Kernighan",
                "Bjarne Stroustrup",
                "Bjarne Stroustrup");
        final QuestionList question2=new QuestionList("What is C++?",
                "C++ is an object oriented programming language",
                "C++ is a procedural programming language",
                "C++ supports both procedural and object oriented programming language",
                "C++ is a functional programming language",
                "C++ supports both procedural and object oriented programming language");
        final QuestionList question3=new QuestionList("Which of the following is the correct syntax of including a user defined header files in C++?",
                "#include [userdefined]",
                "#include “userdefined”",
                "#include <userdefined.h>",
                "#include <userdefined>",
                "#include <userdefined.h>");
        final QuestionList question4=new QuestionList("Which of the following is used for comments in C++?",
                "/* comment */",
                "// comment */",
                "// comment",
                "both // comment or /* comment */",
                "both // comment or /* comment */");
        final QuestionList question5=new QuestionList("Which of the following user-defined header file extension used in c++?",
                "hg",
                "cpp",
                "h",
                "hf","h");


        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);

        return questionLists;
    }

    public  List<QuestionList> getQuestion(String selectedTopicName){
        switch (selectedTopicName){
            case "java":
                return javaQuestion();

            case "php":
                return phpQuestion();

            case "rust":
                return rustQuestion();

            default:
                return cppQuestion();

        }

    }
}
