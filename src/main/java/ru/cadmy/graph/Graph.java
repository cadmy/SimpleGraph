package ru.cadmy.graph;

import ru.cadmy.graph.entity.Edge;

import java.util.List;

/**
 * Created by Cadmy on 14.06.2019.
 */
public interface Graph {

    void addVertex(String vertex);

    void addEdge(String start, String end);

    List<Edge> getPath(String start, String end);
}
