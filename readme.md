## JRecord Source code directory

This directory holds the Java source code for the JRecord Project, the directories are:

*   **JRecord_Common** - parts of JRecord that are shared with the RecordEditor project.
*   **JRecord** - The rest of JRecord.
*   **JRecord_IO_Builder_Examples** - Examples of using JRecord-IOBuilders.
*   **OtherSource** This sub directory contains the following sub projects:
    *   [cb2xml_package](https://sourceforge.net/projects/cb2xml/) - cb2xml project, Cobol Copybook analysis. This package is also used in some commercial products from the likes of IBM, Computer Associates etc.
    *   **JRecord_Cobol2Json_package** - Source for CobolToJson utility, requires Jackson JSon library.
    *   **JRecord_CodeGen** - Program to generate JRecord-Java interface code from a Cobol Copybook. This is still _a work in progress_
    *   **JRecord_Examples1** - Examples of using <it>Clasic-JRecord<it>.</it></it>
    *   [JRecord_Cobol2Xml_package](https://sourceforge.net/projects/coboltoxml/) - A simple Cobol-data-file <==> Xml-file conversion utility. It is a replacement for the Dat2Xml and Xml2Dat programs in [cb2xml](https://sourceforge.net/projects/cb2xml/).
    *   **JRecord_SchemaCompare** - A simple project to compare JRecord-Layouts (JRecord-Layouts are crreated from Cobol Copybooks) with a file. This small project has the following uses:
        *   Allows you to check the reading of Cobol-Copybooks with a past version of JRecord.
        *   Server as an example of using JRecord_CodeGen generated code into a simple project.

## Building with maven

I do not use maven myself, but this should work:

*   Build cb2xml
*   Build JRecord
*   If required, you can build cobolToJson and CobolToXml from supplied source (_OtherSource_ directory

## Building with ant

Go to JRecord directory and run the build xml. This should run the other and scripts

## Loading into a IDE

*   Load cb2xml into the IDE
*   Load JRecord_Common into the IDE, This uses the cb2xml project
*   Load JRecord into the IDE, This uses the JRecord_Common and cb2xml projects
*   Load other sub-projects as required. This will use JRecord_Common and JRecord.