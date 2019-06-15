package ru.cadmy.graph;

import ru.cadmy.graph.entity.Edge;
import ru.cadmy.graph.entity.Vertex;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by Cadmy on 14.06.2019.
 */
public abstract class SimpleGraph implements Graph {

    protected Set<Vertex> vertices = new CopyOnWriteArraySet<>();
    protected List<Edge> edges = new CopyOnWriteArrayList<>();

    @Override
    public void addVertex(String name) {
        vertices.add(new Vertex(name));
    }

    @Override
    public void addEdge(String start, String end) {
        Vertex root = getVertex(start);
        Vertex destination = getVertex(end);
        edges.add(new Edge(root, destination));
    }

    @Override
    public List<Edge> getPath(String start, String end) {
        return null;
    }

    protected Vertex getVertex(String name) {
        return vertices.stream().filter(v -> v.getName().equals(name)).findFirst().orElse( null);
    }
}
