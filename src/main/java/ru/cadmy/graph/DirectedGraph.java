package ru.cadmy.graph;

import ru.cadmy.graph.entity.Edge;
import ru.cadmy.graph.entity.Vertex;

import java.util.*;

/**
 * Created by Cadmy on 14.06.2019.
 */
public class DirectedGraph extends SimpleGraph {

    public List<Edge> getPath(String root, String destination) {
        Vertex start = getVertex(root);
        Vertex end = getVertex(destination);

        List<Edge> path = new ArrayList<>();
        Set<Edge> seen = new HashSet<>();

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
                    return path;
                }
            }
        }
        return new ArrayList<>();
    }

}
