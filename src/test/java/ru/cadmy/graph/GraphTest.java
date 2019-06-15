package ru.cadmy.graph;

import org.junit.Before;

/**
 * Created by Cadmy on 14.06.2019.
 *
 *
 *    Dzerzhinsk                   NizhnyNovgorod
 *          @ <------------------- @
 *        /                         \
 *      /                            \
 *     V                              V
 *     @ <--------------------------- @ Sarov
 *   Arzamas                          |
 *                                    |
 *                                    |
 *                                    V
 *                                    @ Pavlovo
 */
public class GraphTest {
    Graph graph;

    @Before
    public void setUp() throws Exception {
        graph.addVertex("NizhnyNovgorod");
        graph.addVertex("Dzerzhinsk");
        graph.addVertex("Arzamas");
        graph.addVertex("Sarov");
        graph.addVertex("Pavlovo");
        graph.addEdge( "NizhnyNovgorod", "Dzerzhinsk");
        graph.addEdge("NizhnyNovgorod", "Sarov");
        graph.addEdge("Dzerzhinsk", "Arzamas");
        graph.addEdge("Sarov", "Arzamas");
        graph.addEdge("Sarov", "Pavlovo");
    }
}
