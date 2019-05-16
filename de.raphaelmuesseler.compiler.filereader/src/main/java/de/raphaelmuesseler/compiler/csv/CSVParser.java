package de.raphaelmuesseler.compiler.csv;// Generated from CSV.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CSVParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            NUMBER = 1, STRING = 2, COMMA = 3, NEWLINE = 4;
    public static final int
            RULE_csvfile = 0, RULE_line = 1, RULE_expr = 2;

    private static String[] makeRuleNames() {
        return new String[]{
                "csvfile", "line", "expr"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, "NUMBER", "STRING", "COMMA", "NEWLINE"
        };
    }

    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "CSV.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public CSVParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class CsvfileContext extends ParserRuleContext {
        public List<LineContext> line() {
            return getRuleContexts(LineContext.class);
        }

        public LineContext line(int i) {
            return getRuleContext(LineContext.class, i);
        }

        public CsvfileContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_csvfile;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CSVListener) ((CSVListener) listener).enterCsvfile(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CSVListener) ((CSVListener) listener).exitCsvfile(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CSVVisitor) return ((CSVVisitor<? extends T>) visitor).visitCsvfile(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CsvfileContext csvfile() throws RecognitionException {
        CsvfileContext _localctx = new CsvfileContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_csvfile);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(9);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == NUMBER || _la == STRING) {
                    {
                        {
                            setState(6);
                            line();
                        }
                    }
                    setState(11);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class LineContext extends ParserRuleContext {
        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode COMMA() {
            return getToken(CSVParser.COMMA, 0);
        }

        public LineContext line() {
            return getRuleContext(LineContext.class, 0);
        }

        public TerminalNode NEWLINE() {
            return getToken(CSVParser.NEWLINE, 0);
        }

        public LineContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_line;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CSVListener) ((CSVListener) listener).enterLine(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CSVListener) ((CSVListener) listener).exitLine(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CSVVisitor) return ((CSVVisitor<? extends T>) visitor).visitLine(this);
            else return visitor.visitChildren(this);
        }
    }

    public final LineContext line() throws RecognitionException {
        LineContext _localctx = new LineContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_line);
        try {
            setState(19);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(12);
                    expr();
                    setState(13);
                    match(COMMA);
                    setState(14);
                    line();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(16);
                    expr();
                    setState(17);
                    match(NEWLINE);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprContext extends ParserRuleContext {
        public TerminalNode NUMBER() {
            return getToken(CSVParser.NUMBER, 0);
        }

        public TerminalNode STRING() {
            return getToken(CSVParser.STRING, 0);
        }

        public ExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CSVListener) ((CSVListener) listener).enterExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CSVListener) ((CSVListener) listener).exitExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CSVVisitor) return ((CSVVisitor<? extends T>) visitor).visitExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprContext expr() throws RecognitionException {
        ExprContext _localctx = new ExprContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_expr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(21);
                _la = _input.LA(1);
                if (!(_la == NUMBER || _la == STRING)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\6\32\4\2\t\2\4\3" +
                    "\t\3\4\4\t\4\3\2\7\2\n\n\2\f\2\16\2\r\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3" +
                    "\5\3\26\n\3\3\4\3\4\3\4\2\2\5\2\4\6\2\3\3\2\3\4\2\30\2\13\3\2\2\2\4\25" +
                    "\3\2\2\2\6\27\3\2\2\2\b\n\5\4\3\2\t\b\3\2\2\2\n\r\3\2\2\2\13\t\3\2\2\2" +
                    "\13\f\3\2\2\2\f\3\3\2\2\2\r\13\3\2\2\2\16\17\5\6\4\2\17\20\7\5\2\2\20" +
                    "\21\5\4\3\2\21\26\3\2\2\2\22\23\5\6\4\2\23\24\7\6\2\2\24\26\3\2\2\2\25" +
                    "\16\3\2\2\2\25\22\3\2\2\2\26\5\3\2\2\2\27\30\t\2\2\2\30\7\3\2\2\2\4\13" +
                    "\25";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}