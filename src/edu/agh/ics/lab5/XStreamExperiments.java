package edu.agh.ics.lab5;

import com.thoughtworks.xstream.XStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class XStreamExperiments {

    public static void main(String[] args) {
        Person p = new Person("Jan", "Kowalski", "870329111");
        XStream xStream = new XStream();
        xStream.alias("person", Person.class);

        try(PrintWriter pw = new PrintWriter(new FileWriter("person.xml"))) {
            xStream.toXML(p, pw);
            System.out.println(xStream.toXML(p));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
