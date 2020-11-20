package com.kondak.validators;

import com.kondak.symbols.nodes.LeftBracketSymbol;
import com.kondak.symbols.nodes.RightBracketSymbol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Landau Rule: "in the expression the number of left brackets must be equal to the number of right brackets"
public class LandauRuleValidator implements BrainFuckCodeValidator {
    private static final Logger log = LogManager.getLogger();
    private static final char LEFT_BRACKETS_SYMBOL = new LeftBracketSymbol().getImage();
    private static final char RIGHT_BRACKETS_SYMBOL = new RightBracketSymbol().getImage();
    @Override
    public void validate(String code) {
        int leftBracketsCount = 0;
        int rightBracketsCount = 0;
        int delta;

        for (char symbol : code.toCharArray()) {
            if (symbol == LEFT_BRACKETS_SYMBOL)
                leftBracketsCount++;
            if (symbol == RIGHT_BRACKETS_SYMBOL)
                rightBracketsCount++;
        }
        delta = leftBracketsCount - rightBracketsCount;

        //if there more left brackets, there right brackets deficiency
        if (delta > 0) {
            log.info("Caught expression without right bracket");
            throw new IllegalArgumentException("In expression syntax error: missing character " + RIGHT_BRACKETS_SYMBOL);
        }
        if (delta < 0) {
            log.info("Caught expression without left bracket");
            throw new IllegalArgumentException("In expression syntax error: missing character " + LEFT_BRACKETS_SYMBOL);
        }
    }
}
