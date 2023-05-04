package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionSolverImplTest {

    @Test
    void solve_Simple() {
        // arrange
        var solver = new ExpressionSolver();
        var expression = "15 - 5";
        var expected = 10;

        // act
        var actual = solver.solve(expression);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void solve_OperationsOrder() {
        // arrange
        var solver = new ExpressionSolver();
        var expression = "2 + 5 * 2";
        var expected = 12;

        // act
        var actual = solver.solve(expression);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void solve_Parenthesis() {
        // arrange
        var solver = new ExpressionSolver();
        var expression = "(2 + 5) * 2";
        var expected = 14;

        // act
        var actual = solver.solve(expression);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void solve_Triple() {
        // arrange
        var solver = new ExpressionSolver();
        var expression = "5 + 1 + 2";
        var expected = 8;

        // act
        var actual = solver.solve(expression);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void solve_NestedParenthesis() {
        // arrange
        var solver = new ExpressionSolver();
        var expression = "((2 + 10) / (3 * 2))";
        var expected = 2;

        // act
        var actual = solver.solve(expression);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void solve_OpenParenthesis() {
        // arrange
        var solver = new ExpressionSolver();
        var expression = "((2 + 10) / (3 * 2)";

        // act
        assertThrows(IllegalArgumentException.class, () -> {
            solver.solve(expression);
        });
    }

    @Test
    void solve_CloseParenthesis() {
        // arrange
        var solver = new ExpressionSolver();
        var expression = "((2 + 10) / 3 * 2))";

        // act
        assertThrows(IllegalArgumentException.class, () -> {
            solver.solve(expression);
        });
    }

    @Test
    void solve_Operator() {
        // arrange
        var solver = new ExpressionSolver();
        var expression = "*";

        // act
        assertThrows(IllegalArgumentException.class, () -> {
            solver.solve(expression);
        });
    }
}