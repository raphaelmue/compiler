package de.raphaelmuesseler.compiler.csv;// Generated from CSV.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CSVLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            NUMBER = 1, STRING = 2, COMMA = 3, NEWLINE = 4;
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "NUMBER", "STRING", "COMMA", "NEWLINE"
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


    public CSVLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\6#\b\1\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\3\2\5\2\r\n\2\3\2\6\2\20\n\2\r\2\16\2\21\3\3\3" +
                    "\3\7\3\26\n\3\f\3\16\3\31\13\3\3\3\3\3\3\4\3\4\3\5\5\5 \n\5\3\5\3\5\2" +
                    "\2\6\3\3\5\4\7\5\t\6\3\2\t\3\2//\3\2\62;\3\2$$\4\2C\\c|\3\2..\3\2\17\17" +
                    "\3\2\f\f\2&\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\3\f\3\2\2" +
                    "\2\5\23\3\2\2\2\7\34\3\2\2\2\t\37\3\2\2\2\13\r\t\2\2\2\f\13\3\2\2\2\f" +
                    "\r\3\2\2\2\r\17\3\2\2\2\16\20\t\3\2\2\17\16\3\2\2\2\20\21\3\2\2\2\21\17" +
                    "\3\2\2\2\21\22\3\2\2\2\22\4\3\2\2\2\23\27\t\4\2\2\24\26\t\5\2\2\25\24" +
                    "\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31\27" +
                    "\3\2\2\2\32\33\t\4\2\2\33\6\3\2\2\2\34\35\t\6\2\2\35\b\3\2\2\2\36 \t\7" +
                    "\2\2\37\36\3\2\2\2\37 \3\2\2\2 !\3\2\2\2!\"\t\b\2\2\"\n\3\2\2\2\7\2\f" +
                    "\21\27\37\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}