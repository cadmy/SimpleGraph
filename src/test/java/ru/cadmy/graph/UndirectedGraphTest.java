package ru.cadmy.graph;

import org.junit.Test;
import ru.cadmy.graph.entity.Edge;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Cadmy on 14.06.2019.
 */
public class UndirectedGraphTest extends GraphTest {

    public UndirectedGraphTest() {
        this.graph = new UndirectedGraph();
    }

    @Test
    public void checkCorrectPath() {
        List<Edge> edges = graph.getPath("NizhnyNovgorod", "Arzamas");
        System.out.println(edges);
        assertEquals(2, edges.size());
    }

    @Test
    public void checkUndircetedCorrectPath() {
        List<Edge> edges = graph.getPath("Dzerzhinsk", "Pavlovo");
        System.out.println(edges);
        assertEquals(3, edges.size());
    }

    @Test
    public void checkAnotherUndircetedCorrectPath() {
        List<Edge> edges = graph.getPath("Arzamas", "NizhnyNovgorod");
        System.out.println(edges);
        assertEquals(2, edges.size());
    }

    @Test
    public void checkShortPath() {
        List<Edge> edges = graph.getPath("NizhnyNovgorod", "Dzerzhinsk");
        System.out.println(edges);
        assertEquals(1, edges.size());
    }

    @Test
    public void checkUnreachableDestination() {
        List<Edge> edges = graph.getPath("Arzamas", "Sarov");
        System.out.println(edges);
        assertEquals(true, edges.size() > 0);
    }

    @Test
    public void checkPathIsNotExist() {
        List<Edge> edges = graph.getPath("Arzamas", "Kirov");
        System.out.println(edges);
        assertEquals(0, edges.size());
    }
}