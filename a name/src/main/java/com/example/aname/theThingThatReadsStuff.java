package com.example.aname;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class theThingThatReadsStuff {
    public static void write() throws IOException {
        File f = new File("OutputAt-0.html");
        f.createNewFile();
        FileWriter fw = new FileWriter(f);
        fw.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Pretty Colored Information Page</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: 'Arial', sans-serif;\n" +
                "            background-color: #f0f8ff;\n" +
                "            color: #333;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        header {\n" +
                "            background-color: #ff9a8b;\n" +
                "            color: white;\n" +
                "            padding: 20px;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        h1 {\n" +
                "            font-size: 2.5em;\n" +
                "        }\n" +
                "        .section {\n" +
                "            margin: 20px;\n" +
                "            padding: 20px;\n" +
                "            background-color: #fff;\n" +
                "            border-radius: 8px;\n" +
                "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n" +
                "        }\n" +
                "        .section h2 {\n" +
                "            color: #ff6f61;\n" +
                "            font-size: 2em;\n" +
                "        }\n" +
                "        .section p {\n" +
                "            font-size: 1.2em;\n" +
                "            line-height: 1.6;\n" +
                "        }\n" +
                "        .info-box {\n" +
                "            background-color: #ffebcc;\n" +
                "            padding: 10px;\n" +
                "            border-radius: 8px;\n" +
                "            margin-top: 15px;\n" +
                "            color: #4d4d4d;\n" +
                "        }\n" +
                "        footer {\n" +
                "            background-color: #ff9a8b;\n" +
                "            color: white;\n" +
                "            text-align: center;\n" +
                "            padding: 10px;\n" +
                "            position: fixed;\n" +
                "            width: 100%;\n" +
                "            bottom: 0;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<header>\n" +
                "    <h1>Welcome to My Beautiful Info Page</h1>\n" +
                "</header>\n" +
                "\n" +
                "<div class=\"section\">\n" +
                "    <h2>About This Page</h2>\n" +
                "    <p>This page is designed to showcase how to display information in a beautiful and colorful way using HTML and CSS. It's perfect for presenting anything in an easy-to-read, aesthetically pleasing format!</p>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"section\">\n" +
                "    <h2>Interesting Fact</h2>\n" +
                "    <p>Did you know that the Eiffel Tower can grow by up to 6 inches during the summer due to the expansion of the metal? It's a fascinating piece of engineering!</p>\n" +
                "    <div class=\"info-box\">\n" +
                "        <strong>Fun Tip:</strong> You can easily add more fun facts or interesting information like this!\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "<footer>\n" +
                "    <p>&copy; 2025 Your Name. All rights reserved.</p>\n" +
                "</footer>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n");
        fw.flush();
        fw.close();
    }
}
