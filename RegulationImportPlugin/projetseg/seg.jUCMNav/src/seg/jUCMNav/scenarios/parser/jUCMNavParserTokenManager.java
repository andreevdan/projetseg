/* Generated By:JJTree&JavaCC: Do not edit this line. jUCMNavParserTokenManager.java */
package seg.jUCMNav.scenarios.parser;

public class jUCMNavParserTokenManager implements jUCMNavParserConstants {
    public static java.io.PrintStream debugStream = System.out;

    public static void setDebugStream(java.io.PrintStream ds) {
        debugStream = ds;
    }

    private static final int jjStopStringLiteralDfa_0(int pos, long active0) {
        switch (pos) {
        case 0:
            if ((active0 & 0x18000000L) != 0L) {
                jjmatchedKind = 32;
                return 29;
            }
            return -1;
        case 1:
            if ((active0 & 0x10000000L) != 0L) {
                jjmatchedKind = 32;
                jjmatchedPos = 1;
                return 29;
            }
            if ((active0 & 0x8000000L) != 0L)
                return 29;
            return -1;
        case 2:
            if ((active0 & 0x10000000L) != 0L) {
                jjmatchedKind = 32;
                jjmatchedPos = 2;
                return 29;
            }
            return -1;
        default:
            return -1;
        }
    }

    private static final int jjStartNfa_0(int pos, long active0) {
        return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
    }

    static private final int jjStopAtPos(int pos, int kind) {
        jjmatchedKind = kind;
        jjmatchedPos = pos;
        return pos + 1;
    }

    static private final int jjStartNfaWithStates_0(int pos, int kind, int state) {
        jjmatchedKind = kind;
        jjmatchedPos = pos;
        try {
            curChar = SimpleCharStream.readChar();
        } catch (java.io.IOException e) {
            return pos + 1;
        }
        return jjMoveNfa_0(state, pos + 1);
    }

    static private final int jjMoveStringLiteralDfa0_0() {
        switch (curChar) {
        case 40:
            return jjStopAtPos(0, 10);
        case 41:
            return jjStopAtPos(0, 11);
        case 42:
            return jjStopAtPos(0, 18);
        case 43:
            return jjStopAtPos(0, 16);
        case 45:
            return jjStopAtPos(0, 17);
        case 58:
            return jjMoveStringLiteralDfa1_0(0x4000000L);
        case 59:
            return jjStopAtPos(0, 29);
        case 60:
            jjmatchedKind = 14;
            return jjMoveStringLiteralDfa1_0(0x8000L);
        case 61:
            jjmatchedKind = 22;
            return jjMoveStringLiteralDfa1_0(0x800200L);
        case 62:
            jjmatchedKind = 12;
            return jjMoveStringLiteralDfa1_0(0x2000L);
        case 101:
            return jjMoveStringLiteralDfa1_0(0x10000000L);
        case 105:
            return jjMoveStringLiteralDfa1_0(0x8000000L);
        case 123:
            return jjStopAtPos(0, 7);
        case 125:
            return jjStopAtPos(0, 8);
        default:
            return jjMoveNfa_0(2, 0);
        }
    }

    static private final int jjMoveStringLiteralDfa1_0(long active0) {
        try {
            curChar = SimpleCharStream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(0, active0);
            return 1;
        }
        switch (curChar) {
        case 61:
            if ((active0 & 0x2000L) != 0L)
                return jjStopAtPos(1, 13);
            else if ((active0 & 0x8000L) != 0L)
                return jjStopAtPos(1, 15);
            else if ((active0 & 0x800000L) != 0L)
                return jjStopAtPos(1, 23);
            else if ((active0 & 0x4000000L) != 0L)
                return jjStopAtPos(1, 26);
            break;
        case 62:
            if ((active0 & 0x200L) != 0L)
                return jjStopAtPos(1, 9);
            break;
        case 102:
            if ((active0 & 0x8000000L) != 0L)
                return jjStartNfaWithStates_0(1, 27, 29);
            break;
        case 108:
            return jjMoveStringLiteralDfa2_0(active0, 0x10000000L);
        default:
            break;
        }
        return jjStartNfa_0(0, active0);
    }

