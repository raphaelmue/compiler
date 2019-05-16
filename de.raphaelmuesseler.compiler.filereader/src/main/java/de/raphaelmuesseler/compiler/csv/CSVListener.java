package de.raphaelmuesseler.compiler.csv;// Generated from CSV.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CSVParser}.
 */
public interface CSVListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link CSVParser#csvfile}.
     *
     * @param ctx the parse tree
     */
    void enterCsvfile(CSVParser.CsvfileContext ctx);

    /**
     * Exit a parse tree produced by {@link CSVParser#csvfile}.
     *
     * @param ctx the parse tree
     */
    void exitCsvfile(CSVParser.CsvfileContext ctx);

    /**
     * Enter a parse tree produced by {@link CSVParser#line}.
     *
     * @param ctx the parse tree
     */
    void enterLine(CSVParser.LineContext ctx);

    /**
     * Exit a parse tree produced by {@link CSVParser#line}.
     *
     * @param ctx the parse tree
     */
    void exitLine(CSVParser.LineContext ctx);

    /**
     * Enter a parse tree produced by {@link CSVParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterExpr(CSVParser.ExprContext ctx);

    /**
     * Exit a parse tree produced by {@link CSVParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitExpr(CSVParser.ExprContext ctx);
}