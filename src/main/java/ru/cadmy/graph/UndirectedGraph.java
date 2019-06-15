package ru.cadmy.graph;

import ru.cadmy.graph.entity.Edge;
import ru.cadmy.graph.entity.Vertex;

import java.util.*;

/**
 * Created by Cadmy on 14.06.2019.
 */
public class UndirectedGraph extends SimpleGraph {

    Set<Edge> seen = new HashSet<>();

    @Override
    public void addEdge(String start, String end) {
        super.addEdge(start, end);
        super.addEdge(end, start);
    }

    public List<Edge> getPath(String root, String destination) {
        Vertex start = getVertex(root);
        Vertex end = getVertex(destination);

        List<Edge> path = new ArrayList<>();

        for (Edge edge : edges) {
            if (edge.getStart().equals(start) && !seen.contains(edge)) {
                seen.add(edge);
                path.add(edge);
                if (edge.getEnd().equals(end)) {
                    return path;
                }
                List<Edge> subpath = getPath(edge.getEnd().getName(), destination);
                if (subpath.isEmpty()) {
                    path = new ArrayList<>();
                } else {
                    path.addAll(subpath);
                    path.remove(new Edge(edge.getEnd(), edge.getStart()));
                    List<Edge> elementsToRemove = new ArrayList<>();
                    for (Iterator<Edge> iterator = path.iterator(); iterator.hasNext(); ) {
                        Edge current = iterator.next();
                        if (iterator.hasNext()) {
                            if (current.getStart().equals(iterator.next().getStart())) {
                                elementsToRemove.add(current);
                            }
                        }

                    }
                    path.removeAll(elementsToRemove);
                    return path;
                }
            }
        }
        return new ArrayList<>();
    }

}