    static private final int jjMoveStringLiteralDfa2_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjStartNfa_0(0, old0);
        try {
            curChar = SimpleCharStream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(1, active0);
            return 2;
        }
        switch (curChar) {
        case 115:
            return jjMoveStringLiteralDfa3_0(active0, 0x10000000L);
        default:
            break;
        }
        return jjStartNfa_0(1, active0);
    }

    static private final int jjMoveStringLiteralDfa3_0(long old0, long active0) {
        if (((active0 &= old0)) == 0L)
            return jjStartNfa_0(1, old0);
        try {
            curChar = SimpleCharStream.readChar();
        } catch (java.io.IOException e) {
            jjStopStringLiteralDfa_0(2, active0);
            return 3;
        }
        switch (curChar) {
        case 101:
            if ((active0 & 0x10000000L) != 0L)
                return jjStartNfaWithStates_0(3, 28, 29);
            break;
        default:
            break;
        }
        return jjStartNfa_0(2, active0);
    }

    static private final void jjCheckNAdd(int state) {
        if (jjrounds[state] != jjround) {
            jjstateSet[jjnewStateCnt++] = state;
            jjrounds[state] = jjround;
        }
    }

    static private final void jjAddStates(int start, int end) {
        do {
            jjstateSet[jjnewStateCnt++] = jjnextStates[start];
        } while (start++ != end);
    }

    static private final void jjCheckNAddTwoStates(int state1, int state2) {
        jjCheckNAdd(state1);
        jjCheckNAdd(state2);
    }

    static private final void jjCheckNAddStates(int start, int end) {
        do {
            jjCheckNAdd(jjnextStates[start]);
        } while (start++ != end);
    }

    static private final void jjCheckNAddStates(int start) {
        jjCheckNAdd(jjnextStates[start]);
        jjCheckNAdd(jjnextStates[start + 1]);
    }
    static final long[] jjbitVec0 = { 0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL };

    static private final int jjMoveNfa_0(int startState, int curPos) {
        int[] nextStates;
        int startsAt = 0;
        jjnewStateCnt = 42;
        int i = 1;
        jjstateSet[0] = startState;
        int j, kind = 0x7fffffff;
        for (;;) {
            if (++jjround == 0x7fffffff)
                ReInitRounds();
            if (curChar < 64) {
                long l = 1L << curChar;
                do {
                    switch (jjstateSet[--i]) {
                    case 2:
                        if ((0x3ff000000000000L & l) != 0L) {
                            if (kind > 31)
                                kind = 31;
                            jjCheckNAdd(27);
                        } else if (curChar == 47)
                            jjCheckNAddStates(0, 2);
                        else if (curChar == 33) {
                            if (kind > 25)
                                kind = 25;
                        } else if (curChar == 38)
                            jjstateSet[jjnewStateCnt++] = 3;
                        if (curChar == 33)
                            jjCheckNAdd(13);
                        break;
                    case 3:
                        if (curChar == 38 && kind > 19)
                            kind = 19;
                        break;
                    case 4:
                        if (curChar == 38)
                            jjstateSet[jjnewStateCnt++] = 3;
                        break;
                    case 13:
                        if (curChar == 61 && kind > 24)
                            kind = 24;
                        break;
                    case 14:
                        if (curChar == 33)
                            jjCheckNAdd(13);
                        break;
                    case 18:
                        if (curChar == 33 && kind > 25)
                            kind = 25;
                        break;
                    case 27:
                        if ((0x3ff000000000000L & l) == 0L)
                            break;
                        if (kind > 31)
                            kind = 31;
                        jjCheckNAdd(27);
                        break;
                    case 29:
                        if ((0x3ff000000000000L & l) == 0L)
                            break;
                        if (kind > 32)
                            kind = 32;
                        jjstateSet[jjnewStateCnt++] = 29;
                        break;
                    case 30:
                        if (curChar == 47)
                            jjCheckNAddStates(0, 2);
                        break;
                    case 31:
                        if (curChar == 47)
                            jjCheckNAddStates(3, 5);
                        break;
                    case 32:
                        if ((0xffffffffffffdbffL & l) != 0L)
                            jjCheckNAddStates(3, 5);
                        break;
                    case 33:
                        if ((0x2401L & l) != 0L && kind > 5)
                            kind = 5;
                        break;
                    case 34:
                        if (curChar == 10 && kind > 5)
                            kind = 5;
                        break;
                    case 35:
                        if (curChar == 13)
                            jjstateSet[jjnewStateCnt++] = 34;
                        break;
                    case 36:
                        if (curChar == 42)
                            jjCheckNAddTwoStates(37, 38);
                        break;
                    case 37:
                        if ((0xfffffbffffffffffL & l) != 0L)
                            jjCheckNAddTwoStates(37, 38);
                        break;
                    case 38:
                        if (curChar == 42)
                            jjAddStates(6, 7);
                        break;
                    case 39:
                        if ((0xffff7fffffffffffL & l) != 0L)
                            jjCheckNAddTwoStates(40, 38);
                        break;
                    case 40:
                        if ((0xfffffbffffffffffL & l) != 0L)
                            jjCheckNAddTwoStates(40, 38);
                        break;
                    case 41:
                        if (curChar == 47 && kind > 6)
                            kind = 6;
                        break;
                    default:
                        break;
                    }
                } while (i != startsAt);
            } else if (curChar < 128) {
                long l = 1L << (curChar & 077);
                do {
                    switch (jjstateSet[--i]) {
                    case 2:
                        if ((0x7fffffe87fffffeL & l) != 0L) {
                            if (kind > 32)
                                kind = 32;
                            jjCheckNAdd(29);
                        } else if (curChar == 94) {
                            if (kind > 21)
                                kind = 21;
                        } else if (curChar == 124)
                            jjstateSet[jjnewStateCnt++] = 7;
                        if (curChar == 102)
                            jjstateSet[jjnewStateCnt++] = 25;
                        else if (curChar == 116)
                            jjstateSet[jjnewStateCnt++] = 21;
                        else if (curChar == 110)
                            jjstateSet[jjnewStateCnt++] = 16;
                        else if (curChar == 120)
                            jjstateSet[jjnewStateCnt++] = 10;
                        else if (curChar == 111)
                            jjstateSet[jjnewStateCnt++] = 5;
                        else if (curChar == 97)
                            jjstateSet[jjnewStateCnt++] = 1;
                        break;
                    case 0:
                        if (curChar == 100 && kind > 19)
                            kind = 19;
                        break;
                    case 1:
                        if (curChar == 110)
                            jjstateSet[jjnewStateCnt++] = 0;
                        break;
                    case 5:
                        if (curChar == 114 && kind > 20)
                            kind = 20;
                        break;
                    case 6:
                        if (curChar == 111)
                            jjstateSet[jjnewStateCnt++] = 5;
                        break;
                    case 7:
                        if (curChar == 124 && kind > 20)
                            kind = 20;
                        break;
                    case 8:
                        if (curChar == 124)
                            jjstateSet[jjnewStateCnt++] = 7;
                        break;
                    case 9:
                        if (curChar == 114 && kind > 21)
                            kind = 21;
                        break;
                    case 10:
                        if (curChar == 111)
                            jjstateSet[jjnewStateCnt++] = 9;
                        break;
                    case 11:
                        if (curChar == 120)
                            jjstateSet[jjnewStateCnt++] = 10;
                        break;
                    case 12:
                        if (curChar == 94 && kind > 21)
                            kind = 21;
                        break;
                    case 15:
                        if (curChar == 116 && kind > 25)
                            kind = 25;
                        break;
                    case 16:
                        if (curChar == 111)
                            jjstateSet[jjnewStateCnt++] = 15;
                        break;
                    case 17:
                        if (curChar == 110)
                            jjstateSet[jjnewStateCnt++] = 16;
                        break;
                    case 19:
                        if (curChar == 101 && kind > 30)
                            kind = 30;
                        break;
                    case 20:
                        if (curChar == 117)
                            jjCheckNAdd(19);
                        break;
                    case 21:
                        if (curChar == 114)
                            jjstateSet[jjnewStateCnt++] = 20;
                        break;
                    case 22:
                        if (curChar == 116)
                            jjstateSet[jjnewStateCnt++] = 21;
                        break;
                    case 23:
                        if (curChar == 115)
                            jjCheckNAdd(19);
                        break;
                    case 24:
                        if (curChar == 108)
                            jjstateSet[jjnewStateCnt++] = 23;
                        break;
                    case 25:
                        if (curChar == 97)
                            jjstateSet[jjnewStateCnt++] = 24;
                        break;
                    case 26:
                        if (curChar == 102)
                            jjstateSet[jjnewStateCnt++] = 25;
                        break;
                    case 28:
                    case 29:
                        if ((0x7fffffe87fffffeL & l) == 0L)
                            break;
                        if (kind > 32)
                            kind = 32;
                        jjCheckNAdd(29);
                        break;
                    case 32:
                        jjAddStates(3, 5);
                        break;
                    case 37:
                        jjCheckNAddTwoStates(37, 38);
                        break;
                    case 39:
                    case 40:
                        jjCheckNAddTwoStates(40, 38);
                        break;
                    default:
                        break;
                    }
                } while (i != startsAt);
            } else {
                int i2 = (curChar & 0xff) >> 6;
                long l2 = 1L << (curChar & 077);
                do {
                    switch (jjstateSet[--i]) {
                    case 32:
                        if ((jjbitVec0[i2] & l2) != 0L)
                            jjAddStates(3, 5);
                        break;
                    case 37:
                        if ((jjbitVec0[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(37, 38);
                        break;
                    case 39:
                    case 40:
                        if ((jjbitVec0[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(40, 38);
                        break;
                    default:
                        break;
                    }
                } while (i != startsAt);
            }
            if (kind != 0x7fffffff) {
                jjmatchedKind = kind;
                jjmatchedPos = curPos;
                kind = 0x7fffffff;
            }
            ++curPos;
            if ((i = jjnewStateCnt) == (startsAt = 42 - (jjnewStateCnt = startsAt)))
                return curPos;
            try {
                curChar = SimpleCharStream.readChar();
            } catch (java.io.IOException e) {
                return curPos;
            }
        }
    }
    static final int[] jjnextStates = { 31, 36, 13, 32, 33, 35, 39, 41, };
    public static final String[] jjstrLiteralImages = { "", null, null, null, null, null, null, "\173", "\175", "\75\76", "\50", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
            "\51", "\76", "\76\75", "\74", "\74\75", "\53", "\55", "\52", null, null, null, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
            "\75", "\75\75", null, null, "\72\75", "\151\146", "\145\154\163\145", "\73", null, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
            null, null, null, null, };
    public static final String[] lexStateNames = { "DEFAULT", //$NON-NLS-1$
    };
    static final long[] jjtoToken = { 0x1ffffff81L, };
    static final long[] jjtoSkip = { 0x7eL, };
    static protected SimpleCharStream input_stream;
    static private final int[] jjrounds = new int[42];
    static private final int[] jjstateSet = new int[84];
    static protected char curChar;

    public jUCMNavParserTokenManager(SimpleCharStream stream) {
        if (input_stream != null)
            throw new TokenMgrError(
                    "ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR); //$NON-NLS-1$
        input_stream = stream;
    }

    public jUCMNavParserTokenManager(SimpleCharStream stream, int lexState) {
        this(stream);
        SwitchTo(lexState);
    }

    static public void ReInit(SimpleCharStream stream) {
        jjmatchedPos = jjnewStateCnt = 0;
        curLexState = defaultLexState;
        input_stream = stream;
        ReInitRounds();
    }

    static private final void ReInitRounds() {
        int i;
        jjround = 0x80000001;
        for (i = 42; i-- > 0;)
            jjrounds[i] = 0x80000000;
    }

    static public void ReInit(SimpleCharStream stream, int lexState) {
        ReInit(stream);
        SwitchTo(lexState);
    }

    static public void SwitchTo(int lexState) {
        if (lexState >= 1 || lexState < 0)
            throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE); //$NON-NLS-1$ //$NON-NLS-2$
        else
            curLexState = lexState;
    }

    static protected Token jjFillToken() {
        Token t = Token.newToken(jjmatchedKind);
        t.kind = jjmatchedKind;
        String im = jjstrLiteralImages[jjmatchedKind];
        t.image = (im == null) ? SimpleCharStream.GetImage() : im;
        t.beginLine = SimpleCharStream.getBeginLine();
        t.beginColumn = SimpleCharStream.getBeginColumn();
        t.endLine = SimpleCharStream.getEndLine();
        t.endColumn = SimpleCharStream.getEndColumn();
        return t;
    }

    static int curLexState = 0;
    static int defaultLexState = 0;
    static int jjnewStateCnt;
    static int jjround;
    static int jjmatchedPos;
    static int jjmatchedKind;

    public static Token getNextToken() {
        int kind;
        Token specialToken = null;
        Token matchedToken;
        int curPos = 0;

        EOFLoop: for (;;) {
            try {
                curChar = SimpleCharStream.BeginToken();
            } catch (java.io.IOException e) {
                jjmatchedKind = 0;
                matchedToken = jjFillToken();
                return matchedToken;
            }

            try {
                SimpleCharStream.backup(0);
                while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
                    curChar = SimpleCharStream.BeginToken();
            } catch (java.io.IOException e1) {
                continue EOFLoop;
            }
            jjmatchedKind = 0x7fffffff;
            jjmatchedPos = 0;
            curPos = jjMoveStringLiteralDfa0_0();
            if (jjmatchedKind != 0x7fffffff) {
                if (jjmatchedPos + 1 < curPos)
                    SimpleCharStream.backup(curPos - jjmatchedPos - 1);
                if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L) {
                    matchedToken = jjFillToken();
                    return matchedToken;
                } else {
                    continue EOFLoop;
                }
            }
            int error_line = SimpleCharStream.getEndLine();
            int error_column = SimpleCharStream.getEndColumn();
            String error_after = null;
            boolean EOFSeen = false;
            try {
                SimpleCharStream.readChar();
                SimpleCharStream.backup(1);
            } catch (java.io.IOException e1) {
                EOFSeen = true;
                error_after = curPos <= 1 ? "" : SimpleCharStream.GetImage(); //$NON-NLS-1$
                if (curChar == '\n' || curChar == '\r') {
                    error_line++;
                    error_column = 0;
                } else
                    error_column++;
            }
            if (!EOFSeen) {
                SimpleCharStream.backup(1);
                error_after = curPos <= 1 ? "" : SimpleCharStream.GetImage(); //$NON-NLS-1$
            }
            throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
        }
    }

}
