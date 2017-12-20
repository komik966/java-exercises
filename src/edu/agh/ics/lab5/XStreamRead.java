package edu.agh.ics.lab5;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class XStreamRead {

    public static void main(String[] args) {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("person", Person.class);
        try {
            Person newJohn = (Person) xStream.fromXML(new FileReader("person.xml"));
            System.out.println(newJohn);
        } catch (FileNotFoundException | ClassCastException e) {
            e.printStackTrace();
        }
    }
}
