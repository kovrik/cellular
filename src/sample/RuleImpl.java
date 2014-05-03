package sample;

import java.util.HashMap;
import java.util.Map;

public class RuleImpl implements Rule {

    private final Map<Triple, Boolean> ruleset;

    public static final RuleImpl RULE30 = new RuleImpl();
    static {
        RULE30.put(Triple._000, false);
        RULE30.put(Triple._001, true);
        RULE30.put(Triple._010, true);
        RULE30.put(Triple._011, true);
        RULE30.put(Triple._100, true);
        RULE30.put(Triple._101, false);
        RULE30.put(Triple._110, false);
        RULE30.put(Triple._111, false);
    }

    public static final RuleImpl RULE90 = new RuleImpl();
    static {
        RULE90.put(Triple._000, false);
        RULE90.put(Triple._001, true);
        RULE90.put(Triple._010, false);
        RULE90.put(Triple._011, true);
        RULE90.put(Triple._100, true);
        RULE90.put(Triple._101, false);
        RULE90.put(Triple._110, true);
        RULE90.put(Triple._111, false);
    }

    public static final RuleImpl RULE110 = new RuleImpl();
    static {
        RULE110.put(Triple._000, false);
        RULE110.put(Triple._001, true);
        RULE110.put(Triple._010, true);
        RULE110.put(Triple._011, true);
        RULE110.put(Triple._100, false);
        RULE110.put(Triple._101, true);
        RULE110.put(Triple._110, true);
        RULE110.put(Triple._111, false);
    }

    public static final RuleImpl RULE184 = new RuleImpl();
    static {
        RULE184.put(Triple._000, false);
        RULE184.put(Triple._001, false);
        RULE184.put(Triple._010, false);
        RULE184.put(Triple._011, true);
        RULE184.put(Triple._100, true);
        RULE184.put(Triple._101, true);
        RULE184.put(Triple._110, false);
        RULE184.put(Triple._111, true);
    }

    public static final RuleImpl CUSTOM_RULE = new RuleImpl();
    static {
        CUSTOM_RULE.put(Triple._000, true);
        CUSTOM_RULE.put(Triple._001, false);
        CUSTOM_RULE.put(Triple._010, false);
        CUSTOM_RULE.put(Triple._011, true);
        CUSTOM_RULE.put(Triple._100, false);
        CUSTOM_RULE.put(Triple._101, true);
        CUSTOM_RULE.put(Triple._110, false);
        CUSTOM_RULE.put(Triple._111, true);
    }

    public RuleImpl() {
        this.ruleset = new HashMap<Triple, Boolean>();
    }

    public RuleImpl(Map<Triple, Boolean> ruleset) {
        if (ruleset.size() < 8) {
            throw new IllegalArgumentException("Ruleset is not full!");
        }
        this.ruleset = ruleset;
    }

    public void put(Triple t, Boolean b) {
        this.ruleset.put(t, b);
    }

    @Override
    public boolean map(Triple t) {
        return ruleset.get(t);
    }

    @Override
    public String toString() {
        return "RuleImpl{" + "ruleset=" + ruleset + '}';
    }
}
