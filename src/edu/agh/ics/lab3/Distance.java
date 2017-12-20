package edu.agh.ics.lab3;

import java.util.List;

public interface Distance <T extends Number>
{
    double distance(List<T> vectorA, List<T> vectorB) throws NotMatchingDimensionsException;
}
