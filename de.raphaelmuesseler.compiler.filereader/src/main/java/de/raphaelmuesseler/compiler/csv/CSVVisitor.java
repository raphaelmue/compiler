package de.raphaelmuesseler.compiler.csv;// Generated from CSV.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CSVParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface CSVVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link CSVParser#csvfile}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCsvfile(CSVParser.CsvfileContext ctx);

    /**
     * Visit a parse tree produced by {@link CSVParser#line}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLine(CSVParser.LineContext ctx);

    /**
     * Visit a parse tree produced by {@link CSVParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpr(CSVParser.ExprContext ctx);
}